springboot + jsp 

-------------------------------

外置tomcat，pom.xml 文件 需添加 <scope>provided</scope> 。之后可以直接启动：
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
    <scope>provided</scope>
</dependency>

-------------------------------

内置tomcat启动时需要注意：
1：注释掉<scope>provided</scope>
 <!--用于编译jsp-->
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
    <!--<scope>provided</scope>-->
</dependency>
2：因为该项目在maven module下，属于一个子项目，需要添加
customer_jsp_path 路径。主要原因：Tomcat未能找到src/main/webapp目录。

/* 仅仅 内置tomcat使用*/
@Bean
public EmbeddedServletContainerFactory embeddedServletContainerFactory() {
	ConfigurableEmbeddedServletContainer factory = new TomcatEmbeddedServletContainerFactory();

	URL xmlPath = this.getClass().getClassLoader().getResource("");
	String customer_jsp_path = xmlPath.getFile().replaceAll("target/classes", "src/main/webapp");

	factory.setDocumentRoot(new File(customer_jsp_path));
	return (EmbeddedServletContainerFactory) factory;
}