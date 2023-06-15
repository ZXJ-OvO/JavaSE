package com.zxj.day07;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 定义一个女朋友类。女朋友的属性包含：
 * 姓名，身高，体重。行为包含：洗衣服wash()，做饭cook()。
 * 另外定义一个用于展示三个属性值的show()方法。
 * 请在测试类中通过有参构造方法创建对象并赋值，
 * 然后分别调用展示方法、洗衣服方法和做饭方法。打印效果如下：
 */
public class Question05 {
    public static void main(String[] args) {
        GirlFriend girlFriend = new GirlFriend("小红", 160, 50);
        show(girlFriend);
        wash(girlFriend);
        cook(girlFriend);
    }

    public static void show(GirlFriend girlFriend) {
        System.out.println(girlFriend.getName()+girlFriend.getHeight()+ "cm" +girlFriend.getWeight()+ "kg");
    }
    public static void wash(GirlFriend girlFriend) {
        System.out.println(girlFriend.getName()+"洗衣服");
    }
    public static void cook(GirlFriend girlFriend) {
        System.out.println(girlFriend.getName()+"做饭");
    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class GirlFriend {
    private String name;
    private int height;
    private int weight;
}
