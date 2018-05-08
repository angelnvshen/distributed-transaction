package own.stu.distributedTransaction.pay.service.user.dao;

import org.springframework.stereotype.Component;
import own.stu.distributedTransaction.common.core.dao.MyMapper;
import own.stu.distributedTransaction.pay.service.user.entity.RpPayWay;

import java.util.List;
import java.util.Map;
@Component
public interface RpPayWayMapper extends MyMapper<RpPayWay> {

    List<RpPayWay> listPage(Map<String, Object> map);

}