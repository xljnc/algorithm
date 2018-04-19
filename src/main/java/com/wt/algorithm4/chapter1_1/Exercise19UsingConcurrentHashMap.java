package com.wt.algorithm4.chapter1_1;

import java.math.BigDecimal;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 使用ConcurrentHashMap实现缓存。
 * 转载自:http://ifeve.com/java8-local-caching/
 *
 * @Author WuTian
 * @Date 2018-04-19 11:53
 */
public class Exercise19UsingConcurrentHashMap {
    private static final Map<Integer, BigDecimal> cache = new ConcurrentHashMap<>(1024);

    static {
        cache.put(0, new BigDecimal(0));
        cache.put(1, new BigDecimal(1));
    }

    public static void main(String[] args) {
        for(int i=0;i<1000;i++){
            System.out.println("index:"+i+",value:"+fibonacci(i));
        }
    }

    private static BigDecimal fibonacci(int index) {
        cache.computeIfAbsent(index, (key) -> {
            return fibonacci(index-1).add(fibonacci(index-2));
        });
        return cache.get(index);
    }


}
