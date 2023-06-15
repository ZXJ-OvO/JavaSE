package com.zxj.day07;

/**
 * 定义手机类，手机有品牌(brand),价格(price)和颜色(color)三个属性，有打电话call()和sendMessage()两个功能。
 * 请定义出手机类，类中要有空参、有参构造方法，set/get方法。
 * 定义测试类，在主方法中使用空参构造创建对象，使用set方法赋值。
 * 调用对象的两个功能，打印效果如下：
 */
public class Question04 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        phone.setBrand("华为");
        phone.setColor("黑色");
        phone.setPrice(5000);
        phone.call();
        phone.sendMessage();
    }

}

class Phone {
    private String brand;
    private int price;
    private String color;

    public Phone() {
    }

    public Phone(String brand, int price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }

    public void call() {
        System.out.println("打电话");
    }

    public void sendMessage() {
        System.out.println("发短信");
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price < 0) {
            System.out.println("价格不能为负数");
        } else {
            this.price = price;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        if (color.equals("红色") || color.equals("黑色") || color.equals("白色")) {
            this.color = color;
        } else {
            System.out.println("颜色不对");
        }
    }
}
