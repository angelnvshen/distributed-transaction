SpringBoot ��Ӷ�JSP��֧�ֳ������⣺
1.�޸�JSP������������Ч:
�����������У�SpringBoot���±���JSP���ܻᵼ�½ϴ��������ʧ�����Һ���׷�鵽�����Դ�����������µİ汾�У��ٷ��Ѿ�Ĭ�Ϲرմ˹��ܣ����JspServlet��ĳ�ʼ����������ô����ν����������أ��Ƽ���������취��1.ʹ��devtools 2. ������ã�server.servlet.jsp.init-parameters.development=true��
2.����404��
1.���뵼��Ƕ��ʽ������JASPER������ 2.���봴��webappĿ¼


������ʽ1����IDE���� ��Ӧ�� XXXXXApplication��Ȼ�����Ŀ��ַ��

������ʽ2����������Tomcat��������ɺ󣬴���Ŀ��ַ��������Ҫע����ǣ�ʹ������Tomcat�����ʱ����Ҫ��Ƕ��ʽ��������Ϊprovided���𡣣���ֹ��ͻ��

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