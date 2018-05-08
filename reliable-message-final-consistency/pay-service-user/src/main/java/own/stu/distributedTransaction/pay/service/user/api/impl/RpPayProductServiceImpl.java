
package own.stu.distributedTransaction.pay.service.user.api.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import own.stu.distributedTransaction.common.core.enums.PublicEnum;
import own.stu.distributedTransaction.common.core.enums.PublicStatusEnum;
import own.stu.distributedTransaction.common.core.page.PageBean;
import own.stu.distributedTransaction.common.core.page.PageParam;
import own.stu.distributedTransaction.common.core.service.impl.BaseService;
import own.stu.distributedTransaction.common.core.utils.StringUtil;
import own.stu.distributedTransaction.pay.service.user.api.RpPayProductService;
import own.stu.distributedTransaction.pay.service.user.api.RpPayWayService;
import own.stu.distributedTransaction.pay.service.user.api.RpUserPayConfigService;
import own.stu.distributedTransaction.pay.service.user.dao.RpPayProductMapper;
import own.stu.distributedTransaction.pay.service.user.entity.RpPayProduct;
import own.stu.distributedTransaction.pay.service.user.entity.RpPayWay;
import own.stu.distributedTransaction.pay.service.user.entity.RpUserPayConfig;
import own.stu.distributedTransaction.pay.service.user.exceptions.PayBizException;

/**
 * @类功能说明： 支付产品service实现类
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：zh
 * @创建时间：2019-5-18 上午11:14:10
 */
@Service
public class RpPayProductServiceImpl extends BaseService<RpPayProduct> implements RpPayProductService{

	@Autowired
//	private RpPayProductDao rpPayProductDao;
	private RpPayProductMapper rpPayProductDao;
	
	@Autowired
	private RpPayWayService rpPayWayService;
	
	@Autowired
	private RpUserPayConfigService rpUserPayConfigService;
	
	@Override
	public PageBean listPage(PageParam pageParam, RpPayProduct rpPayProduct) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("status", PublicStatusEnum.ACTIVE.name());
		paramMap.put("auditStatus", rpPayProduct.getAuditStatus());
		paramMap.put("productName", rpPayProduct.getProductName());

		PageHelper.startPage(pageParam.getPageNum(), pageParam.getNumPerPage());
		List<RpPayProduct> list = rpPayProductDao.listPage(paramMap);
		PageInfo info = new PageInfo<RpPayProduct>(list);

		return new PageBean(pageParam.getPageNum(), pageParam.getNumPerPage(), (int)info.getTotal(), info.getList());
	}
	
	/**
	 * 根据产品编号获取支付产品
	 */
	@Override
	public RpPayProduct getByProductCode(String productCode, String auditStatus){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("productCode", productCode);
		paramMap.put("status", PublicStatusEnum.ACTIVE.name());
		paramMap.put("auditStatus", auditStatus);
		List<RpPayProduct> list = rpPayProductDao.listPage(paramMap);
		return list.get(0);
	}
	
	/**
	 * 创建支付产品
	 * @param productCode
	 * @param productName
	 */
	@Override
	public void createPayProduct(String productCode, String productName) throws PayBizException {
		RpPayProduct rpPayProduct = getByProductCode(productCode, null);
		if(rpPayProduct != null){
			throw new PayBizException(PayBizException.PAY_PRODUCT_IS_EXIST,"支付产品已存在");
		}
		rpPayProduct = new RpPayProduct();
		rpPayProduct.setStatus(PublicStatusEnum.ACTIVE.name());
		rpPayProduct.setCreateTime(new Date());
		rpPayProduct.setId(StringUtil.get32UUID());
		rpPayProduct.setProductCode(productCode);
		rpPayProduct.setProductName(productName);
		rpPayProduct.setAuditStatus(PublicEnum.NO.name());
		saveData(rpPayProduct);
	}
	
	/**
	 * 删除支付产品
	 * @param productCode
	 */
	@Override
	public void deletePayProduct(String productCode) throws PayBizException{
		
		List<RpPayWay> payWayList = rpPayWayService.listByProductCode(productCode);
		if(!payWayList.isEmpty()){
			throw new PayBizException(PayBizException.PAY_PRODUCT_HAS_DATA,"支付产品已关联支付方式，无法删除！");
		}
		
		List<RpUserPayConfig> payConfigList = rpUserPayConfigService.listByProductCode(productCode);
		if(!payConfigList.isEmpty()){
			throw new PayBizException(PayBizException.PAY_PRODUCT_HAS_DATA,"支付产品已关联用户，无法删除！");
		}
		
		RpPayProduct rpPayProduct = getByProductCode(productCode, null);
		if(rpPayProduct.getAuditStatus().equals(PublicEnum.YES.name())){
			throw new PayBizException(PayBizException.PAY_PRODUCT_IS_EFFECTIVE,"支付产品已生效，无法删除！");
		}
		
		rpPayProduct.setStatus(PublicStatusEnum.UNACTIVE.name());
		updateData(rpPayProduct);
	}
	
	/**
	 * 获取所有支付产品
	 */
	@Override
	public List<RpPayProduct> listAll(){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("status", PublicStatusEnum.ACTIVE.name());
		return rpPayProductDao.listPage(paramMap);
	}
	
	/**
	 * 审核
	 * @param productCode
	 * @param auditStatus
	 */
	@Override
	public void audit(String productCode, String auditStatus) throws PayBizException{
		RpPayProduct rpPayProduct = getByProductCode(productCode, null);
		if(rpPayProduct == null){
			throw new PayBizException(PayBizException.PAY_PRODUCT_IS_NOT_EXIST,"支付产品不存在！");
		}
		
		if(auditStatus.equals(PublicEnum.YES.name())){
			//检查是否已设置支付方式
			List<RpPayWay> payWayList = rpPayWayService.listByProductCode(productCode);
			if(payWayList.isEmpty()){
				throw new PayBizException(PayBizException.PAY_TYPE_IS_NOT_EXIST,"支付方式未设置，无法操作！");
			}
			
		}else if(auditStatus.equals(PublicEnum.NO.name())){
			//检查是否已有支付配置
			List<RpUserPayConfig> payConfigList = rpUserPayConfigService.listByProductCode(productCode);
			if(!payConfigList.isEmpty()){
				throw new PayBizException(PayBizException.USER_PAY_CONFIG_IS_EXIST,"支付产品已关联用户支付配置，无法操作！");
			}
		}
		rpPayProduct.setAuditStatus(auditStatus);
		rpPayProduct.setEditTime(new Date());
		updateData(rpPayProduct);
	}
}