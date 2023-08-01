package com.daily.huangpuSETest.demo02;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

/**
 * **需求**
 * 某个班级组织团建活动，班长给出了几个去处给大家选择，
 * 分别是 “农家乐” , "轰趴"，“野外拓展”，“健身房”，本次活动每个学生是可以多选的。
 * 现在有如下5名学生选择了如下去处。
 * 张全蛋儿  农家乐,野外拓展
 * 李二狗子  轰趴,野外拓展,健身房
 * 翠花     野外拓展，
 * 小帅     轰趴，健身房
 * 有容     农家乐
 * **具体的功能点如下：**
 * 1、请找出每个去处想去的人数是多少，并输出投票最多的去处是哪个。
 * 2、请找出哪些人没有选择投票最多的去处，输出他们的名字。
 * （**本案例用不用stream流做都给分**）	 **比如：小帅，有容没有选择野外拓展。**
 */
public class DestinationVoteInfo {
    public static ArrayList<Student> studentArrayList = new ArrayList<>();

    public static void main(String[] args) {

        // 题目没有要求解析，则直接封装数据
        studentArrayList.add(new Student("张全蛋儿", new String[]{"农家乐", "野外拓展"}));
        studentArrayList.add(new Student("李二狗子", new String[]{"轰趴", "野外拓展", "健身房"}));
        studentArrayList.add(new Student("翠花", new String[]{"野外拓展"}));
        studentArrayList.add(new Student("小帅", new String[]{"轰趴", "健身房"}));
        studentArrayList.add(new Student("有容", new String[]{"农家乐"}));

        // 计算每个地点的投票人数
        Long farmPartyCount = headCount("农家乐");
        Long fieldExpansionCount = headCount("野外拓展");
        Long boomCount = headCount("轰趴");
        Long gymCount = headCount("健身房");

        System.out.println("1、每个去处想去的人数统计：");
        System.out.println("农家乐：" + farmPartyCount + " 人");
        System.out.println("野外拓展：" + fieldExpansionCount + " 人");
        System.out.println("轰趴：" + boomCount + " 人");
        System.out.println("健身房：" + gymCount + " 人");

        // 封装到地点得票类
        DestinationVote farmPartyVote = new DestinationVote("农家乐", farmPartyCount);
        DestinationVote fieldExpansionVote = new DestinationVote("野外拓展", fieldExpansionCount);
        DestinationVote boomVote = new DestinationVote("轰趴", boomCount);
        DestinationVote gymVote = new DestinationVote("健身房", gymCount);

        // 封装到数组中然后取得数组最大值，过滤出所有和最大值相同的地点信息
        DestinationVote[] destinationVotes = new DestinationVote[]{farmPartyVote, fieldExpansionVote, boomVote, gymVote};
        Optional<DestinationVote> max = Arrays.stream(destinationVotes).max((o1, o2) -> (int) (o1.getTime() - o2.getTime()));
        System.out.println("\n2、投票最多的去处统计如下：");

        ArrayList<String> maxVoteDestination = new ArrayList<>();
        Arrays.stream(destinationVotes).filter(destinationVote -> Objects.equals(destinationVote.getTime(), max.get().getTime())).forEach(destinationVote -> {
            System.out.println(destinationVote.getName());
            maxVoteDestination.add(destinationVote.getName());
        });

        System.out.println("\n3、以下同学没有前往得票最高的场所：");
        headCount(maxVoteDestination);
    }

    public static void headCount(ArrayList<String> maxVoteDestination) {
        ArrayList<String> list = new ArrayList<>();
        for (Student student : studentArrayList) {
            // 使用集合装载当前学生投票地点和最高得票地点
            String[] destinations = student.getDestination();
            list.addAll(Arrays.asList(destinations));
            list.addAll(maxVoteDestination);
            List<String> collect = list.stream().distinct().collect(Collectors.toList());

            // 去重前后集合长度相等的意味着此学生中的地点数组中不含目标地点，则输出
            if (list.size() == collect.size()) System.out.println(student.getName());
            list.clear();
        }
    }

    public static Long headCount(String destinationString) {
        return studentArrayList.stream().filter(student -> {
            String[] destinations = student.getDestination();
            for (String destination : destinations)
                if (destination.equals(destinationString)) return true;
            return false;
        }).count();
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class DestinationVote implements Comparable<DestinationVote> {
    private String name;
    private Long time;

    @Override
    public int compareTo(DestinationVote o) {
        return this.time.compareTo(o.time);
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Student {
    private String name;
    private String[] destination;
}