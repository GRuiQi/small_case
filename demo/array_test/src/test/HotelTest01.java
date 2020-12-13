package test;

import bean.Hotel;

/**
 * 需求：
 *  酒店一共5层，共有10个房间
 *  1,2层标准间
 *  3,4双人间
 *  5豪华房间
 *  客户办理入住，将入住的房间装填修改为占用
 *  客户办理退房，将房间的状态修改为房间
 *
 *  将现实中的东西用计算机语言表达出来
 */
public class HotelTest01 {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.print();
    }
}
