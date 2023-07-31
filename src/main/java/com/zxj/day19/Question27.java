package com.zxj.day19;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * UDP多发多收
 */
public class Question27 {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String msg = scanner.nextLine();

            if ("exit".equalsIgnoreCase(msg)) {
                System.out.println("退出成功！");
                System.exit(1);
            }

            byte[] bytes = msg.getBytes();
            DatagramPacket packet = new DatagramPacket(bytes,
                    bytes.length,
                    InetAddress.getByName("localhost"),
                    8888);

            socket.send(packet);
        }
    }
}

class Question27Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(8888);

        byte[] bytes = new byte[1024 * 64];
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length);

        while (true) {
            socket.receive(packet);

            int len = packet.getLength();

            InetAddress address = packet.getAddress();
            int port = packet.getPort();
            System.out.println(address + ":" + port);

            String s = new String(bytes, 0, len);
            System.out.println(s);
        }

    }
}

