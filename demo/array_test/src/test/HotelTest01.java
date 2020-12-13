package test;

import bean.Hotel;

import java.util.Scanner;

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
        Scanner s = new Scanner(System.in);
        System.out.println("酒店列表如下所示:");
        Hotel hotel = new Hotel();
        hotel.print();
        while(true){
            System.out.println("请输入预定或者退房");
            String input = s.next();
            if("预定".equals(input)){
                System.out.println("请输入房间预定编号");
                String id = s.next();
                hotel.order(id);
            }else if("退房".equals(input)){
                System.out.println("请输入房间退房编号");
                String id = s.next();
                hotel.checkOut(id);
            }else{
                System.out.println("请输入预定或退房");
            }

            hotel.print();
        }



    }
}
