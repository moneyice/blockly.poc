package com.qianyitian.blockly.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.math.BigDecimal;
import java.util.Map;
/**
 * 年度月薪计税工资
 */
public class AnnualMonthlyTaxableSalaryFunction extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env) {
        String userId = (String) env.get("userId");
        return new AviatorDecimal(annualMonthlyTaxableSalary(userId));
    }

    /**
     * 年度月薪计税工资
     *
     * @param userId
     * @return
     */
    private BigDecimal annualMonthlyTaxableSalary(String userId) {
        if ("111".equals(userId)) {
            return BigDecimal.valueOf(90000.00);
        } else {
            return BigDecimal.valueOf(1);
        }
    }

    @Override
    public String getName() {
        return "annualMonthlyTaxableSalary";
    }
}