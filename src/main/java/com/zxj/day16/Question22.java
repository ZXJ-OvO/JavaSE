package com.zxj.day16;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Question22 {
    public static void main(String[] args) {
        HashMap<Goods, Integer> map = new HashMap<>();
        System.out.println("添加商品");
        Scanner scanner = new Scanner(System.in);
        OUT:
        while (true) {
            System.out.println("输入商品品牌：");
            String brand = scanner.next();

            if (brand.equals("end")) {
                Set<Goods> goods = map.keySet();
                for (Goods good : goods) {
                    System.out.print(good.getBrand() + " " + good.getName() + " --> " + map.get(good) + "\n");
                }
                return;
            }

            System.out.println("输入商品名称：");
            String name = scanner.next();
            Goods currentGood = new Goods(brand, name);

            Set<Goods> goods = map.keySet();

            for (Goods good : goods) {
                if (currentGood.equals(good)) {
                    map.put(good, map.get(good) + 1);
                    continue OUT;
                }
            }

            map.put(currentGood, 1);
        }
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Goods {
    private String brand;
    private String name;
}
