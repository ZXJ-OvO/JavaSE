package com.zxj.day19;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 分别创建客户端、服务端，并绑定端口。
 * 1. 服务端要求：
 * 1. 使用多线程来侦听客户端请求；
 * 2. 如果有客户发出请求，则主动给每位客户端发送一句“欢迎光临！请上传文件(文本文件)！”；
 * 3. 用户上传后，将文件保存在本地，并回复上传成功；
 * 4. 如果客户端上传的文件中有敏感词汇，则替换成**，再保存。
 * 5. 敏感词汇：操
 * 2. 客户端要求：
 * 1. 创建一个套接字(Socket)， 向服务器的侦听端口发出请求；
 * 2. 从本地选择一个带有敏感词汇的文本文件上传到服务器；
 * 3. 并将服务端响应的数据在控制台输出。
 */
public class Question30 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket();
        OutputStream stream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(stream);
    }
}
