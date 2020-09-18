package com.qianyitian.blockly.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.math.BigDecimal;
import java.util.Map;

public class MonthPerformFactorFunction extends AbstractFunction {
        @Override
        public AviatorObject call(Map<String, Object> env) {
            String userId = (String)env.get("userId");
            //查数据库得出 工资标准
            BigDecimal monthPerformSalaryStandard = queryMonthPerformFactor(userId);
            return new AviatorDecimal(monthPerformSalaryStandard);
        }

    private BigDecimal queryMonthPerformFactor(String userId) {
            if("111".equals(userId)){
                return BigDecimal.valueOf(0.9);
            }else{
                return BigDecimal.valueOf(1);
            }

    }

    @Override
        public String getName() {
            return "getMonthPerformFactor";
        }
    }