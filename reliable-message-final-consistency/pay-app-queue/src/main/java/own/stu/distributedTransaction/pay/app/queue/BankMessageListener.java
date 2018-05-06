/*
 * ====================================================================
 * 龙果学院： www.roncoo.com （微信公众号：RonCoo_com）
 * 超级教程系列：《微服务架构的分布式事务解决方案》视频教程
 * 讲师：吴水成（水到渠成），840765167@qq.com
 * 课程地址：http://www.roncoo.com/course/view/7ae3d7eddc4742f78b0548aa8bd9ccdb
 * ====================================================================
 */
package own.stu.distributedTransaction.pay.app.queue;

import com.alibaba.fastjson.JSONObject;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SessionAwareMessageListener;
import own.stu.distributedTransaction.common.core.exception.BizException;
import own.stu.distributedTransaction.pay.app.queue.bankmessage.BankMessageFixedThreadPool;
import own.stu.distributedTransaction.pay.app.queue.bankmessage.BankMessageTask;
import own.stu.distributedTransaction.pay.app.queue.bankmessage.biz.BankMessageBiz;

import javax.jms.Message;
import javax.jms.Session;
import java.util.Map;

public class BankMessageListener implements SessionAwareMessageListener<Message> {

	private static final Log LOG = LogFactory.getLog(BankMessageListener.class);

	@Autowired
	private JmsTemplate notifyJmsTemplate;

	@Autowired
	private BankMessageBiz bankMessageBiz;

//	@Autowired
//	private RpTradePaymentManagerService rpTradePaymentManagerService;
//
//	@Autowired
//	private RpTransactionMessageService rpTransactionMessageService;


	public synchronized void onMessage(Message message, Session session) {

		Map<String,String> param = null;
		String strMessage = null;

		try {
			ActiveMQTextMessage objectMessage = (ActiveMQTextMessage) message;
			strMessage = objectMessage.getText();
			LOG.info("strMessage1 bank:" + strMessage);
			param = JSONObject.parseObject(strMessage, Map.class); // 这里转换成相应的对象还有问题

			BankMessageTask bankMessageTask = new BankMessageTask(param);
			bankMessageTask.setBankMessageBiz(bankMessageBiz);

			BankMessageFixedThreadPool.addTask(bankMessageTask);

		} catch (BizException e) {
			// 业务异常，不再写会队列
			LOG.error("==>BizException", e);
		} catch (Exception e) {
			// 不明异常不再写会队列
			LOG.error("==>Exception", e);
		}
	}

	public JmsTemplate getNotifyJmsTemplate() {
		return notifyJmsTemplate;
	}


	public void setNotifyJmsTemplate(JmsTemplate notifyJmsTemplate) {
		this.notifyJmsTemplate = notifyJmsTemplate;
	}

	public BankMessageBiz getBankMessageBiz() {
		return bankMessageBiz;
	}

	public void setBankMessageBiz(BankMessageBiz bankMessageBiz) {
		this.bankMessageBiz = bankMessageBiz;
	}
}
