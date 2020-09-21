package com.qianyitian.blockly.poc.controller;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.JavaMethodReflectionFunctionMissing;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.qianyitian.blockly.function.MonthPerformFactorFunction;
import com.qianyitian.blockly.function.MonthPerformSalaryStandardFunction;
import com.qianyitian.blockly.util.FileUtil;
import com.qianyitian.blockly.util.FunctionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
@CrossOrigin
public class BlocklyController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    ExecutorService threadPool = Executors.newFixedThreadPool(2);
    Map<String, String> map = new HashMap<>();

    static {
        File directory = new File("");//参数为空
        String author = directory.getAbsolutePath();
    }

    String xml_folder_path = System.getProperty("user.dir") + "\\files\\";
    String rule_folder_path = System.getProperty("user.dir") + "\\files\\";

    public BlocklyController() {
    }

    @GetMapping(value = "/pool")
    public String pool() {
        ThreadPoolExecutor pool = (ThreadPoolExecutor) threadPool;
        StringBuilder sb = new StringBuilder();
        sb.append("task count " + pool.getTaskCount()).append(" queue size " + pool.getQueue().size()).append(" completed tasks " + pool.getCompletedTaskCount());
        sb.append(" active count " + pool.getActiveCount());
        return sb.toString();

    }


    @PostMapping(value = "/saveScript/{ruleName}")
    public String saveScript(@PathVariable String ruleName, @RequestBody String input) throws IOException {
        logger.info("saveScript   ======================================= " + input);
        logger.info("rule_folder_path   ======================================= " + rule_folder_path);
        String filename = rule_folder_path + ruleName + ".av";
        FileUtil.fileLinesWrite(filename, input);
        return "OK";
    }

    @PostMapping(value = "/loadScript/{ruleName}")
    public String loadScript(@PathVariable String ruleName) throws IOException {
        String filename = rule_folder_path + ruleName + ".av";
        String s = FileUtil.readFile(filename);
        logger.info("loadScript   ======================================= " + s);
        return s;
    }

    @PostMapping(value = "/saveXML/{ruleName}")
    public String saveXML(@PathVariable String ruleName, @RequestBody String input) throws IOException {
        logger.info("saveXML   ======================================= " + input);
        logger.info("rule_folder_path   ======================================= " + xml_folder_path);
        String filename = xml_folder_path + ruleName + ".xml";
        logger.info("filename   ======================================= " + filename);
        FileUtil.fileLinesWrite(filename, input);
        return "OK";
    }

    @PostMapping(value = "/loadXML/{ruleName}")
    public String loadXML(@PathVariable String ruleName) throws IOException {
        String filename = xml_folder_path + ruleName + ".xml";
        String content = FileUtil.readFile(filename);
        logger.info("loadXML   ======================================= " + content);
        return content;
    }

    @PostMapping(value = "/executeRule/{ruleName}")
    public String executeRule(@PathVariable String ruleName, @RequestBody String input) throws IOException {
        logger.info("Running   ======================================= " + input);
        String filename = rule_folder_path + ruleName + ".av";
        if (StringUtils.isEmpty(input)) {
            input = "111";
        }
        String userid = input;
        Map<String, Object> env = AviatorEvaluator.newEnv("userId", userid);

        List<AbstractFunction> list = FunctionUtil.findAllFunctions();
        for (AbstractFunction abstractFunction : list) {
            AviatorEvaluator.addFunction(abstractFunction);
        }
//        AviatorEvaluator.addFunction(new MonthPerformSalaryStandardFunction());
//
//        AviatorEvaluator.setFunctionMissing(JavaMethodReflectionFunctionMissing.getInstance());
        Expression exp = AviatorEvaluator.getInstance().compileScript(filename, false);
        Object execute = exp.execute(env);
        BigDecimal tax = (BigDecimal) execute;

        String result = "运行结果为: " + tax;
        return result;
    }


}
