package com.zxj.day23;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * 获取ArrayList底层数组的真实长度，经过扩容后，可以使用trimToSize()方法将底层数组的长度缩减为真实长度。
 * 扩容机制：
 * 当添加第一个元素时，底层会创建一个长度为10的数组。
 * 当超过了10个元素时，底层会将原来的数组扩容为原来的1.5倍+1，同时将原有数组中的元素复制到新的数组中。
 */
public class Question08 {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            list.add(i);
        }

        int capacity = getArrayListCapacity(list);
        System.out.println("底层数组的容量: " + capacity);

        list.trimToSize();
        capacity = getArrayListCapacity(list);
        System.out.println("底层数组的容量: " + capacity);

    }

    /**
     * 反射获取ArrayList底层数组的容量
     */
    public static int getArrayListCapacity(ArrayList<?> arrayList) throws NoSuchFieldException, IllegalAccessException {
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(arrayList);
        return elementData.length;
    }
}
