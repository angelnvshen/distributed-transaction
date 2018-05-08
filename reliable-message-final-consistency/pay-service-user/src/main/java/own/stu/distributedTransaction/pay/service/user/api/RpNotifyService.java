
package own.stu.distributedTransaction.pay.service.user.api;

import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.pay.service.user.entity.RpNotifyRecord;
import own.stu.distributedTransaction.pay.service.user.entity.RpNotifyRecordLog;
import own.stu.distributedTransaction.pay.service.user.entity.RpNotifyRecordLog_bak;
import own.stu.distributedTransaction.pay.service.user.exceptions.NotifyBizException;

import java.util.Map;

/**
 * @功能说明:
 * @创建者:
 * @创建时间: 16/6/2  上午10:41
 * @公司名称:
 * @版本:
 */


public interface RpNotifyService {

    /**
     * 发送消息通知
     * @param notifyUrl 通知地址
     * @param merchantOrderNo   商户订单号
     * @param merchantNo    商户编号
     */
    public void notifySend(String notifyUrl, String merchantOrderNo, String merchantNo) throws NotifyBizException;


    /**
     * 通过ID获取通知记录
     * @param id
     * @return
     */
    public RpNotifyRecord getNotifyRecordById(String id) throws NotifyBizException;

    /**
     * 根据商户编号,商户订单号,通知类型获取通知记录
     * @param merchantNo    商户编号
     * @param merchantOrderNo   商户订单号
     * @param notifyType    消息类型
     * @return
     */
    public RpNotifyRecord getNotifyByMerchantNoAndMerchantOrderNoAndNotifyType(String merchantNo, String merchantOrderNo, String notifyType) throws NotifyBizException;


    public PageBean<RpNotifyRecord> queryNotifyRecordListPage(PageParam pageParam, Map<String, Object> paramMap) throws NotifyBizException;
    /**
     * 创建消息通知
     * @param rpNotifyRecord
     */
    public long createNotifyRecord(RpNotifyRecord rpNotifyRecord) throws NotifyBizException;

    /**
     * 修改消息通知
     * @param rpNotifyRecord
     */
    public void updateNotifyRecord(RpNotifyRecord rpNotifyRecord) throws NotifyBizException;

    /**
     * 创建消息通知记录
     * @param rpNotifyRecordLog
     * @return
     */
    public long createNotifyRecordLog(RpNotifyRecordLog rpNotifyRecordLog) throws NotifyBizException;

}
