import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 初始化一幅扑克牌
 * 将初始化的扑克牌放到集合List
 *
 * List:存放Map索引，洗牌只是洗List. Collections.shuffle只接受List
 * Map:key索引。value扑克的点数
 * TreeSet: TreeSet特性可以排序。 洗牌后进行发牌。根据索引去map里看下是什么牌
 */
public class Test01 {


    public static void main(String[] args) {

        String[] num = {"A","2","3","4","5","6","7","8",
                "9","10","J","Q","K"};

        String[] color = {"红桃","黑桃","方块","梅花"};

        List<String> poker = new ArrayList();

        //拼接扑克的花色和数字，将结果放到集合中
        for(String s1:color){
            for(String s2:num){
                poker.add(s1+s2);
            }
        }
        poker.add("小王");
        poker.add("大王");

        System.out.println("初始化："+poker);

        //洗牌
        Collections.shuffle(poker);

        System.out.println("洗牌："+poker);

        //发三张排
        ArrayList<String> pony = new ArrayList<>();
        ArrayList<String> jack = new ArrayList<>();
        ArrayList<String> alice = new ArrayList<>();

        //留下三张底牌
        ArrayList<String> dipai = new ArrayList<>();
        for (int i = 0; i < poker.size() ; i++) {
            if(i>=poker.size()-3){
                dipai.add(poker.get(i));
            }else if(i%3==0){
                pony.add(poker.get(i));
            }else if(i%3==1){
                jack.add(poker.get(i));
            }else{
                alice.add(poker.get(i));
            }
        }

        //看牌
        System.out.println("pony:"+pony);
        System.out.println("jack:"+jack);
        System.out.println("alice:"+alice);
        System.out.println("dipai:"+dipai);
    }

}
