package own.stu.distributedTransaction.pay.service.accounting.dao;

import own.stu.distributedTransaction.common.core.dao.MyMapper;
import own.stu.distributedTransaction.pay.service.accounting.entity.RpAccountingVoucher;

public interface RpAccountingVoucherDao extends MyMapper<RpAccountingVoucher> {

    //生成请求号: 会计分录类型+日期+随机数字.
    String buildAccountingVoucherNo();
}