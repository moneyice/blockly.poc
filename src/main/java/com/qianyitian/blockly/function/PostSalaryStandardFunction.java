package com.qianyitian.blockly.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 岗位工资标准
 */
public class PostSalaryStandardFunction extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env) {

        //查数据库得出 岗位工资标准
        BigDecimal monthPerformSalaryStandard = postSalaryStandard(env);
        return new AviatorDecimal(monthPerformSalaryStandard);
    }

    private BigDecimal postSalaryStandard(Map<String, Object> env) {
        String userId = (String) env.get("userId");
        //“薪点制”工资标准中最近的 月度岗位工资金额
        String accountDate = (String) env.get("accountDate");
        if ("test".equals(userId)) {
            return BigDecimal.valueOf(8000);
        } else {
            return BigDecimal.valueOf(5000);
        }

    }

    @Override
    public String getName() {
        return "postSalaryStandard";
    }
}