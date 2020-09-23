package com.qianyitian.blockly.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 年度专项扣减调整
 */
public class AnnualSpecialDeductionAdjustmentFunction extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env) {
        String userId = (String) env.get("userId");
        return new AviatorDecimal(annualSpecialDeductionAdjustment(userId));
    }

    /**
     * 年度专项扣减调整
     *
     * @param userId
     * @return
     */
    private BigDecimal annualSpecialDeductionAdjustment(String userId) {
        if ("111".equals(userId)) {
            return BigDecimal.valueOf(11);
        } else {
            return BigDecimal.valueOf(0);
        }
    }

    @Override
    public String getName() {
        return "annualSpecialDeductionAdjustment";
    }
}