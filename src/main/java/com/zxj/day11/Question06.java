package com.zxj.day11;

public class Question06 {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        animal1.run();

        Animal animal2 = new Wolf();
        animal2.run();

        // 多态：编译看左边，运行看右边
        // 多态是行为的多态 对象的多态  Java属性不谈多态
        System.out.println(animal1.name);
        System.out.println(animal2.name);


        if (animal1 instanceof Dog) {
            System.out.println(animal1);
            Dog dog = (Dog) animal1;
            System.out.println(dog);
        }
        if (animal2 instanceof Wolf) {
            System.out.println(animal2);
            Wolf wolf = (Wolf) animal2;
            System.out.println(wolf);
        }

    }
}

class Animal {
    String name = "动物";

    public void run() {
        System.out.println("动物跑得快");
    }
}

class Dog extends Animal {
    String name = "🐕";

    @Override
    public void run() {
        System.out.println("🐕跑的快");
    }
}

class Wolf extends Animal {
    String name = "🐺";

    @Override
    public void run() {
        System.out.println("🐺跑得更快");
    }
}

