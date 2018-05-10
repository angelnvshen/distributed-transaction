
package own.stu.distributedTransaction.pay.app.message;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import own.stu.distributedTransaction.pay.app.message.scheduled.MessageScheduled;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 消息处理定时器<br/>
 * 主要分为两步： MessageStatusEnum <br/>
 * 1.处理状态为“待确认”但已超时的消息 <br/>
 * 2.处理状态为“发送中”但超时没有被成功消费确认的消息 <br/>
 */
@Component
public class MessageTask {

    private static final Log log = LogFactory.getLog(MessageTask.class);

    @Autowired
    private MessageScheduled messageScheduled;

    // 每分钟启动
    @Scheduled(cron = "0/4 * * * * ?")
    public void timerToNow() {
        System.out.println("now time:" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    //每分钟启动
    //@Scheduled(cron = "0 0/1 * * * ?")
    public void handleWaitingConfirmTimeOutMessages() {
        log.info("执行(处理[waiting_confirm]状态的消息)任务开始");
        messageScheduled.handleWaitingConfirmTimeOutMessages();
        log.info("执行(处理[waiting_confirm]状态的消息)任务结束");

        try {
            log.info("[waiting_confirm]睡眠60秒");
            Thread.sleep(60000);
        } catch (InterruptedException e) {
        }
    }

    //每分钟启动
    //@Scheduled(cron = "0 0/1 * * * ?")
    public void handleSendingTimeOutMessage() {
        log.info("执行(处理[SENDING]的消息)任务开始");
        messageScheduled.handleSendingTimeOutMessage();
        log.info("执行(处理[SENDING]的消息)任务结束");
        try {
            log.info("[SENDING]睡眠60秒");
            Thread.sleep(60000);
        } catch (InterruptedException e) {
        }
    }
}
