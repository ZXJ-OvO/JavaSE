package com.hutool.collection;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.lang.Filter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;


/**
 * cn.hutool.core.collection 集合工具类 CollUtil
 */
public class HuToolCollUtil {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("a");
        arrayList.add("c");
        arrayList.add("c");
        ArrayList<String> arrayList1 = new ArrayList<>(arrayList);
        arrayList1.add("a");
        arrayList1.add("b");
        arrayList1.add("c");
        arrayList1.add("c");
        arrayList1.add("c");

        System.out.println("-----------------------------------------------交并补运算");

        // 求多个（不定参数）集合的非重复交集
        System.out.println(CollUtil.intersectionDistinct(arrayList1, arrayList));

        // 求多个（不定参数）集合的非重复并集
        System.out.println(CollUtil.unionDistinct(arrayList1, arrayList));


        System.out.println("-----------------------------------------------创建集合");


        // 创建一个新的ArrayList并添加多个元素
        System.out.println(CollUtil.newArrayList("a", "b", "c", "d"));

        // 创建一个新的LinkedList并添加多个元素
        System.out.println(CollUtil.newLinkedList("a", "b", "c", "d"));

        // 创建一个新的HashSet并添加多个元素
        System.out.println(CollUtil.newHashSet("a", "b", "c", "d"));

        // 创建一个新的LinkedHashSet并添加多个元素
        System.out.println(CollUtil.newLinkedHashSet("a", "b", "c", "d"));


        System.out.println("-----------------------------------------------集合转换");

        // 数组转为ArrayList
        int[] ints = {1, 2, 3, 4, 5, 6};
        System.out.println(CollUtil.toList(ints));


        System.out.println("-----------------------------------------------过滤删除");


        // 安全判断指定集合是否包含指定值，集合若为null或空则返回false
        System.out.println(CollUtil.safeContains(arrayList, "a"));

        // Collection集合去重
        ArrayList<String> list = CollUtil.newArrayList("a", "b", "c", "d", "a", "b", "c", "d");
        System.out.println(CollUtil.distinct(list));

        // Collection集合截取内容
        System.out.println(CollUtil.sub(list, 2, 5));

        // Collection集合切片
        System.out.println(CollUtil.split(list, 3));

        // Collection集合过滤，返回过滤的集合，原集合元素不变
        ArrayList<String> newArrayList = CollUtil.newArrayList("a", "b", "c", "d", "a", "b", "c", "d");
        Collection<String> list2 = CollUtil.filterNew(newArrayList, new Filter<>() {
            @Override
            public boolean accept(String s) {
                return s.equals("a") || s.equals("b");
            }
        });
        System.out.println("过滤后的集合" + list2);
        System.out.println("原集合" + newArrayList);

        // 去除Collection集合中的多个元素，直接对原集合操作，然后返回原集合
        ArrayList<String> list1 = CollUtil.removeAny(list, "a", "b");
        System.out.println(list1);

        // 去除Collection集合中的非指定元素，直接对原集合操作，然后返回原集合
        ArrayList<String> list3 = CollUtil.newArrayList("a", "b", "c", "d", "a", "b", "c", "d");
        ArrayList<String> list4 = CollUtil.filter(list3, new Filter<>() {
            @Override
            public boolean accept(String s) {
                // 返回false表示需要被过滤掉 返回true表示保留 直接在原集合上操作
                return !s.equals("a");
            }
        });
        System.out.println("原集合：" + list3);

        System.out.println("-----------------------------------------------集合操作");

        // 去除null、""、空白字符串
        ArrayList<String> list5 = CollUtil.newArrayList("a", "b", null, "", " ");
        System.out.println(CollUtil.removeBlank(list5));

        // 将集合转为字符串
        List<String> colList = CollUtil.newArrayList("a", "b", "c", "d", "e");
        System.out.println(CollUtil.join(colList, "->")); // a->b->c->d->e

        // 给定两个集合然后一一对应放入Map中
        List<String> keyList = CollUtil.newArrayList("a", "c", "b", "d", "e");
        List<Integer> valueList = CollUtil.newArrayList(1, 2, 3, 4, 5);
        System.out.println(CollUtil.zip(keyList, valueList));

        // 将Entry集合转换为HashMap
        HashMap<Integer, String> hashMap = new HashMap<>();
        Set<Map.Entry<Integer, String>> entries = hashMap.entrySet();
        CollUtil.toMap(entries);

        // 一个对象不为空且不存在于集合中，加入到集合中
        ArrayList<String> strings = CollUtil.newArrayList("a", "b", "c", "d", "e");
        CollUtil.addIfAbsent(strings, "f");
        CollUtil.addIfAbsent(strings, "a");
        System.out.println(strings);

        // 将另一个集合中的元素加入到指定集合中，如果列表中已经存在该元素，则不添加
        ArrayList<String> strings1 = CollUtil.newArrayList("a", "b", "c", "d", "e", "8964");
        System.out.println(CollUtil.addAllIfNotContains(strings, strings1));

        // 获得集合中的元素类型
        System.out.println(CollUtil.getElementType(strings));

        // 从Map中根据键列表获取值列表
        HashMap<String, String> map = new HashMap<>();
        map.put("a", "1");
        map.put("b", "2");
        map.put("c", "3");
        ArrayList<String> ofKeys = CollUtil.valuesOfKeys(map, "a", "b", "c");
        System.out.println(ofKeys);


        System.out.println("-----------------------------------------------集合排序");

        // 排序Collection集合，不会修改原集合，返回新集合
        ArrayList<Integer> list6 = CollUtil.newArrayList(11, 44, 22, 77, 33);
        List<Integer> sort = CollUtil.sort(list6, (o1, o2) -> o1 - o2);
        System.out.println(sort);

        // 根据bean的属性排序
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        class Student {
            private String name;
            private Integer score;
        }
        Student student1 = new Student("关羽", 100);
        Student student2 = new Student("张飞", 99);

        ArrayList<Student> students = CollUtil.newArrayList(student1, student2);
        System.out.println(students);
        List<Student> score = CollUtil.sortByProperty(students, "score");
        System.out.println(score);

        // 根据汉字的拼音顺序排序
        ArrayList<String> strings2 = CollUtil.newArrayList("刘备", "关羽", "张飞");
        List<String> strings3 = CollUtil.sortByPinyin(strings2);
        System.out.println(strings3);

        // 判断两个Collections的集合是否相同
        ArrayList<String> strings4 = CollUtil.newArrayList("a", "b", "c", "d", "e");
        ArrayList<String> strings5 = CollUtil.newArrayList("a", "b", "c", "d", "e");
        System.out.println(CollUtil.isEqualList(strings4, strings5));

        // 取集合的最大值
        ArrayList<Integer> list7 = CollUtil.newArrayList(11, 2, 33, 4, 54);
        Integer max = CollUtil.max(list7);
        System.out.println(max);

        // 取集合的最小值
        Integer min = CollUtil.min(list7);
        System.out.println(min);

        // 反转得到新的集合
        ArrayList<Integer> list8 = CollUtil.newArrayList(11, 2, 33, 4, 54);
        List<Integer> integers = CollUtil.reverseNew(list8);
        System.out.println(integers);

        // 交换集合的元素的位置
        ListUtil.swapTo(list8, 33, 0);
        System.out.println(list8);

    }
}

