package com.qianyitian.blockly.function;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.*;

import java.util.Map;

import static com.googlecode.aviator.runtime.type.AviatorType.Method;

/**
 * 自定义函数
 */
public class CustomFunciton extends AbstractFunction {
    /**
     * code=001
     * @param env
     * @param arg1
     * @param arg2
     * @return
     */
    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject code, AviatorObject arg2) {

        String value = FunctionUtils.getStringValue(code, env);
        String type = FunctionUtils.getStringValue(arg2, env);

        String orgId = (String) env.get("orgId");
        if(type.equals("1")) {
            return new AviatorString(customStringMethod(value, orgId));
        }
        return new AviatorDouble(customNumberMethod(value, orgId));
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
        return "customFunciton";
    }
}