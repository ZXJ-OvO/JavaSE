package com.zxj.day10;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 在传智播客有很多员工(Employee),按照工作内容不同分教研部员工(Teacher)和行政部员工(AdminStaff)
 * 教研部根据教学的方式不同又分为讲师(Lecturer)和助教(Tutor)
 * 行政部根据负责事项不同,有分为维护专员(Maintainer),采购专员(Buyer)
 * 公司的每一个员工都编号,姓名和其负责的工作
 * 工作内容:
 * 讲师: 工号为 666 的讲师 乔峰 在讲课
 * 助教: 工号为 668的助教 段誉 在帮助学生解决问题
 * 维护专员: 工号为 686 的维护专员 柳岩 在解决不能共享屏幕问题
 * 采购专员: 工号为 888 的采购专员 景甜 在采购音响设备
 * 提示:赋值可以用set方法或者构造方法
 */
public class Question07 {
    public static void main(String[] args) {
        Lecturer lecturer = new Lecturer(666, "乔峰", "讲课");
        Tutor tutor = new Tutor(668, "段誉", "帮助学生解决问题");
        Maintainer maintainer = new Maintainer(686, "柳岩", "解决不能共享屏幕问题");
        Buyer buyer = new Buyer(888, "景甜", "采购音响设备");
        lecturer.show();
        tutor.show();
        maintainer.show();
        buyer.show();
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Employee {
    private int id;
    private String name;
    private String work;

    public void show() {
        System.out.println("工号为 " + id + " 的" + name + " 在" + work);
    }
}

class Lecturer extends Employee {
    public Lecturer(int id, String name, String work) {
        super(id, name, work);
    }
}

class Tutor extends Employee {
    public Tutor(int id, String name, String work) {
        super(id, name, work);
    }
}

class Maintainer extends Employee {
    public Maintainer(int id, String name, String work) {
        super(id, name, work);
    }
}

class Buyer extends Employee {
    public Buyer(int id, String name, String work) {
        super(id, name, work);
    }
}


