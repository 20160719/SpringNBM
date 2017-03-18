package com.myself.persistences.entity;

import java.sql.Timestamp;

public class Operation extends TargetHis {

	/********************* 操作常量 ***********************/
	// 新增
	public static final String OP_CREATE = "I";
	// 查询
	public static final String OP_SREACH = "S";
	// 修改
	public static final String OP_MODIFY = "M";
	// 删除
	public static final String OP_DELETE = "D";
	
	// 序列号
	private String serialNum;
	// 操作码
	private String opCode;
	// 操作类型
	private String opTyle;
	// 操作时间
	private Timestamp opTime;
	
	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getOpCode() {
		return opCode;
	}

	public void setOpCode(String opCode) {
		this.opCode = opCode;
	}

	public String getOpTyle() {
		return opTyle;
	}

	public void setOpTyle(String opTyle) {
		this.opTyle = opTyle;
	}

	public Timestamp getOpTime() {
		return opTime;
	}

	public void setOpTime(Timestamp opTime) {
		this.opTime = opTime;
	}

}
