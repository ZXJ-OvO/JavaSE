package com.daily.huangpuMiddleTest.demo02;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.text.StrSplitter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * 某班级要组织秋游活动，有四个景点的数据可以选择，依次是：
 * “东湖”、"黄鹤楼"、“木兰文化区”、“归元禅寺”
 * 每名学生最多可以选择 两个 想去的景点，最少要选择 1个 想去的景点，
 * String info = "
 * 10001,张无忌,男,2023-07-22 11:11:12,东湖-黄鹤楼
 * 10002,赵敏,女,2023-07-22 09:11:21,黄鹤楼-归元禅寺
 * 10003,周芷若,女,2023-07-22 04:11:21,木兰文化区-东湖
 * 10004，小昭,女,2023-07-22 08:11:21,东湖
 * 10005，灭绝,女,2023-07-22 17:11:21,归元禅寺";
 * 需要你解析上面的字符串，获取里面的用户数据，并封装到Student对象中
 * 多个Student对象在添加到List<Student> 集合中
 * 字符串中的规则如下，多个用户用 # 拼接，用户的信息之间用 , 拼接,多个景点是用-拼接的。
 * 其中用户的id和选择时间是需要进行类型转换的，
 * 其中id需要将String转成Long，选择时间需要将String转成LocalDateTime。
 * 遍历上面获取的List<Student> 集合，统计里面每个景点选择的次数，并输出 景点名称和选择的次数。
 * 请用程序计算出哪个景点想去的人数最多，以及哪些人没有选择这个最多人想去的景点。
 */
public class Test02 {
    public static void main(String[] args) {
        String info = "10001,张无忌,男,2023-07-22 11:11:12,东湖-黄鹤楼#10002,赵敏,女,2023-07-22 09:11:21,黄鹤楼-归元禅寺#10003,周芷若,女,2023-07-22 04:11:21,木兰文化区-东湖#10004，小昭,女,2023-07-22 08:11:21,东湖#10005，灭绝,女,2023-07-22 17:11:21,归元禅寺";

        Student student1 = new Student("10001", "张无忌", '男', "东湖-黄鹤楼", "2023-07-22 11:11:12");
        Student student2 = new Student("10002", "赵敏", '女', "黄鹤楼-归元禅寺", "2023-07-22 11:11:12");
        Student student3 = new Student("10003", "周芷若", '女', "木兰文化区-东湖", "2023-07-22 11:11:12");
        Student student4 = new Student("10004", "小昭", '女', "东湖", "2023-07-22 11:11:12");
        Student student5 = new Student("10005", "灭绝", '女', "归元禅寺", "2023-07-22 11:11:12");

        ArrayList<Student> students = CollUtil.newArrayList(student1, student2, student3, student4, student5);

        HashMap<String, Integer> locationMap = new HashMap<>();
        ArrayList<String> locationList = new ArrayList<>();

        for (Student student : students) {
            String[] locationArray = StrSplitter.splitToArray(student.getAddress(), "-", 0, true, true);
            System.out.println(student.getStuName() + ": " + Arrays.toString(locationArray));
            Collections.addAll(locationList, locationArray);
        }
        System.out.println("\n地点数据：" + locationList);


        for (String location : locationList) {
            if (locationMap.containsKey(location)) {
                locationMap.put(location, locationMap.get(location) + 1);
            } else {
                locationMap.put(location, 1);
            }
        }
        locationMap.forEach((s, i) -> System.out.print("景点名称：" + s + "\t选择次数：" + i + "\n"));

        System.out.println("\n根据去的人数排序后的结果：");
        Map<String, Integer> map = MapUtil.sortByValue(locationMap, true);
        map.forEach((s, i) -> System.out.print("景点名称：" + s + "\t选择次数：" + i + "\n"));

        Set<String> set = map.keySet();
        Object[] array = set.toArray();
        System.out.println("\n人数最多的景点：" + array[0] + "\n");
        String bestLocation = (String) array[0];
        System.out.println("以下的人没有前往" + bestLocation);

        int count = 0;
        OUT:
        for (Student student : students) {
            String address = student.getAddress();
            String[] arrays = StrSplitter.splitToArray(address, "-", 0, true, true);
            for (String s : arrays) {
                if (s.equals(bestLocation)) {
                    count = 0;
                    continue OUT;
                } else {
                    count++;
                }
            }
            if (count == arrays.length) {
                count = 0;
                System.out.println(student.getStuName());
            }
        }
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Student {
    private String stuId;
    private String stuName;
    private Character gender;
    private String address;
    private String dateTime;
}
