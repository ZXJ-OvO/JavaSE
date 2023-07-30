package com.zxj.day12;


public class Question14 {
    public static void main(String[] args) {
        GeneratorSpecifyImpl sgs = new GeneratorSpecifyImpl();
        String[] strings = new String[10];
        sgs.printArray(strings);
        sgs.printArray("数组");
    }
}

/**
 * 指定类型-实现泛型类
 */
class GeneratorSpecifyImpl implements Generator {

    private void method() {
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
interface Generator {
}
