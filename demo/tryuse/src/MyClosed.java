public class MyClosed implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("关闭流");
    }
}
