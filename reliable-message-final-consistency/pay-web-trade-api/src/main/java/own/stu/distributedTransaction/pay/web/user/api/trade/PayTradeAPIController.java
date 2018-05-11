package own.stu.distributedTransaction.pay.web.user.api.trade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import own.stu.distributedTransaction.pay.service.trade.service.RpTradePaymentManagerService;
import own.stu.distributedTransaction.pay.service.trade.service.RpTradePaymentQueryService;
import own.stu.distributedTransaction.pay.service.trade.entity.RpTradePaymentRecord;
import own.stu.distributedTransaction.pay.service.trade.vo.OrderPayResultVo;

import java.util.Map;

@RestController("trade")
@RequestMapping("trade")
public class PayTradeAPIController {

    @Autowired
    private RpTradePaymentQueryService rpTradePaymentQueryService;

    @Autowired
    private RpTradePaymentManagerService rpTradePaymentManagerService;

    @RequestMapping("getRecordByBankOrderNo")
    public RpTradePaymentRecord getRecordByBankOrderNo(String bankOrderNo) {
        return rpTradePaymentQueryService.getRecordByBankOrderNo(bankOrderNo);
    }

    @RequestMapping("completeScanPay")
    public String completeScanPay(@RequestBody Map<String, String> resultMap){
        String payWayCode = resultMap.get("payWayCode");
        rpTradePaymentManagerService.completeScanPay(payWayCode, resultMap);
        return "success";
    }
}
