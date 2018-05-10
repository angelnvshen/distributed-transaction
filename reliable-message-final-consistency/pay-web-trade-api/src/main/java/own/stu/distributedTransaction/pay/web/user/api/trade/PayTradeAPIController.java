package own.stu.distributedTransaction.pay.web.user.api.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import own.stu.distributedTransaction.pay.service.trade.service.RpTradePaymentQueryService;
import own.stu.distributedTransaction.pay.service.trade.entity.RpTradePaymentRecord;

@RestController("trade")
@RequestMapping("trade")
public class PayTradeAPIController {

    @Autowired
    private RpTradePaymentQueryService rpTradePaymentQueryService;

    @RequestMapping("getRecordByBankOrderNo")
    public RpTradePaymentRecord getRecordByBankOrderNo(String bankOrderNo) {
        return rpTradePaymentQueryService.getRecordByBankOrderNo(bankOrderNo);
    }

}
