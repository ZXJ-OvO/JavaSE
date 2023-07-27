package com.daily.huangpuSETest.demo01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * ### 第一题（15）
 * 需求**
 * 某小型商城系统的订单信息在**素材下的orders.xml文件中，现在要求把xml中的订单信息，封装成一个一个的订单对象，将订单对象保存到ArrayList集合中。
 * 具体功能点要求**
 * 1)   定义订单类Order，创 建ArrayList集合，用于存储订单Order对象 （解析XML 4分，封装成对象2分）
 * 2）  请使用Stream流找出今天之前的订单，并遍历输出。（3分）
 * 3)   请使用Stream流找出集合中价格最贵的订流单，把这个订单的详细信息打印出来。（3分）
 * 4)   请使用Stream流遍历集合中的每个订单，要求按照价格降序输出每个订单的详情。（3分）
 */
public class OrderInfoParsing {
    public static void main(String[] args) throws Exception {
        // 创建Dom4J解析器对象
        SAXReader saxReader = new SAXReader();
        // 通过解析器对象读取XML文件为Document对象
        Document document = saxReader.read("D:\\project\\java\\JavaSE\\JavaSE\\src\\main\\java\\com\\daily\\huangpuSETest\\demo01\\orders.xml");
        // 拿到根节点
        Element rootElement = document.getRootElement();
        // 拿到当前节点下的子元素
        List<Element> elements = rootElement.elements();

        ArrayList<Order> orderArrayList = new ArrayList<>();

        for (Element element : elements) {
            String nameText = element.elementText("name");
            String doubleText = element.elementText("double");
            String timeText = element.elementText("time");

            LocalDateTime localDateTime = LocalDateTime.parse(timeText, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            double price = Double.parseDouble(doubleText);

            Order order = new Order(nameText, localDateTime, price);
            orderArrayList.add(order);
        }

        System.out.println("\n1、解析封装后订单对象数据总览：");
        orderArrayList.forEach(System.out::println);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("\n2、今天之前的订单：");
        orderArrayList.stream()
                .filter(order -> order.getTime().isBefore(localDateTime))
                .forEach(order -> System.out.print("名称：" + order.getName() + "\t" + "价格：" + order.getPrice() + "\t" + "时间：" + order.getTime() + "\t\n"));

        System.out.println("\n3、价值量最大的订单：");

        // 求最大价值订单
        Optional<Order> max = orderArrayList.stream()
                .max(Comparator.comparingDouble(Order::getPrice));

        // 输出所有价值量与最大价值订单相同的所有订单
        orderArrayList.stream()
                .filter(order -> BigDecimal.valueOf(order.getPrice()).
                        compareTo
                                (BigDecimal.valueOf(max.get().getPrice()))
                        == 0)
                .forEach(System.out::println);

        System.out.println("\n4、按照价格降序输出每个订单的详情：");
        orderArrayList.stream()
                .sorted((order1, order2) -> Double.compare(order2.getPrice(), order1.getPrice()))
                .forEach(System.out::println);

    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Order {
    private String name;
    private LocalDateTime time;
    private Double price;
}