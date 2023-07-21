package com.zxj.day15;

import cn.hutool.core.collection.CollUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

public class Question12 {
    public static void main(String[] args) {
        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        class Candidate {
            private String name;
            private Integer score;
        }

        ArrayList<Candidate> list = CollUtil.newArrayList(new Candidate("张三", 100),
                new Candidate("李四", 80),
                new Candidate("王五", 60),
                new Candidate("赵六", 30),
                new Candidate("田七", 20));

        CollUtil.sortByProperty(list, "score");

        CollUtil.removeAny(list, list.get(0));
        System.out.println(list);

    }


}
