
package own.stu.distributedTransaction.pay.service.user.api.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.common.core.service.impl.BaseService;
import own.stu.distributedTransaction.pay.service.user.api.RpUserPayInfoService;
import own.stu.distributedTransaction.pay.service.user.dao.RpUserPayInfoMapper;
import own.stu.distributedTransaction.pay.service.user.entity.RpUserPayInfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @类功能说明： 用户第三方支付信息service实现类
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：zh
 * @创建时间：2019-5-18 上午11:14:10
 */
@Service
public class RpUserPayInfoServiceImpl extends BaseService<RpUserPayInfo> implements RpUserPayInfoService {

    @Autowired
//	private RpUserPayInfoDao rpUserPayInfoDao;
    private RpUserPayInfoMapper rpUserPayInfoDao;

    @Override
    public PageBean listPage(PageParam pageParam, RpUserPayInfo rpUserPayInfo) {
        Map<String, Object> paramMap = new HashMap<String, Object>();

        PageHelper.startPage(pageParam.getPageNum(), pageParam.getNumPerPage());
        List<RpUserPayInfo> list = rpUserPayInfoDao.listPage(paramMap);
        PageInfo info = new PageInfo<RpUserPayInfo>(list);

        return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), (int) info.getTotal(), info.getList());
    }

    /**
     * 通过商户编号获取商户支付配置信息
     *
     * @return
     */
    @Override
    public RpUserPayInfo getByUserNo(String userNo, String payWayCode) {
        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("userNo", userNo);
        paramMap.put("payWayCode", payWayCode);
        List<RpUserPayInfo> list = rpUserPayInfoDao.listPage(paramMap);
        return list.get(0);
    }
}