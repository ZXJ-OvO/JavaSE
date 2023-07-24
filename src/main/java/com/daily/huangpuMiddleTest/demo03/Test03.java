package com.daily.huangpuMiddleTest.demo03;

import cn.hutool.core.collection.CollUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 现在有n个物品，每个物品都是液体，液体存在重量和价值，
 * 现在要求你只能从如下提供的液体中总共取走10升液体，
 * 每种液体每次可以不拿，全拿，或拿一部分，问取走的10升液体的最高价值是多少。
 * 名称           重量(升)	   总价值
 * 水		       4      	   24
 * 牛奶  		  8      	  160
 * 五粮液		 2    	     4000
 * 可乐		  6     	  108
 * 茅台		  1    	      4000
 * 1、请按照如上数据的顺序，将每种液体数据依次添加到程序中来
 * （注意：可以创建对象封装每种液体数据，并添加到ArrayList集合中去）
 * 2、请用程序计算出取的10升液体的最高价值是多少？以及10升液体具体是哪些液体组成，各自取了多少。
 */
public class Test03 {
    public static void main(String[] args) {
        // 商品初始化
        Good water = new Good("水", 4, 24);
        Good milk = new Good("牛奶", 8, 160);
        Good wuLiangYe = new Good("五粮液", 2, 4000);
        Good coke = new Good("可乐", 6, 108);
        Good maoTai = new Good("茅台", 1, 4000);

        // 商品对象用集合存储
        ArrayList<Good> goods = CollUtil.newArrayList(water, milk, wuLiangYe, coke, maoTai);

        // 单位价值量越大，总价质量越大，计算每个商品对象的单位价值量
        int waterWorth = getWorthPercent(water.getWorth(), water.getHeight());
        int milkWorth = getWorthPercent(milk.getWorth(), milk.getHeight());
        int wuLiangYeWorth = getWorthPercent(wuLiangYe.getWorth(), wuLiangYe.getHeight());
        int cokeWorth = getWorthPercent(coke.getWorth(), coke.getHeight());
        int maoTaiWorth = getWorthPercent(maoTai.getWorth(), maoTai.getHeight());

        // 用新的对象封装 商品名称 和商品 单位价值量 商品的 总数量
        Cert waterCert = new Cert(water.getName(), waterWorth, water.getHeight());
        Cert milkCert = new Cert(milk.getName(), milkWorth, milk.getHeight());
        Cert wuLiangYeCert = new Cert(wuLiangYe.getName(), wuLiangYeWorth, wuLiangYe.getHeight());
        Cert cokeCert = new Cert(coke.getName(), cokeWorth, coke.getHeight());
        Cert maoTaiCert = new Cert(maoTai.getName(), maoTaiWorth, maoTai.getHeight());

        // 用集合装载新对象
        ArrayList<Cert> certs = CollUtil.newArrayList(waterCert, milkCert, wuLiangYeCert, cokeCert, maoTaiCert);

        // 对新对象集合按照价值量进行排序
        CollUtil.sortByProperty(certs, "worth");
        // 反转集合实现单位价值计量的递减排序
        Collections.reverse(certs);


        // 总价值量
        int worthSum = 0;
        // 总商品数量
        int heightSum = 0;

        // 用来装买的东西
        ArrayList<String> name = new ArrayList<>();


        String count = "";
        int id = 0;

        // 只要商品数量不不超过阈值就一直塞
        for (int i = 0; heightSum < 10 && i < 10; i++) {
            // 拿到当前的货物的总数量并交给 商品总量 接收
            heightSum += certs.get(i).getSum();
            // 拿到当前的
            worthSum += certs.get(i).getWorth() * certs.get(i).getSum();
            name.add(certs.get(i).getName());
            id++;
            count = certs.get(i).getName();
        }

        // 选购的内容
        System.out.println(name);
        // 到这里溢出
        System.out.println(count);
        // 溢出量
        int balance = heightSum - 10;

        System.out.println("选购清单：");
        for (int i = 0; i < name.size(); i++) {

            System.out.print(name.get(i));
            if (i == id - 1) {
                System.out.print("数量：" + (certs.get(i).getSum() - 1) + " 升\n");
            } else {
                System.out.print("数量：" + (certs.get(i).getSum()) + " 升\n");
            }
        }
        System.out.println();
        System.out.println("总价值：" + (worthSum - milkWorth));


    }

    private static Integer getWorthPercent(Integer worth, Integer height) {
        return worth / height;
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Cert {
    // 商品名
    private String name;
    // 单位价值量
    private Integer worth;
    // 商品总数
    private Integer sum;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Good {
    private String name;
    private Integer height;
    private Integer worth;
}