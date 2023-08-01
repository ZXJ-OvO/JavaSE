package com.daily.huangpuSETest.demo04;

import lombok.Getter;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Thread.sleep;

/**
 * **需求**
 * * 红包雨游戏，某企业有100名员工，员工的工号依次是1, 2，3, 4，..到100。
 * 现在公司举办了年会活动，活动中有一个红包雨环节，要求共计发出200个红包雨。
 * 其中小红包在[1 - 30]  元之间，总占比为80%，大红包[31-100]元，总占比为20%。
 * **具体的功能点如下**
 * 1、系统模拟上述要求产生200个红包。
 * 2、模拟100个员工抢红包雨，需要输出哪个员工抢到哪个红包的过程，活动结束时需要提示活动结束。
 * 3、活动结束后，请1对100名员工按照所抢红包的总金额进行降序排序展示，**例如：3号员工抢红包总计：293元、1号员工抢红包总计250元，....**
 */
public class RedEnvelopeRain {
    // 存放参与活动的员工
    public static ArrayList<Employee> employeesInvolved = new ArrayList<>();
    // 存放红包
    public static final ArrayList<Integer> redEnvelopeArrayList = new ArrayList<>();
    // 记录当前已经抢到的红包索引
    public static int currentEnvelopeIndex = 0;

    public static void main(String[] args) throws Exception {
        // 系统模拟上述要求产生200个红包
        SecureRandom secureRandom = new SecureRandom();
        for (int i = 0; i < 200 * 0.8; i++) redEnvelopeArrayList.add(secureRandom.nextInt(30) + 1);
        for (int i = 0; i < 200 * 0.2; i++) redEnvelopeArrayList.add(secureRandom.nextInt(31) + 70);
        Collections.shuffle(redEnvelopeArrayList);

        // 模拟100个员工抢红包雨
        for (int i = 0; i < 100; i++) new Employee(i + 1).start();

        // 让主线程等待所有执行员工抢红包雨逻辑的线程完成
        for (Employee employee : employeesInvolved) employee.join();


        sleep(1000);

        System.out.println("\n本次活动结束！请核对下方每人所抢的红包金额！（按总额降序排序）\n");


        // 按照所抢红包的总金额进行降序排序展示
        employeesInvolved.sort((o1, o2) -> o2.getTotalMoney() - o1.getTotalMoney());
        for (Employee employee : employeesInvolved)
            System.out.println("员工" + employee.getEmpId() + " 抢红包总计：" + employee.getTotalMoney() + "元");

    }
}

@Getter
class Employee extends Thread {
    private final int empId;
    private int totalMoney;

    public Employee(int empId) {
        this.empId = empId;
    }

    public void run() {
        while (true) {
            // 当前红包索引
            int envelopeIndex;

            // 使用synchronized块确保多个线程不会同时访问共享资源
            synchronized (RedEnvelopeRain.redEnvelopeArrayList) {
                // 获取当前红包索引
                envelopeIndex = RedEnvelopeRain.currentEnvelopeIndex;
                // 当前的红包索引自增，因为当前红包已经被抢，下一个红包的索引为当前索引+1
                RedEnvelopeRain.currentEnvelopeIndex++;
                // 没有红包可抢，退出循环
                if (envelopeIndex >= RedEnvelopeRain.redEnvelopeArrayList.size()) break;
            }

            // 获取当前红包金额
            int envelope = RedEnvelopeRain.redEnvelopeArrayList.get(envelopeIndex);

            // 若红包为已抢状态，则跳过当前红包
            if (envelope == -1) {
                continue;
            }

            totalMoney += envelope;

            System.out.println("员工" + empId + " 抢到红包：" + envelope + "元，当前总计：" + totalMoney + "元");

            // 将已抢的红包从列表中删除
            synchronized (RedEnvelopeRain.redEnvelopeArrayList) {
                // 采取这种办法（当前被抢的红包金额设置成-1）取代remove删除操作避免并发修改异常和索引越界异常
                RedEnvelopeRain.redEnvelopeArrayList.set(envelopeIndex, -1);
            }
        }

        // 本员工成功参与
        RedEnvelopeRain.employeesInvolved.add(this);
    }

}




