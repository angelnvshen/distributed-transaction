package own.stu.distributedTransaction.pay.service.api.account;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import own.stu.distributedTransaction.pay.service.api.entity.RpAccountingVoucher;

/**
 * Created by CHANEL on 2018/5/10.
 */
@FeignClient(name = "pay-web-trade-api")
public interface RpAccountingVoucherServiceApi {

    @RequestMapping("accounting/createAccountingVoucher")
    String createAccountingVoucher(@RequestBody RpAccountingVoucher rpAccountingVoucher);
}
