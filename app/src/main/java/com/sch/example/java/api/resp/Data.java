package com.sch.example.java.api.resp;

import java.util.List;

/**
 * Created by StoneHui on 2018/7/5.
 * <p>
 * 返回数据。
 */
public class Data {

    boolean status;
    int total;
    List<Gallery> tngou;

    public Data(boolean status, int total, List<Gallery> tngou) {
        this.status = status;
        this.total = total;
        this.tngou = tngou;
    }

    @Override
    public String toString() {
        return "Data{" +
                "status=" + status +
                ", total=" + total +
                ", tngou=" + tngou +
                '}';
    }

    static class Gallery {

        int id;
        int galleryclass;
        String title;
        String img;
        int count;
        int rcount;
        int fcount;
        int size;

        Gallery(int id, int galleryclass, String title, String img, int count, int rcount, int fcount, int size) {
            this.id = id;
            this.galleryclass = galleryclass;
            this.title = title;
            this.img = img;
            this.count = count;
            this.rcount = rcount;
            this.fcount = fcount;
            this.size = size;

        }

        @Override
        public String toString() {
            return "Gallery{" +
                    "id=" + id +
                    ", galleryclass=" + galleryclass +
                    ", title='" + title + '\'' +
                    ", img='" + img + '\'' +
                    ", count=" + count +
                    ", rcount=" + rcount +
                    ", fcount=" + fcount +
                    ", size=" + size +
                    '}';
        }
    }
}
