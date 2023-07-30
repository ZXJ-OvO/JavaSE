package com.daily.huangpuReview;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 商品属性：商品id，商品名称，商品价格，商品购买数量
 * 程序运行，往数组或者集合中添加3个商品，商品id，名称，价格自己任意书写。
 * 完成以下功能：
 * 添加商品：
 * 要求：商品的id都要唯一
 * 删除商品：
 * 要求：根据id删除商品，如果存在，则删除，如果不存在，则提示删除失败
 * 修改商品：
 * 要求：将其中任意一件商品的数量+1
 * 查询商品：
 * 要求：根据商品的id进行查询，如果存在，打印商品所有信息，如果不存在，则提示没有这个商品
 * 结算：
 * 累加总额
 */
public class Question13 {
    public static void main(String[] args) {
        ShopCart shopCart = new ShopCart();
        shopCart.start();
    }

}

class ShopCart {
    private final Scanner scanner = new Scanner(System.in);
    private final ArrayList<Goods> goodsList = new ArrayList<>();

    public void start() {
        System.out.println("**************购物车**************");
        System.out.println("1、添加商品");
        System.out.println("2、删除商品");
        System.out.println("3、修改商品");
        System.out.println("4、查询商品");
        System.out.print("请输入操作命令：");
        String cmd = scanner.next();
        switch (cmd) {
            case "1":
                addGoods();
                break;
            case "2":
                deleteGoods();
                break;
            case "3":
                updateGoods();
                break;
            case "4":
                selectAll();
                break;
        }
    }

    private void selectAll() {
        new ArrayList<>();
        for (Goods goods : goodsList) {
            System.out.println(goods);
        }
    }


    private void updateGoods() {
    }

    private void deleteGoods() {
    }

    private void addGoods() {
        Goods good = new Goods();

        System.out.print("请输入商品名称：");
        String goodsName = scanner.next();
        good.setName(goodsName);

        System.out.print("请输入商品价格：");
        Double goodsPrice = scanner.nextDouble();
        good.setPrice(goodsPrice);

        System.out.println("请输入商品数量");
        int goodNumber = scanner.nextInt();
        good.setNumber(goodNumber);

        goodsList.add(good);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Goods {
    private String id;
    private String name;
    private Double price;
    private Integer number;
}
