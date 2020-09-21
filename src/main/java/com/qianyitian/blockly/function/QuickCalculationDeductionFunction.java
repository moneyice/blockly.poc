package com.qianyitian.blockly.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 速算扣除数
 */
public class QuickCalculationDeductionFunction extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env) {
        String userId = (String) env.get("userId");
        return new AviatorDecimal(quickCalculationDeduction(userId));
    }

    /**
     * 速算扣除数
     *
     * @param userId
     * @return
     */
    private BigDecimal quickCalculationDeduction(String userId) {
        if ("111".equals(userId)) {
            return BigDecimal.valueOf(500.00);
        } else {
            return BigDecimal.valueOf(0);
        }
    }

    @Override
    public String getName() {
        return "quickCalculationDeduction";
    }
}