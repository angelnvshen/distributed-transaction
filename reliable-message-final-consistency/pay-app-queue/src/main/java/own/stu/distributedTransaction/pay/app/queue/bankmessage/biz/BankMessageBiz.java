
package own.stu.distributedTransaction.pay.app.queue.bankmessage.biz;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import own.stu.distributedTransaction.pay.service.api.message.RpTransactionMessageServiceApi;
import own.stu.distributedTransaction.pay.service.api.trade.RpTradePaymentQueryServiceApi;

import java.util.Map;

/**
 * <b>功能说明: </b>
 */
@Service
public class BankMessageBiz {

    private static final Log LOG = LogFactory.getLog(BankMessageBiz.class);

    @Autowired
    private RpTradePaymentQueryServiceApi rpTradePaymentManagerService;

    @Autowired
    private RpTransactionMessageServiceApi rpTransactionMessageService;

    public void completePay(Map<String, String> notifyMessageMap) {

        String messageId = notifyMessageMap.get("messageId");
        //String payWayCode = notifyMessageMap.get("payWayCode");
        //调用业务方法,完成交易
        try {
            rpTradePaymentManagerService.completeScanPay(notifyMessageMap);

            //删除消息
            rpTransactionMessageService.deleteMessageByMessageId(messageId);
        } catch (Exception e) {
            LOG.error("完成支付结果异常:", e);
        }
    }
}
