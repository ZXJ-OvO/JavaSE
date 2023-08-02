package com.daily.finalExam.Demo05;

import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * 1、录入学生信息。
 * 2、查询全部学生信息。
 * 3、根据id删除某个学生（客户端如果输入了exit则退出客户端）
 * 其中客户端需要录入学生信息包括：
 * 学生的学号（要求确保不重复，这里需要与服务端通信进行确认）、
 * 名称、年龄、性别。客户端录入该学生数据后需要将这位学生信息发送到服务端进行保存（服务端需要将其保存到文件中去，文件类型和内容格式请自行设计）。
 * 客户端可以继续选择2号命令，
 * 从服务端查询全部学生信息回来展示。
 * 客户端可以继续选择3号命令，提示用户输入要删除的学生id去服务端删除该学生数据，
 * 并需要将删除的结果进行返回。
 */
public class Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        System.out.println("客户端已启动，请选择功能：");
        System.out.println("1、录入学生信息。");
        System.out.println("2、查询全部学生信息。");
        System.out.println("3、根据id删除某个学生（客户端如果输入了exit则退出客户端）");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!"exit".equals(input)) {
            switch (input) {
                case "1":
                    System.out.println("请输入学生学号：");
                    String id = scanner.nextLine();
                    System.out.println("请输入学生姓名：");
                    String name = scanner.nextLine();
                    System.out.println("请输入学生年龄：");
                    String age = scanner.nextLine();
                    System.out.println("请输入学生性别");
                    String gender = scanner.nextLine();
                    Student student = new Student(id, name, age, gender);
                    new ObjectOutputStream(socket.getOutputStream()).writeObject(student);
                    System.out.println("学生信息录入成功");
                    break;
                case "2":
                    System.out.println("查询全部学生信息");


                    break;
                case "3":
                    System.out.println("根据id删除某个学生");
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
            System.out.println("客户端已启动，请选择功能：");
            System.out.println("1、录入学生信息。");
            System.out.println("2、查询全部学生信息。");
            System.out.println("3、根据id删除某个学生（客户端如果输入了exit则退出客户端）");
            input = scanner.nextLine();
        }

    }
}
