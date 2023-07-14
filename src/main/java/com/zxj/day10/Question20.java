package com.zxj.day10;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 狮子(Lion)
 * 成员变量: 姓名,颜色,价格
 * 成员方法: 吃饭,看家
 * 猫(Cat)
 * 成员变量: 姓名,颜色,价格
 * 成员方法: 吃饭,抓老鼠
 */
public class Question20 {
    public static void main(String[] args) {
        Lion lion = new Lion();
        Cat cat = new Cat();
        lion.setName("关羽");
        lion.setColor("红色");
        lion.setPrice(999.9);

        cat.setName("曹操");
        cat.setColor("白色");
        cat.setPrice(9999.9);

        System.out.println(lion);
        System.out.println(cat);

        lion.houseKeeping();
        cat.grab();

    }
}

class Lion extends Mammal {
    public void houseKeeping() {
        System.out.println(this.name + "看家");
    }

    @Override
    public void eat() {
        System.out.println(this.name + "吃饭");
    }
}

class Cat extends Mammal {
    public void grab() {
        System.out.println(this.name + "抓老鼠");
    }

    @Override
    public void eat() {
        System.out.println(this.name + "吃饭");
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Mammal {
    public String name;
    public String color;
    public Double price;

    public void eat() {
    }
}

