package com.zxj.day15;

import cn.hutool.core.collection.CollUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

public class Question13 {
    public static void main(String[] args) {

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        class Person {
            private String name;
            private String address;
        }

        ArrayList<Person> people = CollUtil.newArrayList(new Person("张三", "北京"),
                new Person("李四", "上海"),
                new Person("王五", "广州"),
                new Person("赵六", "深圳"),
                new Person("田七", "杭州"));
        people.get(0).setAddress("纽约");

        System.out.println(people);
    }

}
