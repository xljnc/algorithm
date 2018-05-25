package com.wt.algorithm4.url;

import com.wt.algorithm4.util.RandomUtil;

/**
 * @author WuTian
 * @date 2018-05-14 9:26
 * @description
 */
public class SignatureTest {
    public static void main(String[] args) {
        String noncestr = RandomUtil.getRandom(16);
        Long timestamp = System.currentTimeMillis();
        System.out.println(noncestr);
        System.out.println(timestamp);
    }
}
