package com.zxj.day19;

import java.net.InetAddress;

public class Question25 {
    public static void main(String[] args) throws Exception {
/*        Class<?> inetAddressReflex = Class.forName("java.net.InetAddress");
        Constructor<?>[] constructors = inetAddressReflex.getDeclaredConstructors();
        for (Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            InetAddress o = (InetAddress) constructor.newInstance();
            String reflexHostName = o.getHostName();
            System.out.println(reflexHostName);
        }*/

        // 获得本机ip对象
        InetAddress inetAddress = InetAddress.getLocalHost();
        String hostName = inetAddress.getHostName();
        String address = inetAddress.getHostAddress();
        System.out.println(hostName);
        System.out.println(address);

        System.out.println("----------------------------");

        // 获得指定主机
        InetAddress ip1 = InetAddress.getByName("www.itcast.com");
        System.out.println(ip1.getHostName());
        InetAddress ip2 = InetAddress.getByName("localhost");
        System.out.println(ip2.getHostName());

        // 判断本机与该主机是否联通
        System.out.println(ip2.isReachable(5000));

    }
}
