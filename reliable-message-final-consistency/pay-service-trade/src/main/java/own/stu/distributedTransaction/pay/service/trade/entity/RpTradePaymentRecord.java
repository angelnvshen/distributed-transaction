package own.stu.distributedTransaction.pay.service.trade.entity;

import own.stu.distributedTransaction.common.core.entity.BaseEntity;
import own.stu.distributedTransaction.common.core.utils.StringUtil;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "rp_trade_payment_record")
public class RpTradePaymentRecord extends BaseEntity {
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
     * 支付流水号
     */
    @Column(name = "trx_no")
    private String trxNo;

    /**
     * 银行订单号
     */
    @Column(name = "bank_order_no")
    private String bankOrderNo;

    /**
     * 银行流水号
     */
    @Column(name = "bank_trx_no")
    private String bankTrxNo;

    /**
     * 商家名称
     */
    @Column(name = "merchant_name")
    private String merchantName;

    /**
     * 商家编号
     */
    @Column(name = "merchant_no")
    private String merchantNo;

    /**
     * 付款人编号
     */
    @Column(name = "payer_user_no")
    private String payerUserNo;

    /**
     * 付款人名称
     */
    @Column(name = "payer_name")
    private String payerName;

    /**
     * 付款方支付金额
     */
    @Column(name = "payer_pay_amount")
    private BigDecimal payerPayAmount;

    /**
     * 付款方手续费
     */
    @Column(name = "payer_fee")
    private BigDecimal payerFee;

    /**
     * 付款方账户类型(参考账户类型枚举:AccountTypeEnum)
     */
    @Column(name = "payer_account_type")
    private String payerAccountType;

    /**
     * 收款人编号
     */
    @Column(name = "receiver_user_no")
    private String receiverUserNo;

    /**
     * 收款人名称
     */
    @Column(name = "receiver_name")
    private String receiverName;

    /**
     * 收款方支付金额
     */
    @Column(name = "receiver_pay_amount")
    private BigDecimal receiverPayAmount;

    /**
     * 收款方手续费
     */
    @Column(name = "receiver_fee")
    private BigDecimal receiverFee;

    /**
     * 收款方账户类型(参考账户类型枚举:AccountTypeEnum)
     */
    @Column(name = "receiver_account_type")
    private String receiverAccountType;

    /**
     * 下单IP(客户端IP,从网关中获取)
     */
    @Column(name = "order_ip")
    private String orderIp;

    /**
     * 从哪个页面链接过来的(可用于防诈骗)
     */
    @Column(name = "order_referer_url")
    private String orderRefererUrl;

    /**
     * 订单金额
     */
    @Column(name = "order_amount")
    private BigDecimal orderAmount;

    /**
     * 平台收入
     */
    @Column(name = "plat_income")
    private BigDecimal platIncome;

    /**
     * 费率
     */
    @Column(name = "fee_rate")
    private BigDecimal feeRate;

    /**
     * 平台成本
     */
    @Column(name = "plat_cost")
    private BigDecimal platCost;

    /**
     * 平台利润
     */
    @Column(name = "plat_profit")
    private BigDecimal platProfit;

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
     * 支付成功时间
     */
    @Column(name = "pay_success_time")
    private Date paySuccessTime;

    /**
     * 完成时间
     */
    @Column(name = "complete_time")
    private Date completeTime;

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

    /**
     * 交易业务类型  ：消费、充值等
     */
    @Column(name = "trx_type")
    private String trxType;

    /**
     * 订单来源
     */
    @Column(name = "order_from")
    private String orderFrom;

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

    private String field1;

    private String field2;

    private String field3;

    private String field4;

    private String field5;

    @Column(name = "bank_return_msg")
    private String bankReturnMsg;


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
     * 获取支付流水号
     *
     * @return trx_no - 支付流水号
     */
    public String getTrxNo() {
        return trxNo;
    }

