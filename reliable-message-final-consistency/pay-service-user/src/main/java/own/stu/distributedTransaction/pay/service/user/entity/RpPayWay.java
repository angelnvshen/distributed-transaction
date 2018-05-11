package own.stu.distributedTransaction.pay.service.user.entity;

import own.stu.distributedTransaction.common.core.utils.StringUtil;

import java.util.Date;
import javax.persistence.*;

@Table(name = "rp_pay_way")
public class RpPayWay {
    /**
     * ID
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id = StringUtil.get32UUID();// 主键ID.

    /**
     * version
     */
    private Long version = 0l;// 版本号默认为0

    /**
     * 创建时间
     */
    @Column(name = "create_time")
   private Date createTime= new Date();// 创建时间.;

    /**
     * 修改时间
     */
    @Column(name = "edit_time")
    private Date editTime;

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
     * 支付类型编号
     */
    @Column(name = "pay_type_code")
    private String payTypeCode;

    /**
     * 支付类型名称
     */
    @Column(name = "pay_type_name")
    private String payTypeName;

    /**
     * 支付产品编号
     */
    @Column(name = "pay_product_code")
    private String payProductCode;

    /**
     * 状态(100:正常状态,101非正常状态)
     */
    private String status;

    /**
     * 排序(倒序排序,默认值1000)
     */
    private Integer sorts;

    /**
     * 商户支付费率
     */
    @Column(name = "pay_rate")
    private Double payRate;

    /**
     * 获取ID
     *
     * @return ID - ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取version
     *
     * @return version - version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * 设置version
     *
     * @param version version
     */
    public void setVersion(Long version) {
        this.version = version;
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
     * 获取修改时间
     *
     * @return edit_time - 修改时间
     */
    public Date getEditTime() {
        return editTime;
    }

    /**
     * 设置修改时间
     *
     * @param editTime 修改时间
     */
    public void setEditTime(Date editTime) {
        this.editTime = editTime;
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

    /**
     * 获取支付类型编号
     *
     * @return pay_type_code - 支付类型编号
     */
    public String getPayTypeCode() {
        return payTypeCode;
    }

    /**
     * 设置支付类型编号
     *
     * @param payTypeCode 支付类型编号
     */
    public void setPayTypeCode(String payTypeCode) {
        this.payTypeCode = payTypeCode;
    }

    /**
     * 获取支付类型名称
     *
     * @return pay_type_name - 支付类型名称
     */
    public String getPayTypeName() {
        return payTypeName;
    }

    /**
     * 设置支付类型名称
     *
     * @param payTypeName 支付类型名称
     */
    public void setPayTypeName(String payTypeName) {
        this.payTypeName = payTypeName;
    }

    /**
     * 获取支付产品编号
     *
     * @return pay_product_code - 支付产品编号
     */
    public String getPayProductCode() {
        return payProductCode;
    }

    /**
     * 设置支付产品编号
     *
     * @param payProductCode 支付产品编号
     */
    public void setPayProductCode(String payProductCode) {
        this.payProductCode = payProductCode;
    }

    /**
     * 获取状态(100:正常状态,101非正常状态)
     *
     * @return status - 状态(100:正常状态,101非正常状态)
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置状态(100:正常状态,101非正常状态)
     *
     * @param status 状态(100:正常状态,101非正常状态)
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取排序(倒序排序,默认值1000)
     *
     * @return sorts - 排序(倒序排序,默认值1000)
     */
    public Integer getSorts() {
        return sorts;
    }

    /**
     * 设置排序(倒序排序,默认值1000)
     *
     * @param sorts 排序(倒序排序,默认值1000)
     */
    public void setSorts(Integer sorts) {
        this.sorts = sorts;
    }

    /**
     * 获取商户支付费率
     *
     * @return pay_rate - 商户支付费率
     */
    public Double getPayRate() {
        return payRate;
    }

    /**
     * 设置商户支付费率
     *
     * @param payRate 商户支付费率
     */
    public void setPayRate(Double payRate) {
        this.payRate = payRate;
    }
}