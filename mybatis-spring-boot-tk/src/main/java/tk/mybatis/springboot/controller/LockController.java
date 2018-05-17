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
}
