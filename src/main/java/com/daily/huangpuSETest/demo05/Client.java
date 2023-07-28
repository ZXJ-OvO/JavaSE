package com.daily.huangpuSETest.demo05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8964);
            System.out.println("连接服务中...");

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println("1. Register\n2. Login\n3. Exit");
                System.out.print("Enter your choice: ");
                String choice = scanner.nextLine();

                if (choice.equals("1")) {
                    String data = registerUser(scanner);
                    writer.println(data);
                } else if (choice.equals("2")) {
                    String data = loginUser(scanner);
                    writer.println(data);
                } else if (choice.equals("3")) {
                    writer.println("exit");
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }

                String response = reader.readLine();
                System.out.println("Server response: " + response);
            }

            reader.close();
            writer.close();
            scanner.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String registerUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return "register:" + username + ":" + password;
    }

    private static String loginUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return "login:" + username + ":" + password;
    }
}
