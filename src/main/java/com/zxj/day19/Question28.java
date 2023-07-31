package com.zxj.day19;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP客户端
 */
public class Question28 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 6666);
        OutputStream os = socket.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            String msg = scanner.nextLine();
            dos.writeUTF(msg);
            dos.flush();
        }
    }
}

class ServerReaderThread extends Thread {
    private Socket socket;

    public ServerReaderThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            while (true){
                String msg = dis.readUTF();
                String address = socket.getInetAddress().getHostAddress();
                int port = socket.getPort();
                System.out.println("服务端收到" + address + ":" + port + "->" + msg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Question28Server {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动...");
        ServerSocket socket = new ServerSocket(6666);
        while (true) {
            Socket accept = socket.accept();
            System.out.println("客户端上线了");
        }
    }
}