SpringBoot 添加对JSP的支持常见问题：
1.修改JSP需重启才能生效:
在生产环境中，SpringBoot重新编译JSP可能会导致较大的性能损失，并且很难追查到问题根源，所以在最新的版本中，官方已经默认关闭此功能，详见JspServlet类的初始化参数。那么，如何解决这个问题呢？推荐两个解决办法：1.使用devtools 2. 添加配置（server.servlet.jsp.init-parameters.development=true）
2.各种404：
1.必须导入嵌入式容器和JASPER解析器 2.必须创建webapp目录


启动方式1：在IDE启动 对应的 XXXXXApplication，然后打开项目地址。

启动方式2：部署到外置Tomcat，启动完成后，打开项目地址。这里需要注意的是，使用外置Tomcat部署的时候，需要将嵌入式容器调整为provided级别。（防止冲突）

    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-tomcat</artifactId>
      <scope>provided</scope>
    </dependency>
    <dependency>
      <groupId>org.apache.tomcat.embed</groupId>
      <artifactId>tomcat-embed-jasper</artifactId>
      <scope>provided</scope>
    </dependency>