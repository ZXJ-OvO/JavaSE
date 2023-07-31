package com.zxj.day22;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP:DatagramSocket
 */
public class Question02 {
    //
    public static void main(String[] args) throws Exception {
        // 创建一个UDP发送端socket对象，并随机分配一个端口号
        DatagramSocket socket = new DatagramSocket();
        System.out.println(socket);

        // 创建一个UDP接收端socket对象，并绑定到指定的端口号
        DatagramSocket socket1 = new DatagramSocket(8080);
        System.out.println(socket1);

        // 创建一个用来发出的数据包对象
        InetAddress localHost = InetAddress.getLocalHost();
        byte[] bytes = new byte[1024];


        int length = 1024;
        int port = 8080;
        DatagramPacket packet = new DatagramPacket(bytes, length, localHost, port);
        System.out.println(packet);

        // 创建一个用来接收的数据包对象
        DatagramPacket packet1 = new DatagramPacket(bytes, length);
        System.out.println(packet1);

        // 发送数据包
        socket.send(packet);

        // 接收数据包
        socket1.receive(packet1);

        // 获取数据包实际的字节个数
        int length1 = packet1.getLength();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("MyThread");
    }
}
