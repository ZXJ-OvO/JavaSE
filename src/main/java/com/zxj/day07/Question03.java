package com.zxj.day07;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Scanner;

/**
 * Question02系统化
 */
public class Question03 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("================电影票系统================");
        System.out.println("电影票系统功能：");
        System.out.println("1、查询全部电影票信息");
        System.out.println("2、根据电影票id查询电影票信息");
        Movies movies1 = new Movies();
        Movies movies2 = new Movies();
        Movies movies3 = new Movies();
        int nextInt = sc.nextInt();
        switch (nextInt) {
            case 1:
                moviesInit(movies1, movies2, movies3);
                selectAllMovies(movies1, movies2, movies3);
                break;
            case 2:
                moviesInit(movies1, movies2, movies3);
                selectMoviesById(sc.nextLong(), movies1, movies2, movies3);
                break;
            default:
                System.out.println("输入错误");
                break;
        }
    }

    private static void selectMoviesById(Long id, Movies movies1, Movies movies2, Movies movies3) {
        if (id == 1) {
            System.out.println("电影票id：" + movies1.getId());
            System.out.println("电影票价格：" + movies2.getPrice());
            System.out.println("电影票状态：" + movies3.isStatus());
        } else if (id == 2) {
            System.out.println("电影票id：" + movies1.getId());
            System.out.println("电影票价格：" + movies2.getPrice());
            System.out.println("电影票状态：" + movies3.isStatus());
        } else if (id == 3) {
            System.out.println("电影票id：" + movies1.getId());
            System.out.println("电影票价格：" + movies2.getPrice());
            System.out.println("电影票状态：" + movies3.isStatus());
        } else {
            System.out.println("输入错误");
        }

    }

    private static void selectAllMovies(Movies movies1, Movies movies2, Movies movies3) {

        System.out.println("目前系统中的电影票信息如下：");
        System.out.println("电影票id：" + movies1.getId());
        System.out.println("电影票价格：" + movies2.getPrice());
        System.out.println("电影票状态：" + movies3.isStatus());
        System.out.println("电影票id：" + movies1.getId());
        System.out.println("电影票价格：" + movies2.getPrice());
        System.out.println("电影票状态：" + movies3.isStatus());
        System.out.println("电影票id：" + movies1.getId());
        System.out.println("电影票价格：" + movies2.getPrice());
        System.out.println("电影票状态：" + movies3.isStatus());
    }

    private static void moviesInit(Movies movies1, Movies movies2, Movies movies3) {
        movies1.setId(1L);
        movies2.setId(2L);
        movies3.setId(3L);
        movies1.setPrice(100);
        movies2.setPrice(200);
        movies3.setPrice(300);
        movies1.setStatus(true);
        movies2.setStatus(true);
        movies3.setStatus(true);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Movies {
    private Long id;
    private double price;
    private boolean status;
}

