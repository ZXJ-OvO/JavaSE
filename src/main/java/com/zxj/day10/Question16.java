package com.zxj.day10;

import lombok.Data;

public class Question16 {
    public static void main(String[] args) {
        BB bb = new BB();
        bb.a = 1;
        bb.print1();

        // 子类不能继承父类中私有的部分，但是可以通过方法来使用
        // 虽然不能继承，但是确实在对象中
        bb.setB(2);
        System.out.println(bb);
    }
}

@Data
class AA {
    public int a;

    public void print1() {

    }

    private int b;

    private void print2() {

    }
}

class BB extends AA {

}
