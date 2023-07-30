package com.zxj.day13;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 我们在逛淘宝的时候,搜索商品之后都可以按照价格从低到高显示,后面淘宝可能会出现新的商品,那么新添的商品也会按照价格从低到高重新排序,请设计一个程序,完成添加新商品之后价格重新排序.
 */
public class Question12 {
    public static void main(String[] args) {
        ArrayList<Goods> list = new ArrayList<>();
        Goods goods1 = new Goods();
        goods1.setName("huawei");
        goods1.setPrice(300);
        Goods goods2 = new Goods();
        goods2.setName("xiaomi");
        goods2.setPrice(100);
        Goods goods3 = new Goods();
        goods3.setName("apple");
        goods3.setPrice(200);
        list.add(goods1);
        list.add(goods2);
        list.add(goods3);


        System.out.println(list);
        System.out.println("请添加新的商品");
        Goods goods = new Goods();
        System.out.println("请输入商品名称");
        goods.setName(new Scanner(System.in).nextLine());
        System.out.println("请输入商品价格");
        goods.setPrice(new Scanner(System.in).nextInt());
        list.add(goods);

        System.out.println(list);
        list.sort(Comparator.comparingInt(Goods::getPrice));
        System.out.println(list);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Goods {
    private String name;
    private Integer price;
}
