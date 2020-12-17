package com.shop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>(3);

        map.put("1","JavaSE");
        map.put("2","JavaWEB");
        map.put("3","JavaEE");

        System.out.println("遍历方法1: 先遍历key , 再取出value");
        for (String key : map.keySet()) {
            System.out.println("key is "+key);
            System.out.println("value is "+ map.get(key));
        }
        System.out.println();
        for (Map.Entry<String,String> m : map.entrySet()) {
            System.out.println(m);
            System.out.println("key is "+m.getKey());
            System.out.println("value is "+m.getValue());
        }
        System.out.println();
        Iterator<Map.Entry<String,String>> iter = map.entrySet().iterator();
        Map.Entry<String,String> entry;
        while(iter.hasNext()){
            entry = iter.next();
            System.out.println("key is "+entry.getKey());
            System.out.println("value is "+entry.getValue());
        }

    }
}
