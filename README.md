# ex
java WEB异常处理框架,客户端只需要简单配置一下filter,即可接入,无任何依赖

主要功能点

1、异常发生时异步发送报警邮箱
2、简单的异常发生数据统计


测试地址：http://ex.xiaoting.link/

步骤

1.修改application.properties中的数据库配置 rmi.registry.port(注册端口),rmi.service.port(通讯端口)号配置

2.因为使用spring boot,所以可以将ex-web模块打成jar包单独执行,也可以打成war包放在容器中

3.将ex-client和ex-core模块打成jar包，放在需要调用的项目中

4.在web.xml文件中配置filter,初始化参数也可以在config.properties中配置key名相同


5.发送的邮件服务器配置可以在修改application.properties中修改,也可以在平台上的配置消息模块中修改对应的key名分别是mail.host,mail.port,mail.username,mail.password

Filter 配置:

    包名:com.xiao.ex.filter.ExFilter,
    init-param中配置 host(ex-web模块的服务器ip地址)，port(注册端口),time(间隔上传时间，其中host和port是必传值,time默认十分钟上报一次异常,

如有问题请联系我QQ:1360379096


如果你喜欢本项目，请点击右上角的 Star，这样就可以将本项目放入您的收藏。

如果你非常喜欢，请点击右上角的 Fork，这样就可以直接将本项目直接复制到您的名下。

如果您有问题需要反馈，请点击 github 上的 issues 提交您的问题。

如果您改进了代码，并且愿意将它合并到本项目中，你可以使用 github 的 pull requests 功能来提交您的修改。