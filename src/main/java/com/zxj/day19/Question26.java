package com.zxj.day19;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP发送端
 */
public class Question26 {
    public static void main(String[] args) throws Exception {
        // 创建发送端管道 默认分配程序端口
        DatagramSocket socket = new DatagramSocket();

        // 准备数据包对象
        byte[] bytes = "今晚啤酒、龙虾、小烧烤、探讨一下人生".getBytes();
        DatagramPacket packet = new DatagramPacket(
                bytes,
                bytes.length,
                InetAddress.getLocalHost(),
                8888
        );

        socket.send(packet);

        socket.close();

    }
}

class Q26Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);
        byte[] buffer = new byte[64 * 1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        socket.receive(packet);

        int length = packet.getLength();

        InetAddress address = packet.getAddress();
        int port = packet.getPort();
        System.out.println(address + ":" + port);

        String rs = new String(buffer, 0, length);
        System.out.println(rs);

    }
}