package com.zxj.day14;

import java.util.function.Supplier;

/**
 * **训练目标**：掌握Java中lambda表达式的使用
 * **需求背景**：在注册网站用户的时候，大部分的网站都会先生成一个随机的验证码展示给用户，用于区分正常人和机器的操作。如下图所示：
 * **需求描述**：在素材的supplier项目的Entry类的指定位置补全代码(调用verificationCode方法)，实现一个生成四位随机验证码! 案例的执行效果如下所示：
 * 1、Supplier<T>是一个生产类型接口，该接口的方法`T get();`是需要在方法内部生产一个T类型的对象返回。
 * 2、verificationCode方法参数Supplier<String>说明如下所示：
 * 3、生成验证码的字符可以从OPTIONS_CAHS中获取
 * 4、调用verificationCode方法获取一个4位的随机验证码
 */
public class Question13 {
    // 验证码可选字符
    private static final String OPTIONS_CAHS = "023456789abcdefghjklmnopqrstuvwxyz";

    public static void main(String[] args) {
        // 在等号的右边补全代码
        String verificationCode = verificationCode(() -> {
            String code = "";
            for (int i = 0; i < 4; i++) {
                code += OPTIONS_CAHS.charAt((int) (Math.random() * OPTIONS_CAHS.length()));
            }
            return code;
        });

        // 输出
        System.out.println("本次生成的验证码为：" + verificationCode);
    }

    // 调用该方法生成一个4位的随机验证码
    public static String verificationCode(Supplier<String> supplier) {

        return supplier.get();
    }

}
