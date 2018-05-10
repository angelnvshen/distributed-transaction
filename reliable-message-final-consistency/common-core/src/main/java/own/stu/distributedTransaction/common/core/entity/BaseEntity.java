
package own.stu.distributedTransaction.common.core.entity;

import own.stu.distributedTransaction.common.core.utils.StringUtil;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * @类功能说明： 基类.
 * @创建时间：2019-5-11 上午11:14:10
 */
public class BaseEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id = StringUtil.get32UUID();// 主键ID.
	private Integer version = 0;// 版本号默认为0
	private String status;// 状态 PublicStatusEnum
	private String creater;// 创建人.
	@Column(name = "create_time")
	private Date createTime = new Date();// 创建时间.
	@Column(name = "edit_time")
	private String editor;// 修改人.
	private Date editTime;// 修改时间.
	private String remark;// 描述

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreater() {
		return creater;
	}

	public void setCreater(String creater) {
		this.creater = creater;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getEditor() {
		return editor;
	}

	public void setEditor(String editor) {
		this.editor = editor;
	}

	public Date getEditTime() {
		return editTime;
	}

	public void setEditTime(Date editTime) {
		this.editTime = editTime;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
