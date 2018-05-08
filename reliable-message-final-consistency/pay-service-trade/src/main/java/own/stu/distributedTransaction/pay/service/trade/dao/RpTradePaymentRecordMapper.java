package own.stu.distributedTransaction.pay.service.trade.dao;

import org.springframework.stereotype.Component;
import own.stu.distributedTransaction.common.core.dao.MyMapper;
import own.stu.distributedTransaction.pay.service.trade.entity.RpTradePaymentRecord;

import java.util.List;
import java.util.Map;

@Component
public interface RpTradePaymentRecordMapper extends MyMapper<RpTradePaymentRecord> {
    List<RpTradePaymentRecord> listPage(Map<String, Object> map);
    List<RpTradePaymentRecord> listByColumn(Map<String, Object> map);

    String buildTrxNoSeq();
    String buildBankOrderNoSeq();
}