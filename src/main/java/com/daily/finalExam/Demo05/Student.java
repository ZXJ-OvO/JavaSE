package com.daily.finalExam.Demo05;

import java.util.Objects;

/**
 * System.out.println("请输入学生学号：");
 * String id = scanner.nextLine();
 * System.out.println("请输入学生姓名：");
 * String name = scanner.nextLine();
 * System.out.println("请输入学生年龄：");
 * String age = scanner.nextLine();
 * System.out.println("请输入学生性别");
 * String gender = scanner.nextLine();
 */
public class Student {
    private String id;
    private String name;
    private String age;
    private String gender;

    public Student() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return Objects.equals(id, student.id) && Objects.equals(name, student.name) && Objects.equals(age, student.age) && Objects.equals(gender, student.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, gender);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }

    public Student(String id, String name, String age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
