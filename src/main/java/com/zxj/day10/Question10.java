package com.zxj.day10;

public class Question10 {
    static int count = 0;

    public static void main(String[] args) {

        StudentTest.printHelloWorld();

        StudentTest studentTest = new StudentTest();
        studentTest.print();

        System.out.println(studentTest.checkScore(61));

        startMain();
    }

    public static void startMain() {
        count++;
        if (count == 20) {
            System.exit(1);
        }
        String[] ints = new String[10];
        Question10.main(ints);
    }
}

class StudentTest {
    static double score;

    // 静态方法，有static修饰，属于类
    public static void printHelloWorld() {
        System.out.print("Hello ");
        System.out.println("World!");
    }

    // 实例方法，无static修饰，属于类的每个对象
    public void print() {
        System.out.println(this + " java");
    }

    public String checkScore(double score) {
        StudentTest.score = score;
        return StudentTest.score >= 60 ? "及格" : "不及格";
    }
}