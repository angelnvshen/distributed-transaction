package tk.mybatis.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tk.mybatis.springboot.service.RegionsService;

@Controller
@RequestMapping("region")
public class RegionsController {

    @Autowired
    private RegionsService regionsService;

    @ResponseBody
    @RequestMapping(value = "/getRegionsInfo")
    public String getListOrderByNLevel() {
         return regionsService.getListByNLevel();
    }
}
