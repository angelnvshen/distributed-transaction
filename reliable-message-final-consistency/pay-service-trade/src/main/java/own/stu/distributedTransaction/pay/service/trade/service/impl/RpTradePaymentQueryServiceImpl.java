
package own.stu.distributedTransaction.pay.service.trade.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import own.stu.distributedTransaction.common.core.enums.PublicEnum;
import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.pay.service.trade.service.RpTradePaymentManagerService;
import own.stu.distributedTransaction.pay.service.trade.service.RpTradePaymentQueryService;
import own.stu.distributedTransaction.pay.service.trade.dao.RpTradePaymentOrderMapper;
import own.stu.distributedTransaction.pay.service.trade.dao.RpTradePaymentRecordMapper;
import own.stu.distributedTransaction.pay.service.trade.entity.RpTradePaymentOrder;
import own.stu.distributedTransaction.pay.service.trade.entity.RpTradePaymentRecord;
import own.stu.distributedTransaction.pay.service.trade.enums.TradeStatusEnum;
import own.stu.distributedTransaction.pay.service.trade.vo.OrderPayResultVo;
import own.stu.distributedTransaction.pay.service.trade.vo.PaymentOrderQueryVo;
import own.stu.distributedTransaction.pay.service.user.api.RpUserPayConfigService;
import own.stu.distributedTransaction.pay.service.user.entity.RpUserPayConfig;
import own.stu.distributedTransaction.pay.service.user.exceptions.UserBizException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @类功能说明： 交易模块查询接口实现类.
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @创建时间：2019年5月25日,下午2:44:42.
 */
@Primary
@Service
public class RpTradePaymentQueryServiceImpl implements RpTradePaymentQueryService {
    protected static final Log LOG = LogFactory.getLog(RpTradePaymentQueryServiceImpl.class);

    @Autowired
//	private RpTradePaymentRecordDao rpTradePaymentRecordDao;
    private RpTradePaymentRecordMapper rpTradePaymentRecordDao;

    @Autowired
//	private RpTradePaymentOrderDao rpTradePaymentOrderDao;
    private RpTradePaymentManagerService rpTradePaymentManagerService;

    @Autowired
    private RpTradePaymentOrderMapper rpTradePaymentOrderDao;

    @Autowired
    private RpUserPayConfigService rpUserPayConfigService;

    /**
     * 根据参数查询交易记录List
     *
     * @param paramMap
     * @return
     */
    public List<RpTradePaymentRecord> listPaymentRecord(Map<String, Object> paramMap) {
        return rpTradePaymentRecordDao.listByColumn(paramMap);
    }

    /**
     * 根据商户支付KEY 及商户订单号 查询支付结果
     *
     * @param payKey  商户支付KEY
     * @param orderNo 商户订单号
     * @return
     */
    @Override
    public OrderPayResultVo getPayResult(String payKey, String orderNo) {

        RpUserPayConfig rpUserPayConfig = rpUserPayConfigService.getByPayKey(payKey);
        if (rpUserPayConfig == null) {
            throw new UserBizException(UserBizException.USER_PAY_CONFIG_ERRPR, "用户支付配置有误");
        }

        String merchantNo = rpUserPayConfig.getUserNo();// 商户编号
        RpTradePaymentOrder rpTradePaymentOrder = rpTradePaymentManagerService.selectByMerchantNoAndMerchantOrderNo(merchantNo, orderNo);

        OrderPayResultVo orderPayResultVo = new OrderPayResultVo();// 返回结果
        if (rpTradePaymentOrder != null && TradeStatusEnum.SUCCESS.name().equals(rpTradePaymentOrder.getStatus())) {// 支付记录为空,或者支付状态非成功
            orderPayResultVo.setStatus(PublicEnum.YES.name());// 设置支付状态
            orderPayResultVo.setOrderPrice(rpTradePaymentOrder.getOrderAmount());// 设置支付订单
            orderPayResultVo.setProductName(rpTradePaymentOrder.getProductName());// 设置产品名称
            orderPayResultVo.setReturnUrl(rpTradePaymentOrder.getReturnUrl());
        }

        return orderPayResultVo;
    }