    /**
     * 设置支付流水号
     *
     * @param trxNo 支付流水号
     */
    public void setTrxNo(String trxNo) {
        this.trxNo = trxNo;
    }

    /**
     * 获取银行订单号
     *
     * @return bank_order_no - 银行订单号
     */
    public String getBankOrderNo() {
        return bankOrderNo;
    }

    /**
     * 设置银行订单号
     *
     * @param bankOrderNo 银行订单号
     */
    public void setBankOrderNo(String bankOrderNo) {
        this.bankOrderNo = bankOrderNo;
    }

    /**
     * 获取银行流水号
     *
     * @return bank_trx_no - 银行流水号
     */
    public String getBankTrxNo() {
        return bankTrxNo;
    }

    /**
     * 设置银行流水号
     *
     * @param bankTrxNo 银行流水号
     */
    public void setBankTrxNo(String bankTrxNo) {
        this.bankTrxNo = bankTrxNo;
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
     * 获取商家编号
     *
     * @return merchant_no - 商家编号
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * 设置商家编号
     *
     * @param merchantNo 商家编号
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    /**
     * 获取付款人编号
     *
     * @return payer_user_no - 付款人编号
     */
    public String getPayerUserNo() {
        return payerUserNo;
    }

    /**
     * 设置付款人编号
     *
     * @param payerUserNo 付款人编号
     */
    public void setPayerUserNo(String payerUserNo) {
        this.payerUserNo = payerUserNo;
    }

    /**
     * 获取付款人名称
     *
     * @return payer_name - 付款人名称
     */
    public String getPayerName() {
        return payerName;
    }

    /**
     * 设置付款人名称
     *
     * @param payerName 付款人名称
     */
    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    /**
     * 获取付款方支付金额
     *
     * @return payer_pay_amount - 付款方支付金额
     */
    public BigDecimal getPayerPayAmount() {
        return payerPayAmount;
    }

    /**
     * 设置付款方支付金额
     *
     * @param payerPayAmount 付款方支付金额
     */
    public void setPayerPayAmount(BigDecimal payerPayAmount) {
        this.payerPayAmount = payerPayAmount;
    }

    /**
     * 获取付款方手续费
     *
     * @return payer_fee - 付款方手续费
     */
    public BigDecimal getPayerFee() {
        return payerFee;
    }

    /**
     * 设置付款方手续费
     *
     * @param payerFee 付款方手续费
     */
    public void setPayerFee(BigDecimal payerFee) {
        this.payerFee = payerFee;
    }

    /**
     * 获取付款方账户类型(参考账户类型枚举:AccountTypeEnum)
     *
     * @return payer_account_type - 付款方账户类型(参考账户类型枚举:AccountTypeEnum)
     */
    public String getPayerAccountType() {
        return payerAccountType;
    }

    /**
     * 设置付款方账户类型(参考账户类型枚举:AccountTypeEnum)
     *
     * @param payerAccountType 付款方账户类型(参考账户类型枚举:AccountTypeEnum)
     */
    public void setPayerAccountType(String payerAccountType) {
        this.payerAccountType = payerAccountType;
    }

    /**
     * 获取收款人编号
     *
     * @return receiver_user_no - 收款人编号
     */
    public String getReceiverUserNo() {
        return receiverUserNo;
    }

    /**
     * 设置收款人编号
     *
     * @param receiverUserNo 收款人编号
     */
    public void setReceiverUserNo(String receiverUserNo) {
        this.receiverUserNo = receiverUserNo;
    }

    /**
     * 获取收款人名称
     *
     * @return receiver_name - 收款人名称
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * 设置收款人名称
     *
     * @param receiverName 收款人名称
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    /**
     * 获取收款方支付金额
     *
     * @return receiver_pay_amount - 收款方支付金额
     */
    public BigDecimal getReceiverPayAmount() {
        return receiverPayAmount;
    }

    /**
     * 设置收款方支付金额
     *
     * @param receiverPayAmount 收款方支付金额
     */
    public void setReceiverPayAmount(BigDecimal receiverPayAmount) {
        this.receiverPayAmount = receiverPayAmount;
    }

    /**
     * 获取收款方手续费
     *
     * @return receiver_fee - 收款方手续费
     */
    public BigDecimal getReceiverFee() {
        return receiverFee;
    }

    /**
     * 设置收款方手续费
     *
     * @param receiverFee 收款方手续费
     */
    public void setReceiverFee(BigDecimal receiverFee) {
        this.receiverFee = receiverFee;
    }

    /**
     * 获取收款方账户类型(参考账户类型枚举:AccountTypeEnum)
     *
     * @return receiver_account_type - 收款方账户类型(参考账户类型枚举:AccountTypeEnum)
     */
    public String getReceiverAccountType() {
        return receiverAccountType;
    }

    /**
     * 设置收款方账户类型(参考账户类型枚举:AccountTypeEnum)
     *
     * @param receiverAccountType 收款方账户类型(参考账户类型枚举:AccountTypeEnum)
     */
    public void setReceiverAccountType(String receiverAccountType) {
        this.receiverAccountType = receiverAccountType;
    }

    /**
     * 获取下单IP(客户端IP,从网关中获取)
     *
     * @return order_ip - 下单IP(客户端IP,从网关中获取)
     */
    public String getOrderIp() {
        return orderIp;
    }

    /**
     * 设置下单IP(客户端IP,从网关中获取)
     *
     * @param orderIp 下单IP(客户端IP,从网关中获取)
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
     * 获取平台收入
     *
     * @return plat_income - 平台收入
     */
    public BigDecimal getPlatIncome() {
        return platIncome;
    }

    /**
     * 设置平台收入
     *
     * @param platIncome 平台收入
     */
    public void setPlatIncome(BigDecimal platIncome) {
        this.platIncome = platIncome;
    }

    /**
     * 获取费率
     *
     * @return fee_rate - 费率
     */
    public BigDecimal getFeeRate() {
        return feeRate;
    }

    /**
     * 设置费率
     *
     * @param feeRate 费率
     */
    public void setFeeRate(BigDecimal feeRate) {
        this.feeRate = feeRate;
    }

    /**
     * 获取平台成本
     *
     * @return plat_cost - 平台成本
     */
    public BigDecimal getPlatCost() {
        return platCost;
    }

    /**
     * 设置平台成本
     *
     * @param platCost 平台成本
     */
    public void setPlatCost(BigDecimal platCost) {
        this.platCost = platCost;
    }

    /**
     * 获取平台利润
     *
     * @return plat_profit - 平台利润
     */
    public BigDecimal getPlatProfit() {
        return platProfit;
    }

    /**
     * 设置平台利润
     *
     * @param platProfit 平台利润
     */
    public void setPlatProfit(BigDecimal platProfit) {
        this.platProfit = platProfit;
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
     * 获取支付成功时间
     *
     * @return pay_success_time - 支付成功时间
     */
    public Date getPaySuccessTime() {
        return paySuccessTime;
    }

    /**
     * 设置支付成功时间
     *
     * @param paySuccessTime 支付成功时间
     */
    public void setPaySuccessTime(Date paySuccessTime) {
        this.paySuccessTime = paySuccessTime;
    }

    /**
     * 获取完成时间
     *
     * @return complete_time - 完成时间
     */
    public Date getCompleteTime() {
        return completeTime;
    }

    /**
     * 设置完成时间
     *
     * @param completeTime 完成时间
     */
    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
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
     * @return bank_return_msg
     */
    public String getBankReturnMsg() {
        return bankReturnMsg;
    }

    /**
     * @param bankReturnMsg
     */
    public void setBankReturnMsg(String bankReturnMsg) {
        this.bankReturnMsg = bankReturnMsg;
    }
}