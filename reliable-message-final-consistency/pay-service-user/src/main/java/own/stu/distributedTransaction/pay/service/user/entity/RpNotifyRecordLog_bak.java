
package own.stu.distributedTransaction.pay.service.user.entity;

import own.stu.distributedTransaction.common.core.entity.BaseEntity;

import java.io.Serializable;
import java.util.Date;

/**
 * @功能说明:
 * @创建者:
 * @创建时间: 16/6/2  上午11:25
 * @公司名称:
 * @版本:
 */
public class RpNotifyRecordLog_bak extends BaseEntity implements Serializable{
    /**
     *
     */
    private static final long serialVersionUID = 459406550725396000L;

    /** 通知记录ID **/
    private String notifyId;

    /** 请求信息 **/
    private String request;

    /** 返回信息 **/
    private String response;

    /** 商户编号 **/
    private String merchantNo;

    /** 商户订单号 **/
    private String merchantOrderNo;

    /** HTTP状态 **/
    private Integer httpStatus;

    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public RpNotifyRecordLog_bak() {
        super();
    }

    public RpNotifyRecordLog_bak(Date createTime, String notifyId, String request, String response, String merchantNo, String merchantOrderNo, Integer httpStatus) {
        super();
        this.createTime = createTime;
        this.notifyId = notifyId;
        this.request = request;
        this.response = response;
        this.merchantNo = merchantNo;
        this.merchantOrderNo = merchantOrderNo;
        this.httpStatus = httpStatus;
    }

    /** 通知记录ID **/
    public String getNotifyId() {
        return notifyId;
    }

    /** 通知记录ID **/
    public void setNotifyId(String notifyId) {
        this.notifyId = notifyId;
    }

    /** 请求信息 **/
    public String getRequest() {
        return request;
    }

    /** 请求信息 **/
    public void setRequest(String request) {
        this.request = request == null ? null : request.trim();
    }

    /** 返回信息 **/
    public String getResponse() {
        return response;
    }

    /** 返回信息 **/
    public void setResponse(String response) {
        this.response = response == null ? null : response.trim();
    }

    /** 商户编号 **/
    public String getMerchantNo() {
        return merchantNo;
    }

    /** 商户编号 **/
    public void setMerchantNo(String merchantNo) {
        this.merchantNo = merchantNo == null ? null : merchantNo.trim();
    }

    /** 商户订单号 **/
    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    /** 商户订单号 **/
    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo == null ? null : merchantOrderNo.trim();
    }

    /** HTTP状态 **/
    public Integer getHttpStatus() {
        return httpStatus;
    }

    /** HTTP状态 **/
    public void setHttpStatus(Integer httpStatus) {
        this.httpStatus = httpStatus;
    }

}
