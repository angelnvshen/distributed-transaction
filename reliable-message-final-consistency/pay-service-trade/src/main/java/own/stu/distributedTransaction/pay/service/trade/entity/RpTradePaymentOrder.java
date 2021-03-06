package own.stu.distributedTransaction.pay.service.trade.entity;

import own.stu.distributedTransaction.common.core.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "rp_trade_payment_order")
public class RpTradePaymentOrder extends BaseEntity {

    /**
     * 商品名称
     */
    @Column(name = "product_name")
    private String productName;

    /**
     * 商户订单号
     */
    @Column(name = "merchant_order_no")
    private String merchantOrderNo;

    /**
     * 订单金额
     */
    @Column(name = "order_amount")
    private BigDecimal orderAmount;

    /**
     * 订单来源
     */
    @Column(name = "order_from")
    private String orderFrom;

    /**
     * 商家名称
     */
    @Column(name = "merchant_name")
    private String merchantName;

    /**
     * 商户编号
     */
    @Column(name = "merchant_no")
    private String merchantNo;

    /**
     * 下单时间
     */
    @Column(name = "order_time")
    private Date orderTime;

    /**
     * 下单日期
     */
    @Column(name = "order_date")
    private Date orderDate;

    /**
     * 下单IP(客户端IP,在网关页面获取)
     */
    @Column(name = "order_ip")
    private String orderIp;

    /**
     * 从哪个页面链接过来的(可用于防诈骗)
     */
    @Column(name = "order_referer_url")
    private String orderRefererUrl;

    /**
     * 页面回调通知URL
     */
    @Column(name = "return_url")
    private String returnUrl;

    /**
     * 后台异步通知URL
     */
    @Column(name = "notify_url")
    private String notifyUrl;

    /**
     * 订单撤销原因
     */
    @Column(name = "cancel_reason")
    private String cancelReason;

    /**
     * 订单有效期(单位分钟)
     */
    @Column(name = "order_period")
    private Integer orderPeriod;

    /**
     * 到期时间
     */
    @Column(name = "expire_time")
    private Date expireTime;

    /**
     * 支付通道编号
     */
    @Column(name = "pay_way_code")
    private String payWayCode;

    /**
     * 支付通道名称
     */
    @Column(name = "pay_way_name")
    private String payWayName;

    /**
     * 交易业务类型  ：消费、充值等
     */
    @Column(name = "trx_type")
    private String trxType;

    /**
     * 支付方式类型编号
     */
    @Column(name = "pay_type_code")
    private String payTypeCode;

    /**
     * 支付方式类型名称
     */
    @Column(name = "pay_type_name")
    private String payTypeName;

    /**
     * 资金流入类型
     */
    @Column(name = "fund_into_type")
    private String fundIntoType;

    /**
     * 是否退款(100:是,101:否,默认值为:101)
     */
    @Column(name = "is_refund")
    private String isRefund;

    /**
     * 退款次数(默认值为:0)
     */
    @Column(name = "refund_times")
    private Integer refundTimes;

    /**
     * 成功退款总金额
     */
    @Column(name = "success_refund_amount")
    private BigDecimal successRefundAmount;

    private String field1;

    private String field2;

    private String field3;

    private String field4;

    private String field5;

    @Column(name = "trx_no")
    private String trxNo;

    /**
     * 获取商品名称
     *
     * @return product_name - 商品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置商品名称
     *
     * @param productName 商品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取商户订单号
     *
     * @return merchant_order_no - 商户订单号
     */
    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    /**
     * 设置商户订单号
     *
     * @param merchantOrderNo 商户订单号
     */
    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    /**
     * 获取订单金额
     *
     * @return order_amount - 订单金额
     */
    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    /**
     * 设置订单金额
     *
     * @param orderAmount 订单金额
     */
    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    /**
     * 获取订单来源
     *
     * @return order_from - 订单来源
     */
    public String getOrderFrom() {
        return orderFrom;
    }

