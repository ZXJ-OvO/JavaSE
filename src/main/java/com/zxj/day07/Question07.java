package com.zxj.day07;

/**
 * 定义猫类Cat。属性:毛的颜色color，品种breed。行为:吃饭eat()，抓老鼠catchMouse()
 * 定义狗类Dog。属性:毛的颜色color，品种breed。行为:吃饭()，看家lookHome()
 */
public class Question07 {
    public static void main(String[] args) {
        Cat cat = new Cat();
        cat.eat();
        cat.catchMouse();
        Dog dog = new Dog();
        dog.eat();
        dog.lookHome();
    }

}

class Cat {

    public Cat() {
    }

    public void eat() {
        System.out.println("猫吃饭");
    }

    public void catchMouse() {
        System.out.println("猫抓老鼠");
    }
}

class Dog {

    public Dog() {
    }

    public void eat() {
        System.out.println("狗吃饭");
    }

    public void lookHome() {
        System.out.println("狗看家");
    }
}
