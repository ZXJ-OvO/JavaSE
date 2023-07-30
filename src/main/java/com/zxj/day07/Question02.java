package com.zxj.day07;

import lombok.Data;


/**
 * 展示系统中的全部电影(每部电影展示：名称、价格)。
 * 允许用户根据电影编号（id）查询出某部电影的详细信息
 */
public class Question02 {
    public static void main(String[] args) {
        Movie movie1 = new Movie();
        Movie movie2 = new Movie();

        movie1.setId(1L);
        movie2.setId(2L);

        movie1.setPrice(10.0);
        movie2.setPrice(20.0);

        movie1.setStatus(true);
        movie2.setStatus(false);

        // 为什么不是getStatus()? 因为boolean类型的属性，IDEA会自动识别为isStatus()，而不是getStatus()
        System.out.println("电影名称：" + movie1.getId() + " 价格：" + movie1.getPrice() + " 状态：" + movie1.isStatus());
        System.out.println("电影名称：" + movie2.getId() + " 价格：" + movie2.getPrice() + " 状态：" + movie2.isStatus());

    }
}

@Data
class Movie {
    private Long id;
    private double price;
    private boolean status;
}
