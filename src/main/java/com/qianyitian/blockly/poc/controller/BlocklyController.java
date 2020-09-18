package com.qianyitian.blockly.poc.controller;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.JavaMethodReflectionFunctionMissing;
import com.qianyitian.blockly.function.MonthPerformFactorFunction;
import com.qianyitian.blockly.function.MonthPerformSalaryStandardFunction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
public class BlocklyController {
    private Logger logger = LoggerFactory.getLogger(getClass());
    ExecutorService threadPool = Executors.newFixedThreadPool(2);
    Map<String, String> map = new HashMap<>();

    String xml_folder_path = "C:\\Users\\bing.a.qian\\IdeaProjects\\blockly.poc\\files\\";
    String rule_folder_path = "C:\\Users\\bing.a.qian\\IdeaProjects\\blockly.poc\\files\\";

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

//    @PostMapping(value = "/run")
//    public String run(@RequestBody String input) throws IOException {
//        logger.info("Running   ======================================= " + input);
//        Map<String, Object> env = AviatorEvaluator.newEnv("userID", 1001L, "baseTax", 10000D);
//        AviatorEvaluator.addFunction(new AddFunction());
//        AviatorEvaluator.setFunctionMissing(JavaMethodReflectionFunctionMissing.getInstance());
//        Expression exp = AviatorEvaluator.getInstance().compileScript(rule_file_path, false);
//        Object execute = exp.execute(env);
//        BigDecimal tax = (BigDecimal) execute;
//        env = AviatorEvaluator.newEnv("userID", 1002L, "baseTax", 10000D);
//        execute = exp.execute(env);
//        tax = (BigDecimal) execute;
//        System.out.println("运行结果为： " + tax);
//        return String.valueOf(tax);
//    }


    @PostMapping(value = "/saveScript/{ruleName}")
    public String saveScript(@PathVariable String ruleName, @RequestBody String input) throws IOException {
        logger.info("saveScript   ======================================= " + input);
        String filename = rule_folder_path + ruleName + ".av";
        fileLinesWrite(filename, input);
        return "OK";
    }

    @PostMapping(value = "/loadScript/{ruleName}")
    public String loadScript(@PathVariable String ruleName) throws IOException {
        String filename = rule_folder_path + ruleName + ".av";
        String s = ReadFile(filename);
        logger.info("loadScript   ======================================= " + s);
        return s;
    }

    @PostMapping(value = "/saveXML/{ruleName}")
    public String saveXML(@PathVariable String ruleName, @RequestBody String input) throws IOException {
        logger.info("saveXML   ======================================= " + input);
        String filename = xml_folder_path + ruleName + ".xml";
        fileLinesWrite(filename, input);
        return "OK";
    }

    @PostMapping(value = "/loadXML/{ruleName}")
    public String loadXML(@PathVariable String ruleName) throws IOException {
        String filename = xml_folder_path + ruleName + ".xml";
        String content = ReadFile(filename);
        logger.info("loadXML   ======================================= " + content);
        return content;
    }

    @PostMapping(value = "/executeRule/{ruleName}")
    public String executeRule(@PathVariable String ruleName,@RequestBody String input) throws IOException {
        logger.info("Running   ======================================= " + input);
        String filename = rule_folder_path + ruleName + ".av";
        if(StringUtils.isEmpty(input)){
            input="111";
        }
        String userid = input;
        Map<String, Object> env = AviatorEvaluator.newEnv("userId", userid);
        AviatorEvaluator.addFunction(new MonthPerformFactorFunction());
        AviatorEvaluator.addFunction(new MonthPerformSalaryStandardFunction());

        AviatorEvaluator.setFunctionMissing(JavaMethodReflectionFunctionMissing.getInstance());

        Expression exp = AviatorEvaluator.getInstance().compileScript(filename, false);
        Object execute = exp.execute(env);
        BigDecimal tax = (BigDecimal) execute;

        String result = "运行结果为: " + tax;
        return result;
    }


    public static String ReadFile(String Path) {
        BufferedReader reader = null;
        String laststr = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(Path);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null) {
                laststr += tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return laststr;
    }

    /**
     * 文件数据写入（如果文件夹和文件不存在，则先创建，再写入）
     *
     * @param filePath
     * @param content
     */
    public static void fileLinesWrite(String filePath, String content) {
        FileWriter fw = null;
        try {
            File file = new File(filePath);
            //如果文件夹不存在，则创建文件夹
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {//如果文件不存在，则创建文件,写入第一行内容
                file.createNewFile();
                fw = new FileWriter(file);
            } else {//如果文件存在,则追加或替换内容
                fw = new FileWriter(file, false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        PrintWriter pw = new PrintWriter(fw);
        pw.println(content);
        pw.flush();
        try {
            fw.flush();
            pw.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
