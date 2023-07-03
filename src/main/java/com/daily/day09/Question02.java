package com.daily.day09;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

/**
 * 第二题:
 * 有如下员工信息：
 * 姓名：张三，工资：3000
 * 姓名：李四，工资：3500
 * 姓名：王五，工资：4000
 * 姓名：赵六，工资：4500
 * 姓名：田七，工资：5000
 * 先需要将所有的员工信息都存入ArrayList集合中，并完成如下操作：
 * 1、判断是否有姓名为“王五”的员工，如果有，改名为“王小五”
 * 2、判断是否有姓名为“赵六”的员工，如果有，将其删除
 * 3、给姓名为“田七”的员工，涨500工资
 */
public class Question02 {
    public static void main(String[] args) {
        @AllArgsConstructor
        @Data
        @NoArgsConstructor
        class Employee {
            private String name;
            private int salary;
        }

        Employee employee1 = new Employee("张三", 3000);
        Employee employee2 = new Employee("李四", 3500);
        Employee employee3 = new Employee("王五", 4000);
        Employee employee4 = new Employee("赵六", 4500);
        Employee employee5 = new Employee("田七", 5000);
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        employees.add(employee5);
        for (Employee employee : employees) {
            if (employee.getName().equals("王五")) {
                employee.setName("王小五");
            }
        }
        for (Employee employee : employees) {
            if (employee.getName().equals("赵六")) {
                employees.remove(employee);
                break;
            }
        }
        for (Employee employee : employees) {
            if (employee.getName().equals("田七")) {
                employee.setSalary(employee.getSalary() + 500);
            }
        }
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
