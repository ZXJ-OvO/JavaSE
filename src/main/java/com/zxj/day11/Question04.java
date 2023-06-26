package com.zxj.day11;

public class Question04 {
    public static void main(String[] args) {
        ButtonSwitch buttonSwitch = new ElectricalAppliances();
        buttonSwitch.on();
        buttonSwitch.off();
        buttonSwitch = new Television();
        buttonSwitch.on();
        buttonSwitch.off();
        buttonSwitch = new AirConditioning();
        buttonSwitch.on();
        buttonSwitch.off();
    }
}

interface ButtonSwitch {
    void on();

    void off();
}

class ElectricalAppliances implements ButtonSwitch {
    @Override
    public void on() {
        System.out.println("电器开启");
    }

    @Override
    public void off() {
        System.out.println("电器关闭");
    }
}

class Television extends ElectricalAppliances {
    @Override
    public void on() {
        System.out.println("电视开启");
    }

    @Override
    public void off() {
        System.out.println("电视关闭");
    }
}

class AirConditioning extends ElectricalAppliances {
    @Override
    public void on() {
        System.out.println("空调开启");
    }

    @Override
    public void off() {
        System.out.println("空调关闭");
    }
}