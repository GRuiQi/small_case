public class note {
    /**
     * Web在线踢出用户
     * jack
     * 将User放到session中，userName:jack
     *
     * andy
     * 将User放到session中，userName:andy
     *
     * 每来一个用户，就放到session里。不方便管理
     *
     * 将用户名和对应的session放到中map中，
     * 想要哪个用户的信息，去map里查一下就可以了
     *
     * 将map放到ServletContext域里面
     * ServletContext(
     * 在一个web项目当中，有且仅有这一个servletContext对象
     * 生命周期。当服务器启动初始化该对象直到服务器关闭自动销毁
     * )
     * map
     * jack -- session1
     * andy -- session2
     *
     * 踢出用户，把当前用户相对应的session对象清空
     */


    /**
     * 登陆页面  login.jsp
     *
     * 登陆处理   LoginServlet 将该用户的数据放到session中
     *
     * 在线用户展现页面 userList.jsp
     *
     * 踢出在线用户  OfflineServlet 会跳转到userList.jsp
     *
     *辅助性操作：
     * 监听ServletContext的创建
     * MyServletContextListener 初始化一个Map对象
     *
     * 用户 User
     * 监听User对象和Session发生绑定的时候，将session放到map中，
     * 之后将该map放到ServletContext中
     *
     *字符编码过滤器
     * CharacterEncodingFilter  防止乱码
     *
     *
     * 权限过滤器
     * PermissionFilter 过滤权限
     * 当用户session不存在的时候，跳转到登陆页面
     * 例子：比如知乎有些内容登陆才能浏览
     */

    /**
     * jar
     * maven项目导包地址
     * https://mvnrepository.com/artifact/org.springframework
     *
     */
}
