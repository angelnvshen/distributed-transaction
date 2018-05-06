package own.stu.distributedTransaction.pay.service.accounting.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "rp_accounting_voucher")
public class RpAccountingVoucher {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 最后修改时间
     */
    @Column(name = "edit_time")
    private Date editTime;

    /**
     * 会计分录类型
     */
    @Column(name = "entry_type")
    private Integer entryType;

    /**
     * 请求号
     */
    @Column(name = "request_no")
    private String requestNo;

    /**
     * 来源系统
     */
    @Column(name = "from_system")
    private Integer fromSystem;

    /**
     * 原始凭证号
     */
    @Column(name = "voucher_no")
    private String voucherNo;

    /**
     * 会计日期
     */
    @Column(name = "accounting_date")
    private Date accountingDate;

    /**
     * 平台银行帐户变动金额
     */
    @Column(name = "bank_change_amount")
    private BigDecimal bankChangeAmount;

    /**
     * 付款方账号
     */
    @Column(name = "payer_account_no")
    private String payerAccountNo;

    /**
     * 收款方账号
     */
    @Column(name = "receiver_account_no")
    private String receiverAccountNo;

    /**
     * 银行账户
     */
    @Column(name = "bank_account")
    private String bankAccount;

    /**
     * 银行渠道编码
     */
    @Column(name = "bank_channel_code")
    private String bankChannelCode;

    /**
     * 付款方账户变动金额
     */
    @Column(name = "payer_change_amount")
    private BigDecimal payerChangeAmount;

    /**
     * 收款方账户变动金额
     */
    @Column(name = "receiver_change_amount")
    private BigDecimal receiverChangeAmount;

    /**
     * 利润
     */
    private BigDecimal profit;

    /**
     * 收入
     */
    private BigDecimal income;

    /**
     * 成本
     */
    private BigDecimal cost;

    /**
     * 备注
     */
    private String remark;

    /**
     * 银行订单号
     */
    @Column(name = "bank_order_no")
    private String bankOrderNo;

    /**
     * 付款方帐户类型
     */
    @Column(name = "payer_account_type")
    private Integer payerAccountType;

    /**
     * 支付金额
     */
    @Column(name = "pay_amount")
    private BigDecimal payAmount;

    /**
     * 收款方帐户类型
     */
    @Column(name = "receiver_account_type")
    private Integer receiverAccountType;

    /**
     * 收款方手续费
     */
    @Column(name = "receiver_fee")
    private BigDecimal receiverFee;

    /**
     * 付款方手续费
     */
    @Column(name = "payer_fee")
    private BigDecimal payerFee;

    /** 分录步骤，1：产生交易 2：清算对账 */
    private Integer step; // 非数据库映射字段，只用于传参

    private String messageId; // 非数据库映射字段，只用于传参

    public Integer getStep() {
        return step;
    }

