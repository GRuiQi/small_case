package com.atguigu.bean;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Page<T> {
    private List<T> datas;
    private int pageno; //页码
    private int totalno;  //总页数
    private int totalsize; //每页的记录数
}
