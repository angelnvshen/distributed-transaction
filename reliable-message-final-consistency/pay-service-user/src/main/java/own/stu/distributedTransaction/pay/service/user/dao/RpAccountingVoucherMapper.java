package own.stu.distributedTransaction.pay.service.user.dao;

import org.springframework.stereotype.Component;
import own.stu.distributedTransaction.common.core.dao.MyMapper;
import own.stu.distributedTransaction.pay.service.user.entity.RpAccountingVoucher;

import java.util.List;
import java.util.Map;

@Component
public interface RpAccountingVoucherMapper extends MyMapper<RpAccountingVoucher> {

    //生成请求号: 会计分录类型+日期+随机数字.
    String buildAccountingVoucherNo();

    List<RpAccountingVoucher> listPage(Map<String, Object> map);
}