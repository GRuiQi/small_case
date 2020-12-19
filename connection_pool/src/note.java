public class note {
    /**
     * 和数据库，硬盘打交道，需要花费很多时间
     *
     * 一般流程：
     *用户 -> Servlet/Controller  -> Dao -> DB
     *
     * 加入数据库连接池：
     *用户 -> Servlet/Controller -> Dao -> 数据库连接池/数据源(connection) -> DB
     *
     * 可以达到connection复用
     */
}
