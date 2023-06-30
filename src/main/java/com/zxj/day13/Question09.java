package com.zxj.day13;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
import java.util.Comparator;

/**
 * API Arrays
 */
public class Question09 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 2, 5, 1, 3123, 123, 2};
        // 将数组元素快速打印
        System.out.println(Arrays.toString(arr));

        // 指定起始索引和结束索引，进行元素拷贝
        int[] arr2 = Arrays.copyOfRange(arr, 1, 3);
        System.out.println(Arrays.toString(arr2));

        // 拷贝数组
        int[] arr3 = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(arr3));

        // 更改数组的原数据并生成新的元素
        Arrays.setAll(arr, (i) -> arr[i] * 2);
        System.out.println(Arrays.toString(arr));

        // 排序
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));

        // 二分查找
        int index = Arrays.binarySearch(arr, 4);
        System.out.println("二分查找" + index);

        // 比较两个数组是否相等
        System.out.println(Arrays.equals(arr, arr2));

        // 填充数组
        Arrays.fill(arr, 0);
        System.out.println(Arrays.toString(arr));

        // 多维数组的打印
        int[][] arr4 = {{1, 2, 3}, {4, 5, 6}};
        System.out.println(Arrays.deepToString(arr4));


        // 数组中存放的是对象，自定义排序规则
        Student[] students = new Student[4];
        students[0] = new Student("张三", 18, 3);
        students[1] = new Student("李四", 19, 2);
        students[2] = new Student("王五", 20, 4);
        students[3] = new Student("赵六", 21, 1);
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));

        // 使用第一个参数的字段减去第二个参数的字段 从小到大排序 从大到小排序反过来 也就是第二个参数减去第一个参数
        Student[] students1 = Arrays.copyOf(students, students.length);
//        Arrays.sort(students1, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getAge() - o2.getAge();
//            }
//        });

        // Lambda表达式
        // Arrays.sort(students1, (o1, o2) -> o1.getAge() - o2.getAge());
        // 方法引用
        Arrays.sort(students1, Comparator.comparingInt(Student::getAge));
        System.out.println(Arrays.toString(students1));


    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int code;

    @Override
    public int compareTo(Student o) {
        return this.code - o.code;
    }
}