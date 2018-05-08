package own.stu.distributedTransaction.pay.service.user.dao;

import org.springframework.stereotype.Component;
import own.stu.distributedTransaction.common.core.dao.MyMapper;
import own.stu.distributedTransaction.pay.service.user.entity.RpUserInfo;

import java.util.List;
import java.util.Map;

@Component
public interface RpUserInfoMapper extends MyMapper<RpUserInfo> {

    List<RpUserInfo> listPage(Map<String, Object> map);

    /** 获取用户编号 **/
    String buildUserNoSeq();

    /** 获取账户编号 **/
    String buildAccountNoSeq();
}