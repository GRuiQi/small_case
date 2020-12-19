
统计在线的用户。
这种方式适用于局域网络。

> 在互联网中，电脑，手机，ipad同时连接路由器(wifi).
这三个设备的ip都是一样的。ip来统计就不妥了

根据Session统计：
如果一个用户同时打开两个浏览器，
会产生两个session对象。这种做法不
妥当。



根据ip地址来统计：上述情况，一个ip地址对应两个session.
每打开一个浏览器就会产生一个session.
统计map的size()就可以统计在线用户数了。

ServletContext 
- map: 
   - key:ip地址
   - value:`list<HttpSession>`
   
request：就是一次请求，request数据不共享

session：一个浏览器在服务器里产生要给session对象。可以访问到
同一个浏览器的多个request的数据。

servletContext: 同一个web应用只有ServletContext对象。
request,session可以访问它的数据。

### 如何实现该功能？

1. 展示在线用户数量
    - online_count.jsp
    - 提供退出按钮

2. 退出
    - LogoutServlet
    - 将当前ip地址所对应的session清空或设置失效

3. 监听ServletContext初始化
    - 初始化的时候创建一个Map对象
    
4. 监听request对象的初始化
    - 获取客户端的ip
    - 获取session对象
    - 创建list对象，将session对象放到list中
    - 将ip和list放到Map中
    - 将Map放到ServletContext中

5. session监听器
    - 当session销毁的时候，将当前session对象从list
    中移除
    
    
测试：在cmd输入ipconfig，测试在线用户个数。
因为是开手机热点，所以手机电脑连成局域网