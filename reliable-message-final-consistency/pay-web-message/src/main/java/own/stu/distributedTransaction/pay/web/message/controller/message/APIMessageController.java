package own.stu.distributedTransaction.pay.web.message.controller.message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.common.core.utils.StringUtil;
import own.stu.distributedTransaction.pay.service.message.api.RpTransactionMessageService;
import own.stu.distributedTransaction.pay.service.message.entity.RpTransactionMessage;

import java.util.List;
import java.util.Map;

/**
 * Created by CHANEL on 2018/5/9.
 */
@RestController
@RequestMapping("message")
public class APIMessageController {
    @Autowired
    RpTransactionMessageService rpTransactionMessageService;

    @RequestMapping("saveMessageWaitingConfirm")
    public String saveMessageWaitingConfirm(@RequestBody RpTransactionMessage rpTransactionMessage){
        rpTransactionMessageService.saveMessageWaitingConfirm(rpTransactionMessage);
        return "success";
    }

    @RequestMapping("confirmAndSendMessage")
    public String confirmAndSendMessage(String messageId){
        rpTransactionMessageService.confirmAndSendMessage(messageId);
        return "success";
    }

    @RequestMapping("saveAndSendMessage")
    public String saveAndSendMessage(@RequestBody RpTransactionMessage rpTransactionMessage){
        rpTransactionMessageService.saveAndSendMessage(rpTransactionMessage);
        return "success";
    }

    @RequestMapping("directSendMessage")
    public String directSendMessage(@RequestBody RpTransactionMessage rpTransactionMessage){
        rpTransactionMessageService.directSendMessage(rpTransactionMessage);
        return "success";
    }

    @RequestMapping("reSendMessage")
    public String reSendMessage(@RequestBody RpTransactionMessage rpTransactionMessage){
        rpTransactionMessageService.reSendMessage(rpTransactionMessage);
        return "success";
    }

    @RequestMapping("reSendMessageByMessageId")
    public String reSendMessageByMessageId(String messageId){
        rpTransactionMessageService.reSendMessageByMessageId(messageId);
        return "success";
    }

    @RequestMapping("setMessageToAreadlyDead")
    public String setMessageToAreadlyDead(String messageId){
        rpTransactionMessageService.setMessageToAreadlyDead(messageId);
        return "success";
    }

    @RequestMapping("getMessageByMessageId")
    public RpTransactionMessage getMessageByMessageId(String messageId){
        return rpTransactionMessageService.getMessageByMessageId(messageId);
    }

    @RequestMapping("deleteMessageByMessageId")
    public String deleteMessageByMessageId(String messageId){
        rpTransactionMessageService.deleteMessageByMessageId(messageId);
        return "success";
    }

    @RequestMapping("listPage")
    public List<RpTransactionMessage> listPage(@RequestBody Map<String, Object> paramMap){
        PageParam pageParam = new PageParam();
        pageParam.setPageNum(StringUtil.isEmpty(paramMap.get("pageNum"))? 1: Integer.valueOf((String) paramMap.get("pageNum")));
        pageParam.setNumPerPage(StringUtil.isEmpty(paramMap.get("numPerPage"))? 1: Integer.valueOf((String) paramMap.get("numPerPage")));
        PageBean pageBean = rpTransactionMessageService.listPage(pageParam, paramMap);
        return pageBean.getRecordList();
    }

    @RequestMapping("test")
    public String test(@RequestParam(value = "message", defaultValue = "success") String message){
        return message;
    }
}
