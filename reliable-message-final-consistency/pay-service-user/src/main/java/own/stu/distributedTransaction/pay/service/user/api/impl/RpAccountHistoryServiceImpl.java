/*
 * ====================================================================
 * 龙果学院： www.roncoo.com （微信公众号：RonCoo_com）
 * 超级教程系列：《微服务架构的分布式事务解决方案》视频教程
 * 讲师：吴水成（水到渠成），840765167@qq.com
 * 课程地址：http://www.roncoo.com/course/view/7ae3d7eddc4742f78b0548aa8bd9ccdb
 * ====================================================================
 */
package own.stu.distributedTransaction.pay.service.user.api.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.common.core.service.impl.BaseService;
import own.stu.distributedTransaction.pay.service.user.api.RpAccountHistoryService;
import own.stu.distributedTransaction.pay.service.user.dao.RpAccountHistoryMapper;
import own.stu.distributedTransaction.pay.service.user.entity.RpAccount;
import own.stu.distributedTransaction.pay.service.user.entity.RpAccountHistory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @类功能说明： 账户历史service实现类
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：广州领课网络科技有限公司（龙果学院：www.roncoo.com）
 * @作者：zh
 * @创建时间：2016-5-18 上午11:14:10
 * @版本：V1.0
 */
@Service("rpAccountHistoryService")
public class RpAccountHistoryServiceImpl extends BaseService<RpAccountHistory> implements RpAccountHistoryService {

	@Autowired
	private RpAccountHistoryMapper rpAccountHistoryDao;

	@Override
	public PageBean listPage(PageParam pageParam, RpAccountHistory rpAccountHistory) {
		Map<String, Object> paramMap = new HashMap<String, Object>();

		return listPage(pageParam, paramMap);
	}

	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {

		PageHelper.startPage(pageParam.getPageNum(), pageParam.getNumPerPage());
		List<RpAccountHistory> list = rpAccountHistoryDao.listPage(paramMap);
		PageInfo info = new PageInfo<RpAccountHistory>(list);

		return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), (int)info.getTotal(), info.getList());
	}
}