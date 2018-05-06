package own.stu.distributedTransaction.pay.service.message.dao;

import org.springframework.stereotype.Component;
import own.stu.distributedTransaction.common.core.dao.MyMapper;
import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.pay.service.message.entity.RpTransactionMessage;

import java.util.Map;

@Component
public interface RpTransactionMessageDao extends MyMapper<RpTransactionMessage> {

    PageBean<RpTransactionMessage> listPage(PageParam pageParam, Map<String, Object> paramMap);
}