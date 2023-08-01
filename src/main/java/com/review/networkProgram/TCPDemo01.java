package com.review.networkProgram;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP协议 一发一收
 */
public class TCPDemo01 {
}

class Client01 {
    public static void main(String[] args) throws Exception {
        // 创建Socket管道，与目标服务接通
        Socket socket = new Socket(InetAddress.getLocalHost(), 6666);

        // 从Socket管道中得到一个字节输出流
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeUTF("喂？是朱磊吗？你就是朱磊！");
        dataOutputStream.flush();
        System.out.println("发送完毕！");
    }
}

class Server01 {
    public static void main(String[] args) throws Exception {
        // 注册端口
        ServerSocket serverSocket = new ServerSocket(6666);
        // 开始接收客户端的Socket管道连接
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        String msg = dataInputStream.readUTF();

        String address = socket.getInetAddress().getHostAddress();
        int port = socket.getPort();

        System.out.println(address + ":" + port + "说：" + msg);
    }
}