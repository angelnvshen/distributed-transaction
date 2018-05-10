package own.stu.distributedTransaction.pay.service.api.trade;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import own.stu.distributedTransaction.pay.service.api.entity.RpTradePaymentRecord;

//@FeignClient(name = "${pay.web.trade.service.name}")
@FeignClient(name = "pay-web-trade-api")
public interface RpTradePaymentQueryServiceApi {

    @RequestMapping("trade/getRecordByBankOrderNo")
    RpTradePaymentRecord getRecordByBankOrderNo(String bankOrderNo);
}
