package bean;

/**
 * 酒店
 */
public class Hotel {
    /**
     * 酒店里的房间是一个挨着一个的，需要在Hotel将这些房间
     * 体现出来。酒店里的房间基本是固定不变的。
     * Java中数组的长度正好是固定的
     *
     * 酒店有多层，所有使用二维数组
     */

    private Room[][] rooms;

    /**
     * 初始化房间对象数据
     */
    public Hotel(){
        //酒店一共5层，共有10个房间
        rooms = new Room[5][10];

        //初始化房间编号，房间类型
        for(int i=0;i<rooms.length;i++){
            //***  Ctrl + j 生成代码快捷键 ****
            for (int j = 0; j < rooms[i].length; j++) {
                if(i==0 || i==1){
                    //101,102,103...
                   rooms[i][j] =  new Room(
                            String.valueOf((i+1)*100+(j+1)),
                            "标准间",false);
                }
                if(i==2||i==3){
                    rooms[i][j] =  new Room(
                            String.valueOf((i+1)*100+(j+1)),
                            "双人间",false);
                }
                if(i==4){
                    rooms[i][j] =  new Room(
                            String.valueOf((i+1)*100+(j+1)),
                            "豪华间",false);
                }

                
            }
        }
    }

    //在使用酒店管理系统的时候，需要查看每个房间的状态是否被占用

    public void print(){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                System.out.print(String.valueOf(rooms[i][j])+" ");

            }

            System.out.println();
        }
    }

    //当用户办理入住的时候，需要将房间状态改为占用
    public void order(String id){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if(rooms[i][j].getId().equals(id)){
                    rooms[i][j].setUse(true);
                    return;
                    //return 退出所有循环，break退出本次循环
                }

            }

        }
    }

    //提供一个退房的方法
    public void checkOut(String id){
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if(rooms[i][j].getId().equals(id)){
                    rooms[i][j].setUse(false);
                    return;
                    //return 退出所有循环，break退出本次循环
                }

            }

        }
    }
}
