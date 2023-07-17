package com.zxj.day12;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class Question20 {
    public String name;
    private static String sex;

    /**
     * 成员内部类，无static修饰，属于类的对象的
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public class Inner {
        // 类有的成员它都有
        private String name;

        //public static String schoolName;
        public void ggg(String name) {
            Question20.this.name = name;
        }
    }

    public static void main(String[] args) {
        Question20.Inner in = new Question20().new Inner();
        in.setName("aaa");

    }
}
