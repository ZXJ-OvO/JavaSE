package com.daily.huangpuSETest.demo05;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) throws Exception {

        try (
                // 创建发送端的Socket对象与服务端连接，参数为服务端的IP和端口
                Socket socket = new Socket("localhost", 8964);
                BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
                Scanner scanner = new Scanner(System.in)
        ) {
            System.out.println("连接服务中...");
            OUT:
            while (true) {
                System.out.println("1. 注册\n2. 登录\n3. 退出");
                System.out.print("请输入你的操作指令: ");

                switch (scanner.nextLine()) {
                    case "1": {
                        writer.println(registerUser(scanner));
                        break;
                    }
                    case "2": {
                        writer.println(loginUser(scanner));
                        break;
                    }
                    case "3":
                        writer.println("退出");
                        break OUT;
                    default:
                        System.out.println("🥲选择指令无效，请重试.");
                        break;
                }

                String response = reader.readLine();
                System.out.println("💻服务响应中...: " + response);
            }
        }
    }

    private static String registerUser(Scanner scanner) {
        System.out.print("🫣输入用户名: ");
        String username = scanner.nextLine();
        System.out.print("🫣输入密码: ");
        String password = scanner.nextLine();
        return "注册:" + username + ":" + password;
    }

    private static String loginUser(Scanner scanner) {
        System.out.print("⌨️输入用户名: ");
        String username = scanner.nextLine();
        System.out.print("⌨️输入密码: ");
        String password = scanner.nextLine();
        return "登录:" + username + ":" + password;
    }
}
