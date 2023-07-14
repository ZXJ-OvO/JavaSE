package com.zxj.day10;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 1.定义项目经理类
 * 属性：
 * 姓名 工号 工资 奖金
 * 行为：
 * 工作work
 * 2.定义程序员类
 * 属性：
 * 姓名 工号 工资
 * 行为：
 * 工作work
 * 3.要求:向上抽取一个父类,让这两个类都继承这个父类,共有的属性写在父类中，子类重写父类中的方法
 * 编写测试类:完成这两个类的测试
 */
public class Question19 {
    public static void main(String[] args) {
        Programmer programmer = new Programmer("刘备", "002", 888.0);
        Manager manager = new Manager(1000.0, "关羽", "001", 888.0);

        System.out.println(programmer);
        System.out.println(manager);
        programmer.work();
        manager.work();
    }
}

@Data
class Programmer extends Human {
    public Programmer() {

    }

    public Programmer(String name, String id, Double salary) {
        super.name = name;
        super.salary = salary;
        super.id = id;
    }
}

@Data
class Manager extends Human {
    private Double bonus;

    public Manager() {

    }

    public Manager(Double bonus, String name, String id, Double salary) {
        super(name, id, salary);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Human {
    public String name;
    public String id;
    public Double salary;

    public void work() {
        System.out.println(name + id + salary);
    }
}
