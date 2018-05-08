
package own.stu.distributedTransaction.pay.service.user.api;

import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.common.core.service.IService;
import own.stu.distributedTransaction.pay.service.user.entity.RpUserPayConfig;
import own.stu.distributedTransaction.pay.service.user.entity.RpUserPayConfig;
import own.stu.distributedTransaction.pay.service.user.exceptions.PayBizException;

import java.util.List;

/**
 * @类功能说明： 用户支付配置service接口
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：zh
 * @创建时间：2019-5-18 上午11:14:10
 */
public interface RpUserPayConfigService extends IService<RpUserPayConfig>{
	
	/**
	 * 根据商户编号获取已生效的支付配置
	 * @param userNo
	 * @return
	 */
	RpUserPayConfig getByUserNo(String userNo) throws PayBizException;
	
	/**
	 * 根据商户编号获取支付配置
	 * @param userNo
	 * @param auditStatus
	 * @return
	 */
	RpUserPayConfig getByUserNo(String userNo, String auditStatus) throws PayBizException;
	
	/**
	 * 根据支付产品获取已生效数据
	 */
	List<RpUserPayConfig> listByProductCode(String productCode) throws PayBizException;
	
	/**
	 * 根据支付产品获取数据
	 */
	List<RpUserPayConfig> listByProductCode(String productCode, String auditStatus) throws PayBizException;
	
	/**
	 * 创建用户支付配置
	 */
	void createUserPayConfig(String userNo, String userName, String productCode, String productName, Integer riskDay, String fundIntoType,
                             String isAutoSett, String appId, String merchantId, String partnerKey, String ali_partner, String ali_sellerId, String ali_key)  throws PayBizException;
	
	/**
	 * 删除支付产品
	 * @param userNo
	 */
	void deleteUserPayConfig(String userNo) throws PayBizException;
	
	/**
	 * 修改用户支付配置
	 */
	void updateUserPayConfig(String userNo, String productCode, String productName, Integer riskDay, String fundIntoType,
                             String isAutoSett, String appId, String merchantId, String partnerKey, String ali_partner, String ali_sellerId, String ali_key)  throws PayBizException;

	/**
	 * 审核
	 * @param userNo
	 * @param auditStatus
	 */
	void audit(String userNo, String auditStatus) throws PayBizException;
	
	/**
	 * 根据商户key获取已生效的支付配置
	 * @param payKey
	 * @return
	 */
	RpUserPayConfig getByPayKey(String payKey) throws PayBizException;
	
}