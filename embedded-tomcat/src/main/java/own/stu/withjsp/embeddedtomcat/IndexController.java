package own.stu.withjsp.embeddedtomcat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by CHANEL on 2018/5/6.
 */
@Controller
public class IndexController {

    @RequestMapping("info")
    public String index(){
        return "index";
    }

    @ResponseBody
    @GetMapping("test")
    public String message(){
        return "Success";
    }

}
