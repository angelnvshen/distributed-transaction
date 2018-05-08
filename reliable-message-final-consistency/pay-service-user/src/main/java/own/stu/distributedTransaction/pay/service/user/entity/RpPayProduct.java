package own.stu.distributedTransaction.pay.service.user.entity;

import own.stu.distributedTransaction.common.core.enums.PublicEnum;
import own.stu.distributedTransaction.common.core.utils.StringUtil;

import java.util.Date;
import javax.persistence.*;

@Table(name = "rp_pay_product")
public class RpPayProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id = StringUtil.get32UUID();// 主键ID.

    @Column(name = "create_time")
    private Date createTime;

    @Column(name = "edit_time")
    private Date editTime;

    private Long version;

    private String status;

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

    @Column(name = "audit_status")
    private String auditStatus;

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

    public String getAuditStatusDesc() {
        return PublicEnum.getEnum(this.getAuditStatus()).getDesc();
    }
}