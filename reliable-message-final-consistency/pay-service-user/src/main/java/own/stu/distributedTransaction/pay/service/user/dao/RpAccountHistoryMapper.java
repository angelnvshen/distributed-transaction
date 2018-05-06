package own.stu.distributedTransaction.pay.service.user.dao;

import own.stu.distributedTransaction.common.core.dao.MyMapper;
import own.stu.distributedTransaction.pay.service.user.entity.RpAccountHistory;
import own.stu.distributedTransaction.pay.service.user.vo.DailyCollectAccountHistoryVo;

import java.util.List;
import java.util.Map;

public interface RpAccountHistoryMapper extends MyMapper<RpAccountHistory> {

    List<RpAccountHistory> listPage(Map<String, Object> map);

    /** 更新账户风险预存期外的账户历史记录记为结算完成 **/
    void updateCompleteSettTo100(Map<String, Object> params);

    RpAccountHistory getByRequestNo(String requestNo);

    List<DailyCollectAccountHistoryVo> listDailyCollectAccountHistoryVo(Map<String, Object> params);
}