package com.zxj.day14;

import cn.hutool.core.collection.CollUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * 掌握Java中数组排序，以及理解其在实际开发中的应用
 * 某学校要组织学生参加活动，要求学生按照身高从小打大进行排队。请在素材的sort项目中的Entry类中补全相关的代码，模拟排队效果！程序运行效果如下所示：
 */
public class Question12 {
    public static void main(String[] args) {
        ArrayList<Student> students = CollUtil.newArrayList(new Student("张三", 1.78),
                new Student("李四", 1.76),
                new Student("王五", 1.80),
                new Student("赵六", 1.50)
        );
        CollUtil.sortByProperty(students, "height");
        System.out.println(students);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Student {
    private String name;
    private Double height;
}