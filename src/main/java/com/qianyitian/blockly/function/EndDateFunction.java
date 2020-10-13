package com.qianyitian.blockly.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import com.qianyitian.blockly.util.DateUtil;

import java.util.Map;

/**
 * 期末结束日期函数
 */
public class EndDateFunction extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env) {
        return new AviatorString(entryDate(env));
    }

    /**
     * 期末结束函数
     *
     * @param env
     * @return
     */
    private String entryDate(Map<String, Object> env) {
        //参数个数2020-10
        String accountDate = (String) env.get("accountDate");
        return DateUtil.getLastDayOfMonth(accountDate);
    }

    @Override
    public String getName() {
        return "entryDate";
    }
}