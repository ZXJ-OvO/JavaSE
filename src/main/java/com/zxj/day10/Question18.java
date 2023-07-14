package com.zxj.day10;

public class Question18 {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Dog dog1 = new Dog("a");
    }

}

class Animal {
    public Animal() {
        System.out.println("父类构造器");
    }

    public Animal(String s) {
        System.out.println("父类有参构造器");
    }
}

class Dog extends Animal {
    public Dog() {
        System.out.println("子类构造器");
    }

    public Dog(String a) {
        System.out.println("子类有参构造器");
    }
}
