
package own.stu.distributedTransaction.pay.service.message.api;

import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.pay.service.message.entity.RpTransactionMessage;
import own.stu.distributedTransaction.pay.service.message.exceptions.MessageBizException;

import java.util.Map;

/**
 * <b>功能说明: </b>
 */
public interface RpTransactionMessageService {

	/**
	 * 预存储消息. 
	 */
	int saveMessageWaitingConfirm(RpTransactionMessage rpTransactionMessage) throws MessageBizException;
	
	
	/**
	 * 确认并发送消息.
	 */
	void confirmAndSendMessage(String messageId) throws MessageBizException;

	
	/**
	 * 存储并发送消息.
	 */
	int saveAndSendMessage(RpTransactionMessage rpTransactionMessage) throws MessageBizException;

	
	/**
	 * 直接发送消息.
	 */
	void directSendMessage(RpTransactionMessage rpTransactionMessage) throws MessageBizException;
	
	
	/**
	 * 重发消息.
	 */
	void reSendMessage(RpTransactionMessage rpTransactionMessage) throws MessageBizException;
	
	
	/**
	 * 根据messageId重发某条消息.
	 */
	void reSendMessageByMessageId(String messageId) throws MessageBizException;
	
	
	/**
	 * 将消息标记为死亡消息.
	 */
	void setMessageToAreadlyDead(String messageId) throws MessageBizException;


	/**
	 * 根据消息ID获取消息
	 */
	RpTransactionMessage getMessageByMessageId(String messageId) throws MessageBizException;

	/**
	 * 根据消息ID删除消息
	 */
	void deleteMessageByMessageId(String messageId) throws MessageBizException;
	
	
	/**
	 * 重发某个消息队列中的全部已死亡的消息.
	 */
	void reSendAllDeadMessageByQueueName(String queueName, int batchSize) throws MessageBizException;
	
	/**
	 * 获取分页数据
	 */
	PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) throws MessageBizException;
}
