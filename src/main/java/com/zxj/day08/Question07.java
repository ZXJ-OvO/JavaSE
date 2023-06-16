package com.zxj.day08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 完成菜品的上架、以及菜品信息浏览功能。
 */
public class Question07 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入需要上架的菜品名称（按q结束上架）：");
            String name = sc.nextLine();
            if (name.equals("q")) {
                break;
            }
            list.add(name);
        }
        System.out.println("上架操作成功，当前菜品有：" + list);
    }
}
