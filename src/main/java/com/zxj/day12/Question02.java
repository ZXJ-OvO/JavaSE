package com.zxj.day12;

/**
 * 枚举， 使用见作者项目：Mall中的mall-common服务中的常量包
 */
public class Question02 {
    public static void main(String[] args) {

    }

    // 实现全局统一返回R？
    public static Brand returnMsg() {
        return Brand.ELASTICSEARCH;
    }

}

enum Brand {
    JAVA, SPRING, MYSQL, REDIS, ELASTICSEARCH;
}

