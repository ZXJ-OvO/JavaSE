package com.zxj.day17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * 如图所示:我们在逛淘宝的时候,会把喜欢的商品加入到购物车中,当我们第一次加入到购物车的时候,
 * 购物车中该商品的数量会显示为1,如果我们添加的是同一个店铺的同一件商品,
 * 购物车中该商品的数量会增加1。但是如果添加的不是同一个店铺的商品不用,我们则认为不是同一件商品,
 * 添加到购物车的时候就会当做新商品添加。请设计程序,完成将商品添加到购物车的需求.
 * --购物车
 * ----店铺
 * ----店铺
 * ------商品名称  商品数量
 * ------商品名称  商品数量
 */
public class Question03 {
    public static void main(String[] args) throws InterruptedException {
        // 商品集合<商品名称, 商品数量 >
        HashMap<String, Integer> goods = new HashMap<>();
        // 店铺集合<店铺名称, 商品集合>
        HashMap<String, HashMap<String, Integer>> shop = new HashMap<>();
        // 购物车集合
        ArrayList<HashMap<String, HashMap<String, Integer>>> cart = new ArrayList<>();

        System.out.println("***************购物车***************");
        if (cart.size() == 0) {
            System.out.println("购物车为空");
            System.out.println("即将跳转到商品添加页面...");
            Thread thread = new Thread();
            for (int i = 3; i > 0; i--) {
                thread.sleep(1000);
                System.out.print(i + " ");
            }
            shopping(shop, goods, cart);
        } else {
            shopping(shop, goods, cart);
        }

        System.out.println("***************购物车***************");
        System.out.println("购物车中的商品如下:");
        cart.forEach(System.out::println);
    }

    public static void shopping(HashMap<String, HashMap<String, Integer>> shop, HashMap<String, Integer> goods, ArrayList<HashMap<String, HashMap<String, Integer>>> cart) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n请输入店铺名称:");
        String shopName = scanner.nextLine();

        if (shop.containsKey(shopName)) {
            System.out.println("请输入需要购买的商品名称");
            String good = scanner.nextLine();

            // 判断该点铺下是否存在输入的商品
            if (goods.containsKey(good)) {
                // 存在同名商品。数量加一
                Integer integer = goods.get(good);
                goods.put(good, integer + 1);
            } else {
                // 不存在同名商品，数量设置为一
                goods.put(good, 1);
            }
        } else {
            // 当前的shopName是第一次被载入到购物车
            System.out.println("请输入需要购买的商品名称");
            String goodName = scanner.nextLine();
            // 商铺不存在，则旗下的商品必然不在购物车中
            goods.put(goodName, 1);
            shop.put(shopName, goods);
            cart.add(shop);
            // 递归 重新进入购物车
            shopping(shop, goods, cart);
        }
    }
}
