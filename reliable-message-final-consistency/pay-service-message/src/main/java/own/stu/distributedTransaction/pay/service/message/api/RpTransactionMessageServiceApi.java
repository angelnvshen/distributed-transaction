package own.stu.distributedTransaction.pay.service.message.api;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.pay.service.message.entity.RpTransactionMessage;

import java.util.List;
import java.util.Map;

//@FeignClient(name = "${pay.web.message.service.name}")
@FeignClient(name = "pay-web-message-api")
public interface RpTransactionMessageServiceApi {

    @RequestMapping("saveMessageWaitingConfirm")
    String saveMessageWaitingConfirm(@RequestBody RpTransactionMessage rpTransactionMessage);

    @RequestMapping("confirmAndSendMessage")
    String confirmAndSendMessage(String messageId);

    @RequestMapping("saveAndSendMessage")
    String saveAndSendMessage(@RequestBody RpTransactionMessage rpTransactionMessage);

    @RequestMapping("directSendMessage")
    String directSendMessage(@RequestBody RpTransactionMessage rpTransactionMessage);

    @RequestMapping("reSendMessage")
    String reSendMessage(@RequestBody RpTransactionMessage rpTransactionMessage);

    @RequestMapping("reSendMessageByMessageId")
    String reSendMessageByMessageId(String messageId);

    @RequestMapping("setMessageToAreadlyDead")
    String setMessageToAreadlyDead(String messageId);

    @RequestMapping("getMessageByMessageId")
    RpTransactionMessage getMessageByMessageId(String messageId);

    @RequestMapping("deleteMessageByMessageId")
    String deleteMessageByMessageId(String messageId);

    @RequestMapping("listPage")
    PageBean listPage(@RequestBody Map<String, Object> paramMap);
}
