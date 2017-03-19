package com.myself.dto;

public abstract class EntityDto {

	// 操作类型
	private String operateType;
	// 序列号
	private String serialNum;
	// 操作码
	private String opCode;
	// json字符串
	private String targetJson;
	
	private String remark;

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

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

	public String getTargetJson() {
		return targetJson;
	}

	public void setTargetJson(String targetJson) {
		this.targetJson = targetJson;
	}

	protected String getRemark() {
		return remark;
	}

	protected void setRemark(String remark) {
		this.remark = remark;
	}

}