    public void setStep(Integer step) {
        this.step = step;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取最后修改时间
     *
     * @return edit_time - 最后修改时间
     */
    public Date getEditTime() {
        return editTime;
    }

    /**
     * 设置最后修改时间
     *
     * @param editTime 最后修改时间
     */
    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    /**
     * 获取会计分录类型
     *
     * @return entry_type - 会计分录类型
     */
    public Integer getEntryType() {
        return entryType;
    }

    /**
     * 设置会计分录类型
     *
     * @param entryType 会计分录类型
     */
    public void setEntryType(Integer entryType) {
        this.entryType = entryType;
    }

    /**
     * 获取请求号
     *
     * @return request_no - 请求号
     */
    public String getRequestNo() {
        return requestNo;
    }

    /**
     * 设置请求号
     *
     * @param requestNo 请求号
     */
    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    /**
     * 获取来源系统
     *
     * @return from_system - 来源系统
     */
    public Integer getFromSystem() {
        return fromSystem;
    }

    /**
     * 设置来源系统
     *
     * @param fromSystem 来源系统
     */
    public void setFromSystem(Integer fromSystem) {
        this.fromSystem = fromSystem;
    }

    /**
     * 获取原始凭证号
     *
     * @return voucher_no - 原始凭证号
     */
    public String getVoucherNo() {
        return voucherNo;
    }

    /**
     * 设置原始凭证号
     *
     * @param voucherNo 原始凭证号
     */
    public void setVoucherNo(String voucherNo) {
        this.voucherNo = voucherNo;
    }

    /**
     * 获取会计日期
     *
     * @return accounting_date - 会计日期
     */
    public Date getAccountingDate() {
        return accountingDate;
    }

    /**
     * 设置会计日期
     *
     * @param accountingDate 会计日期
     */
    public void setAccountingDate(Date accountingDate) {
        this.accountingDate = accountingDate;
    }

    /**
     * 获取平台银行帐户变动金额
     *
     * @return bank_change_amount - 平台银行帐户变动金额
     */
    public BigDecimal getBankChangeAmount() {
        return bankChangeAmount;
    }

    /**
     * 设置平台银行帐户变动金额
     *
     * @param bankChangeAmount 平台银行帐户变动金额
     */
    public void setBankChangeAmount(BigDecimal bankChangeAmount) {
        this.bankChangeAmount = bankChangeAmount;
    }

    /**
     * 获取付款方账号
     *
     * @return payer_account_no - 付款方账号
     */
    public String getPayerAccountNo() {
        return payerAccountNo;
    }

    /**
     * 设置付款方账号
     *
     * @param payerAccountNo 付款方账号
     */
    public void setPayerAccountNo(String payerAccountNo) {
        this.payerAccountNo = payerAccountNo;
    }

    /**
     * 获取收款方账号
     *
     * @return receiver_account_no - 收款方账号
     */
    public String getReceiverAccountNo() {
        return receiverAccountNo;
    }

    /**
     * 设置收款方账号
     *
     * @param receiverAccountNo 收款方账号
     */
    public void setReceiverAccountNo(String receiverAccountNo) {
        this.receiverAccountNo = receiverAccountNo;
    }

    /**
     * 获取银行账户
     *
     * @return bank_account - 银行账户
     */
    public String getBankAccount() {
        return bankAccount;
    }

    /**
     * 设置银行账户
     *
     * @param bankAccount 银行账户
     */
    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    /**
     * 获取银行渠道编码
     *
     * @return bank_channel_code - 银行渠道编码
     */
    public String getBankChannelCode() {
        return bankChannelCode;
    }

    /**
     * 设置银行渠道编码
     *
     * @param bankChannelCode 银行渠道编码
     */
    public void setBankChannelCode(String bankChannelCode) {
        this.bankChannelCode = bankChannelCode;
    }

    /**
     * 获取付款方账户变动金额
     *
     * @return payer_change_amount - 付款方账户变动金额
     */
    public BigDecimal getPayerChangeAmount() {
        return payerChangeAmount;
    }

    /**
     * 设置付款方账户变动金额
     *
     * @param payerChangeAmount 付款方账户变动金额
     */
    public void setPayerChangeAmount(BigDecimal payerChangeAmount) {
        this.payerChangeAmount = payerChangeAmount;
    }

    /**
     * 获取收款方账户变动金额
     *
     * @return receiver_change_amount - 收款方账户变动金额
     */
    public BigDecimal getReceiverChangeAmount() {
        return receiverChangeAmount;
    }

    /**
     * 设置收款方账户变动金额
     *
     * @param receiverChangeAmount 收款方账户变动金额
     */
    public void setReceiverChangeAmount(BigDecimal receiverChangeAmount) {
        this.receiverChangeAmount = receiverChangeAmount;
    }

    /**
     * 获取利润
     *
     * @return profit - 利润
     */
    public BigDecimal getProfit() {
        return profit;
    }

    /**
     * 设置利润
     *
     * @param profit 利润
     */
    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    /**
     * 获取收入
     *
     * @return income - 收入
     */
    public BigDecimal getIncome() {
        return income;
    }

    /**
     * 设置收入
     *
     * @param income 收入
     */
    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    /**
     * 获取成本
     *
     * @return cost - 成本
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * 设置成本
     *
     * @param cost 成本
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
     * 获取付款方帐户类型
     *
     * @return payer_account_type - 付款方帐户类型
     */
    public Integer getPayerAccountType() {
        return payerAccountType;
    }

    /**
     * 设置付款方帐户类型
     *
     * @param payerAccountType 付款方帐户类型
     */
    public void setPayerAccountType(Integer payerAccountType) {
        this.payerAccountType = payerAccountType;
    }

    /**
     * 获取支付金额
     *
     * @return pay_amount - 支付金额
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * 设置支付金额
     *
     * @param payAmount 支付金额
     */
    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 获取收款方帐户类型
     *
     * @return receiver_account_type - 收款方帐户类型
     */
    public Integer getReceiverAccountType() {
        return receiverAccountType;
    }

    /**
     * 设置收款方帐户类型
     *
     * @param receiverAccountType 收款方帐户类型
     */
    public void setReceiverAccountType(Integer receiverAccountType) {
        this.receiverAccountType = receiverAccountType;
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
}