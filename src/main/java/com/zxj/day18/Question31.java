package com.zxj.day18;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Question31 {
    public static final Logger logger = LoggerFactory.getLogger(Question31.class);

    public static void main(String[] args) {
        logger.info("Hello World");
        logger.info("Hello World");
        logger.info("Hello World");
        logger.info("Hello World");
        logger.info("Hello World");
        logger.error("Hello World");
        logger.debug("Hello World");
        logger.warn("Hello World");
        logger.info("Hello World");
    }

    public static int test(int a, int b) {
        int c = a / b;
        return c;
    }
}
