package own.stu.distributedTransaction.pay.service.user.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "rp_user_pay_info")
public class RpUserPayInfo {
    @Id
    @Column(name = "id_")
    private String id;

    @Column(name = "create_time")
   private Date createTime= new Date();// 创建时间.;

    @Column(name = "edit_time")
    private Date editTime;

    private Long version = 0l;// 版本号默认为0

    private String remark;

    private String status;

    @Column(name = "app_id")
    private String appId;

    @Column(name = "app_sectet")
    private String appSectet;

    @Column(name = "merchant_id")
    private String merchantId;

    @Column(name = "app_type")
    private String appType;

    @Column(name = "user_no")
    private String userNo;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "partner_key")
    private String partnerKey;

    /**
     * 支付方式编号
     */
    @Column(name = "pay_way_code")
    private String payWayCode;

    /**
     * 支付方式名称
     */
    @Column(name = "pay_way_name")
    private String payWayName;

    /**
     * @return id_
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
     * @return app_id
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * @return app_sectet
     */
    public String getAppSectet() {
        return appSectet;
    }

    /**
     * @param appSectet
     */
    public void setAppSectet(String appSectet) {
        this.appSectet = appSectet;
    }

    /**
     * @return merchant_id
     */
    public String getMerchantId() {
        return merchantId;
    }

    /**
     * @param merchantId
     */
    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    /**
     * @return app_type
     */
    public String getAppType() {
        return appType;
    }

    /**
     * @param appType
     */
    public void setAppType(String appType) {
        this.appType = appType;
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
     * @return partner_key
     */
    public String getPartnerKey() {
        return partnerKey;
    }

    /**
     * @param partnerKey
     */
    public void setPartnerKey(String partnerKey) {
        this.partnerKey = partnerKey;
    }

    /**
     * 获取支付方式编号
     *
     * @return pay_way_code - 支付方式编号
     */
    public String getPayWayCode() {
        return payWayCode;
    }

    /**
     * 设置支付方式编号
     *
     * @param payWayCode 支付方式编号
     */
    public void setPayWayCode(String payWayCode) {
        this.payWayCode = payWayCode;
    }

    /**
     * 获取支付方式名称
     *
     * @return pay_way_name - 支付方式名称
     */
    public String getPayWayName() {
        return payWayName;
    }

    /**
     * 设置支付方式名称
     *
     * @param payWayName 支付方式名称
     */
    public void setPayWayName(String payWayName) {
        this.payWayName = payWayName;
    }
}