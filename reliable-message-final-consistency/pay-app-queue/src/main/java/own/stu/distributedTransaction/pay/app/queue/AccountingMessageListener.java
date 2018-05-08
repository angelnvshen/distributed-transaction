
package own.stu.distributedTransaction.pay.app.queue;

import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.SessionAwareMessageListener;

import com.alibaba.fastjson.JSONObject;
import own.stu.distributedTransaction.common.core.exception.BizException;
import own.stu.distributedTransaction.pay.service.message.api.RpTransactionMessageService;
import own.stu.distributedTransaction.pay.service.user.api.RpAccountingVoucherService;
import own.stu.distributedTransaction.pay.service.user.entity.RpAccountingVoucher;

public class AccountingMessageListener implements SessionAwareMessageListener<Message> {

	private static final Log LOG = LogFactory.getLog(AccountingMessageListener.class);

	/**
	 * 会计队列模板(由Spring创建并注入进来)
	 */
	@Autowired
	private JmsTemplate notifyJmsTemplate;
	@Autowired
	private RpAccountingVoucherService rpAccountingVoucherService;
	@Autowired
	private RpTransactionMessageService rpTransactionMessageService;


	public synchronized void onMessage(Message message, Session session) {

		RpAccountingVoucher param = null;
		String strMessage = null;

		try {
			ActiveMQTextMessage objectMessage = (ActiveMQTextMessage) message;
			strMessage = objectMessage.getText();
			LOG.info("strMessage1 accounting:" + strMessage);
			param = JSONObject.parseObject(strMessage, RpAccountingVoucher.class); // 这里转换成相应的对象还有问题
			if (param == null) {
				LOG.info("param参数为空");
				return;
			}

			int payerAccountType = 0;
			if (param.getPayerAccountType() != null && !param.getPayerAccountType().equals("")) {
				payerAccountType = param.getPayerAccountType();
			}

			String bankOrderNo = param.getBankOrderNo();
			int receiverAccountType = 0;
			if (param.getReceiverAccountType() != null && !param.getReceiverAccountType().equals("")) {
				receiverAccountType = param.getReceiverAccountType();
			}

			rpAccountingVoucherService.createAccountingVoucher(param);

			//删除消息
			rpTransactionMessageService.deleteMessageByMessageId(param.getMessageId());

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


	public RpAccountingVoucherService getRpAccountingVoucherService() {
		return rpAccountingVoucherService;
	}


	public void setRpAccountingVoucherService(RpAccountingVoucherService rpAccountingVoucherService) {
		this.rpAccountingVoucherService = rpAccountingVoucherService;
	}
}
