
package own.stu.distributedTransaction.pay.service.user.entity;

import java.io.Serializable;

import own.stu.distributedTransaction.common.core.entity.BaseEntity;
import own.stu.distributedTransaction.common.core.enums.PublicStatusEnum;

/**
 * @类功能说明： 支付产品实体类
 * @类修改者：
 * @修改日期：
 * @修改说明：
 * @公司名称：
 * @作者：zh
 * @创建时间：2019-5-18 上午11:14:10
 */
public class RpUserInfo_bak extends BaseEntity implements Serializable {

    private String userNo;

    private String userName;

    private String accountNo;

    private static final long serialVersionUID = 1L;


    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo == null ? null : userNo.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }
    
    public String getStatusDesc() {
        return PublicStatusEnum.getEnum(this.getStatus()).getDesc();
    }

}