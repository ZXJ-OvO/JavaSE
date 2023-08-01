package com.review.networkProgram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP协议 一发一收
 */
public class UDPDemo01 {

}

class UDPClient01 {
    public static void main(String[] args) throws Exception {
        // 创建发送端对象，默认分配端口
        DatagramSocket socket = new DatagramSocket();

        // 准备数据包对象
        String s = "基于UDP协议的一发一收";
        byte[] bytes = s.getBytes();

        DatagramPacket packet = new DatagramPacket(
                bytes,
                bytes.length,
                InetAddress.getByName("localhost"),
                6666);

        // 发送数据包
        socket.send(packet);

        // 关闭资源
        socket.close();
    }
}

class UDPServer01 {
    public static void main(String[] args) throws Exception {
        // 创建服务端端口;
        DatagramSocket socket = new DatagramSocket(6666);

        // 准备一个数据包对象
        byte[] bytes = new byte[64 * 1024];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

        // 接收数据包
        socket.receive(packet);
        int length = packet.getLength();

        InetAddress address = packet.getAddress();
        int port = packet.getPort();

        // 解析数据包 读到多少写出多少
        String rs = new String(bytes, 0, length);
        System.out.println("收到了来自" + address + ":" + port + "的数据：\n" + rs);
    }
}