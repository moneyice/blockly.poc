package com.qianyitian.blockly.function;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.qianyitian.blockly.util.FunctionUtil;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 年度免税额
 */
public class AnnualAllowanceFunction extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env) {
        String userId = (String) env.get("userId");
        String filename =  System.getProperty("user.dir") + "\\files\\" + "test.av";

        List<AbstractFunction> list = FunctionUtil.findAllFunctions();
        for (AbstractFunction abstractFunction : list) {
            AviatorEvaluator.addFunction(abstractFunction);
        }
        Expression exp = null;
        try {
            exp = AviatorEvaluator.getInstance().compileScript(filename, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Object execute = exp.execute(env);
        BigDecimal tax = (BigDecimal) execute;
        return new AviatorDecimal(annualAllowance(userId));
    }

    /**
     * 年度免税额
     *
     * @param userId
     * @return
     */
    private BigDecimal annualAllowance(String userId) {
        if ("111".equals(userId)) {
            return BigDecimal.valueOf(31500.00);
        } else {
            return BigDecimal.valueOf(0);
        }
    }

    @Override
    public String getName() {
        return "annualAllowance";
    }
}