
package own.stu.distributedTransaction.pay.service.trade.vo;

import own.stu.distributedTransaction.common.core.enums.PayWayEnum;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Map;

/**
 * @功能说明:支付网关页面展示实体
 * @创建者:
 * @创建时间: 16/6/15  下午6:01
 * @公司名称:
 * @版本:
 */
public class RpPayGateWayPageShowVo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = -5333056064541554935L;

	/** 订单金额 **/
    private BigDecimal orderAmount;

    /** 产品名称 **/
    private String productName;

    /** 商户名称 **/
    private String merchantName;

    /** 商户订单号 **/
    private String merchantOrderNo;

    /** 商户支付key **/
    private String payKey;

    /** 支付方式列表 **/
    private Map<String , PayWayEnum> payWayEnumMap;

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public Map<String, PayWayEnum> getPayWayEnumMap() {
        return payWayEnumMap;
    }

    public void setPayWayEnumMap(Map<String, PayWayEnum> payWayEnumMap) {
        this.payWayEnumMap = payWayEnumMap;
    }

    public String getMerchantOrderNo() {
        return merchantOrderNo;
    }

    public void setMerchantOrderNo(String merchantOrderNo) {
        this.merchantOrderNo = merchantOrderNo;
    }

    public String getPayKey() {
        return payKey;
    }

    public void setPayKey(String payKey) {
        this.payKey = payKey;
    }
}
