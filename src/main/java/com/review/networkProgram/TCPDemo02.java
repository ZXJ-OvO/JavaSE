package com.review.networkProgram;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * TCP协议 多发多收（不支持多个客户端）
 */
public class TCPDemo02 {

}

class Client02 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket(InetAddress.getLocalHost(), 6666);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        while (true) {
            String s = scanner.nextLine();
            dataOutputStream.writeUTF(s);
            dataOutputStream.flush();
        }
    }
}

class Server02 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(6666);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        InetAddress inetAddress = socket.getInetAddress();
        String address = inetAddress.getHostAddress();

        while (true) {
            String s = dataInputStream.readUTF();
            int port = socket.getPort();
            System.out.println(address + ":" + port + "说：" + s);
        }
    }
}
