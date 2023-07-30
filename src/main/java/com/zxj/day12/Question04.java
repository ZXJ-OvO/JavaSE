package com.zxj.day12;

import java.util.Objects;

/**
 * API Objects equals  isNull  nonNull     Objects的equals似乎没有存在的必要？据说判空就要用，但是难道说我重写的equals不具有判空的逻辑吗
 */
public class Question04 {
    public static void main(String[] args) throws Exception {
        Animal animal = new Animal("cat");
        Animal anima2 = new Animal("cat");
        //System.out.println(animal3.equals(animal));
        System.out.println(animal.equals(anima2));          // Object.equals   --> false
        System.out.println(Objects.equals(animal, anima2)); // Objects.equals  --> false
        System.out.println(animal == anima2);               // false，比较地址值
        System.out.println(Objects.equals(animal.getName(), anima2.getName())); // true String重写了equals与hashCode

        System.out.println(true);

        System.out.println(true);
    }
}
