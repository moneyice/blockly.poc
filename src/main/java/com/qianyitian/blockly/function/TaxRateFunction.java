package com.qianyitian.blockly.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.math.BigDecimal;
import java.util.Map;

/**
 * 税率
 */
public class TaxRateFunction extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env) {
        String userId = (String) env.get("userId");
        return new AviatorDecimal(taxRate(userId));
    }

    /**
     * 税率
     *
     * @param userId
     * @return
     */
    private BigDecimal taxRate(String userId) {
        if ("111".equals(userId)) {
            return BigDecimal.valueOf(0.03);
        } else {
            return BigDecimal.valueOf(0);
        }
    }

    @Override
    public String getName() {
        return "taxRate";
    }
}