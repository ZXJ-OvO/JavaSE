package com.zxj.day13;

/**
 * 要求:只需要校验用户名,密码以及邮箱(无需验证确认密码以及邮箱验证码)
 * 用户名:必须是大小写字母,数字,_组合 3到16个字符
 * 密码:开头必须是大小写字母,或者数字,后面加1个或者多个.  然后再加一个或者多个大小写字母,数字
 * 邮箱:：@前面可以是数字，字母，下划线。@后面是字母和.
 * talta@sina.com.cn
 */
public class Question13 {
    public static void main(String[] args) {

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*_)[a-zA-Z0-9_]{3,16}$\n";
        String regex2 = "^[a-zA-Z0-9](\\.[a-zA-Z0-9])+$\n";
        String regex3 = "^[a-zA-Z0-9_]+@[a-zA-Z.]+$\n";

        //校验
        String username = "zX1j_";
        String password = "。/zxj123";
        String email = "/zxjOvO@gmail.com";

        System.out.println(username.matches(regex));
        System.out.println(password.matches(regex2));
        System.out.println(email.matches(regex3));

    }
}
