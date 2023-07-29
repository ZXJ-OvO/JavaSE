package com.daily.huangpuSETest.demo05;

/*
  **需求**
  在实际开发中，很多系统都要完成用户登录和注册功能，但需要注意的是，用户注册的登录名和密码必须是发送给服务端进行保存的，**并且注册的登录名是不能重复的**，同时登录也是需要到服务端进行认证的。
  **功能点具体要求**
  1、开发一个客户端，具备注册，和登录功能，除非用户输入exit，否则不退出这个界面。
  2、注册功能要求：可以发送登录名和密码给服务端，服务端要响应是否注册成功的结果给客户端。如果注册没有问题，服务端需要将用户注册的登录名和密码保存到文件中去。（**注：是什么文件，可自行确定**）
  3、登录功能要求：用户输入登录名和密码，需要发送给服务端，服务端认证后需要把登录的结果发送给客户端接收。
  **评分细则**
  能开发出客户端，并成功发送注册信息给服务端接收  4
  服务端能接收注册信息，并成功写出去到属性文件中去 9
  客户端能正确收到服务端响应的注册信息。 2
  客户端能成功发出登录信息，服务端能成功收到  3
  服务端能正确认证登录是否成功  4
  客户端能收到登录后的结果。 2
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 */
public class Server {
    private static final String USER_FILE = "src\\main\\java\\com\\daily\\huangpuSETest\\demo05\\users.txt";

    public static void main(String[] args) throws Exception {

        // 为服务端程序注册端口号8964
        ServerSocket serverSocket = new ServerSocket(8964);
        System.out.println("服务端启动成功，等待客户端连接中...");


        while (true) {
            // 阻塞等待客户端的连接请求，一旦与某个客户端成功连接，则返回服务端的Socket对象
            Socket clientSocket = serverSocket.accept();
            System.out.println("💻: " + clientSocket.getInetAddress() + " 已连接...🚴‍♂️");

            // TODO: 2023/7/28
            // 为每个客户端连接开启一个线程
            handleClient(clientSocket);

            // 断开Socket
            clientSocket.close();
            System.out.println("💻: " + clientSocket.getInetAddress() + "已断开...🚳");
        }
    }

    private static void handleClient(Socket clientSocket) throws Exception {
        try (
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            while (true) {
                String data = reader.readLine();
                if (data == null || data.equalsIgnoreCase("⛔退出")) {
                    break;
                }

                String[] parts = data.split(":");
                String action = parts[0];
                String username = parts[1];
                String password = parts[2];

                if (action.equalsIgnoreCase("✏️注册")) {
                    if (isUsernameTaken(username)) {
                        writer.println("🫠账户名已存在，注册失败!");
                    } else {
                        registerUser(username, password);
                        writer.println("🥳注册成功！");
                    }
                } else if (action.equalsIgnoreCase("✏️登录")) {
                    if (isValidLogin(username, password)) {
                        writer.println("🤪登陆成功！");
                    } else {
                        writer.println("😣无效的账号或密码");
                    }
                }
            }
        }
    }

    private static boolean isUsernameTaken(String username) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(USER_FILE));
        String line;
        while ((line = reader.readLine()) != null) {
            String storedUsername = line.split(":")[0];
            if (storedUsername.equals(username)) {
                return true;
            }
        }
        return false;
    }

    private static void registerUser(String username, String password) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(USER_FILE, true))) {
            writer.println(username + ":" + password);
        }
    }

    private static boolean isValidLogin(String username, String password) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(USER_FILE));
        String line;
        while ((line = reader.readLine()) != null) {
            String storedUsername = line.split(":")[0];
            String storedPassword = line.split(":")[1];
            if (storedUsername.equals(username) && storedPassword.equals(password)) {
                return true;
            }
        }
        return false;
    }
}
