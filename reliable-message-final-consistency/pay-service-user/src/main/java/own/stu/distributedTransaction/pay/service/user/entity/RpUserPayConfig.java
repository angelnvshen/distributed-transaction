package own.stu.distributedTransaction.pay.service.user.entity;

import own.stu.distributedTransaction.common.core.enums.PublicEnum;
import own.stu.distributedTransaction.common.core.utils.StringUtil;
import own.stu.distributedTransaction.pay.service.user.enums.FundInfoTypeEnum;

import java.util.Date;
import javax.persistence.*;

@Table(name = "rp_user_pay_config")
public class RpUserPayConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id = StringUtil.get32UUID();// 主键ID.

    @Column(name = "create_time")
   private Date createTime= new Date();// 创建时间.;

    @Column(name = "edit_time")
    private Date editTime;

    private Long version = 0l;// 版本号默认为0

    private String remark;

    private String status;

    @Column(name = "audit_status")
    private String auditStatus;

    @Column(name = "is_auto_sett")
    private String isAutoSett;

    /**
     * 支付产品编号
     */
    @Column(name = "product_code")
    private String productCode;

    /**
     * 支付产品名称
     */
    @Column(name = "product_name")
    private String productName;

    @Column(name = "user_no")
    private String userNo;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "risk_day")
    private Integer riskDay;

    @Column(name = "pay_key")
    private String payKey;

    @Column(name = "fund_into_type")
    private String fundIntoType;

    @Column(name = "pay_secret")
    private String paySecret;

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
     * @return audit_status
     */
    public String getAuditStatus() {
        return auditStatus;
    }

    /**
     * @param auditStatus
     */
    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * @return is_auto_sett
     */
    public String getIsAutoSett() {
        return isAutoSett;
    }

    /**
     * @param isAutoSett
     */
    public void setIsAutoSett(String isAutoSett) {
        this.isAutoSett = isAutoSett;
    }

    /**
     * 获取支付产品编号
     *
     * @return product_code - 支付产品编号
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * 设置支付产品编号
     *
     * @param productCode 支付产品编号
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     * 获取支付产品名称
     *
     * @return product_name - 支付产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置支付产品名称
     *
     * @param productName 支付产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
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
     * @return user_name
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
     * @return pay_key
     */
    public String getPayKey() {
        return payKey;
    }

    /**
     * @param payKey
     */
    public void setPayKey(String payKey) {
        this.payKey = payKey;
    }

    /**
     * @return fund_into_type
     */
    public String getFundIntoType() {
        return fundIntoType;
    }

    /**
     * @param fundIntoType
     */
    public void setFundIntoType(String fundIntoType) {
        this.fundIntoType = fundIntoType;
    }

    /**
     * @return pay_secret
     */
    public String getPaySecret() {
        return paySecret;
    }

    /**
     * @param paySecret
     */
    public void setPaySecret(String paySecret) {
        this.paySecret = paySecret;
    }

    public String getAuditStatusDesc() {
        return PublicEnum.getEnum(this.getAuditStatus()).getDesc();
    }

    public String getFundIntoTypeDesc() {
        return FundInfoTypeEnum.getEnum(this.getFundIntoType()).getDesc();
    }
}