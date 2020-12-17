import java.util.*;

/**
 *
 * List:存放Map索引，洗牌只是洗List. Collections.shuffle只接受List
 * Map:key索引。value扑克的点数
 * TreeSet: TreeSet特性可以排序。 洗牌后进行发牌。根据索引去map里看下是什么牌
 */
public class Test02 {


    public static void main(String[] args) {

      run();

    }

    public static void run(){
        String[] num = {"A","2","3","4","5","6","7","8",
                "9","10","J","Q","K"};

//        String[] color = {"黑桃","红桃","梅花","方块"};
        String[] color = {"♦","♣","♥","♠"};

        List<Integer> list = new ArrayList<>();
        //map的key存放索引，value存放扑克牌
        Map<Integer,String> map = new HashMap<>();

        //索引，用来做映射
        int index = 0;
        //拼接扑克的花色和数字，将结果放到集合中
        for(String s1:num){
            for(String s2:color){
                map.put(index,s2+s1);
                list.add(index);

                index++;
            }
        }
        map.put(index,"小王");
        list.add(index++);

        map.put(index,"大王");
        list.add(index);

        //洗牌
        Collections.shuffle(list);

        //发三家排

        TreeSet<Integer> jack = new TreeSet<>();
        TreeSet<Integer> alice = new TreeSet<>();
        TreeSet<Integer> mike = new TreeSet<>();
        TreeSet<Integer> dipai = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            if(i>=list.size()-3){
                dipai.add(list.get(i));
            }else if(i%3==0){
                jack.add(list.get(i));
            }else if(i%3==1){
                alice.add(list.get(i));
            }else{
                mike.add(list.get(i));
            }
        }

        //看牌
        check(map,jack,"jack");
        check(map,alice,"alice");
        check(map,mike,"mike");
        check(map,dipai,"dipai");

    }

    public static void check(Map<Integer,String>map,TreeSet<Integer> set,String name){
        System.out.print(name+" : ");

        //根据TreeSet中的数据去Map中进行查询
        for (Integer i:set){
            System.out.print(map.get(i) + ",");

        }
        System.out.println();
    }

}
