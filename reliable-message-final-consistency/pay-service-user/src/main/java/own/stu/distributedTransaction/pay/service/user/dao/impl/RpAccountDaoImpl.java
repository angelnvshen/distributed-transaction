/*
 * ====================================================================
 * 龙果学院： www.roncoo.com （微信公众号：RonCoo_com）
 * 超级教程系列：《微服务架构的分布式事务解决方案》视频教程
 * 讲师：吴水成（水到渠成），840765167@qq.com
 * 课程地址：http://www.roncoo.com/course/view/7ae3d7eddc4742f78b0548aa8bd9ccdb
 * ====================================================================
 */
package own.stu.distributedTransaction.pay.service.user.dao.impl;

import org.springframework.stereotype.Repository;
import own.stu.distributedTransaction.common.core.dao.impl.BaseDaoImpl;
import own.stu.distributedTransaction.common.core.enums.PublicStatusEnum;
import own.stu.distributedTransaction.pay.service.user.dao.RpAccountDao;
import own.stu.distributedTransaction.pay.service.user.entity.RpAccount_bak;

import java.util.HashMap;
import java.util.Map;


/**
 * @类功能说明： 账户dao实现类
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：广州领课网络科技有限公司（龙果学院：www.roncoo.com）
 * @作者：zh
 * @创建时间：2016-5-18 上午11:14:10
 * @版本：V1.0
 */
@Repository
public class RpAccountDaoImpl  extends BaseDaoImpl<RpAccount_bak> implements RpAccountDao {
	public RpAccount_bak getByAccountNo(String accountNo){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("accountNo", accountNo);
		paramMap.put("status", PublicStatusEnum.ACTIVE.name());
		return this.getBy(paramMap);
	}

	public RpAccount_bak getByUserNo(Map<String, Object> map){
		return this.getSessionTemplate().selectOne(getStatement("getByUserNo"), map);
	}
}