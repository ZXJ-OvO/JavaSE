package com.review.networkProgram;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP协议 多发多收（支持多客户端）
 */
public class TCPDemo03 {
}

class Client {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket(InetAddress.getLocalHost(), 6666);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        while (true) {
            dataOutputStream.writeUTF(scanner.nextLine());
            dataOutputStream.flush();
        }
    }
}

class Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6666);
        while (true) {
            // 放进循环中不断的接收新的socket
            Socket socket = serverSocket.accept();

            // 每接收到一个新的socket就创建一条新的线程与他保持通信
            new ReadThread(socket).start();
        }
    }
}

class ReadThread extends Thread {
    private final Socket socket;

    public ReadThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        String msg;
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            while (true) {
                msg = dataInputStream.readUTF();
                System.out.println(socket.getInetAddress().getHostAddress() + ":" + "说：" + msg);
            }

        } catch (Exception e) {
            System.out.println(socket.getInetAddress().getHostAddress() + "下线了");
        }

    }
}