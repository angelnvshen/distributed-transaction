
package own.stu.distributedTransaction.pay.service.user.api;

import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.common.core.service.IService;
import own.stu.distributedTransaction.pay.service.user.entity.RpUserInfo;
import own.stu.distributedTransaction.pay.service.user.exceptions.PayBizException;

import java.util.List;

/**
 * @类功能说明： 用户信息service接口
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：zh
 * @创建时间：2019-5-18 上午11:14:10
 */
public interface RpUserInfoService extends IService<RpUserInfo>{
	
	/**
     * 用户线下注册
     * 
     * @param userName
     *            用户名
     * @return
     */
    void registerOffline(String userName)  throws PayBizException;

	/**
	 * 根据商户编号获取商户信息
	 * @param merchantNo
	 * @return
	 */
	RpUserInfo getDataByMerchentNo(String merchantNo) throws PayBizException;
	
	/**
	 * 获取所有用户
	 * @return
	 */
	List<RpUserInfo> listAll() throws PayBizException;
	
}