    /**
     * 根据银行订单号查询支付记录
     *
     * @param bankOrderNo
     * @return
     */
    public RpTradePaymentRecord getRecordByBankOrderNo(String bankOrderNo) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("bankOrderNo", bankOrderNo);
        List<RpTradePaymentRecord> list = rpTradePaymentRecordDao.listPage(paramMap);
        return list.get(0);
    }

    /**
     * 根据支付流水号查询支付记录
     *
     * @param trxNo
     * @return
     */
    public RpTradePaymentRecord getRecordByTrxNo(String trxNo) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("trxNo", trxNo);
        List<RpTradePaymentRecord> list = rpTradePaymentRecordDao.listPage(paramMap);
        return list.get(0);
    }

    /**
     * 分页查询支付订单
     *
     * @param pageParam
     * @param paymentOrderQueryVo
     * @return
     */
    @Override
    public PageBean<RpTradePaymentOrder> listPaymentOrderPage(PageParam pageParam, PaymentOrderQueryVo paymentOrderQueryVo) {

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("merchantNo", paymentOrderQueryVo.getMerchantNo());//商户编号
        paramMap.put("merchantName", paymentOrderQueryVo.getMerchantName());//商户名称
        paramMap.put("merchantOrderNo", paymentOrderQueryVo.getMerchantOrderNo());//商户订单号
        paramMap.put("fundIntoType", paymentOrderQueryVo.getFundIntoType());//资金流入类型
        paramMap.put("merchantOrderNo", paymentOrderQueryVo.getOrderDateBegin());//订单开始时间
        paramMap.put("merchantOrderNo", paymentOrderQueryVo.getOrderDateEnd());//订单结束时间
        paramMap.put("payTypeName", paymentOrderQueryVo.getPayTypeName());//支付类型
        paramMap.put("payWayName", paymentOrderQueryVo.getPayWayName());//支付类型
        paramMap.put("status", paymentOrderQueryVo.getStatus());//支付状态

        if (paymentOrderQueryVo.getOrderDateBegin() != null) {
            paramMap.put("orderDateBegin", paymentOrderQueryVo.getOrderDateBegin());//支付状态
        }

        if (paymentOrderQueryVo.getOrderDateEnd() != null) {
            paramMap.put("orderDateEnd", paymentOrderQueryVo.getOrderDateEnd());//支付状态
        }

        PageHelper.startPage(pageParam.getPageNum(), pageParam.getNumPerPage());
        List<RpTradePaymentOrder> list = rpTradePaymentOrderDao.listPage(paramMap);
        PageInfo info = new PageInfo<RpTradePaymentOrder>(list);

        return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), (int) info.getTotal(), info.getList());

    }

    /**
     * 分页查询支付记录
     *
     * @param pageParam
     * @param paymentOrderQueryVo
     * @return
     */
    @Override
    public PageBean<RpTradePaymentRecord> listPaymentRecordPage(PageParam pageParam, PaymentOrderQueryVo paymentOrderQueryVo) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("merchantNo", paymentOrderQueryVo.getMerchantNo());//商户编号
        paramMap.put("merchantName", paymentOrderQueryVo.getMerchantName());//商户名称
        paramMap.put("merchantOrderNo", paymentOrderQueryVo.getMerchantOrderNo());//商户订单号
        paramMap.put("fundIntoType", paymentOrderQueryVo.getFundIntoType());//资金流入类型
        paramMap.put("merchantOrderNo", paymentOrderQueryVo.getOrderDateBegin());//订单开始时间
        paramMap.put("merchantOrderNo", paymentOrderQueryVo.getOrderDateEnd());//订单结束时间
        paramMap.put("payTypeName", paymentOrderQueryVo.getPayTypeName());//支付类型
        paramMap.put("payWayName", paymentOrderQueryVo.getPayWayName());//支付类型
        paramMap.put("status", paymentOrderQueryVo.getStatus());//支付状态

        if (paymentOrderQueryVo.getOrderDateBegin() != null) {
            paramMap.put("orderDateBegin", paymentOrderQueryVo.getOrderDateBegin());//支付状态
        }

        if (paymentOrderQueryVo.getOrderDateEnd() != null) {
            paramMap.put("orderDateEnd", paymentOrderQueryVo.getOrderDateEnd());//支付状态
        }

        PageHelper.startPage(pageParam.getPageNum(), pageParam.getNumPerPage());
        List<RpTradePaymentRecord> list = rpTradePaymentRecordDao.listPage(paramMap);
        PageInfo info = new PageInfo<RpTradePaymentRecord>(list);

        return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), (int) info.getTotal(), info.getList());
    }
}
