package com.daily.huangpuMiddleTest.demo04;

import java.time.LocalDate;

public class Day {
    private LocalDate today;
    private boolean flag; // false  true休息

    public Day(){
    }

    public Day(LocalDate today) {
        this.today = today;
    }

    public int getWeekValue(){
        return today.getDayOfWeek().getValue();
    }

    public String getWeek(){
        String[] weeks = {"星期一", "星期二", "星期三", "星期四", "星期五", "星期六", "星期日"};
        return weeks[today.getDayOfWeek().getValue() - 1];
    }

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return today.toString() + "-" + getWeek() + "-"
                + (flag ? "休息" : "上班");
    }
}
