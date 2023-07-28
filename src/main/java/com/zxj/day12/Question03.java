package com.zxj.day12;

import lombok.Getter;

import java.util.Random;

/**
 * API Object
 */
public class Question03 {
    public static void main(String[] args) {

        // toString 返回字符串的表示形式
        Random random = new Random();
        System.out.println(random.toString());

        // equals 判断两个对象是否相等  lombok的注解默认是重写了equals与hashcode，调用原生的equals比较两个cat会false
        Animal animal = new Animal("cat");
        Animal anima2 = new Animal("cat");
        System.out.println(animal.equals(anima2));

        /*
           Creates and returns a copy of this object.  The precise meaning
           of "copy" may depend on the class of the object. The general
           intent is that, for any object x, the expression:

           x.clone() != x                        true

           x.clone().getClass() == x.getClass()  true

           x.clone().equals(x)                   true
         */


    }
}

/*@Data
@AllArgsConstructor
@NoArgsConstructor*/
@Getter
class Animal {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public Animal() {
    }

    public void setName(String name) {
        this.name = name;
    }
}