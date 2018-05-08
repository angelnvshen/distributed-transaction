package own.stu.distributedTransaction.pay.service.user.entity;

import own.stu.distributedTransaction.common.core.utils.StringUtil;
import own.stu.distributedTransaction.pay.service.user.enums.NotifyStatusEnum;
import own.stu.distributedTransaction.pay.service.user.enums.NotifyTypeEnum;

import java.util.Date;
import javax.persistence.*;

@Table(name = "rp_notify_record")
public class RpNotifyRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id = StringUtil.get32UUID();// 主键ID.

    private Integer version;

    @Column(name = "create_time")
    private Date createTime;

    /**
     * 修改者
     */
    private String editor;

    /**
     * 创建者
     */
    private String creater;

    /**
     * 最后修改时间
     */
    @Column(name = "edit_time")
    private Date editTime;

    /** 最后一次通知时间 **/
    private Date lastNotifyTime;

    @Column(name = "notify_times")
    private Integer notifyTimes;

    @Column(name = "limit_notify_times")
    private Integer limitNotifyTimes;

    private String url;

    @Column(name = "merchant_order_no")
    private String merchantOrderNo;

    @Column(name = "merchant_no")
    private String merchantNo;

    /**
     * 100:成功 101:失败
     */
    private String status;

    /**
     * 通知类型
     */
    @Column(name = "notify_type")
    private String notifyType;

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
     * @return version
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * @param version
     */
    public void setVersion(Integer version) {
        this.version = version;
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
     * 获取修改者
     *
     * @return editor - 修改者
     */
    public String getEditor() {
        return editor;
    }

    /**
     * 设置修改者
     *
     * @param editor 修改者
     */
    public void setEditor(String editor) {
        this.editor = editor;
    }

    /**
     * 获取创建者
     *
     * @return creater - 创建者
     */
    public String getCreater() {
        return creater;
    }

    /**
     * 设置创建者
     *
     * @param creater 创建者
     */
    public void setCreater(String creater) {
        this.creater = creater;
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
     * @return notify_times
     */
    public Integer getNotifyTimes() {
        return notifyTimes;
    }

    /**
     * @param notifyTimes
     */
    public void setNotifyTimes(Integer notifyTimes) {
        this.notifyTimes = notifyTimes;
    }

    /**
     * @return limit_notify_times
     */
    public Integer getLimitNotifyTimes() {
        return limitNotifyTimes;
    }

    /**
     * @param limitNotifyTimes
     */
    public void setLimitNotifyTimes(Integer limitNotifyTimes) {
        this.limitNotifyTimes = limitNotifyTimes;
    }

    /**
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return merchant_order_no
     */
    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    /**
     * @param merchantOrderNo
     */
    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    /**
     * @return merchant_no
     */
    public String getMerchantNo() {
        return merchantNo;
    }

    /**
     * @param merchantNo
     */
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo;
    }

    /**
     * 获取100:成功 101:失败
     *
     * @return status - 100:成功 101:失败
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置100:成功 101:失败
     *
     * @param status 100:成功 101:失败
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取通知类型
     *
     * @return notify_type - 通知类型
     */
    public String getNotifyType() {
        return notifyType;
    }

    /**
     * 设置通知类型
     *
     * @param notifyType 通知类型
     */
    public void setNotifyType(String notifyType) {
        this.notifyType = notifyType;
    }

    public Date getLastNotifyTime() {
        return lastNotifyTime;
    }

    public void setLastNotifyTime(Date lastNotifyTime) {
        this.lastNotifyTime = lastNotifyTime;
    }

    public RpNotifyRecord() {

    }

    public RpNotifyRecord(Date createTime, Date lastNotifyTime, Integer notifyTimes, Integer limitNotifyTimes, String url,
                          String  merchantNo, String merchantOrderNo, NotifyStatusEnum status, NotifyTypeEnum type) {
        this.createTime = createTime;
        this.lastNotifyTime = lastNotifyTime;
        this.notifyTimes = notifyTimes;
        this.limitNotifyTimes = limitNotifyTimes;
        this.url = url;
        this.merchantNo = merchantNo;
        this.merchantOrderNo = merchantOrderNo;
        this.notifyType = type.name();
        this.setStatus(status.name());
    }
}