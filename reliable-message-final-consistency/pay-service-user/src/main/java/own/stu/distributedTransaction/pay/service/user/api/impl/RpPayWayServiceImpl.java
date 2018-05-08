
package own.stu.distributedTransaction.pay.service.user.api.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import own.stu.distributedTransaction.common.core.enums.PayTypeEnum;
import own.stu.distributedTransaction.common.core.enums.PayWayEnum;
import own.stu.distributedTransaction.common.core.enums.PublicEnum;
import own.stu.distributedTransaction.common.core.enums.PublicStatusEnum;
import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.common.core.service.impl.BaseService;
import own.stu.distributedTransaction.common.core.utils.StringUtil;
import own.stu.distributedTransaction.pay.service.user.api.RpPayProductService;
import own.stu.distributedTransaction.pay.service.user.api.RpPayWayService;
import own.stu.distributedTransaction.pay.service.user.dao.RpPayWayMapper;
import own.stu.distributedTransaction.pay.service.user.entity.RpPayProduct;
import own.stu.distributedTransaction.pay.service.user.entity.RpPayWay;
import own.stu.distributedTransaction.pay.service.user.exceptions.PayBizException;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @类功能说明： 支付方式service实现类
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：zh
 * @创建时间：2019-5-18 上午11:14:10
 */
@Service
public class RpPayWayServiceImpl extends BaseService<RpPayWay> implements RpPayWayService {

    @Autowired
//	private RpPayWayDao rpPayWayDao;
    private RpPayWayMapper rpPayWayDao;

    @Autowired
    private RpPayProductService rpPayProductService;

    @Override
    public PageBean listPage(PageParam pageParam, RpPayWay rpPayWay) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("status", PublicStatusEnum.ACTIVE.name());
        paramMap.put("payProductCode", rpPayWay.getPayProductCode());
        paramMap.put("payWayName", rpPayWay.getPayWayName());
        paramMap.put("payTypeName", rpPayWay.getPayTypeName());

        PageHelper.startPage(pageParam.getPageNum(), pageParam.getNumPerPage());
        List<RpPayWay> list = rpPayWayDao.listPage(paramMap);
        PageInfo info = new PageInfo<RpPayWay>(list);

        return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), (int) info.getTotal(), info.getList());

    }

    @Override
    public RpPayWay getByPayWayTypeCode(String payProductCode, String payWayCode, String payTypeCode) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("payProductCode", payProductCode);
        paramMap.put("payTypeCode", payTypeCode);
        paramMap.put("payWayCode", payWayCode);
        paramMap.put("status", PublicStatusEnum.ACTIVE.name());
        List<RpPayWay> list = rpPayWayDao.listPage(paramMap);
        return list.get(0);
    }

    /**
     * 绑定支付费率
     *
     * @param payWayCode
     * @param payTypeCode
     * @param payRate
     */
    @Override
    public void createPayWay(String payProductCode, String payWayCode, String payTypeCode, Double payRate) throws PayBizException {
        RpPayWay payWay = getByPayWayTypeCode(payProductCode, payWayCode, payTypeCode);
        if (payWay != null) {
            throw new PayBizException(PayBizException.PAY_TYPE_IS_EXIST, "支付渠道已存在");
        }

        RpPayProduct rpPayProduct = rpPayProductService.getByProductCode(payProductCode, null);
        if (rpPayProduct.getAuditStatus().equals(PublicEnum.YES.name())) {
            throw new PayBizException(PayBizException.PAY_PRODUCT_IS_EFFECTIVE, "支付产品已生效，无法绑定！");
        }

        RpPayWay rpPayWay = new RpPayWay();
        rpPayWay.setPayProductCode(payProductCode);
        rpPayWay.setPayRate(payRate);
        rpPayWay.setPayWayCode(payWayCode);
        rpPayWay.setPayWayName(PayWayEnum.getEnum(payWayCode).getDesc());
        rpPayWay.setPayTypeCode(payTypeCode);
        rpPayWay.setPayTypeName(PayTypeEnum.getEnum(payTypeCode).getDesc());
        rpPayWay.setStatus(PublicStatusEnum.ACTIVE.name());
        rpPayWay.setCreateTime(new Date());
        rpPayWay.setId(StringUtil.get32UUID());
        saveData(rpPayWay);
    }

    /**
     * 根据支付产品获取支付方式
     */
    @Override
    public List<RpPayWay> listByProductCode(String payProductCode) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("payProductCode", payProductCode);
        paramMap.put("status", PublicStatusEnum.ACTIVE.name());
        return rpPayWayDao.listPage(paramMap);
    }

    /**
     * 获取所有支付方式
     */
    @Override
    public List<RpPayWay> listAll() {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("status", PublicStatusEnum.ACTIVE.name());
        return rpPayWayDao.listPage(paramMap);
    }
}