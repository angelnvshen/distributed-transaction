package own.stu.distributedTransaction.pay.web.user.api.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import own.stu.distributedTransaction.pay.service.user.api.RpAccountingVoucherService;
import own.stu.distributedTransaction.pay.service.user.entity.RpAccountingVoucher;

@RestController("accounting")
@RequestMapping("accounting")
public class PayAccountingAPIController {

    @Autowired
    private RpAccountingVoucherService rpAccountingVoucherService;

    @RequestMapping("createAccountingVoucher")
    public String createAccountingVoucher(@RequestBody RpAccountingVoucher rpAccountingVoucher){
        rpAccountingVoucherService.createAccountingVoucher(rpAccountingVoucher);
        return "success";
    }

}
