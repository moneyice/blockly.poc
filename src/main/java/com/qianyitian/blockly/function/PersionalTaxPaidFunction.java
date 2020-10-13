package com.qianyitian.blockly.function;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.qianyitian.blockly.util.FunctionUtil;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 已纳个人所得税
 */
public class PersionalTaxPaidFunction extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env) {
        String userId = (String) env.get("userId");
        return new AviatorDecimal(personalTaxPaid(userId));
    }

    /**
     * 已纳个人所得税
     *
     * @param userId
     * @return
     */
    private BigDecimal personalTaxPaid(String userId) {
        if ("111".equals(userId)) {
            return BigDecimal.valueOf(5000.00);
        } else {
            return BigDecimal.valueOf(10);
        }
    }

    @Override
    public String getName() {
        return "personalTaxPaid";
    }
}