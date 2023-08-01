package com.review.dataStructure;

import java.util.Arrays;
import java.util.Objects;

public class MyArrayList<E> {

    // 默认容量
    private static final int DEFAULT_CAPACITY = 10;
    // 用来默认初始化空的数组
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    // 用来装元素的数组
    Object[] elementData;
    private int size;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public int size() {
        return size;
    }

    /**
     * 拿到指定索引的元素
     *
     * @param index 索引
     * @return 元素
     */
    public E get(int index) {
        Objects.checkIndex(index, size);
        return (E) elementData[index];
    }

    public boolean add(E e) {
        if (size == elementData.length) elementData = grow(size + 1);
        elementData[size] = e;
        size = size + 1;

        return true;
    }

    public void add(int index, E element) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException();
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.elementData).length)
            elementData = grow(size + 1);
        System.arraycopy(elementData, index,
                elementData, index + 1,
                s - index);
        elementData[index] = element;
        size = s + 1;
    }

    public E remove(int index) {
        Objects.checkIndex(index, size);
        final Object[] es = elementData;
        E oldValue = (E) es[index];
        final int newSize;
        if ((newSize = size - 1) > index) System.arraycopy(es, index + 1, es, index, newSize - index);
        es[size = newSize] = null;
        return oldValue;
    }

    private Object[] grow(int minCapacity) {
        return elementData = Arrays.copyOf(elementData, newCapacity(minCapacity));
    }

    private int newCapacity(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1); // 1.5倍扩容 右移1位相当于除以2取整
        if (newCapacity - minCapacity <= 0) {
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA)
                return Math.max(DEFAULT_CAPACITY, minCapacity);
            if (minCapacity < 0) throw new OutOfMemoryError();
            return minCapacity;
        }

        if (newCapacity - MAX_ARRAY_SIZE <= 0) {
            return newCapacity;
        } else {
            if (minCapacity < 0) throw new OutOfMemoryError();
            return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
        }
    }

    @Override
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (int i = 0; i < size; i++) {
            builder.append(elementData[i].toString());
            if (i != size - 1) builder.append(", ");
        }
        builder.append("]");
        return builder.toString();
    }

}