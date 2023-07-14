package com.zxj.day12;


public class Question14 {
    public static void main(String[] args) {
        GeneratorSpecifyImpl<String[]> sgs = new GeneratorSpecifyImpl<>();
        String[] strings = new String[10];
        sgs.printArray(strings);
        sgs.printArray("数组");
    }
}

/**
 * 不指定类型-实现泛型类
 */
class GeneratorNotSpecifiedImpl<T> implements Generator<T> {

    @Override
    public T method() {
        return null;
    }
}

/**
 * 指定类型-实现泛型类
 */
class GeneratorSpecifyImpl<T> implements Generator<String> {

    @Override
    public String method() {
        return "are you ok";
    }

    /**
     * 泛型方法
     */
    public <E> void printArray(E inputArray) {
        System.out.println(inputArray);
        method();
    }
}

/**
 * 自定义泛型类
 */
interface Generator<T> {
    T method();
}
