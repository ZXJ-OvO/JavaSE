package com.zxj.day23;

import java.lang.reflect.Proxy;

/**
 * 动态代理
 */
public class Question10 {
    public static void main(String[] args) {

        try {
            Class<?> aClass = Class.forName("com.zxj.day23.Question10");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        Proxy.newProxyInstance(Question10.class.getClassLoader(), new Class[]{ProxyMethod.class}, (proxy, method, args1) -> null);
    }
}

// 代理接口
interface ProxyMethod {
    void sing();

    void dance();

    void coding();
}
