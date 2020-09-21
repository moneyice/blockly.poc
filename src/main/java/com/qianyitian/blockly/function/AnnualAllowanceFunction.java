package com.qianyitian.blockly.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 年度免税额
 */
public class AnnualAllowanceFunction extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env) {
        String userId = (String) env.get("userId");
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