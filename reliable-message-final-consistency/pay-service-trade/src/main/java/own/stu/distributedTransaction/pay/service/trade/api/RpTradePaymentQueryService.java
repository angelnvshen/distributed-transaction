/*
 * ====================================================================
 * 龙果学院： www.roncoo.com （微信公众号：RonCoo_com）
 * 超级教程系列：《微服务架构的分布式事务解决方案》视频教程
 * 讲师：吴水成（水到渠成），840765167@qq.com
 * 课程地址：http://www.roncoo.com/course/view/7ae3d7eddc4742f78b0548aa8bd9ccdb
 * ====================================================================
 */
package own.stu.distributedTransaction.pay.service.trade.api;

import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.pay.service.trade.entity.RpTradePaymentOrder;
import own.stu.distributedTransaction.pay.service.trade.entity.RpTradePaymentRecord;
import own.stu.distributedTransaction.pay.service.trade.vo.OrderPayResultVo;
import own.stu.distributedTransaction.pay.service.trade.vo.PaymentOrderQueryVo;

import java.util.List;
import java.util.Map;

/**
 * 
 * @类功能说明： 交易模块查询接口类.
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：广州领课网络科技有限公司（龙果学院:www.roncoo.com）
 * @作者：Along.shen
 * @创建时间：2016年5月25日,下午2:44:42.
 * @版本：V1.0
 *
 */
public interface RpTradePaymentQueryService {



	/**
	 * 根据参数查询交易记录List
	 * 
	 * @param paremMap
	 * @return
	 */
	List<RpTradePaymentRecord> listPaymentRecord(Map<String, Object> paremMap);

	/**
	 * 根据商户支付KEY 及商户订单号 查询支付结果
	 * 
	 * @param payKey
	 *            商户支付KEY
	 * @param orderNo
	 *            商户订单号
	 * @return
	 */
	OrderPayResultVo getPayResult(String payKey, String orderNo);

	/**
	 * 根据银行订单号查询支付记录
	 * 
	 * @param bankOrderNo
	 * @return
	 */
	RpTradePaymentRecord getRecordByBankOrderNo(String bankOrderNo);

	/**
	 * 根据支付流水号查询支付记录
	 * 
	 * @param trxNo
	 * @return
	 */
	RpTradePaymentRecord getRecordByTrxNo(String trxNo);


	/**
	 * 分页查询支付订单
	 * @param pageParam
	 * @param paymentOrderQueryVo
	 * @return
	 */
	PageBean<RpTradePaymentOrder> listPaymentOrderPage(PageParam pageParam, PaymentOrderQueryVo paymentOrderQueryVo);

	/**
	 * 分页查询支付记录
	 * @param pageParam
	 * @param paymentOrderQueryVo
	 * @return
	 */
	PageBean<RpTradePaymentRecord> listPaymentRecordPage(PageParam pageParam, PaymentOrderQueryVo paymentOrderQueryVo);

}
