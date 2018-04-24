package com.xiao.ex.common;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 任务缓存
 *
 * @author 肖亭
 * @since 2018年03月23 11:09
 **/
public class CacheUtil {
    static LoadingCache<String, AtomicLong> count = CacheBuilder.newBuilder()
            .expireAfterWrite(30, TimeUnit.MINUTES)
            .build(new CacheLoader<String, AtomicLong>() {
                @Override
                public AtomicLong load(String key) throws Exception {
                    return new AtomicLong(1L);
                }
            });

    public static Boolean getCache(String key) throws ExecutionException {
        return count.get(key).getAndIncrement() > 0;
    }

}
