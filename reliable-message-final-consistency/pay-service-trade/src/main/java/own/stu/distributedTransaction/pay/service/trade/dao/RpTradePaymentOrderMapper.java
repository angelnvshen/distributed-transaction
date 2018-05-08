package own.stu.distributedTransaction.pay.service.trade.dao;

import org.springframework.stereotype.Component;
import own.stu.distributedTransaction.common.core.dao.MyMapper;
import own.stu.distributedTransaction.pay.service.trade.entity.RpTradePaymentOrder;

import java.util.List;
import java.util.Map;

@Component
public interface RpTradePaymentOrderMapper extends MyMapper<RpTradePaymentOrder> {

    List<RpTradePaymentOrder> listPage(Map<String, Object> map);
}