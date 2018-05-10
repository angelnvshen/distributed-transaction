
package own.stu.distributedTransaction.pay.app.queue.consumer;

import com.alibaba.fastjson.JSONObject;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SessionAwareMessageListener;
import org.springframework.stereotype.Service;
import own.stu.distributedTransaction.common.core.exception.BizException;
import own.stu.distributedTransaction.pay.app.queue.bankmessage.BankMessageFixedThreadPool;
import own.stu.distributedTransaction.pay.app.queue.bankmessage.BankMessageTask;
import own.stu.distributedTransaction.pay.app.queue.bankmessage.biz.BankMessageBiz;

import javax.jms.Message;
import javax.jms.Session;
import java.util.Map;

@Service
public class BankMessageListener{

	private static final Log LOG = LogFactory.getLog(BankMessageListener.class);

	@Autowired
	private BankMessageBiz bankMessageBiz;

//	@Autowired
//	private RpTradePaymentManagerService rpTradePaymentManagerService;
//
//	@Autowired
//	private RpTransactionMessageService rpTransactionMessageService;

	@JmsListener(destination = "BANK_NOTIFY")
	public void onMessage(Message message) {

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

}
