package com.daily.finalExam.Demo01;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 某在线音乐平台的歌曲信息保存在**素材-> songs.properties文件中
 * 注意：上面每行数据信息依次为：歌名=编号,演员,歌曲时长,点赞数,发布时间
 * 请使用Stream流找出最热门的前5首歌曲，并遍历输出。
 * 请使用Stream流遍历集合中的每首歌曲，要求按照歌曲时长升序输出每首歌曲的详情。
 * 请把songs.properties中的数据，按照发布时间排序（**最近发布时间排在前面**），
 * 然后写出到一个新的文件songs_date.properties文件中去。
 * （songs_date.properties放到当前模块的src路径下即可）。
 */
public class Test01 {
    public static void main(String[] args) throws Exception {

        // 1、解析properties文件的数据
        File file = new File("com/daily/finalExam/Demo01/songs.properties");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        Properties properties = new Properties();
        properties.load(reader);
        Set<Map.Entry<Object, Object>> data = properties.entrySet();
        // 封装到Map集合中
        Map<String, String> map = new HashMap<>();
        for (Map.Entry<Object, Object> entry : data) {
            map.put((String) entry.getKey(), (String) entry.getValue());
        }
        System.out.println("1、歌曲解析详情：");
        map.forEach((k, v) -> System.out.println(k + " = " + v));
        System.out.println();

        // 请使用Stream流找出最热门的前5首歌曲，并遍历输出。
        System.out.println("2、最热门的前5首歌曲：");

        // 将map中的歌曲信息包括key 、 value遍历封装到Songs对象中
        ArrayList<Songs> songsArrayList = new ArrayList<>();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String[] songInfo = entry.getValue().split(",");
            Songs songs = new Songs();
            songs.setName(entry.getKey());
            songs.setId(songInfo[0]);
            songs.setSinger(songInfo[1]);
            songs.setTime(songInfo[2]);
            songs.setLike(Integer.parseInt(songInfo[3]));
            songs.setDate(songInfo[4]);
            songsArrayList.add(songs);
        }
        // 按照点赞数降序排序
        Collections.sort(songsArrayList, (o1, o2) -> o2.getLike() - o1.getLike());
        // 取前5个
        songsArrayList.stream().limit(5).forEach(System.out::println);
        System.out.println();

        // 请使用Stream流遍历集合中的每首歌曲，要求按照歌曲时长升序输出每首歌曲的详情。
        System.out.println("3、歌曲时长升序输出每首歌曲的详情：");
        songsArrayList.stream().sorted(Comparator.comparing(Songs::getTime)).forEach(System.out::println);
        System.out.println();

        // 按照时间排序
        System.out.println("4、按照发布时间排序（最近发布时间排在前面）：");
        Collections.sort(songsArrayList, (o1, o2) -> {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            try {
                Date date1 = simpleDateFormat.parse(o1.getDate());
                Date date2 = simpleDateFormat.parse(o2.getDate());
                return date2.compareTo(date1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 0;
        });
        songsArrayList.forEach(System.out::println);

        // 写出到新的properties文件中去
        System.out.println("5、写出到新的properties文件中去：");
        Properties properties1 = new Properties();
        for (Songs songs : songsArrayList) {
            properties1.setProperty(songs.getName(), songs.getId() + "," + songs.getSinger() + "," + songs.getTime() + "," + songs.getLike() + "," + songs.getDate());
        }
        File file1 = new File("songs_date.properties");
        FileOutputStream fileOutputStream = new FileOutputStream(file1);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        properties1.store(bufferedOutputStream, "songs_date.properties");
    }
}
