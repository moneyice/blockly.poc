package com.qianyitian.blockly.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import com.qianyitian.blockly.util.DateUtil;

import java.util.Map;

/**
 * 期初开始日期函数
 */
public class BeginDateFunction extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env) {
        return new AviatorString(beginDate(env));
    }

    /**
     * 期初开始函数
     *
     * @param env
     * @return
     */
    private String beginDate(Map<String, Object> env) {
        //参数个数2020-10
        String accountDate = (String) env.get("accountDate");
        return DateUtil.getFirstDayOfMonth(accountDate);

    }

    @Override
    public String getName() {
        return "beginDate";
    }
}