package com.myself.persistences.entity;

import java.sql.Timestamp;

public abstract class TargetTime {
	
	// 入库时间
	private Timestamp createTime;
	// 修改时间
	private Timestamp modifyTime;
	// 删除时间
	private Timestamp deleteTime;

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public Timestamp getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(Timestamp deleteTime) {
		this.deleteTime = deleteTime;
	}

}
