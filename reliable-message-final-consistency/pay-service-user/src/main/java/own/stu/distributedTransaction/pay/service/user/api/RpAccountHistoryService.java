
package own.stu.distributedTransaction.pay.service.user.api;


import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.common.core.service.IService;
import own.stu.distributedTransaction.pay.service.user.entity.RpAccountHistory;

import java.util.Map;

/**
 * @类功能说明： 账户历史service接口
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：zh
 * @创建时间：2019-5-18 上午11:14:10
 */
public interface RpAccountHistoryService extends IService<RpAccountHistory>{

    PageBean listPage(PageParam pageParam, Map<String, Object> paramMap);
}