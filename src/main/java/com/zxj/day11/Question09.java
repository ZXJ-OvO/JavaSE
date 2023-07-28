package com.zxj.day11;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;

public class Question09 {
    public static void main(String[] args) {
        StudentDataImpl1 impl1 = new StudentDataImpl1();
        StudentDataImpl2 impl2 = new StudentDataImpl2();
        ArrayList<Student2> students = new ArrayList<>();

        Student2 student1 = new Student2("关羽", '男', 99.9);
        Student2 student2 = new Student2("张飞", '男', 100.0);
        Student2 student3 = new Student2("刘备", '女', 60.0);
        Student2 student4 = new Student2("曹操", '女', 99.9);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);

        System.out.println("方案一");
        impl1.setStudentsData(students);
        impl1.printAllStudent();
        impl1.printAverageScore();

        System.out.println("方案二");
        impl2.setStudentsData(students);
        impl2.printAllStudent();
        impl2.printAverageScore();
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Student2 {
    private String name;
    private char sex;
    private Double score;
}

interface StudentData {
    void printAllStudent();

    void printAverageScore();

    void setStudentsData(ArrayList<Student2> students);
}

class StudentDataImpl1 implements StudentData {
    private ArrayList<Student2> students;

    @Override
    public void printAllStudent() {
        for (Student2 s : students) {
            System.out.println(s.getName() + " " + s.getSex() + " " + s.getScore());
        }
    }

    @Override
    public void printAverageScore() {
        double sum = 0;
        for (Student2 s : students) {
            Double score = s.getScore();
            sum += score;
        }
        double avg = sum / students.size();
        System.out.println("平均分：" + avg);
    }

    @Override
    public void setStudentsData(ArrayList<Student2> students) {
        this.students = students;
    }
}

class StudentDataImpl2 implements StudentData {
    private ArrayList<Student2> students;

    @Override
    public void printAllStudent() {
        for (Student2 s : students) {
            System.out.println(s.getName() + " " + s.getSex() + " " + s.getScore());
        }
    }

    @Override
    public void printAverageScore() {
        int man = 0;
        int woman = 0;
        for (Student2 s : students) {
            char sex = s.getSex();
            if ('男' == sex) {
                man++;
            }
            if ('女' == sex) {
                woman++;
            }
        }

/*        Collections.sort(students, new Comparator<Student2>() {
            @Override
            public int compare(Student2 o1, Student2 o2) {
                return (int) (o1.getScore() - o2.getScore());
            }
        });*/

        Collections.sort(students, (o1, o2) -> (int) (o1.getScore() - o2.getScore()));

        students.remove(students.size() - 1);
        students.remove(0);

        int sum = 0;
        for (Student2 student : students) {
            sum += student.getScore();
        }

        System.out.println("男人人数：" + man);
        System.out.println("女人人数：" + woman);
        System.out.println("去掉最高分最低分后平均分：" + ((sum * 1.0) / students.size() - 2));

    }

    @Override
    public void setStudentsData(ArrayList<Student2> students) {
        this.students = students;
    }
}
