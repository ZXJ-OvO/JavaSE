package com.zxj.day12;

/**
 * 如图所示,我们电脑上都有USB接口,当我们的鼠标和键盘插上去之后才可以使用,拔出来就关闭使用.
 * 其实具体是什么USB设备，笔记本并不关心，只要符合USB规格的设备都可以。
 * 鼠标和键盘要想能在电脑上使用，那么鼠标和键盘也必须遵守USB规范，
 * 不然鼠标和键盘的生产出来无法使用;
 * 根据描述设计程序,完成键盘和鼠标插在电脑上就开启,拔出来就关闭的需求.
 */
public class Question13 {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();

        laptop.onPower();
        laptop.useUSB(new USB() {
            @Override
            public void open() {
                System.out.println("键盘开启");
            }

            @Override
            public void close() {
                System.out.println("键盘关闭");
            }
        });
        laptop.offPower();
    }
}

interface USB {
    void open();

    void close();
}

class Laptop {
    public void onPower() {
        System.out.println("笔记本开机");
    }

    public void offPower() {
        System.out.println("笔记本关机");
    }

    public void useUSB(USB usb) {
        usb.open();
        usb.close();
    }
}
