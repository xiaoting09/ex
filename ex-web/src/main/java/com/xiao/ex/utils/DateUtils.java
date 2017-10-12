package com.xiao.ex.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * Created by chenchen on 17/4/18.
 */
public class DateUtils {

    /**
     * 得到几天前的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateBefore(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
        return now.getTime();
    }

    /**
     * 得到几天后的时间
     *
     * @param d
     * @param day
     * @return
     */
    public static Date getDateAfter(Date d, int day) {
        Calendar now = Calendar.getInstance();
        now.setTime(d);
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
        return now.getTime();
    }

    /**
     * 得到几天后的时间
     *
     * @param time
     * @param pattern
     * @return
     */
    public static Date getDateTimeSdf(String time, String pattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        try {
            return sdf.parse(time);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取一天开始时间
     *
     * @param time 时间
     * @return
     */
    public static Date getStartTime(Date time) {
        Calendar todayStart = Calendar.getInstance();
        todayStart.setTime(time);
        todayStart.set(Calendar.HOUR_OF_DAY, 0);
        todayStart.set(Calendar.MINUTE, 0);
        todayStart.set(Calendar.SECOND, 0);
        todayStart.set(Calendar.MILLISECOND, 0);
        return todayStart.getTime();
    }

    /**
     * 获取一天结束时间
     *
     * @param time 时间
     * @return
     */
    public static Date getEndTime(Date time) {
        Calendar todayEnd = Calendar.getInstance();
        todayEnd.setTime(time);
        todayEnd.set(Calendar.HOUR_OF_DAY, 23);
        todayEnd.set(Calendar.MINUTE, 59);
        todayEnd.set(Calendar.SECOND, 59);
        todayEnd.set(Calendar.MILLISECOND, 999);
        return todayEnd.getTime();
    }

    /**
     * 计算t1与t2之间的天数
     *
     * @param t1
     * @param t2
     * @return
     */
    public static int days(Date t1, Date t2) {
        return (int) ((t2.getTime() - t1.getTime()) / (1000 * 60 * 60 * 24));
    }

    /**
     * 获取两个时间的天数差值
     *
     * @param t1
     * @param t2
     * @return
     */
    public static int chronoUnitDays(Date t1, Date t2) {
        Long days = ChronoUnit.DAYS.between(LocalDateTime.ofInstant(t1.toInstant(), ZoneId.systemDefault()),
                LocalDateTime.ofInstant(t2.toInstant(), ZoneId.systemDefault()));
        return days.intValue();
    }

//    public static void main(String[] args) {
//        Date t1 = Date.from(LocalDateTime.parse("2017-06-24 08:56:36", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.systemDefault()).toInstant());
//        Date t2 = Date.from(LocalDateTime.parse("2017-08-09 11:44:18", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")).atZone(ZoneId.systemDefault()).toInstant());
//        System.out.println(chronoUnitDays(t1, t2));
//    }

    /**
     * 计算t1与t2之间的天数
     *
     * @param t1
     * @param t2
     * @return
     */
    public static int absDays(Date t1, Date t2) {
        return Math.abs((int) ((t2.getTime() - t1.getTime()) / (1000 * 60 * 60 * 24)));
    }

    /**
     * 对日期进行格式化(抛出错误)
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String formatDate(Date date, String pattern) {
        if (date == null || pattern.trim().length() == 0) {
            return "";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        return sdf.format(date);
    }
}
