/*
 * ====================================================================
 * 龙果学院： www.roncoo.com （微信公众号：RonCoo_com）
 * 超级教程系列：《微服务架构的分布式事务解决方案》视频教程
 * 讲师：吴水成（水到渠成），840765167@qq.com
 * 课程地址：http://www.roncoo.com/course/view/7ae3d7eddc4742f78b0548aa8bd9ccdb
 * ====================================================================
 */
package own.stu.distributedTransaction.pay.service.accounting.api.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.common.core.utils.DateUtils;
import own.stu.distributedTransaction.pay.service.accounting.api.RpAccountingVoucherService;
import own.stu.distributedTransaction.pay.service.accounting.dao.RpAccountingVoucherDao;
import own.stu.distributedTransaction.pay.service.accounting.entity.RpAccountingVoucher;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

/**
 * 会计原始凭证服务.
 * @author WuShuicheng.
 *
 */
@Component("rpAccountingVoucherService")
public class RpAccountingVoucherServiceImpl implements RpAccountingVoucherService {
	
	private static final Log LOG = LogFactory.getLog(RpAccountingVoucherServiceImpl.class);
	
	@Autowired
	private RpAccountingVoucherDao rpAccountingVoucherDao;
	

	private Weekend<RpAccountingVoucher> geneWeekend(Map<String, Object> paramMap){

		RpAccountingVoucher rpAccountingVoucher = new RpAccountingVoucher();
		try {
			BeanUtils.populate(rpAccountingVoucher, paramMap);
			return geneWeekend(rpAccountingVoucher);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	private Weekend<RpAccountingVoucher> geneWeekend(RpAccountingVoucher rpAccountingVoucher){
		Weekend<RpAccountingVoucher> weekend = Weekend.of(RpAccountingVoucher.class);
		WeekendCriteria<RpAccountingVoucher, Object> criteria = weekend.weekendCriteria();
		if (rpAccountingVoucher.getEntryType() != null) {
			criteria.andEqualTo(RpAccountingVoucher::getEntryType, rpAccountingVoucher.getEntryType());
		}
		if (StringUtils.isNotBlank(rpAccountingVoucher.getVoucherNo())) {
			criteria.andEqualTo(RpAccountingVoucher::getVoucherNo, rpAccountingVoucher.getVoucherNo());
		}
		if (rpAccountingVoucher.getFromSystem() != null) {
			criteria.andEqualTo(RpAccountingVoucher::getFromSystem, rpAccountingVoucher.getFromSystem());
		}

		return weekend;
	}

	/**
	 * 创建会计分录原始凭证信息.
	 */
	public void createAccountingVoucher(RpAccountingVoucher rpAccountingVoucher) {

		Weekend<RpAccountingVoucher> weekend = Weekend.of(RpAccountingVoucher.class);
		WeekendCriteria<RpAccountingVoucher, Object> criteria = weekend.weekendCriteria();
		if (rpAccountingVoucher.getEntryType() != null) {
			criteria.andEqualTo(RpAccountingVoucher::getEntryType, rpAccountingVoucher.getEntryType());
		}
		if (StringUtils.isNotBlank(rpAccountingVoucher.getRequestNo())) {
			criteria.andEqualTo(RpAccountingVoucher::getRequestNo, rpAccountingVoucher.getRequestNo());
		}
		if (StringUtils.isNotBlank(rpAccountingVoucher.getVoucherNo())) {
			criteria.andEqualTo(RpAccountingVoucher::getVoucherNo, rpAccountingVoucher.getVoucherNo());
		}
		if (StringUtils.isNotBlank(rpAccountingVoucher.getBankOrderNo())) {
			criteria.andEqualTo(RpAccountingVoucher::getBankOrderNo, rpAccountingVoucher.getBankOrderNo());
		}
		if (StringUtils.isNotBlank(rpAccountingVoucher.getBankChannelCode())) {
			criteria.andEqualTo(RpAccountingVoucher::getBankChannelCode, rpAccountingVoucher.getBankChannelCode());
		}
		if (rpAccountingVoucher.getFromSystem() != null) {
			criteria.andEqualTo(RpAccountingVoucher::getFromSystem, rpAccountingVoucher.getFromSystem());
		}
		if (rpAccountingVoucher.getAccountingDate() != null) {
			criteria.andEqualTo(RpAccountingVoucher::getAccountingDate, rpAccountingVoucher.getAccountingDate());
		}

		RpAccountingVoucher rpAccountingVoucher_tmp  = rpAccountingVoucherDao.selectOneByExample(weekend);

		if(rpAccountingVoucher_tmp != null){
			LOG.info("data is exist,voucherNo="+rpAccountingVoucher.getVoucherNo());
			return ;
		}
		
		if (StringUtils.isBlank(rpAccountingVoucher.getRequestNo())) {
			rpAccountingVoucher.setRequestNo(getRequestNo(rpAccountingVoucher.getEntryType()));
		}

		rpAccountingVoucherDao.insert(rpAccountingVoucher);
	}
	
	/**
	 * 生成请求号: 会计分录类型+日期+随机数字.
	 * @param entryType 会计分录类型
	 * @return requestNo.
	 */
	public String getRequestNo(int entryType) {
		return entryType + DateUtils.toString(new Date(), "yyyyMMdd") + rpAccountingVoucherDao.buildAccountingVoucherNo();
	}
	/***
	 * 根据条件查询单挑数据
	 * @param map
	 * @return
	 */
	public RpAccountingVoucher getBy(Map<String, Object> map) {
		RpAccountingVoucher note  = rpAccountingVoucherDao.selectOneByExample(geneWeekend(map));
		return note;
	}

	/***
	 * 根据条件查询分录请求表数据
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	/*public Map getMapBy(Map<String, Object> searchMap) {
		return rpAccountingVoucherDao.getMapBy(searchMap);
	}*/

	@Override
	public PageBean listPage(PageParam pageParam, Map<String, Object> paramMap) {
		PageHelper.startPage(pageParam.getPageNum(), pageParam.getNumPerPage());
		List<RpAccountingVoucher> resultList = rpAccountingVoucherDao.selectByExample(geneWeekend(paramMap));
		PageInfo info = new PageInfo<RpAccountingVoucher>(resultList);

		/*// 是否统计当前分页条件下的数据：1:是，其他为否
		if (isCount != null && "1".equals(isCount.toString())) {
			Map<String, Object> countResultMap = sessionTemplate.selectOne(getStatement(SQL_COUNT_BY_PAGE_PARAM), paramMap);
			return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), totalCount.intValue(), list, countResultMap);
		} else {
			// 构造分页对象
			return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), totalCount.intValue(), list);
		}*/

		return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), (int)info.getTotal(), info.getList());

	}
	
	/**
	 * 查出分录请求表
	 * @param requestNo
	 */
	public RpAccountingVoucher getAccountingVoucherByRequestNo(String requestNo){

		Weekend<RpAccountingVoucher> weekend = Weekend.of(RpAccountingVoucher.class);
		WeekendCriteria<RpAccountingVoucher, Object> criteria = weekend.weekendCriteria();
		if (StringUtils.isNotBlank(requestNo)) {
			criteria.andEqualTo(RpAccountingVoucher::getRequestNo, requestNo);
		}
		RpAccountingVoucher entity  = rpAccountingVoucherDao.selectOneByExample(weekend);

		return entity;
	}
	
	/**
	 * 修改分录请求
	 * @param entity
	 */
	public void updateAccountingVoucher(RpAccountingVoucher entity){
		rpAccountingVoucherDao.updateByPrimaryKeySelective(entity);
	}
	
	
	
}
 