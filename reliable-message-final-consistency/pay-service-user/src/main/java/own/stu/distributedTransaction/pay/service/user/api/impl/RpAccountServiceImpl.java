
package own.stu.distributedTransaction.pay.service.user.api.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.common.core.service.impl.BaseService;
import own.stu.distributedTransaction.pay.service.user.api.RpAccountService;
import own.stu.distributedTransaction.pay.service.user.dao.RpAccountMapper;
import own.stu.distributedTransaction.pay.service.user.entity.RpAccount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @类功能说明： 账户service实现类
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：zh
 * @创建时间：2019-5-18 上午11:14:10
 */
@Service
public class RpAccountServiceImpl extends BaseService<RpAccount> implements RpAccountService {

    @Autowired
    private RpAccountMapper rpAccountDao;

    @Override
    public PageBean listPage(PageParam pageParam, RpAccount rpAccount) {

        Map<String, Object> paramMap = new HashMap<String, Object>();
        paramMap.put("accountNo", rpAccount.getAccountNo());
        return listPage(pageParam, paramMap);
    }

    public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {

        PageHelper.startPage(pageParam.getPageNum(), pageParam.getNumPerPage());
        List<RpAccount> list = rpAccountDao.listPage(paramMap);
        PageInfo info = new PageInfo<RpAccount>(list);

        return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), (int) info.getTotal(), info.getList());
    }
}