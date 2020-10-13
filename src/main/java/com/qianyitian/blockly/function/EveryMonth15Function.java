package com.qianyitian.blockly.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import com.qianyitian.blockly.util.DateUtil;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * 期初开始日期函数
 */
public class EveryMonth15Function extends AbstractFunction {
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
        if(StringUtils.isEmpty(accountDate)){
            return DateUtil.getMonthMiddleDay();
        }
        return accountDate+"-15";

    }

    @Override
    public String getName() {
        return "everyMonth15";
    }
}