package test;

/**
 * 二维数组
 */
public class ArrayTest01 {
    public static void main(String[] args) {
        //静态初始化
        int[][] a = {
                {1,2,3},
                {1,16,20},
                {25,28,21},
                {11,22,33,44}
        };

        //动态初始化
        int[][] b = new int[3][4];
        b[0][0] = 20;
    }
}
