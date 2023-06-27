package com.zxj.day13;

import java.io.IOException;

/**
 * API Runtime
 */
public class Question03 {
    public static void main(String[] args) throws IOException {
        // 设置堆内存大小为12 GB
        long heapSize = 12L * 1024 * 1024 * 1024;
        byte[] dummyArray = new byte[(int) heapSize];

        // 分配一个大型数组，占用内存
        int[] largeArray = new int[1024 * 1024 * 100]; // 大约占用 400 MB 的内存

// 返回Java虚拟机中的内存总量，以字节为单位
        long totalMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        System.out.println("Total Memory: " + totalMemory + " MB");
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        System.out.println("Max Memory: " + maxMemory + " MB");


// 返回Java虚拟机中的内存总量，以字节为单位
//        long totalMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
//        System.out.println("Total Memory: " + totalMemory + " MB");


        // Runtime无法直接new出来，使用这种如下这种方法创建
        Runtime runtime = Runtime.getRuntime();
        System.out.println(runtime.toString());

        // 终止当前运行的虚拟机
        // runtime.exit(0);

        // 返沪Java虚拟机可用的处理器数
        int i = runtime.availableProcessors();
        System.out.println(i);

        // 返回Java虚拟机中的内存总量，以字节为单位
        long max = runtime.totalMemory() / 1024 / 1024;
        System.out.println(max);

        // 返回Java虚拟机中已经分配的内存总量，以字节为单位
        long l = runtime.totalMemory() / 1024 / 1024;
        System.out.println(l);


        // 返回Java虚拟机中的空闲内存量，以字节为单位
        long freeMemory = runtime.freeMemory() / 1024 / 1024;
        System.out.println(freeMemory);

        // 启动某个程序，并返回代表该程序的对象
        Process exec = runtime.exec("cmd.exe");
        System.out.println(exec);

    }
}