    /**
     * 设置订单来源
     *
     * @param orderFrom 订单来源
     */
    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }

    /**
     * 获取商家名称
     *
     * @return merchant_name - 商家名称
     */
    public String getMerchantName() {
        return merchantName;
    }

    /**
     * 设置商家名称
     *
     * @param merchantName 商家名称
     */
    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    /**
     * 获取商户编号
     *
     * @return merchant_no - 商户编号
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 设置商户编号
     *
     * @param merchantNo 商户编号
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    /**
     * 获取下单时间
     *
     * @return order_time - 下单时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 设置下单时间
     *
     * @param orderTime 下单时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 获取下单日期
     *
     * @return order_date - 下单日期
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * 设置下单日期
     *
     * @param orderDate 下单日期
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * 获取下单IP(客户端IP,在网关页面获取)
     *
     * @return order_ip - 下单IP(客户端IP,在网关页面获取)
     */
    public String getOrderIp() {
        return orderIp;
    }

    /**
     * 设置下单IP(客户端IP,在网关页面获取)
     *
     * @param orderIp 下单IP(客户端IP,在网关页面获取)
     */
    public void setOrderIp(String orderIp) {
        this.orderIp = orderIp;
    }

    /**
     * 获取从哪个页面链接过来的(可用于防诈骗)
     *
     * @return order_referer_url - 从哪个页面链接过来的(可用于防诈骗)
     */
    public String getOrderRefererUrl() {
        return orderRefererUrl;
    }

    /**
     * 设置从哪个页面链接过来的(可用于防诈骗)
     *
     * @param orderRefererUrl 从哪个页面链接过来的(可用于防诈骗)
     */
    public void setOrderRefererUrl(String orderRefererUrl) {
        this.orderRefererUrl = orderRefererUrl;
    }

    /**
     * 获取页面回调通知URL
     *
     * @return return_url - 页面回调通知URL
     */
    public String getReturnUrl() {
        return returnUrl;
    }

    /**
     * 设置页面回调通知URL
     *
     * @param returnUrl 页面回调通知URL
     */
    public void setReturnUrl(String returnUrl) {
        this.returnUrl = returnUrl;
    }

    /**
     * 获取后台异步通知URL
     *
     * @return notify_url - 后台异步通知URL
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * 设置后台异步通知URL
     *
     * @param notifyUrl 后台异步通知URL
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    /**
     * 获取订单撤销原因
     *
     * @return cancel_reason - 订单撤销原因
     */
    public String getCancelReason() {
        return cancelReason;
    }

    /**
     * 设置订单撤销原因
     *
     * @param cancelReason 订单撤销原因
     */
    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    /**
     * 获取订单有效期(单位分钟)
     *
     * @return order_period - 订单有效期(单位分钟)
     */
    public Integer getOrderPeriod() {
        return orderPeriod;
    }

    /**
     * 设置订单有效期(单位分钟)
     *
     * @param orderPeriod 订单有效期(单位分钟)
     */
    public void setOrderPeriod(Integer orderPeriod) {
        this.orderPeriod = orderPeriod;
    }

    /**
     * 获取到期时间
     *
     * @return expire_time - 到期时间
     */
    public Date getExpireTime() {
        return expireTime;
    }

    /**
     * 设置到期时间
     *
     * @param expireTime 到期时间
     */
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }

    /**
     * 获取支付通道编号
     *
     * @return pay_way_code - 支付通道编号
     */
    public String getPayWayCode() {
        return payWayCode;
    }

    /**
     * 设置支付通道编号
     *
     * @param payWayCode 支付通道编号
     */
    public void setPayWayCode(String payWayCode) {
        this.payWayCode = payWayCode;
    }

    /**
     * 获取支付通道名称
     *
     * @return pay_way_name - 支付通道名称
     */
    public String getPayWayName() {
        return payWayName;
    }

    /**
     * 设置支付通道名称
     *
     * @param payWayName 支付通道名称
     */
    public void setPayWayName(String payWayName) {
        this.payWayName = payWayName;
    }

    /**
     * 获取交易业务类型  ：消费、充值等
     *
     * @return trx_type - 交易业务类型  ：消费、充值等
     */
    public String getTrxType() {
        return trxType;
    }

    /**
     * 设置交易业务类型  ：消费、充值等
     *
     * @param trxType 交易业务类型  ：消费、充值等
     */
    public void setTrxType(String trxType) {
        this.trxType = trxType;
    }

    /**
     * 获取支付方式类型编号
     *
     * @return pay_type_code - 支付方式类型编号
     */
    public String getPayTypeCode() {
        return payTypeCode;
    }

    /**
     * 设置支付方式类型编号
     *
     * @param payTypeCode 支付方式类型编号
     */
    public void setPayTypeCode(String payTypeCode) {
        this.payTypeCode = payTypeCode;
    }

    /**
     * 获取支付方式类型名称
     *
     * @return pay_type_name - 支付方式类型名称
     */
    public String getPayTypeName() {
        return payTypeName;
    }

    /**
     * 设置支付方式类型名称
     *
     * @param payTypeName 支付方式类型名称
     */
    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }

    /**
     * 获取资金流入类型
     *
     * @return fund_into_type - 资金流入类型
     */
    public String getFundIntoType() {
        return fundIntoType;
    }

    /**
     * 设置资金流入类型
     *
     * @param fundIntoType 资金流入类型
     */
    public void setFundIntoType(String fundIntoType) {
        this.fundIntoType = fundIntoType;
    }

    /**
     * 获取是否退款(100:是,101:否,默认值为:101)
     *
     * @return is_refund - 是否退款(100:是,101:否,默认值为:101)
     */
    public String getIsRefund() {
        return isRefund;
    }

    /**
     * 设置是否退款(100:是,101:否,默认值为:101)
     *
     * @param isRefund 是否退款(100:是,101:否,默认值为:101)
     */
    public void setIsRefund(String isRefund) {
        this.isRefund = isRefund;
    }

    /**
     * 获取退款次数(默认值为:0)
     *
     * @return refund_times - 退款次数(默认值为:0)
     */
    public Integer getRefundTimes() {
        return refundTimes;
    }

    /**
     * 设置退款次数(默认值为:0)
     *
     * @param refundTimes 退款次数(默认值为:0)
     */
    public void setRefundTimes(Integer refundTimes) {
        this.refundTimes = refundTimes;
    }

    /**
     * 获取成功退款总金额
     *
     * @return success_refund_amount - 成功退款总金额
     */
    public BigDecimal getSuccessRefundAmount() {
        return successRefundAmount;
    }

    /**
     * 设置成功退款总金额
     *
     * @param successRefundAmount 成功退款总金额
     */
    public void setSuccessRefundAmount(BigDecimal successRefundAmount) {
        this.successRefundAmount = successRefundAmount;
    }

    /**
     * @return field1
     */
    public String getField1() {
        return field1;
    }

    /**
     * @param field1
     */
    public void setField1(String field1) {
        this.field1 = field1;
    }

    /**
     * @return field2
     */
    public String getField2() {
        return field2;
    }

    /**
     * @param field2
     */
    public void setField2(String field2) {
        this.field2 = field2;
    }

    /**
     * @return field3
     */
    public String getField3() {
        return field3;
    }

    /**
     * @param field3
     */
    public void setField3(String field3) {
        this.field3 = field3;
    }

    /**
     * @return field4
     */
    public String getField4() {
        return field4;
    }

    /**
     * @param field4
     */
    public void setField4(String field4) {
        this.field4 = field4;
    }

    /**
     * @return field5
     */
    public String getField5() {
        return field5;
    }

    /**
     * @param field5
     */
    public void setField5(String field5) {
        this.field5 = field5;
    }

    /**
     * @return trx_no
     */
    public String getTrxNo() {
        return trxNo;
    }

    /**
     * @param trxNo
     */
    public void setTrxNo(String trxNo) {
        this.trxNo = trxNo;
    }
}