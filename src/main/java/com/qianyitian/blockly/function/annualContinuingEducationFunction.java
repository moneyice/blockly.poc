package com.qianyitian.blockly.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.math.BigDecimal;
import java.util.Map;
/**
 * 年度继续教育
 */
public class annualContinuingEducationFunction extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env) {
        String userId = (String) env.get("userId");
        return new AviatorDecimal(annualContinuingEducation(userId));
    }

    /**
     * 年度继续教育
     *
     * @param userId
     * @return
     */
    private BigDecimal annualContinuingEducation(String userId) {
        if ("111".equals(userId)) {
            return BigDecimal.valueOf(2000.00);
        } else {
            return BigDecimal.valueOf(0);
        }
    }

    @Override
    public String getName() {
        return "annualContinuingEducationFunction";
    }
}