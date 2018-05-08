package own.stu.distributedTransaction.pay.service.user.dao;

import org.springframework.stereotype.Component;
import own.stu.distributedTransaction.common.core.dao.MyMapper;
import own.stu.distributedTransaction.pay.service.user.entity.RpPayProduct;

import java.util.List;
import java.util.Map;

@Component
public interface RpPayProductMapper extends MyMapper<RpPayProduct> {

    List<RpPayProduct> listPage(Map<String, Object> map);
}