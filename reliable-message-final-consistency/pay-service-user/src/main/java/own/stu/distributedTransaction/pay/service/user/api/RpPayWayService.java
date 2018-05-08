
package own.stu.distributedTransaction.pay.service.user.api;

import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.common.core.service.IService;
import own.stu.distributedTransaction.pay.service.user.entity.RpPayWay;
import own.stu.distributedTransaction.pay.service.user.exceptions.PayBizException;

import java.util.List;

/**
 * @类功能说明： 支付方式service接口
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：zh
 * @创建时间：2019-5-18 上午11:14:10
 */
public interface RpPayWayService extends IService<RpPayWay>{

	/**
	 * 根据支付方式、渠道编码获取数据
	 * @param rpTypeCode
	 * @return
	 */
	RpPayWay getByPayWayTypeCode(String payProductCode, String payWayCode, String rpTypeCode) throws PayBizException;
	

	/**
	 * 绑定支付费率
	 * @param payWayCode
	 * @param payTypeCode
	 * @param payRate
	 */
	void createPayWay(String payProductCode, String payWayCode, String payTypeCode, Double payRate)  throws PayBizException;
	
	/**
	 * 根据支付产品获取支付方式
	 * @param payProductCode
	 */
	List<RpPayWay> listByProductCode(String payProductCode) throws PayBizException;
	
	/**
	 * 获取所有支付方式
	 */
	List<RpPayWay> listAll() throws PayBizException;
	
}