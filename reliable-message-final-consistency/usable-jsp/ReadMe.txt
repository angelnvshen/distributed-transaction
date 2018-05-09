springboot + jsp 

-------------------------------

����tomcat��pom.xml �ļ� ����� <scope>provided</scope> ��֮�����ֱ��������
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
    <scope>provided</scope>
</dependency>

-------------------------------

����tomcat����ʱ��Ҫע�⣺
1��ע�͵�<scope>provided</scope>
 <!--���ڱ���jsp-->
<dependency>
    <groupId>org.apache.tomcat.embed</groupId>
    <artifactId>tomcat-embed-jasper</artifactId>
    <!--<scope>provided</scope>-->
</dependency>
2����Ϊ����Ŀ��maven module�£�����һ������Ŀ����Ҫ���
customer_jsp_path ·������Ҫԭ��Tomcatδ���ҵ�src/main/webappĿ¼��

/* ���� ����tomcatʹ��*/
@Bean
public EmbeddedServletContainerFactory embeddedServletContainerFactory() {
	ConfigurableEmbeddedServletContainer factory = new TomcatEmbeddedServletContainerFactory();

	URL xmlPath = this.getClass().getClassLoader().getResource("");
	String customer_jsp_path = xmlPath.getFile().replaceAll("target/classes", "src/main/webapp");

	factory.setDocumentRoot(new File(customer_jsp_path));
	return (EmbeddedServletContainerFactory) factory;
}