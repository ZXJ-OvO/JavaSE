package com.zxj.day11;

/**
 * 1.定义动物类:
 * 属性:年龄
 * 行为:喝水,吃东西(吃什么不确定)
 * 2.定义游泳接口:
 * 行为:游泳方法swimming
 * 3.定义狗类:
 * 行为:吃饭(啃骨头)和 游泳(狗刨)
 * 4.定义羊类:sheep
 * 行为:吃饭(羊啃草)
 * 5.定义青蛙类:frog
 * 行为:吃饭(吃虫子)和 游泳(蛙泳)
 * 6.定义饲养员类:breeder
 * 行为:饲养动物breed:包括吃饭和喝水
 * 7.定义测试类:
 * 创建饲养员对象,饲养员调用三次饲养方法:饲养狗,饲养羊,饲养青蛙
 */
public class Question10 {
    public static void main(String[] args) {
        Dog1 dog1 = new Dog1();
        dog1.swimming();
        dog1.eat("🦴");

        Sheep sheep = new Sheep();
        sheep.eat("🌿");

        Frog frog = new Frog();
        frog.swimming();
        frog.eat("🦟");

        Breeder breeder = new Breeder();
        breeder.attention(dog1);

    }
}

class Animal1 {
    private Integer age;

    public void drink() {
        System.out.println("🍹");
    }

    public void eat(String food) {
        System.out.println("👄" + food);
    }
}

interface Swimming {
    void swimming();
}

class Dog1 extends Animal1 implements Swimming {

    @Override
    public void swimming() {
        System.out.println("🐕⛏️‍");
    }

    @Override
    public void eat(String food) {
        System.out.println("🐕👄" + food);
    }
}

class Sheep extends Animal1 {
    @Override
    public void eat(String food) {
        System.out.println("🐏👄" + food);
    }
}

class Frog extends Animal1 implements Swimming {
    @Override
    public void eat(String food) {
        System.out.println("🐸👄" + food);
    }


    @Override
    public void swimming() {
        System.out.println("🐸🏊‍");
    }
}

class Breeder {
    public void attention(Animal1 animal1) {
        animal1.drink();
        animal1.eat("💩");
    }
}
