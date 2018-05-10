package own.stu.distributedTransaction.pay.service.api.message;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.pay.service.api.entity.RpTransactionMessage;

import java.util.Map;

//@FeignClient(name = "${pay.web.message.service.name}")
@FeignClient(name = "pay-web-message-api")
public interface RpTransactionMessageServiceApi {

    @RequestMapping("message/saveMessageWaitingConfirm")
    String saveMessageWaitingConfirm(@RequestBody RpTransactionMessage rpTransactionMessage);

    @RequestMapping("message/confirmAndSendMessage")
    String confirmAndSendMessage(String messageId);

    @RequestMapping("message/saveAndSendMessage")
    String saveAndSendMessage(@RequestBody RpTransactionMessage rpTransactionMessage);

    @RequestMapping("message/directSendMessage")
    String directSendMessage(@RequestBody RpTransactionMessage rpTransactionMessage);

    @RequestMapping("message/reSendMessage")
    String reSendMessage(@RequestBody RpTransactionMessage rpTransactionMessage);

    @RequestMapping("message/reSendMessageByMessageId")
    String reSendMessageByMessageId(String messageId);

    @RequestMapping("message/setMessageToAreadlyDead")
    String setMessageToAreadlyDead(String messageId);

    @RequestMapping("message/getMessageByMessageId")
    RpTransactionMessage getMessageByMessageId(String messageId);

    @RequestMapping("message/deleteMessageByMessageId")
    String deleteMessageByMessageId(String messageId);

    @RequestMapping("message/listPage")
    PageBean listPage(@RequestBody Map<String, Object> paramMap);
}
