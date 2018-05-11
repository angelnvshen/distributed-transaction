package own.stu.distributedTransaction.pay.service.user.entity;

import own.stu.distributedTransaction.common.core.utils.StringUtil;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "rp_account")
public class RpAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id = StringUtil.get32UUID();// 主键ID.

    @Column(name = "create_time")
    private Date createTime= new Date();// 创建时间.

    @Column(name = "edit_time")
    private Date editTime;

    private Long version = 0l;// 版本号默认为0

    private String remark;

    @Column(name = "account_no")
    private String accountNo;

    private BigDecimal balance;

    private BigDecimal unbalance;

    @Column(name = "security_money")
    private BigDecimal securityMoney;

    private String status;

    @Column(name = "total_income")
    private BigDecimal totalIncome;

    @Column(name = "total_expend")
    private BigDecimal totalExpend;

    @Column(name = "today_income")
    private BigDecimal todayIncome;

    @Column(name = "today_expend")
    private BigDecimal todayExpend;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "sett_amount")
    private BigDecimal settAmount;

    @Column(name = "user_no")
    private String userNo;

    /************************* just show ************************************/
    private String userName;
    /************************* just show ************************************/

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


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
     * @return unbalance
     */
    public BigDecimal getUnbalance() {
        return unbalance;
    }

    /**
     * @param unbalance
     */
    public void setUnbalance(BigDecimal unbalance) {
        this.unbalance = unbalance;
    }

    /**
     * @return security_money
     */
    public BigDecimal getSecurityMoney() {
        return securityMoney;
    }

    /**
     * @param securityMoney
     */
    public void setSecurityMoney(BigDecimal securityMoney) {
        this.securityMoney = securityMoney;
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

    /**
     * @return total_income
     */
    public BigDecimal getTotalIncome() {
        return totalIncome;
    }

    /**
     * @param totalIncome
     */
    public void setTotalIncome(BigDecimal totalIncome) {
        this.totalIncome = totalIncome;
    }

    /**
     * @return total_expend
     */
    public BigDecimal getTotalExpend() {
        return totalExpend;
    }

    /**
     * @param totalExpend
     */
    public void setTotalExpend(BigDecimal totalExpend) {
        this.totalExpend = totalExpend;
    }

    /**
     * @return today_income
     */
    public BigDecimal getTodayIncome() {
        return todayIncome;
    }

    /**
     * @param todayIncome
     */
    public void setTodayIncome(BigDecimal todayIncome) {
        this.todayIncome = todayIncome;
    }

    /**
     * @return today_expend
     */
    public BigDecimal getTodayExpend() {
        return todayExpend;
    }

    /**
     * @param todayExpend
     */
    public void setTodayExpend(BigDecimal todayExpend) {
        this.todayExpend = todayExpend;
    }

    /**
     * @return account_type
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * @param accountType
     */
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    /**
     * @return sett_amount
     */
    public BigDecimal getSettAmount() {
        return settAmount;
    }

    /**
     * @param settAmount
     */
    public void setSettAmount(BigDecimal settAmount) {
        this.settAmount = settAmount;
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
     * 获取可用余额
     *
     * @return
     */
    public BigDecimal getAvailableBalance() {
        return this.balance.subtract(unbalance);
    }

    /**
     * 获取实际可结算金额
     *
     * @return
     */
    public BigDecimal getAvailableSettAmount() {
        BigDecimal subSettAmount = this.settAmount.subtract(unbalance);
        if (getAvailableBalance().compareTo(subSettAmount) == -1) {
            return getAvailableBalance();
        }
        return subSettAmount;
    }

    /**
     * 验证可用余额是否足够
     *
     * @param amount
     * @return
     */
    public boolean availableBalanceIsEnough(BigDecimal amount) {

        return this.getAvailableBalance().compareTo(amount) >= 0;
    }
}