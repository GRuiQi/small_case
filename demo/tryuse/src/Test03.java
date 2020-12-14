public class Test03 {
    public static void main(String[] args) {
        /**
         *测试实现AutoCloseable接口的类是否会自动调用close方法
         */
        try( MyClosed mc = new MyClosed()){

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
