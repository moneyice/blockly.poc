package com.qianyitian.blockly.function.other;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDouble;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;

import java.util.Map;

/**
 * 自定义函数
 */
public class SubjectFunciton extends AbstractFunction {
    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1, AviatorObject arg2) {

        String code = FunctionUtils.getStringValue(arg1, env);
        String type = FunctionUtils.getStringValue(arg2, env);

        String orgId = (String) env.get("orgId");
        if(type.equals("1")) {
            return new AviatorString(customStringMethod(code, orgId));
        }
        return new AviatorDouble(customNumberMethod(code, orgId));
    }

    private double customNumberMethod(String code, String orgId) {
        //查数据库判断类型是数字/日期/字符串

        return 300;
    }
    private String customStringMethod(String code, String orgId) {
        //查数据库判断类型是数字/日期/字符串

        return "aa";
    }

    @Override
    public String getName() {
        return "subject";
    }
}