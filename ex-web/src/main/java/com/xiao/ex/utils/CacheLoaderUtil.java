package com.xiao.ex.utils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.xiao.ex.common.SpringContextUtil;
import com.xiao.ex.service.ConfigService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * 缓存工具类
 *
 * @author 肖亭
 * @since 2017年10月24 17:08
 **/
public class CacheLoaderUtil {

    static LoadingCache<String, Boolean> cache;

    static {
        cache = CacheBuilder.newBuilder().refreshAfterWrite(24, TimeUnit.HOURS)
                .expireAfterAccess(24, TimeUnit.HOURS)
                .maximumSize(10).
                        build(new CacheLoader<String, Boolean>() {
                            @Override
                            public Boolean load(String appKey) {
                                return getAppkeyInfo(appKey);
                            }

                            private Boolean getAppkeyInfo(String appKey) {
                                return ((ConfigService) SpringContextUtil.getBean("configService"))
                                        .isVersion();
                            }
                        });
    }

    public static Boolean getMysqlV7() {
        try {
            return cache.get("mysql");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return false;
    }


}
