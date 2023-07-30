package com.zxj.day23;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Field;

/**
 * 反射实现框架：获取任意类型的成员变量
 */
public class Question07 {
    public static void main(String[] args) throws IllegalAccessException {
        Country country = new Country();
        country.setName("China");
        country.setRankOfAVG_GDP(64);
        country.setAge(72);
        country.setHourlySalary(10.9);
        reflect(country);
    }

    public static void reflect(Object obj) throws IllegalAccessException {
        Class<?> objClass = obj.getClass();
        Field[] fields = objClass.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            String name = field.getName();
            Object o = field.get(obj);
            Class<?> type = field.getType();
            System.out.println(type + "  " + name + "  " + o);
        }
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Country {
    private String name;
    private Integer age;
    private Double hourlySalary;
    private Integer rankOfAVG_GDP;
}