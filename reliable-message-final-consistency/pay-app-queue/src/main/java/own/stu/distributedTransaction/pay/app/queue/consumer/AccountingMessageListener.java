
package own.stu.distributedTransaction.pay.app.queue.consumer;

import com.alibaba.fastjson.JSONObject;
import org.apache.activemq.command.ActiveMQTextMessage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;
import own.stu.distributedTransaction.common.core.exception.BizException;
import own.stu.distributedTransaction.pay.service.api.account.RpAccountingVoucherServiceApi;
import own.stu.distributedTransaction.pay.service.api.entity.RpAccountingVoucher;
import own.stu.distributedTransaction.pay.service.api.message.RpTransactionMessageServiceApi;

import javax.jms.Message;

@Service
public class AccountingMessageListener {

    private static final Log LOG = LogFactory.getLog(AccountingMessageListener.class);

    @Autowired
    private RpAccountingVoucherServiceApi rpAccountingVoucherService;
    @Autowired
    private RpTransactionMessageServiceApi rpTransactionMessageService;

    @JmsListener(destination = "ACCOUNTING_NOTIFY")
    public synchronized void onMessage(Message message) {

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

}
