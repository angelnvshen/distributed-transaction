package own.stu.distributedTransaction.usable.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import own.stu.distributedTransaction.common.core.utils.StringUtil;
import own.stu.distributedTransaction.pay.service.message.service.RpTransactionMessageService;

@Controller
public class LearnResourceController {

    @RequestMapping("index")
    public String index(){
        if(StringUtil.isEmpty("xxxx")){
            rpTransactionMessageService.confirmAndSendMessage("");
        }
        return "index";
    }

    @Autowired
    private RpTransactionMessageService rpTransactionMessageService;
}