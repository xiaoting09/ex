package com.xiao.ex.utils;


import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

/**
 * 值转换String
 *
 * @author 肖亭
 * @since 2017年09月15 16:36
 **/
public class ValueToStr {
    /**
     * map转换位json
     *
     * @param params Map值
     * @return
     */
    public static String parameters2String(Map<String, String[]> params) {
        if (params == null || params.size() == 0) {
            return null;
        }
        Map<String, String> params2 = new HashMap<>();
        params.forEach((key, values) -> {
            params2.put(key, values[0]);
        });
        return (new Gson()).toJson(params2);
    }
}
