package own.stu.distributedTransaction.pay.service.user.dao;

import org.springframework.stereotype.Component;
import own.stu.distributedTransaction.common.core.dao.MyMapper;
import own.stu.distributedTransaction.pay.service.user.entity.RpAccount;

import java.util.List;
import java.util.Map;

@Component
public interface RpAccountMapper extends MyMapper<RpAccount> {

    RpAccount getByUserNo(Map<String, Object> map);

    List<RpAccount> listPage(Map<String, Object> map);
}