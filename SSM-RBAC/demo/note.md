[TOC]



## 一、项目的结构

RBAC互联网项目中的后台管理功能。

> <img src="https://qiyewuan-1302629736.cos.ap-nanjing.myqcloud.com/img/image-20200808145621980.png" alt="image-20200808145621980" style="zoom:67%;" />

Manager (jar)：后台

Portal (jar)：前台，门户网站

Common (JAR)：共同的部分

Parent（POM） : 管理他们的关系，不做实际功能的开发

>  开发的时候一个一个子项目开发，运行的时候当作整体来运行，打成一个war包。
>
>  两个war包，表明是两个独立的项目。

Web(war) : 整体打包



> 练手项目，没必要弄得那么复杂。



### jar和war

```markdown
一、概念

jar包：
即Java Archive，Java的包，Java编译好之后生成class文件，但如果直接发布这些class文件的话会很不方便，所以就把许多的class文件打包成一个jar，jar中除了class文件还可以包括一些资源和配置文件，通常一个jar包就是一个java程序或者一个java库。
JAR包是类的归档文件，JAR 文件格式以流行的 ZIP 文件格式为基础。与 ZIP 文件不同的是，JAR 文件不仅用于压缩和发布，而且还用于部署和封装库、组件和插件程序，并可被像编译器和 JVM 这样的工具直接使用。

war包:
Web application Archive，与jar基本相同，但它通常表示这是一个Java的Web应用程序的包，tomcat这种Servlet容器会认出war包并自动部署。
war包是JavaWeb程序打的包，war包里面包括写的代码编译成的class文件，依赖的包，配置文件，所有的网站页面，包括html，jsp等等。一个war包可以理解为是一个web项目，里面是项目的所有东西。

二、目录结构
jar包里的com里放的就是class文件，配置文件，但是没有静态资源的文件,大多数 JAR 文件包含一个 META-INF 目录，它用于存储包和扩展的配置数据，如安全性和版本信息。

而war包里的WEB-INF里放的class文件和配置文件，META-INF和jar包作用一样，war包里还包含静态资源的文件

三、总结起来就是有两点不同：
war包和项目的文件结构保持一致，jar包则不一样。

jar包里没有静态资源的文件（index.jsp）

四、部署项目的区别
部署普通的spring项目用war包就可以，

部署springboot项目用jar包就可以，因为springboot内置tomcat。
```

### 互联网金融-应用

#### 概念

任何和金融相关的互联网应用都属于互联网金融。在生活中，这样的应用比比皆是：如购物平台，手机支付，共享单车等

随着传统的金融机构，实体经营店将业务从线下搬到线上，获取了可观的利润后，互联网短时间内吸引了大量资本的注意，发展出了除电商外很多不同的业务模式

#### 众筹

众筹( `Crowd-Funding` )大意为大众筹资或群众筹资，是指用团购预购的形式，向网友募集项目资金的模式。众筹的本意是利用互联网和SNS传播的特性，让创业企业、艺术家或个人对公众展示他们的创意及项目，争取大家的关注和支持，进而获得所需要的资金援助。众筹平台的运作模式大同小异——需要资金的个人或团队将项目策划交给众筹平台，经过相关审核后，便可以在平台的网站上建立属于自己的页面，用来向公众介绍项目情况。

#### P2P网贷

P2P( `Peer-to-Peerlending` )，即点对点信贷。P2P网贷是指通过第三方互联网平台进行资金借、贷双方的匹配，需要借贷的人群可以通过网站平台寻找到有出借能力并且愿意基于一定条件出借的人群，帮助贷款人通过和其他贷款人一起分担一笔借款额度来分散风险，也帮助借款人在充分比较的信息中选择有吸引力的利率条件。

两种运营模式:
第一种是纯线上模式，其特点是资金借贷活动都通过线上进行，不结合线下的审核。通常这些企业采取的审核借款人资质的措施有通过视频认证、查看银行流水账单、身份认证等。
第二种是线上线下结合的模式，借款人在线上提交借款申请后，平台通过所在城市的代理商采取入户调查的方式审核借款人的资信、还款能力等情况。

#### 第三方支付

