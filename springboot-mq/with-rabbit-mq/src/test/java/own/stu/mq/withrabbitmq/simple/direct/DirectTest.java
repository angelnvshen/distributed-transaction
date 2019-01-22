package own.stu.mq.withrabbitmq.simple.direct;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.assertj.core.util.Lists;
import org.junit.Test;
import own.stu.mq.withrabbitmq.simple.exchange.EmitLog;
import own.stu.mq.withrabbitmq.simple.exchange.ReceiveLogs;

public class DirectTest {

  @Test
  public void testConsumer() throws Exception {

    ExecutorService service = Executors.newFixedThreadPool(2);

    service.submit(new Thread(()->{
      try {
        ReceiveLogsDirect.consumer(Lists.newArrayList(LogType.ERROR.name));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }), "thread-"+ 1);

    service.submit(new Thread(()->{
      try {
        ReceiveLogsDirect.consumer(Lists.newArrayList(LogType.ERROR.name, LogType.INFO.name, LogType.WARN.name));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }), "thread-"+ 2);

    TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);
  }



  @Test
  public void testProducer() throws Exception {

    int length = LogType.values().length;
    Random random = new Random();
    for(int i = 0; i< 20 ; i++) {
      LogType type = LogType.values()[random.nextInt(length)];
      String str = getRandomStr(5);
      System.out.println(type.name + "->" + str);
      EmitLogDirect.producer(type.name, str);
    }
  }

  enum LogType{
    WARN("warn"), INFO("info"), ERROR("error");
    private String name;

    LogType(String name) {
      this.name = name;
    }
  }


  public static String getRandomStr(int length) {
    String base = "文件服微服务务费文件佛王府威风威风威风威风井沃尔夫接欧文";
    int randomNum;
    char randomChar;
    Random random = new Random();
    // StringBuffer类型的可以append增加字符
    StringBuffer str = new StringBuffer();

    for (int i = 0; i < length; i++) {
      // 可生成[0,n)之间的整数，获得随机位置
      randomNum = random.nextInt(base.length());
      // 获得随机位置对应的字符
      randomChar = base.charAt(randomNum);
      // 组成一个随机字符串
      str.append(randomChar);
    }
    return str.toString();
  }
}
