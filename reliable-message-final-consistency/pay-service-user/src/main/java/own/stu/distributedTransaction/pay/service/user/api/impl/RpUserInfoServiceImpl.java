
package own.stu.distributedTransaction.pay.service.user.api.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import own.stu.distributedTransaction.common.core.enums.PublicStatusEnum;
import own.stu.distributedTransaction.common.core.exception.BizException;
import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.common.core.service.impl.BaseService;
import own.stu.distributedTransaction.common.core.utils.DateUtils;
import own.stu.distributedTransaction.common.core.utils.StringUtil;
import own.stu.distributedTransaction.pay.service.user.api.RpAccountService;
import own.stu.distributedTransaction.pay.service.user.api.RpUserInfoService;
import own.stu.distributedTransaction.pay.service.user.dao.RpUserInfoMapper;
import own.stu.distributedTransaction.pay.service.user.entity.RpAccount;
import own.stu.distributedTransaction.pay.service.user.entity.RpUserInfo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @类功能说明： 用户信息service实现类
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：zh
 * @创建时间：2019-5-18 上午11:14:10
 */
@Service
public class RpUserInfoServiceImpl extends BaseService<RpUserInfo> implements RpUserInfoService {

    protected static final Log LOG = LogFactory.getLog(RpUserInfoServiceImpl.class);

    /**
     * 用户编号前缀
     **/
    private static final String USER_NO_PREFIX = "8888";

    /**
     * 账户编号前缀
     **/
    private static final String ACCOUNT_NO_PREFIX = "9999";

    @Autowired
//	private RpUserInfoDao rpUserInfoDao;
    private RpUserInfoMapper rpUserInfoDao;

    @Autowired
    private RpAccountService rpAccountService;

    @Override
    public PageBean listPage(PageParam pageParam, RpUserInfo rpUserInfo) {
        Map<String, Object> paramMap = new HashMap<String, Object>();

        PageHelper.startPage(pageParam.getPageNum(), pageParam.getNumPerPage());
        List<RpUserInfo> list = rpUserInfoDao.listPage(paramMap);
        PageInfo info = new PageInfo<RpUserInfo>(list);

        return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), (int) info.getTotal(), info.getList());
    }

    private String buildUserNo() {
        // 获取用户编号序列
        String userNoSeq = null;
        String userNo = null;

        try {
            // 获取用户编号序列
            userNoSeq = rpUserInfoDao.buildUserNoSeq();
            // 20位的用户编号规范：'8888' + yyyyMMdd(时间) + 序列的后8位
            String dateString = DateUtils.toString(new Date(), "yyyyMMdd");
            userNo = USER_NO_PREFIX + dateString + userNoSeq.substring(userNoSeq.length() - 8, userNoSeq.length());
        } catch (Exception e) {
            LOG.error("生成用户编号异常：", e);
            throw BizException.DB_GET_SEQ_NEXT_VALUE_ERROR;
        }
        if (StringUtils.isEmpty(userNo)) {
            throw BizException.DB_GET_SEQ_NEXT_VALUE_ERROR;
        }

        return userNo;
    }

    private String buildAccountNo() {
        // 获取账户编号序列值，用于生成20位的账户编号
        String accountNoSeq = null;
        // 20位的账户编号规范：'9999' + yyyyMMdd(时间) + 序列的后8位
        String accountNo = null;

        try {
            // 获取账户编号序列值，用于生成20位的账户编号
            accountNoSeq = rpUserInfoDao.buildAccountNoSeq();
            // 20位的账户编号规范：'9999' + yyyyMMdd(时间) + 序列的后8位
            String dateString = DateUtils.toString(new Date(), "yyyyMMdd");
            accountNo = ACCOUNT_NO_PREFIX + dateString + accountNoSeq.substring(accountNoSeq.length() - 8, accountNoSeq.length());

        } catch (Exception e) {
            LOG.error("生成账户编号异常：", e);
            throw BizException.DB_GET_SEQ_NEXT_VALUE_ERROR;
        }
        if (StringUtils.isEmpty(accountNo)) {
            throw BizException.DB_GET_SEQ_NEXT_VALUE_ERROR;
        }

        return accountNo;
    }

    /**
     * 用户线下注册
     *
     * @param userName 用户名
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void registerOffline(String userName) {
        String userNo = this.buildUserNo();
        String accountNo = this.buildAccountNo();

        //生成用户信息
        RpUserInfo rpUserInfo = new RpUserInfo();
        rpUserInfo.setAccountNo(accountNo);
        rpUserInfo.setCreateTime(new Date());
        rpUserInfo.setId(StringUtil.get32UUID());
        rpUserInfo.setStatus(PublicStatusEnum.ACTIVE.name());
        rpUserInfo.setUserName(userName);
        rpUserInfo.setUserNo(userNo);
        //rpUserInfo.setVersion(0);
        this.saveData(rpUserInfo);

        // 生成账户信息
        RpAccount rpAccount = new RpAccount();
        rpAccount.setAccountNo(accountNo);
        rpAccount.setAccountType("0");
        rpAccount.setCreateTime(new Date());
        rpAccount.setEditTime(new Date());
        rpAccount.setId(StringUtil.get32UUID());
        rpAccount.setStatus(PublicStatusEnum.ACTIVE.name());
        rpAccount.setUserNo(userNo);
        rpAccount.setBalance(new BigDecimal("0"));
        rpAccount.setSecurityMoney(new BigDecimal("0"));
        rpAccount.setSettAmount(new BigDecimal("0"));
        rpAccount.setTodayExpend(new BigDecimal("0"));
        rpAccount.setTodayIncome(new BigDecimal("0"));
        rpAccount.setUnbalance(new BigDecimal("0"));
        rpAccount.setTotalExpend(new BigDecimal("0"));
        rpAccount.setTotalIncome(new BigDecimal("0"));
        rpAccountService.saveData(rpAccount);
    }

    /**
     * 根据商户编号获取商户信息
     *
     * @param merchantNo
     * @return
     */
    @Override
    public RpUserInfo getDataByMerchentNo(String merchantNo) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("userNo", merchantNo);
        paramMap.put("status", PublicStatusEnum.ACTIVE.name());
        List<RpUserInfo> list = rpUserInfoDao.listPage(paramMap);
        return list.get(0);
    }

    /**
     * 获取所有用户
     *
     * @return
     */
    @Override
    public List<RpUserInfo> listAll() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("status", PublicStatusEnum.ACTIVE.name());
        return rpUserInfoDao.listPage(paramMap);
    }
}