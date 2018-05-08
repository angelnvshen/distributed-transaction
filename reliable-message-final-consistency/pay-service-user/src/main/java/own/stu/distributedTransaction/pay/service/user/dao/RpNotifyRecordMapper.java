package own.stu.distributedTransaction.pay.service.user.dao;

import org.springframework.stereotype.Component;
import own.stu.distributedTransaction.common.core.dao.MyMapper;
import own.stu.distributedTransaction.pay.service.user.entity.RpNotifyRecord;

import java.util.List;
import java.util.Map;

@Component
public interface RpNotifyRecordMapper extends MyMapper<RpNotifyRecord> {

    List<RpNotifyRecord> listPage(Map<String, Object> map);
}