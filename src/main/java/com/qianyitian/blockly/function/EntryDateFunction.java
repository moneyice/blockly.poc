package com.qianyitian.blockly.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 入职日期函数
 */
public class EntryDateFunction extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env) {
        return new AviatorString(entryDate(env));
    }

    /**
     * 入职日期函数
     *
     * @param env
     * @return
     */
    private String entryDate(Map<String, Object> env) {
        String userId = (String) env.get("userId");
        if (userId.equals("test")) {
            return "2020-10-12";
        }
        return "2020-10-20";

    }

    @Override
    public String getName() {
        return "entryDate";
    }
}