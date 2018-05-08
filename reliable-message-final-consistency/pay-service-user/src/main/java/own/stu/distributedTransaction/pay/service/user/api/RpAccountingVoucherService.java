
package own.stu.distributedTransaction.pay.service.user.api;

import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.pay.service.user.entity.RpAccountingVoucher;
import own.stu.distributedTransaction.pay.service.user.exceptions.AccountingBizException;

import java.util.Map;


/**
 * 会计原始凭证服务接口.
 *
 */
public interface RpAccountingVoucherService {
	
	/**
	 * 创建会计分录原始凭证信息.
//	 * @param entryType 会计分录类型.
//	 * @param voucherNo 原始凭证号 （交易记录的唯一凭证号）.
//	 * @param payerAccountNo 付款方账户编号.
//	 * @param receiverAccountNo 收款方账户编号.
//	 * @param payerChangeAmount 付款方帐户变动金额.
//	 * @param receiverChangeAmount 收款方帐户变动金额.
//	 * @param income 平台收入.
//	 * @param cost 平台成本.
//	 * @param profit 平台利润.
//	 * @param bankChangeAmount 平台银行帐户变动金额.
//	 * @param requestNo 请求号 (会计系统自动生成).
//	 * @param bankChannelCode 银行渠道编号.
//	 * @param bankAccount 银行账户.
//	 * @param fromSystem 来源系统.
//	 * @param remark 备注.
//	 * @param bankOrderNo 银行订单号.
//	 * @param payerAccountType 付款方账户类型.
//	 * @param payAmount 支付金额.
//	 * @param receiverAccountType 收款方账户类型.
//	 * @param payerFee 付款方手续费.
//	 * @param receiverFee 收款方手续费.
	 */
	void createAccountingVoucher(RpAccountingVoucher rpAccountingVoucher) throws AccountingBizException;

	/***
	 * 根据条件查询单挑数据
	 * 
	 * @param map
	 * @return
	 */
	RpAccountingVoucher getBy(Map<String, Object> map) throws AccountingBizException;

	/***
	 * 根据条件查询分录请求表数据
	 * 
	 * @return
	 */
	PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) throws AccountingBizException;

	/***
	 * 根据条件查询分录请求表数据
	 * 
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	//Map getMapBy(Map<String, Object> searchMap) throws AccountingBizException;

	/**
	 * 查出分录请求表
	 * 
	 * @param requestNo
	 */
	RpAccountingVoucher getAccountingVoucherByRequestNo(String requestNo) throws AccountingBizException;

	/**
	 * 修改分录请求
	 * 
	 */
	void updateAccountingVoucher(RpAccountingVoucher entity) throws AccountingBizException;

}
