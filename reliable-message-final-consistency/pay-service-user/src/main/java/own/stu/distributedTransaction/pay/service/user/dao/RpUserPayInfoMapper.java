package own.stu.distributedTransaction.pay.service.user.dao;

import org.springframework.stereotype.Component;
import own.stu.distributedTransaction.common.core.dao.MyMapper;
import own.stu.distributedTransaction.pay.service.user.entity.RpUserPayInfo;

import java.util.List;
import java.util.Map;

@Component
public interface RpUserPayInfoMapper extends MyMapper<RpUserPayInfo> {

    List<RpUserPayInfo> listPage(Map<String, Object> map);
}