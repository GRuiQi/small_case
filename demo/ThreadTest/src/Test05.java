/**
 * 使用多线程模拟多家公司售卖电影票
 * 一共有100张电影票，3家公司对外售卖
 */
public class Test05 {

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        Thread t1 = new Thread(ticket);
        Thread t2 = new Thread(ticket);
        Thread t3 = new Thread(ticket);

        t1.setName("猫眼电影");
        t2.setName("糯米电影");
        t3.setName("美团电影");

        t1.start();
        t2.start();
        t3.start();
    }


}

class Ticket implements Runnable{
    //100张电影票
    /**
     * 使用volatile关键字后，会强制该线程不去私有内存中
     * 读取私有变量
     */
    private volatile int count = 100;

    @Override
    public void run() {
        while(true){
            synchronized (this){
                if(count<=0){
                    break;
                }else{
                    //将电影票做减1

                        count--;
                        System.out.println(Thread.
                                currentThread().getName()+"卖出一张票，还剩 "+count+"张票");
                    }


            }
        }
    }
}
