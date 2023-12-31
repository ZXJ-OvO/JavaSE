package com.zxj.day23;

import java.util.*;
import java.util.function.Consumer;

/**
 * 自定义ArrayList
 */
public class ArrayList<E> extends AbstractList<E> implements List<E> {
    /**
     * 默认初始容量大小
     */
    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    /**
     * 保存ArrayList数据的数组 transient修饰的关键字不会被序列化与
     */
    transient Object[] elementData;
    /**
     * ArrayList 所包含的元素个数
     */
    private int size;
    /**
     * 要分配的最大数组大小
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 默认无参构造函数，初始化为10，也就是说初始其实是空数组 当添加第一个元素的时候数组容量才变成10
     */
    public ArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * forEach方法
     */
    @Override
    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        final int expectedModCount = modCount;
        final Object[] es = elementData;
        final int size = this.size;
        for (int i = 0; modCount == expectedModCount && i < size; i++)
            action.accept((E) es[i]);
        if (modCount != expectedModCount) throw new ConcurrentModificationException();
    }

    /**
     * 增
     */
    public boolean add(E e) {
        int minCapacity = size + 1;

        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        modCount++;
        if (minCapacity - elementData.length > 0) {
            int oldCapacity = elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            if (newCapacity - minCapacity < 0) newCapacity = minCapacity;
            if (newCapacity - MAX_ARRAY_SIZE > 0) {
                if (minCapacity < 0) throw new OutOfMemoryError();
                newCapacity = (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
            }
            elementData = Arrays.copyOf(elementData, newCapacity);
        }

        elementData[size++] = e;
        return true;
    }

    /**
     * 删
     */
    public E remove(int index) {
        rangeCheck(index);
        modCount++;
        E oldValue = elementData(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;
        return oldValue;
    }

    /**
     * 改
     */
    public E set(int index, E element) {
        rangeCheck(index);
        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    /**
     * 查
     */
    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    /**
     * 返回此列表中的元素数。
     */
    public int size() {
        return size;
    }

    /**
     * 检查给定的索引是否在范围内。
     */
    private void rangeCheck(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
    }

    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }
}