## ex
java WEB异常处理框架,客户端只需要简单配置一下filter,即可接入,无任何依赖

主要功能点

1、异常发生时异步发送报警邮箱

2、简单的异常发生数据统计


## 测试地址：http://ex.xiaoting.link/

## 如果有兴趣的朋友可以直接运行libs下面的jar包步骤：

1.执行Sql语句并数据库名为ex

2.在命令行输入java -jar ex-web-1.0.0-SNAPSHOT.jar 数据库IP 数据库用户名 密码  


3.将ex-spring-clinet.jar或者ex-web-client 和 ex-core.jar加入到要配置的项目中,并按照上面的步骤配置Filter(如果不想自己运行web模块,可以配置到Demo里面IP地址)





## 普通的Web项目接入步骤

1.修改ex-web模块中的application.properties中的数据库配置 rmi.registry.port(注册端口),rmi.service.port(通讯端口)号配置

2.发送的邮件服务器配置可以在ex-web模块修改application.properties中修改,也可以在平台上的配置消息模块中修改对应的key名分别是mail.host, mail.port, mail.username, mail.password

3.将ex-web模块打成jar包单独执行,也可以打成war包放在容器中

4.在web.xml文件中配置filter,初始化参数也可以在config.properties中配置key名相同



## Filter 配置:

    包名:com.xiao.ex.filter.ExFilter,
     init-param中配置:
     host(ex-web模块的服务器ip地址)，
     port(注册端口),
     time(单位是毫秒,异常间隔上传时间，其中host和port是必传值,time默认十分钟上报一次异常,

## 普通的Web项目接入Demo:

```
    <filter>
        <filter-name>exFilter</filter-name>
        <filter-class>com.xiao.ex.filter.ExFilter</filter-class>
        <init-param>
            <param-name>host</param-name>
            <param-value>119.23.239.186</param-value>
        </init-param>
        <init-param>
            <param-name>port</param-name>
            <param-value>8886</param-value>
        </init-param>
        <init-param>
            <param-name>time</param-name>
            <param-value>1000</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>exFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>

```
## SpringBoot接入步骤

1.修改ex-web模块中的application.properties中的数据库配置 rmi.registry.port(注册端口),rmi.service.port(通讯端口)号配置

2.发送的邮件服务器配置可以在修改ex-web模块application.properties中修改,也可以在平台上的配置消息模块中修改对应的key名分别是mail.host, mail.port, mail.username, mail.password

3.将ex-web模块打成jar包单独执行,也可以打成war包放在容器中

4.引入ex-spring-client.jar包，并声明MyExceptionHandler bean,在application.properties中写入rmi.port(web模块的注册端口),rmi.host(web模块的IP地址),rmi.time(上报时间单位毫秒)



## SpringBoot接入Demo:
```
    @Bean
    public MyExceptionHandler masterTransactionManager() {
        return new MyExceptionHandler();
    }

```


## Spring 接入步骤

1.修改ex-web模块中的application.properties中的数据库配置 rmi.registry.port(注册端口),rmi.service.port(通讯端口)号配置

2.发送的邮件服务器配置可以在修改ex-web模块application.properties中修改,也可以在平台上的配置消息模块中修改对应的key名分别是mail.host, mail.port, mail.username, mail.password

3.将ex-web模块打成jar包单独执行,也可以打成war包放在容器中

4.引入ex-spring-client.jar包，并声明MyExceptionHandler bean,在application.properties中写入rmi.port(web模块的注册端口),rmi.host(web模块的IP地址),rmi.time(上报时间单位毫秒)



## Spring  接入Demo:
```
      <bean class="com.xiao.ex.handler.MyExceptionHandler"/>

```

如有问题请联系我QQ:1360379096

谢谢 @如果没有你 给我提供的意见

如果你喜欢本项目，请点击右上角的 Star，这样就可以将本项目放入您的收藏。

如果你非常喜欢，请点击右上角的 Fork，这样就可以直接将本项目直接复制到您的名下。

如果您有问题需要反馈，请点击 github 上的 issues 提交您的问题。

如果您改进了代码，并且愿意将它合并到本项目中，你可以使用 github 的 pull requests 功能来提交您的修改。
