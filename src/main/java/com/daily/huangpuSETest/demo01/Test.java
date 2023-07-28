package com.daily.huangpuSETest.demo01;


import org.dom4j.io.SAXReader;

import java.io.InputStream;

public class Test {
    public static void main(String[] args) {
        SAXReader saxReader = new SAXReader();
        InputStream resourceAsStream = Test.class.getResourceAsStream("com/daily/huangpuSETest/demo01/orders.xml");

        System.out.println(resourceAsStream);
    }
}
