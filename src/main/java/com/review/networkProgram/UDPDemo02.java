package com.review.networkProgram;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * UDP协议 多发多收
 */
public class UDPDemo02 {
}

class UDPClient02 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();

        Scanner scanner = new Scanner(System.in);
        byte[] bytes = new byte[1024 * 64];

        while (true) {
            String s = scanner.nextLine();
            if ("exit".equals(s)) break;

            bytes = s.getBytes();

            DatagramPacket packet = new DatagramPacket(
                    bytes,
                    bytes.length,
                    InetAddress.getByName("localhost"),
                    6666);

            socket.send(packet);

        }
        socket.close();
    }
}

class UDPServer02 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6666);
        byte[] bytes = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);
        InetAddress address = packet.getAddress();
        int port = packet.getPort();

        while (true) {
            socket.receive(packet);
            int length = packet.getLength();
            String s = new String(bytes, 0, length);
            if ("exit".equals(s)) break;
            System.out.println("收到了来自" + address + ":" + port + "的数据：\n" + s);
        }
    }
}