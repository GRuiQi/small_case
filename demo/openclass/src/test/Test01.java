package test;

import java.util.ArrayList;
import java.util.List;

/**
 * JVM栈
 */
public class Test01 {
    public static void main(String[] args) {
        m2();
    }

    public static void m1(){
        int a = 10;
        Object b = new Object();
        String s1 = new String("happy");
        List<String> list = new ArrayList<>();
        System.out.println("新年快乐");
    }
    public static void m2(){
        m1();
        System.out.println("心想事成");
    }
}

/**
 *   main()  m2()  m1()
 *
 **/