
package own.stu.distributedTransaction.pay.service.user.api;

import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.common.core.service.IService;
import own.stu.distributedTransaction.pay.service.user.entity.RpUserPayInfo;
import own.stu.distributedTransaction.pay.service.user.exceptions.UserBizException;

/**
 * @类功能说明： 用户第三方支付信息service接口
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：zh
 * @创建时间：2019-5-18 上午11:14:10
 */
public interface RpUserPayInfoService extends IService<RpUserPayInfo>{
	
	/**
	 * 通过商户编号获取商户支付配置信息
	 * @param userNo
	 * @param payWayCode
	 * @return
	 */
	RpUserPayInfo getByUserNo(String userNo, String payWayCode) throws UserBizException;
	
}