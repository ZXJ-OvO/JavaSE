package com.daily.day07;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 第一题:
 * 1.定义一个Computer类型的数组，长度为3
 * 2.创建3个Computer对象，存储到数组中
 * 3.获取数组中价格最贵的那个电脑对象
 */
public class Question01 {
    public static void main(String[] args) {
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        class Computer implements Comparable<Computer> {
            private String name;
            private Integer price;

            @Override
            public int compareTo(Computer o) {
                return this.getPrice() - o.getPrice();
            }
        }

        Computer computer1 = new Computer("huawei", 1000);
        Computer computer2 = new Computer("msi", 200);
        Computer computer3 = new Computer("apple", 3000);
        Computer[] array = {computer1, computer2, computer3};
        Computer computer = array[1].getPrice() > array[0].getPrice() ? array[1] : array[0];
        computer = computer.getPrice() > array[2].getPrice() ? computer : array[2];
        System.out.println(computer);
    }
}
