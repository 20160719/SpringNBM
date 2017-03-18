package com.myself.persistences.entity.system;

import java.sql.Timestamp;

public class User extends Account {

	// 用户ID
	private String userId;
	// 姓名
	private String userName;
	// 性别
	private String userSex;
	// 年龄
	private String userAge;
	// 生日
	private String brithday;

	// 创建时间
	protected Timestamp inTime;
	// 修改时间
	protected Timestamp modifyTime;
	// 用户角色
	private String roleIds;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public String getBrithday() {
		return brithday;
	}

	public void setBrithday(String brithday) {
		this.brithday = brithday;
	}

	public Timestamp getInTime() {
		return inTime;
	}

	public void setInTime(Timestamp inTime) {
		this.inTime = inTime;
	}

	public Timestamp getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Timestamp modifyTime) {
		this.modifyTime = modifyTime;
	}

	public String getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(String roleIds) {
		this.roleIds = roleIds;
	}

	@Override
	public String toString() {
		return String
				.format("User [userId=%s, userName=%s, userSex=%s, userAge=%s, brithday=%s, inTime=%s, modifyTime=%s, roleIds=%s, account=%s, password=%s]",
						userId, userName, userSex, userAge, brithday, inTime,
						modifyTime, roleIds, account, password);
	}

}
