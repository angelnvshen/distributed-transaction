package own.stu.distributedTransaction.usable.jsp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LearnResourceController {

    @RequestMapping("index")
    public String index(){
        return "index";
    }
}