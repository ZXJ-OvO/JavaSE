package com.zxj.day17;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

/**
 * 全球
 * 第1名：《肖生克的救赎》，豆瓣评分：9.7
 * 　　第2名：《霸王别姬》豆瓣评分：9.6
 * 　　第3名：《阿甘正传》，豆瓣评分：9.6
 * 　　第5名：《辛德勒的名单》豆瓣评分：9.6
 * 　　第5名：《美丽人生》豆瓣评分：9.5
 * 　　第6名：《千与千寻》，豆瓣评分：9.4
 * 　　第7名：《泰坦尼克号》，豆瓣评分：9.4
 * 　　第8名：《这个杀手不太冷》，豆瓣评分：9.4
 * 　　第9名：《忠犬八公的故事》，豆瓣评分：9.4
 * 　　第10名：《盗梦空间》，豆瓣评分：9.3
 * 华人
 * 　  第1名：《阳光普照》，豆瓣评分：8.5
 * 　　第2名：《气球》豆瓣评分：7.9
 * 　　第3名：《拆弹专家2》，豆瓣评分：7.9
 * 　　第4名：《一秒钟》，豆瓣评分：7.8
 * 　　第5名：《送你一朵小红花》豆瓣评分：7.5
 * 　　第6名：《金都》，豆瓣评分：7.7
 * 　　第7名：《叔叔》，豆瓣评分：7.7
 * 　　第8名：《八佰》，豆瓣评分：7.6
 * 　　第9名：《夺冠》，豆瓣评分：7.3
 * 　　第10名：《我和我的家乡》，豆瓣评分：7.3
 * 1、现将两个榜单中的[影片名]以及[豆瓣评分]，分别按排名顺序依次存入两个Map集合。
 * 影片名 - key
 * 豆瓣评分 - value
 * 2、通过流的方式
 * 1）打印全球影片排行榜中的前三甲影片名
 * 2）打印华人影片排行榜中倒数5名的影片名
 * 3）将两个排行榜中的前5名挑出来共同存入新的集合
 * 4）定义电影Film类(属性：电影名，评分)，将上面新集合中的数据，封装到Film对象中。
 */
public class Question16 {
    public static void main(String[] args) {
        Map<String, Double> globalMovieRanking = new HashMap<>();
        globalMovieRanking.put("《肖生克的救赎》", 9.7);
        globalMovieRanking.put("《霸王别姬》", 9.6);
        globalMovieRanking.put("《阿甘正传》", 9.6);
        globalMovieRanking.put("《辛德勒的名单》", 9.6);
        globalMovieRanking.put("《美丽人生》", 9.5);
        globalMovieRanking.put("《千与千寻》", 9.4);
        globalMovieRanking.put("《泰坦尼克号》", 9.4);
        globalMovieRanking.put("《这个杀手不太冷》", 9.4);
        globalMovieRanking.put("《忠犬八公的故事》", 9.4);
        globalMovieRanking.put("《盗梦空间》", 9.3);

        // Print the top three movies from the global movie ranking
        globalMovieRanking.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> System.out.println(entry.getKey()));

    }

}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Movie {
    private String name;
    private double score;
}
