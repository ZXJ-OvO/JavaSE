package com.daily.huangpuMiddleTest.demo05;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Objects;
import java.util.function.Consumer;


public class MyArrayList<E> {

    private static final int DEFAULT_CAPACITY = 10;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    public Object[] elementData;

    private int size;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public int modCount = 0;


    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }


    public void forEach(Consumer<? super E> action) {
        Objects.requireNonNull(action);
        final int expectedModCount = modCount;
        final Object[] es = elementData;
        final int size = this.size;
        for (int i = 0; modCount == expectedModCount && i < size; i++)
            action.accept((E) es[i]);
        if (modCount != expectedModCount) throw new ConcurrentModificationException();
    }


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


    public E remove(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        modCount++;
        E oldValue = elementData(index);
        int numMoved = size - index - 1;
        if (numMoved > 0) System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;
        return oldValue;
    }


    public E set(int index, E element) {
        if (index >= size) throw new IndexOutOfBoundsException();
        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }


    public E get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        return elementData(index);
    }


    public int size() {
        return size;
    }


    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }

    public void add(E e, int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        modCount++;
        final int s;
        Object[] elementData;
        if ((s = size) == (elementData = this.elementData).length)
            // TODO grow
            // elementData = ;
            System.arraycopy(elementData, index,
                    elementData, index + 1,
                    s - index);
        elementData[index] = index;
        size = s + 1;
    }
}