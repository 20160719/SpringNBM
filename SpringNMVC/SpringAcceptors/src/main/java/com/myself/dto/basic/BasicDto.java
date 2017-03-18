package com.myself.dto.basic;

import java.sql.Timestamp;

import com.myself.dto.EntityDto;

public class BasicDto extends EntityDto {

	// 鎵ц鏂瑰紡
	private String executeType;
	// 鎵ц鏃堕棿
	private Timestamp executeTime;

	public String getExecuteType() {
		return executeType;
	}

	public void setExecuteType(String executeType) {
		this.executeType = executeType;
	}

	public Timestamp getExecuteTime() {
		return executeTime;
	}

	public void setExecuteTime(Timestamp executeTime) {
		this.executeTime = executeTime;
	}

}
