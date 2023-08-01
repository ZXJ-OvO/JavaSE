package com.review.networkProgram;

import java.net.InetAddress;

/**
 * 网络编程常用API
 */
public class NetworkMethod {
    public static void main(String[] args) throws Exception {
        // 获取本机的IP地址对象
        InetAddress localHost = InetAddress.getLocalHost();
        // 获取本机的IP地址
        String address = localHost.getHostAddress();
        System.out.println(address);
        // 获取本机的主机名
        String hostName = localHost.getHostName();
        System.out.println(hostName);

        // 获取目标主机的IP地址对象
        InetAddress byName = InetAddress.getByName("www.baidu.com");
        // 获取目标主机的IP地址
        System.out.println(byName.getHostAddress());
        InetAddress name = InetAddress.getByName("192.168.90.111");
        // 获取目标主机的主机名
        System.out.println(name.getHostName());

        // 在指定时间能否ping通目标主机
        boolean reachable = byName.isReachable(3000);
        System.out.println(reachable);

        /*
            周知端口号 0-1023
            注册端口 1024-49151
            动态端口 49152-65535
         */



    }
}
