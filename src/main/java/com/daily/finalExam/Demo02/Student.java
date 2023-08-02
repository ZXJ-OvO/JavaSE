package com.daily.finalExam.Demo02;

import java.util.Arrays;
import java.util.Objects;

public class Student {
    private String name;
    private String[] items;

    public Student(String name, String[] items) {
        this.name = name;
        this.items = items;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", items=" + Arrays.toString(items) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getItems() {
        return items;
    }

    public void setItems(String[] items) {
        this.items = items;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Student student = (Student) object;
        return Objects.equals(name, student.name) && Arrays.equals(items, student.items);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name);
        result = 31 * result + Arrays.hashCode(items);
        return result;
    }
}
