package own.stu.distributedTransaction.pay.service.user.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;
import own.stu.distributedTransaction.common.core.entity.BaseEntity;
import own.stu.distributedTransaction.common.core.utils.StringUtil;

@Table(name = "rp_account_history")
public class RpAccountHistory implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id = StringUtil.get32UUID();;

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "edit_time")
    private Date editTime;

    private Long version;

    private String remark;

    @Column(name = "account_no")
    private String accountNo;

    private BigDecimal amount;

    private BigDecimal balance;

    @Column(name = "fund_direction")
    private String fundDirection;

    @Column(name = "is_allow_sett")
    private String isAllowSett;

    @Column(name = "is_complete_sett")
    private String isCompleteSett;

    @Column(name = "request_no")
    private String requestNo;

    @Column(name = "bank_trx_no")
    private String bankTrxNo;

    @Column(name = "trx_type")
    private String trxType;

    @Column(name = "risk_day")
    private Integer riskDay;

    @Column(name = "user_no")
    private String userNo;

    private String status;

    /**
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return create_time
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return edit_time
     */
    public Date getEditTime() {
        return editTime;
    }

    /**
     * @param editTime
     */
    public void setEditTime(Date editTime) {
        this.editTime = editTime;
    }

    /**
     * @return version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return account_no
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * @param accountNo
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * @return amount
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @param amount
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * @return balance
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * @param balance
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * @return fund_direction
     */
    public String getFundDirection() {
        return fundDirection;
    }

    /**
     * @param fundDirection
     */
    public void setFundDirection(String fundDirection) {
        this.fundDirection = fundDirection;
    }

    /**
     * @return is_allow_sett
     */
    public String getIsAllowSett() {
        return isAllowSett;
    }

    /**
     * @param isAllowSett
     */
    public void setIsAllowSett(String isAllowSett) {
        this.isAllowSett = isAllowSett;
    }

    /**
     * @return is_complete_sett
     */
    public String getIsCompleteSett() {
        return isCompleteSett;
    }

    /**
     * @param isCompleteSett
     */
    public void setIsCompleteSett(String isCompleteSett) {
        this.isCompleteSett = isCompleteSett;
    }

    /**
     * @return request_no
     */
    public String getRequestNo() {
        return requestNo;
    }

    /**
     * @param requestNo
     */
    public void setRequestNo(String requestNo) {
        this.requestNo = requestNo;
    }

    /**
     * @return bank_trx_no
     */
    public String getBankTrxNo() {
        return bankTrxNo;
    }

    /**
     * @param bankTrxNo
     */
    public void setBankTrxNo(String bankTrxNo) {
        this.bankTrxNo = bankTrxNo;
    }

    /**
     * @return trx_type
     */
    public String getTrxType() {
        return trxType;
    }

    /**
     * @param trxType
     */
    public void setTrxType(String trxType) {
        this.trxType = trxType;
    }

    /**
     * @return risk_day
     */
    public Integer getRiskDay() {
        return riskDay;
    }

    /**
     * @param riskDay
     */
    public void setRiskDay(Integer riskDay) {
        this.riskDay = riskDay;
    }

    /**
     * @return user_no
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * @param userNo
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    /**
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }
}