package own.stu.distributedTransaction.pay.service.api.trade;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import own.stu.distributedTransaction.pay.service.api.entity.OrderPayResultVo;
import own.stu.distributedTransaction.pay.service.api.entity.RpTradePaymentRecord;

import java.util.Map;

@FeignClient(name = "${pay.web.trade.api.name}")
@RequestMapping("${pay.web.trade.api.name}/trade")
public interface RpTradePaymentServiceApi {

    @RequestMapping("getRecordByBankOrderNo")
    RpTradePaymentRecord getRecordByBankOrderNo(String bankOrderNo);

    @RequestMapping("completeScanPay")
    void completeScanPay(@RequestBody Map<String, String> notifyMap);
}
