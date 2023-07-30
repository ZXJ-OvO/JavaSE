package com.zxj.day23;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 获取Class类的对象的三种方式
 */
public class Question01 {
    public static void main(String[] args) throws ClassNotFoundException {

        // 方式一
        Class<?> aClass = Class.forName("com.zxj.day23.Question01");
        System.out.println(aClass);

        // 方式二
        Class<Stu> aClass1 = Stu.class;
        System.out.println(aClass1);

        // 方式三
        Stu stu = new Stu();
        Class<? extends Stu> aClass2 = stu.getClass();
        System.out.println(aClass2);

    }


}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Stu {
    private String name;
}