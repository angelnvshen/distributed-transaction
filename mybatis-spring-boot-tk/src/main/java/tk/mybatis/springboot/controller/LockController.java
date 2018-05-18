package tk.mybatis.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.springboot.service.LockService;

/**
 * Created by CHANEL on 2018/5/16.
 */
@Controller
public class LockController {

    @Autowired
    private LockService lockService;

    @RequestMapping("selectForUpdate")
    @ResponseBody
    public String selectForUpdate(int id, @RequestParam(name = "value", defaultValue = "10",
            required = false)Integer value){
        if(0 != lockService._updateByVersion(id, value)){
            return "success";
        }
        return "fail";
    }

    /**
     * 交易
     * @param from_id 支付账号
     * @param value 支付金额
     * @param to_id 收款账号
     * @return
     */
    @RequestMapping("exchangeAmount")
    @ResponseBody
    public String exchangeAmount(@RequestParam(name = "from_id", defaultValue = "1", required = false)Integer from_id,
                                 @RequestParam(name = "value", defaultValue = "10", required = false)Integer value,
                                 @RequestParam(name = "to_id", defaultValue = "2", required = false)Integer to_id
    ){
        if(0 != lockService.exchangeAmount(from_id, value, to_id)){
            return "success";
        }
        return "fail";
    }
}
