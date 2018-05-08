
package own.stu.distributedTransaction.pay.service.user.api.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.pay.service.user.api.RpNotifyService;
import own.stu.distributedTransaction.pay.service.user.dao.RpNotifyRecordLogMapper;
import own.stu.distributedTransaction.pay.service.user.dao.RpNotifyRecordMapper;
import own.stu.distributedTransaction.pay.service.user.entity.RpNotifyRecord;
import own.stu.distributedTransaction.pay.service.user.entity.RpNotifyRecordLog;
import own.stu.distributedTransaction.pay.service.user.enums.NotifyStatusEnum;
import own.stu.distributedTransaction.pay.service.user.enums.NotifyTypeEnum;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @功能说明:
 * @创建者:
 * @创建时间: 16/6/2  上午10:42
 * @公司名称:
 * @版本:
 */
@Service
public class RpNotifyServiceImpl implements RpNotifyService {

    @Autowired
    private JmsTemplate notifyJmsTemplate;

    @Autowired
    //private RpNotifyRecordDao rpNotifyRecordDao;
    private RpNotifyRecordMapper rpNotifyRecordDao;

    @Autowired
    //private RpNotifyRecordLogDao rpNotifyRecordLogDao;
    private RpNotifyRecordLogMapper rpNotifyRecordLogDao;

    /**
     * 发送消息通知
     *
     * @param notifyUrl       通知地址
     * @param merchantOrderNo 商户订单号
     * @param merchantNo      商户编号
     */
    @Override
    public void notifySend(String notifyUrl, String merchantOrderNo, String merchantNo) {

        RpNotifyRecord record = new RpNotifyRecord();
        record.setNotifyTimes(0);
        record.setLimitNotifyTimes(5);
        record.setStatus(NotifyStatusEnum.CREATED.name());
        record.setUrl(notifyUrl);
        record.setMerchantOrderNo(merchantOrderNo);
        record.setMerchantNo(merchantNo);
        record.setNotifyType(NotifyTypeEnum.MERCHANT.name());

        Object toJSON = JSONObject.toJSON(record);
        final String str = toJSON.toString();

        notifyJmsTemplate.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage(str);
            }
        });
    }

    /**
     * 通过ID获取通知记录
     *
     * @param id
     * @return
     */
    @Override
    public RpNotifyRecord getNotifyRecordById(String id) {
        return rpNotifyRecordDao.selectByPrimaryKey(id);
    }

    /**
     * 根据商户编号,商户订单号,通知类型获取通知记录
     *
     * @param merchantNo      商户编号
     * @param merchantOrderNo 商户订单号
     * @param notifyType      消息类型
     * @return
     */
    @Override
    public RpNotifyRecord getNotifyByMerchantNoAndMerchantOrderNoAndNotifyType(String merchantNo, String merchantOrderNo, String notifyType) {

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("merchantNo", merchantNo);
        paramMap.put("merchantOrderNo", merchantOrderNo);
        paramMap.put("notifyType", notifyType);
        List<RpNotifyRecord> list = rpNotifyRecordDao.listPage(paramMap);
        return list.get(0);
    }

    @Override
    public PageBean<RpNotifyRecord> queryNotifyRecordListPage(PageParam pageParam, Map<String, Object> paramMap) {

        PageHelper.startPage(pageParam.getPageNum(), pageParam.getNumPerPage());
        List<RpNotifyRecord> list = rpNotifyRecordDao.listPage(paramMap);
        PageInfo info = new PageInfo<RpNotifyRecord>(list);

        return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), (int) info.getTotal(), info.getList());
    }

    /**
     * 创建消息通知
     *
     * @param rpNotifyRecord
     */
    @Override
    public long createNotifyRecord(RpNotifyRecord rpNotifyRecord) {
        return rpNotifyRecordDao.insert(rpNotifyRecord);
    }

    /**
     * 修改消息通知
     *
     * @param rpNotifyRecord
     */
    @Override
    public void updateNotifyRecord(RpNotifyRecord rpNotifyRecord) {
        rpNotifyRecordDao.updateByPrimaryKeySelective(rpNotifyRecord);
    }

    /**
     * 创建消息通知记录
     *
     * @param rpNotifyRecordLog
     * @return
     */
    @Override
    public long createNotifyRecordLog(RpNotifyRecordLog rpNotifyRecordLog) {
        return rpNotifyRecordLogDao.insert(rpNotifyRecordLog);
    }


}
