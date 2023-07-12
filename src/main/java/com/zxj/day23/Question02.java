package com.zxj.day23;

public class Question02 {

    public static void main(String[] args) {

        int a = 100;
        int b = 200;

        Integer c = a; // 100
        Integer d = a; // 100
        Integer e = b; // 200
        Integer f = b; // 200

        long l = 100l;
        Long ll = l; // 100

        System.out.println(c == d);       //true  Integer值100在Integer的缓存范围中，所以指向同一个对象，即地址相同
        System.out.println(e == f);       //false Integer的缓存范围是-128~127，200超出了缓存范围中，所以指向不同的对象，即地址不同
        System.out.println(a == l);       //true  字符串常量池中byte short int long类型的范围是-128~127，所以指向同一个对象，即地址相同
        System.out.println(c == l);       //true  包装类在与基本数据类型做==比较时，包装类型会自动拆箱为基本数据类型，所以比较的是基本数据类型，即地址相同
        System.out.println(e.equals(f));  //true  包装类的equals方法重写过，当比较双方的类型不同时，返回false；当比较双方的类型相同时，比较的是实际数据值
        System.out.println(c.equals(l));  //false 类型不同，返回false
        System.out.println(c.equals(ll)); //false 类型不同，返回false

        Float i11 = 333f;
        Float i22 = 333f;
        System.out.println(i11 == i22);// 输出 false

        Double i3 = 1.2;
        Double i4 = 1.2;
        System.out.println(i3 == i4);// 输出 false


        Integer i1 = 40;
        Integer i2 = new Integer(40);
        System.out.println(i1 == i2);        // false
        // Integer i1=40 会发生装箱，等价于Integer i1=Integer.valueOf(40) 因此，i1 直接使用的是缓存中的对象。而Integer i2 = new Integer(40) 会直接创建新的对象。

    }

}
