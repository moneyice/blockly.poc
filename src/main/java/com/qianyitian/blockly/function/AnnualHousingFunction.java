package com.qianyitian.blockly.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.math.BigDecimal;
import java.util.Map;
/**
 * 年度住房租金
 */
public class AnnualHousingFunction extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env) {
        String userId = (String) env.get("userId");
        return new AviatorDecimal(annualHousingRent(userId));
    }


    /**
     * 年度住房租金
     *
     * @param userId
     * @return
     */
    private BigDecimal annualHousingRent(String userId) {
        if ("111".equals(userId)) {
            return BigDecimal.valueOf(0);
        } else {
            return BigDecimal.valueOf(0);
        }
    }

    @Override
    public String getName() {
        return "annualHousingRent";
    }
}