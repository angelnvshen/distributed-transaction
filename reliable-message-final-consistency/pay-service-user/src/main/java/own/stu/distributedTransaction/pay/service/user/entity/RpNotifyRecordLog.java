package own.stu.distributedTransaction.pay.service.user.entity;

import own.stu.distributedTransaction.common.core.utils.StringUtil;

import javax.persistence.*;
import java.util.Date;

@Table(name = "rp_notify_record_log")
public class RpNotifyRecordLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id = StringUtil.get32UUID();// 主键ID.

    private Integer version = 0;

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

    @Column(name = "create_time")
   private Date createTime= new Date();// 创建时间.;

    @Column(name = "notify_id")
    private String notifyId;

    private String request;

    private String response;

    @Column(name = "merchant_no")
    private String merchantNo;

    /**
     * 商户订单号
     */
    @Column(name = "merchant_order_no")
    private String merchantOrderNo;

    /**
     * HTTP状态
     */
    @Column(name = "http_status")
    private String httpStatus;

    public RpNotifyRecordLog() {
    }

    public RpNotifyRecordLog(Date createTime, String notifyId, String request, String response, String merchantNo, String merchantOrderNo, String httpStatus){
        super();
        this.createTime = createTime;
        this.notifyId = notifyId;
        this.request = request;
        this.response = response;
        this.merchantNo = merchantNo;
        this.merchantOrderNo = merchantOrderNo;
        this.httpStatus = httpStatus;
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
     * @return notify_id
     */
    public String getNotifyId() {
        return notifyId;
    }

    /**
     * @param notifyId
     */
    public void setNotifyId(String notifyId) {
        this.notifyId = notifyId;
    }

    /**
     * @return request
     */
    public String getRequest() {
        return request;
    }

    /**
     * @param request
     */
    public void setRequest(String request) {
        this.request = request;
    }

    /**
     * @return response
     */
    public String getResponse() {
        return response;
    }

    /**
     * @param response
     */
    public void setResponse(String response) {
        this.response = response;
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
     * 获取HTTP状态
     *
     * @return http_status - HTTP状态
     */
    public String getHttpStatus() {
        return httpStatus;
    }

    /**
     * 设置HTTP状态
     *
     * @param httpStatus HTTP状态
     */
    public void setHttpStatus(String httpStatus) {
        this.httpStatus = httpStatus;
    }
}