第三方支付（ `Third-PartyPayment` ）狭义上是指具备一定实力和信誉保障的非银行机构，借助通信、计算机和信息安全技术，采用与各大银行签约的方式，在用户与银行支付结算系统间建立连接的电子支付模式。

根据央行2010年在《非金融机构支付服务管理办法》中给出的非金融机构支付服务的定义，从广义上讲第三方支付是指非金融机构作为收、付款人的支付中介所提供的网络支付、预付卡、银行卡收单以及中国人民银行确定的其他支付服务。第三方支付已不仅仅局限于最初的互联网支付，而是成为线上线下全面覆盖，应用场景更为丰富的综合支付工具。

#### 数据金融

大数据金融是指集合海量非结构化数据，通过对其进行实时分析，可以为互联网金融机构提供客户全方位信息，通过分析和挖掘客户的交易和消费信息掌握客户的消费习惯，并准确预测客户行为，使金融机构和金融服务平台在营销和风险控制方面有的放矢。

基于大数据的金融服务平台主要指拥有海量数据的电子商务企业开展的金融服务。大数据的关键是从大量数据中快速获取有用信息的能力，或者是从大数据资产中快速变现利用的能力。因此，大数据的信息处理往往以云计算为基础。

互联网金融网站 [淘宝网](https://www.taobao.com) [京东](https://www.jd.com) [苏宁易购](https://www.suning.com/) [苏宁金融](https://jinrong.suning.com/) [财富中国](http://www.cfbb.com.cn/)



AtCrowdFunding

如何创建项目，怎么创建文件，项目直接的依赖关系。视频都说得很清除了。

atcrowdfunding-web报错解决办法

web.xml不存在，右键-》properties...

web的依赖,可以手动添加

```xml
 <dependencies>
  	<dependency>
  		<groupId>com.ruiqi</groupId>
  		<artifactId>atcrowdfunding-manager</artifactId>
  		<version>0.0.1-SNAPSHOT</version>
  	</dependency>
  	<dependency>
  		<groupId>com.ruiqi</groupId>
  		<artifactId>atcrowdfunding-portal</artifactId>
  		<version>0.0.1-SNAPSHOT</version>
  	</dependency>
  </dependencies>
```







## 二、集成SSM

### spring

spring 框架是整个框架的核心，将前端请求数据的处理以及数据库的操作整合在一起，非常重要。

Spring环境搭建时需要读取web应用的初始化环境contextConfigLocation，从classpath中读取配置文件 spring/spring-*.xml

classpath就是WEB-INF下的lib，Maven项目会自动把src的java文件编译到lib中。

可以认为src就是classpath。

> <img src="https://qiyewuan-1302629736.cos.ap-nanjing.myqcloud.com/img/image-20200808154607194.png" alt="image-20200808154607194" style="zoom:50%;" />



在`web.xml`文件中增加配置信息集成`Spring`框架

```xml
<web-app>
...
    <context-param>
        <param-name>contextConfigLocation</param-name>
        <param-value>classpath*:spring/spring-*.xml</param-value>
    </context-param>
    <listener>
        <listener-class>org.springframework.web.context.ContextLoaderListener</listener-class>
    </listener>
...
</web-app>
Spring`环境构建时需要读取`web`应用的初始化参数`contextConfigLocation`, 从`classpath`中读取配置文件`spring/spring-*.xml
```

在项目`src/main/resources`目录中增加`spring`文件夹，并在其中增加`spring-context.xml`配置文件。

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:tx="http://www.springframework.org/schema/tx"
    xmlns:aop="http://www.springframework.org/schema/aop"
    xsi:schemaLocation="http://www.springframework.org/schema/aop http://www.springframework.org/schema/aop/spring-aop-4.0.xsd
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/tx http://www.springframework.org/schema/tx/spring-tx-4.0.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd">

</beans>
```

`Spring`框架的核心是构建对象，整合对象之间的关系（`IOC`）及扩展对象功能（`AOP`），所以需要在`spring-context.xml`配置文件中增加业务对象扫描的相关配置。扫描后由`Spring`框架进行管理和组合。

```xml
<beans>
    ...
    <context:component-scan base-package="com.atguigu.*" >
        <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>
    ...
</beans>
```

#### 扫描配置中为什么要排除`Controller`注解

`Controller`注解的的作用是声明控制器（处理器）类。

从数据流转的角度，这个类应该是由`SpringMVC`框架进行管理和组织的，所以不需要由`Spring`框架扫描。

### SpringMVC

`SpringMVC`框架用于处理系统中数据的流转及控制操作。
（从哪里来，到哪里去。多么有哲理的一句话。）

集成`SpringMVC`框架，需要在`web.xml`文件中增加配置信息

```xml
<web-app>
...
    <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring/springmvc-context.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
...
</web-app>
SpringMVC`环境构建时需要读取`servlet`初始化参数`init-param`, 从`classpath`中读取配置文件`spring/springmvc-context.xml
```

在项目`src/main/resources/spring`目录中，增加`springmvc-context.xml`配置文件。

```html
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:context="http://www.springframework.org/schema/context"
    xmlns:p="http://www.springframework.org/schema/p"
    xmlns:mvc="http://www.springframework.org/schema/mvc"
    xsi:schemaLocation="http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc-4.0.xsd
        http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context-4.0.xsd">

</beans>
```

`SpringMVC`框架的核心是处理数据的流转，所以需要在`springmvc-context.xml`配置文件中增加控制器对象（`Controller`）扫描的相关配置。扫描后由`SpringMVC`框架进行管理和组合。

```xml
<beans>
    ...
    <context:component-scan base-package="com.atguigu.*" use-default-filters="false" >
        <context:include-filter type="annotation" expression="org.springframework.stereotype.Controller"/>
    </context:component-scan>
    ...
</beans>
```

#### 静态资源如何不被`SpringMVC`框架进行拦截

在配置文件中增加`<mvc:default-servlet-handler/>`, `<mvc:annotation-driven />`即可

在实际的项目中静态资源不会和动态资源放在一起，也就意味着不会放置在服务器中，所以这些配置可以省略。

如果`SpringMVC`框架数据处理为页面跳转，那么需要配置相应的视图解析器`ViewResolver`。

```xml
<beans>
    ...
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" >
        <property name="viewClass" value="org.springframework.web.servlet.view.JstlView"/>
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
    ...
</beans>
```

#### 如果有多个视图解析器怎么办？

`SpringMVC`框架中允许存在多个视图解析器，框架会按照配置声明顺序，依次进行解析。

`SpringMVC`框架中配置多个视图解析器时，如果将`InternalResourceViewResolver`解析器配置在前，那么即使找不到视图，框架也不会继续解析，直接发生`404`错误，所以必须将`InternalResourceViewResolver`解析器放置在最后。

如果`SpringMVC`框架数据处理为响应`JSON`字符串，那么为了浏览器方便对响应的字符串进行处理，需要明确字符串的类型及编码方式。

**如果增加了`<mvc:annotation-driven />`标签，下面的配置可省略。**

``` xml
<beans>
    ...
    <bean class="org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter" >
        <property name="messageConverters" >
            <list>
                <bean class="org.springframework.http.converter.json.MappingJacksonHttpMessageConverter" >
                    <property name="supportedMediaTypes" >
                        <list>
                            <value>application/json;charset=UTF-8</value>
                        </list>
                    </property>
                </bean>
            </list>
        </property>
    </bean>
    ...
</beans>
```

如果项目中含有文件上传业务，还需要增加文件上传解析器`MultipartResolver`

```
<beans>
    ...
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver" p:defaultEncoding="UTF-8" >
        <property name="maxUploadSize" value="2097152"/>
        <property name="resolveLazily" value="true"/>
    </bean>
    ...
</beans>
```



#### [servlet的执行过程和编写](https://zhuanlan.zhihu.com/p/35285934)

> servlet是Java中的动态网页技术，使用它可以生成与客户进行交互的动态页面。
>
> servlet 担当客户请求（Web浏览器或其他HTTP客户程序）与服务器响应（HTTP服务器上的数据库或应用程序）的中间层。
>
> 通过 **请求－响应** 编程模型来访问这个驻留在服务器内存里的servlet程序。
>
> Servlet 向页面传递数据，是通过参数来完成的，request、response、session、application封装了这些参数。
>
> ## 执行过程
>
> 1. 当服务器端通过HTTP协议接收到客户请求后，会将其转化为HttpServletRequest对象传递给Servlet。
> 2. Servlet通过这些类理解客户的请求，并将其处理后的内容通过HttpServletResponse回复到服务器端。
> 3. Web容器进行整理后用HTTP协议向客户端传送响应。
>
> 
>
> ![img](https://pic2.zhimg.com/80/v2-60744d4f8ce1c9962002aa418843f431_720w.jpg)
>
> 

### Mybatis

`Mybatis`框架主要处理业务和数据库之间的数据交互，所以创建对象和管理对象生命周期的职责可以委托`Spring`框架完成。如：创建`Mybatis`核心对象。

```xml
<beans>
    ...
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean" >
        <property name="configLocation" value="classpath:mybatis/config.xml" />
        <property name="dataSource" ref="dataSource" />
        <property name="mapperLocations" >
            <list>
                <value>classpath*:mybatis/mapper-*.xml</value>
            </list>
        </property>
    </bean>
    ...
    <bean id="mapperScannerConfigurer" class="org.mybatis.spring.mapper.MapperScannerConfigurer" >
        <property name="basePackage" value="com.atguigu.atcrowdfunding.**.dao" />
    </bean>
    ...
</beans>
```

既然需要和数据库进行关联，那么`Mybatis`核心对象就需要依赖于数据库连接池（`C3P0`）,所以在`Spring`配置文件中增加相应的配置。

```xml
<beans>
    ...
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource" >
        <property name="driverClass" value="com.mysql.jdbc.Driver"/>
        <property name="jdbcUrl" value="jdbc:mysql://localhost:3306/atcrowdfunding?rewriteBatchedStatements=true&amp;useUnicode=true&amp;characterEncoding=utf8"/>
        <property name="user" value="root"/>
        <property name="password" value="root"/>
    </bean>
    ...
</beans>
```

集成`Mybatis`框架时同时还需要增加核心配置文件`mybatis/config.xml`。

```html
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE configuration PUBLIC "-//mybatis.org//DTD Config 3.0//EN" "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <typeAliases>
        ...
    </typeAliases>
</configuration>
```

及`SQL`映射文件`mybatis/mapper-*.xml`。

```html
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="xxx.XXDao" >
...
</mapper>
```

为了保证数据操作的一致性，必须在程序中增加事务处理。`Spring`框架采用声明式事务，通过`AOP`的方式将事务增加到业务中。所以需要在`Spring`配置文件中增加相关配置

```xml
<beans>
    ...
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager" >
        <property name="dataSource" ref="dataSource"/>
    </bean>
    <tx:advice id="transactionAdvice" transaction-manager="transactionManager" >
        <tx:attributes>
            <tx:method name="*" propagation="REQUIRED" isolation="DEFAULT" rollback-for="java.lang.Exception" />
            <tx:method name="query*" read-only="true" />
        </tx:attributes>
    </tx:advice>    
    <aop:config>
        <aop:advisor advice-ref="transactionAdvice" pointcut="execution(* com.atguigu..*Service.*(..))"/>
    </aop:config>
    ...
</beans>
```



### 验证SSM是否搭建成功

AOP怎么验证？

使用断点，在controller查看 ***Service接口是否被动态代理实现

![image-20200927232222232](https://qiyewuan-1302629736.cos.ap-nanjing.myqcloud.com/img/image-20200927232222232.png)

#### 在Intellij IDEA中使用Debug

[在Intellij IDEA中使用Debug](https://mp.weixin.qq.com/s?src=11&timestamp=1601219968&ver=2610&signature=VSJ5uNsU76lnQAkP-Au7YXkEzcq81CUUmsRF3Xrs4BUBcslNAPGIIvLlQeXYcZbkoJqQm8KNAznztrTfN1y3NiWvvilr8Q*G2nDrr2j8ECb6U1Nokx*tNUweiWfhiAC5&new=1)


##  三、总结

### 字符编码问题

浏览传递utf-8的编码，而服务器按照ISO0859-1来读，自然会出错。

传递数据和展示数据的过程中，字符编码不统一。

特定方式解决：

```java
// 将乱码字符串按照错误的编码方式转换为原始的字节码序列
//byte[] bs = loginacct.getBytes("ISO8859-1");

// 将原始的字节码序列按照正确的编码转换为正确的文字即可。
//loginacct = new String(bs, "UTF-8");
```

Spring提供了过滤器可以解决这个问题。

```xml
<filter>
    <filter-name>encoding</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
    </init-param>
    <init-param>
        <param-name>forceEncoding</param-name>
        <param-value>true</param-value>
    </init-param>
</filter>

<filter-mapping>
    <filter-name>encoding</filter-name>
    <servlet-name>springmvc</servlet-name>
</filter-mapping>
```

请求体中的数据可以用这种方式，但是地址栏的数据不能过滤。不能解决。

要分别解决post和get

post: 设置过滤器

get: 在tomcat的server.xml文件设置  URIEncoding

![image-20200930145709488](https://qiyewuan-1302629736.cos.ap-nanjing.myqcloud.com/img/image-20200930145709488.png)

### 页面不够友好。

#### 使用插件解决  layer弹窗组件

文档：https://www.layui.com/doc/modules/layer.html

​           https://layer.layui.com/



本项目用到的 https://www.layui.com/doc/modules/layer.html#layer.msg

> 我们在源码中用了相对较大的篇幅来定制了这个msg，目的是想将其打造成露脸率最高的提示框。而事实上我的确也在大量地使用它。因为它简单，而且足够得自觉，它不仅占据很少的面积，而且默认还会3秒后*自动消失*所有这一切都决定了我对msg的爱。因此*我赋予了它许多可能*在外形方面，它坚持简陋的变化，在作用方面，它坚持零用户操作。而且它的参数也是自动补齐的。

```javascript
//eg1
layer.msg('只想弱弱提示');
//eg2
layer.msg('有表情地提示', {icon: 6}); 
//eg3
layer.msg('关闭后想做些什么', function(){
  //do something
}); 
//eg
layer.msg('同上', {
  icon: 1,
  time: 2000 //2秒关闭（如果不配置，默认是3秒）
}, function(){
  //do something
});   
        
```



#### 页面样式不够统一

使用插件



### 页面提交数据的时候会清空     ajax来提交数据

#### 页面会发生闪烁（白页面）现象（用户体验效果不好）

![](https://qiyewuan-1302629736.cos.ap-nanjing.myqcloud.com/img/20200822150431.png)

当前的页面可能会变成其他的界面，加载渲染其他页面的过程会出现页面变白的情况

#### 登录功能发生错误的时候，页面数据没有回显（用户体验效果不好）


![](https://qiyewuan-1302629736.cos.ap-nanjing.myqcloud.com/img/20200822150730.png)

> UI线程提交数据就会清空。这点改变不了的。
不让它提交！！创建AJAX线程，让它来提交数据，由它来等待，再由它得到结果给UI线程



jquery  ajax   中文文档：https://jquery.cuishifeng.cn/



**数据库是无法将数据传给前台的**

#### JSON : JavaScript Object Notation 特定格式的javascript对象  没有类型的

网络中没有办法传对象，数字1也不行。只能传字符串。把对象变成字符串来传递，用什么来解析呢？

==JSON 字符串 ：将后台对象按照JSON格式转换为字符串输出到浏览器中，让JS当成对象来处理==

```html
<script>
    function Student(){
        //this.name = "Alice"
    }
    var s = new Student();
    //js支持动态给对象添加属性
    s.name = "lili";
    alert(s.name);
    
    
    
    //声明对象
    var obj = {};
    obj.name = "Alice"
    //json对象
    var obj = {name:"Alice",age:20}
    var array = [{},{}]; // array.length = 2
    
 
</script>
```
alert()方法不是内置方法，因为省略了一个对象window.
没有var声明的变量是window的。

#### 变量的作用域

```javascript
<script>
    // JS中使用var声明的变量就是局部变量
    // JS中不使用var声明的变量就是全局变量
    function test() {
        username="Alice";
        /*相当于window.username = "Alice";*/
    }
    
    test();

	alert(username);  //方法内部的变量在外部可以使用
    alert(name);//没有报错，弹出空的。省略window 全部写法：window.alert(name);
    alert(window.username);
    //(window.)document.getElementById("");
</script>
```

### Web四大作用域

想要在main页面保存用户名的消息，该怎么保存？

javaWeb有四大作用域：`pageContext、request、session、application`

范围从小到达

请求范围要跨越多个页面，就要用到转发，ajax是不跳转页面的。数据保存在请求范围里面，下一个页面是取不到的。应该扩大它的范围。application只有一个，后面的数据会覆盖前面的。不能用application范围。



>  1、如果把变量放到pageContext里，就说明它的作用域是page，它的有效范围只在当前jsp页面里。 从把变量放到pageContext开始，到jsp页面结束，你都可以使用这个变量。
>
>  2、如果把变量放到request里，就说明它的作用域是request，它的有效范围是当前请求周期。所谓请求周期，就是指从http请求发起，到服务器处理结束，返回响应的整个过程。在这个过程中可能使用forward的方式跳转了多个jsp页面，在这些页面里你都可以使用这个变量。
>
>  3、如果把变量放到session里，就说明它的作用域是session，它的有效范围是当前会话。所谓当前会话，就是指从用户打开浏览器开始，到用户关闭浏览器这中间的过程。这个过程可能包含多个请求响应。也就是说，只要用户不关浏览器，服务器就有办法知道这些请求是一个人发起的，整个过程被称为一个会话（session），而放到会话中的变量，
>
>  4、如果把变量放到application里，就说明它的作用域是application，它的有效范围是整个应用。整个应用是指从应用启动，到应用结束。

###  jsp不解析el表达式的情况

jsp可能会不解析el表达式。`${}`会原封不动的显示在页面上，没有显示从后台获得的信息

加上这行代码

```jsp
<%@page isELIgnored="false" %>
```





## 四、权限

用户登陆之后的权利和限制

什么什么能做？什么不能做？

权限模型

> 权限管理，这是每个软件系统都会涉及到的，而且权限管理的需求本质往往都是一样，不同的角色拥有不同的权限，只要你充当了某个角色，你就拥有了相对应的功能。
  RBAC（Role-Based Access Control，基于角色的访问控制），就是用户通过角色与权限进行关联。简单地说，一个用户拥有若干角色，每一个角色拥有若干权限。这样，就构造成“用户-角色-权限”的授权模型。在这种模型中，用户与角色之间，角色与权限（功能）之间，一般都是多对多的关系。


### RBAC

基于角色的访问控制

RBAC是Role Based Access Control的缩写，是基于角色的访问控制。一般都是分为用户（user）， 角色（role），权限（permission）三个实体，角色（role）和权限（permission）是多对多的 关系，用户（user）和角色（role）也是多对多的关系。用户（user）和权限（permission） 之间没有直接的关系，都是通过角色作为代理，才能获取到用户（user）拥有的权限。

 以下是RBAC0的模型

![在这里插入图片描述](https://img-blog.csdnimg.cn/20200710134813352.png#pic_center)

> 一对多 ： 一个教室  多个学生     t_class    
> 多对一：多个学生  一个教室

```
t_classes
----------------------
id              name
----------------------
1               1-1
2               1-2
3               1-3


t_student
------------------------------
id      name       cid
------------------------------
1      Alice        1
2      Mike         1
3      Marry        3
```

> 多对多   双向的一对多    两张表是实现不了多对多的，需要增加
> 一张表来实现


学生    课程

```
t_student
-----------------------
id           name
-----------------------
1           Alice
2           Mike
3           Marry


t_source
--------------------
id          name
--------------------
1           JavaSE
2           JavaWeb
3           JavaEE


t_student_course
------------------------
id     sid       cid
-------------------------
1       1         1
2       1         2
3       2         1


```

### 权限模型级别

> https://baike.sogou.com/v10562566.htm?fromTitle=rbac

- RBAC0


RBAC核心模型, 其他的级别都是建立在该级别的基础上。

一个用户最终拥有的许可 = 这个用户拥有角色对应的许可集合

```
PM ==> 管理项目，招聘员工
PG ==> 开发程序，测试功能
ADMIN ==> 配置系统参数

张三 = PM  +  ADMIN = 管理项目，招聘员工 + 配置系统参数
```

- RBAC1

基于RBAC0模型，进行了角色的分层，也就是说角色上有了上下级的区别。




- RBAC2


也是基于RBAC0模型的基础上，进行了角色的访问控制。

有了互斥角色，管账和管钱。（同时拥有这两种角色容易贪污）




- RBAC3

是最全面的权限管理，它是在RBAC0的基础上，将RBAC1和RBAC2进行整合了，最全面，也最复杂的。


>任何系统中都会涉及到权限管理的模块，无论复杂简单，
我们都可以通过以RBAC模型为基础，进行灵活运用来解决我们的问题。



## 五、路径

```
 web路径
    不以/开始 易出问题
    以/开始相对路径，找资源，以服务器路径为标准 http://localhost:8080/项目名
```

绝对路径：不可改变的路径

- 本地绝对路径：增加盘符的路径（e:/test/test.html）
- 网络绝对路径：增加协议，IP地址，端口号的路径（http://localhost:8080/test/test.html）

相对路径：可以改变的路径，但是以基准路径为参考，查找其他路径

>默认情况下，==相对路径的基准路径是以当前资源的访问路径为基准==


路径以斜杠开头，表示特殊的相对路径，在不同的场景中，相对的位置会发生变化。

url : http://localhost:8080/atcrowdfunding-web/test/test.html

- 前台路径：`<a href="/sssss"><img src="">`
  相对服务器的根`http://localhost:8080` ： http://localhost:8080/sssss

- 后台路径：forward（"/user.jsp"）, xml
  相对web应用的根`http://localhost:8080/atcrowdfunding-web`：http://localhost:8080/atcrowdfunding-web/user.jsp



**项目名称等价于 webapp**



${pageContext.request.contextPath}   EL表达式可以动态获取项目的名称

监听器：将web应用名称（路径）保存到application范围中



- [监听器与过滤器？](https://mp.weixin.qq.com/s?src=11&timestamp=1598105042&ver=2538&signature=dK81GbPV2*p4Qg3b7Yv0RhGkhbhdBxFR8eQfzh0OxVEOGcLRWBNi5qAOyWyjHMuk5fYCnNrW*DGshfoPh91jmKrgxVB0FsypM1ZXdwl*-8ifXxaTQYOXAlboXEtj0FgV&new=1)

过滤器，监听器，拦截器？

## 六、用户维护

用户维护  跳转到分页查询页面

从数据库中查询出数据，分页显示



#### 原生分页查询

mysql

```sql
limit start , size   # 起始位置   每页查多少条
```

异步查询

### 分配角色



## 七

ztree



在程序开发中，展示数据有很多中方式，可以采用表格，图表，树形结构等。

具体采用哪一种，取决与我们想要展示数据的哪一种特性。

- 想要展示数据的先后顺序，那么就采用表格
- 想要展示数据的对比关系，那么就采用图表
-  如果想要展示数据的层次（上下级）关系，那么就采用树形结构



树形结构，应该遵循从上而下，从父到子进行操作的原则。也就是通过父节点数据操作子节点数据。

一个基本的树状结构，根节点可能只有一个，但是分支节点，叶子节点可以存在多个。

在网页设计中，如果想要将数据以树形结构的方式展示在页面中，一般采用`<ul><li>`标签的嵌套使用方式实现

如果所有的html代码都是我们来设计和开发，会比较麻烦，而且容易出现错误。一般在开发中，我们都采用第三方树状组件实现。比如ztree

zTree在线文档：https://tool.oschina.net/apidocs/apidoc?api=ztree3.2%2Fapi%2FAPI_cn.html

```
父菜单
t_parent_menu
----------------------
id          name
----------------------
1           xxxx
2           yyyy
3           zzzz

子菜单
t_child_menu
-------------------------------
id          name          pid  
-------------------------------
1            aaa           1
2            bbb           1
3            zzz           2


自己关联自己
t_menu
------------------------------------
id            name             pid
------------------------------------
1              xxx              
2              yyy          
3              zzz               
4              aaa              1
5              bbb              1
6              ccc              2
```





妈的乱七八糟





添加拦截器

登陆拦截器，preHandle方法 在控制器执行之前完成业务逻辑操作。也就是tomcat打开就会自动跳转到登陆页面。