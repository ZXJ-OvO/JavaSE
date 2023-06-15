package com.zxj.day07;

/**
 * 定义项目经理类Manager。属性：姓名name，工号id，工资salary，奖金bonus。行为：工作work()
 * 定义程序员类Coder。属性：姓名name，工号id，工资salary。行为：工作work()
 */
public class Question06 {
    public static void main(String[] args) {
        Manager manager = new Manager("James", "9527", 15000, 3000);
        manager.work();
        Coder coder = new Coder("Kobe", "0025", 10000);
        coder.work();
    }

}

class Manager {
    private String name;
    private String id;
    private double salary;
    private double bonus;

    public Manager() {
    }

    public Manager(String name, String id, double salary, double bonus) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.bonus = bonus;
    }

    public void work() {
        System.out.println("工号为" + id + "基本工资为" + salary + "奖金为" + bonus + "的项目经理" + name + "正在努力的做着管理工作，分配任务，检查员工提交上来的代码.....");
    }
}

class Coder {
    private String name;
    private String id;
    private double salary;

    public Coder() {
    }

    public Coder(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void work() {
        System.out.println("工号为" + id + "基本工资为" + salary + "的程序员" + name + "正在努力的写着代码......");
    }
}
