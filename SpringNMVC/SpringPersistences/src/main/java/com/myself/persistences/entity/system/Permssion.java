package com.myself.persistences.entity.system;

import com.myself.persistences.entity.TargetHis;

public class Permssion extends TargetHis {
	
	private String roleId;
	
	private String menuId;
	
	private String value;
	
	private String seq;
	
	private String valid;
	
	private String visible;
	
	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getMenuId() {
		return menuId;
	}

	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getValid() {
		return valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}

	public String getVisible() {
		return visible;
	}

	public void setVisible(String visible) {
		this.visible = visible;
	}

	@Override
	public String toString() {
		return "Permssion [roleId=" + roleId + ", menuId=" + menuId
				+ ", value=" + value + ", seq=" + seq + ", valid=" + valid
				+ ", visible=" + visible + "]";
	}

}
