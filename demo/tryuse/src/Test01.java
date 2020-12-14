import java.io.*;

public class Test01 {
    /**
     *模拟软件的试用次数
     *放在内存里面不行，小软件不用放在数据库里面
     *考虑到试用次数记录到硬盘中的一个文件中。
     *规定只能使用三次
     */
    public static void main(String[] args) {
        //将config文件读取到内存中

        //code();
        check();
        int a = 1;
    }

    public static void check(){
        BufferedInputStream bis = null;

        BufferedOutputStream bos = null;


        try {
            bis = new BufferedInputStream(
                    new FileInputStream(
                            "E:\\My Note\\MyProject\\small_case\\demo\\tryuse\\src\\config.properties"));

            int temp = bis.read();
            //解密处理
            int count = temp ^ 66;

            //判断count是否小于零
            if(count<=0){
                System.out.println("您的试用次数已超出限制，请购买正版软件");
            }else{
                //未超出试用限制
                count--;
                System.out.println("您的试用次数还有"+count+"次");

                bos = new BufferedOutputStream(new FileOutputStream
                        ("E:\\My Note\\MyProject\\small_case\\demo\\tryuse\\src\\config.properties"));
                //做加密处理
                bos.write(count^66);
                bos.flush();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //向配置文件中初始化试用次数的值
    public static void code(){
        //BufferedOutputStream bos = null;
        //jdk7的写法，会主动关闭相关的资源 AutoCloseable
        try( BufferedOutputStream    bos = new BufferedOutputStream(new FileOutputStream("E:\\My Note\\MyProject\\small_case\\demo\\tryuse\\src\\config.properties"))
        ){

            bos.write(3^66);
            bos.flush();


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
