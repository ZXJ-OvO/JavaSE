package com.hutool.util.system;

import cn.hutool.system.SystemUtil;

/**
 * SystemUtil 系统工具类
 */
public class HuToolSystemUtil {
    public static void main(String[] args) {
        System.out.println("获取当前进程 PID：\t" + SystemUtil.getCurrentPID());

        System.out.println("返回Java虚拟机 类加载系统 相关属性：\t" + SystemUtil.getClassLoadingMXBean());

        System.out.println("返回Java虚拟机 内存 系统相关属性：\t" + SystemUtil.getMemoryMXBean());
        System.out.println("返回Java虚拟机 线程 系统相关属性：\t" + SystemUtil.getThreadMXBean());
        System.out.println("返回Java虚拟机 运行时 系统相关属性：\t" + SystemUtil.getRuntimeMXBean());
        System.out.println("返回Java虚拟机 编译 系统相关属性：\t" + SystemUtil.getCompilationMXBean());
        System.out.println("返回Java虚拟机 运行 下的操作系统相关信息属性：\t" + SystemUtil.getOperatingSystemMXBean());
        System.out.println("获取Java虚拟机中的 MemoryPoolMXBean 列表：\t" + SystemUtil.getMemoryPoolMXBeans());
        System.out.println("获取Java虚拟机中的 MemoryManagerMXBean 列表：\t" + SystemUtil.getMemoryManagerMXBeans());
        System.out.println("获取Java虚拟机中的 GarbageCollectorMXBean 列表：\t" + SystemUtil.getGarbageCollectorMXBeans());
        System.out.println("取得 Java Virtual Machine Specification 的信息：\t" + SystemUtil.getJvmSpecInfo());
        System.out.println("取得 Java Virtual Machine Implementation 的信息：\t" + SystemUtil.getJvmInfo());
        System.out.println("取得 Java Specification 的信息：\t" + SystemUtil.getJavaSpecInfo());
        System.out.println("取得 Java Implementation 的信息：\t" + SystemUtil.getJavaInfo());
        System.out.println("取得当前运行的 JRE 的信息：\t" + SystemUtil.getJavaRuntimeInfo());
        System.out.println("取得 OS 的信息：\t" + SystemUtil.getOsInfo());
        System.out.println("取得 User 的信息：\t" + SystemUtil.getUserInfo());
        System.out.println("取得 Host 的信息：\t" + SystemUtil.getHostInfo());
        System.out.println("取得 Runtime 的信息：\t" + SystemUtil.getRuntimeInfo());
        System.out.println("获取 JVM中内存 总 大小：\t" + SystemUtil.getTotalMemory());
        System.out.println("获取 JVM中内存 剩余 大小：\t" + SystemUtil.getFreeMemory());
        System.out.println("获取 JVM 可用 的内存总大小：\t" + SystemUtil.getMaxMemory());
        System.out.println("获取总线程数：\t" + SystemUtil.getTotalThreadCount());
        SystemUtil.dumpSystemInfo();

    }
}
