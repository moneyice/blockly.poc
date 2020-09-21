package com.qianyitian.blockly.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 年度赡养老人
 */
public class AnnualSupportForElderlyFunction extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env) {
        String userId = (String) env.get("userId");
        return new AviatorDecimal(annualSupportForElderly(userId));
    }

    /**
     * 年度赡养老人
     *
     * @param userId
     * @return
     */
    private BigDecimal annualSupportForElderly(String userId) {
        if ("111".equals(userId)) {
            return BigDecimal.valueOf(9000.00);
        } else {
            return BigDecimal.valueOf(0);
        }
    }

    @Override
    public String getName() {
        return "annualSupportForElderly";
    }
}