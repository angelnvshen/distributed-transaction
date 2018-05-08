
package own.stu.distributedTransaction.pay.service.trade.vo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @功能说明:
 * @创建者:
 * @创建时间: 16/5/25  下午3:43
 * @公司名称:
 * @版本:
 */
public class ScanPayResultVo implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1324566713391515644L;

	/**
     * 支付方式编码
     */
    private String payWayCode;

    /** 金额 **/
    private BigDecimal orderAmount;

    /** 产品名称 **/
    private String productName;

    /**
     * 二维码地址
     */
    private String codeUrl;

    public String getCodeUrl() {
        return codeUrl;
    }

    public void setCodeUrl(String codeUrl) {
        this.codeUrl = codeUrl;
    }

    public String getPayWayCode() {
        return payWayCode;
    }

    public void setPayWayCode(String payWayCode) {
        this.payWayCode = payWayCode;
    }

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
}
