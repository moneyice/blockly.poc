package com.qianyitian.blockly.util;

import org.springframework.util.StringUtils;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {
    //格式化日期
    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 获取核算日期的第一天
     *
     * @param dateStr yyyy-mm
     * @return
     */
    public static String getFirstDayOfMonth(String dateStr) {
        if (StringUtils.isEmpty(dateStr)) {
            return sdf.format(getMonthFirstDay());
        }
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, getYear(dateStr));
        //设置月份
        cal.set(Calendar.MONTH, getMonth(dateStr) - 1);
        //获取某月最小天数
        int firstDay = cal.getMinimum(Calendar.DATE);
        //设置日历中月份的最小天数
        cal.set(Calendar.DAY_OF_MONTH, firstDay);

        return sdf.format(cal.getTime());
    }

    /**
     * 获取核算日期的最后一天
     *
     * @param dateStr
     * @return
     */
    public static String getLastDayOfMonth(String dateStr) {
        if(StringUtils.isEmpty(dateStr)){
            return sdf.format(getMonthLastDay());
        }
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR, getYear(dateStr));
        //设置月份
        cal.set(Calendar.MONTH, getMonth(dateStr) - 1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        //设置日历中月份的最大天数
        cal.set(Calendar.DAY_OF_MONTH, lastDay);
        //格式化日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(cal.getTime());
    }

    /**
     * 获取核算日期的年
     *
     * @param timeString
     * @return
     */
    public static int getYear(String timeString) {
        return Integer.parseInt(timeString.substring(0, 4));
    }

    /**
     * 获取核算日期月
     *
     * @param timeString
     * @return
     */
    public static int getMonth(String timeString) {
        return Integer.parseInt(timeString.substring(5, 7));
    }

    /**
     * 获取当前月份第一天
     *
     * @return
     */
    public static Date getMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.add(Calendar.MONTH, 0);
        return calendar.getTime();
    }

    /**
     * 获取当前月份最后一天
     * @return
     */
    public static Date getMonthLastDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, 0);
        calendar.add(Calendar.MONTH, 1);
        return calendar.getTime();
    }
    /**
     * 获取当前月份15号
     * @return
     */
    public static String getMonthMiddleDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(Calendar.DAY_OF_MONTH, 15);
        calendar.add(Calendar.MONTH, 0);
        return sdf.format(calendar.getTime());
    }

    public static void main(String[] args) {

    }
}