package com.zxj.day22;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;

/**
 * InetAddress类常用API  ip地址对象
 */
public class Question01 {
    public static void main(String[] args) throws Exception {
        System.out.println(Inet4Address.getLocalHost());
        System.out.println(Inet6Address.getLocalHost());

        // 获取本机IP，返回以一个inetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();

        // 根据IP地址创建一个inetAddress对象
        InetAddress inetAddress = InetAddress.getByName("192.168.90.111");

        // 根据给定的ip地址获取主机名
        String hostName = inetAddress.getHostName();
        System.out.println(hostName);

        // 从ip地址对象中获取ip地址
        String address = localHost.getHostAddress();
        System.out.println(address);

        // 在指定的毫秒内判断是否能与目标主机ping通
        boolean reachable = inetAddress.isReachable(5000);
        System.out.println(reachable);
    }
}
