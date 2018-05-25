package com.wt.algorithm4.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author WuTian
 * @date 2018-05-24 11:52
 * @description
 */
public class Slf4jTest {
    private static final Logger log = LoggerFactory.getLogger(Slf4jTest.class);
    public static void main(String[] args) {
        log.info("test log:{},{}","abc","cde");
    }
}
