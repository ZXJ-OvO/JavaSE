package com.daily.finalExam.Demo01;

import java.util.Objects;

public class Songs {
    private String name;
    private String id;
    private String singer;
    private String time;
    private Integer like;
    private String date;

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Songs songs = (Songs) object;
        return Objects.equals(name, songs.name) && Objects.equals(id, songs.id) && Objects.equals(singer, songs.singer) && Objects.equals(time, songs.time) && Objects.equals(like, songs.like) && Objects.equals(date, songs.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id, singer, time, like, date);
    }

    @Override
    public String toString() {
        return "Songs{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", singer='" + singer + '\'' +
                ", time='" + time + '\'' +
                ", like=" + like +
                ", date='" + date + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
