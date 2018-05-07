package own.stu.distributedTransaction.usable.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import own.stu.distributedTransaction.common.core.utils.StringUtil;
import own.stu.distributedTransaction.pay.service.message.api.RpTransactionMessageService;

@Controller
public class LearnResourceController {
    @RequestMapping("index")
    public String index(){
        return "index";
    }

    @ResponseBody
    @RequestMapping("message")
    public String message(){
        return "success";
    }

}