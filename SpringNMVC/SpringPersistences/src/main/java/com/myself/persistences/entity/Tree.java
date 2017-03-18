package com.myself.persistences.entity;

import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 用于 角色 组织机构  菜单 图书类型等树形结构类
 * @author Administrator
 *
 */

public class Tree extends TargetHis {
	// 树形ID
	protected String id;
	// 树形父ID
	protected String parentId;
	// 树形名称
	protected String name;
	// 树形值
	protected String value;
	// 树形层级
	protected Integer level;
	// 树形是否有效
	protected String valid;
	// 树形是否可见
	protected String visible;
	
	private List<? extends Tree> children;

	public boolean equalContent(Tree tree) {
		boolean flag = (StringUtils.isNotBlank(getId()) && StringUtils.isNotBlank(tree.getId())
				&& getId().equals(tree.getId()))
				|| (StringUtils.isNotBlank(getParentId()) && StringUtils.isNotBlank(tree.getParentId())
						&& getParentId().equals(tree.getParentId()))
				|| (StringUtils.isNotBlank(getName()) && StringUtils.isNotBlank(tree.getName())
						&& getName().equals(tree.getName()));
		return flag;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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

	public List<? extends Tree> getChildren() {
		return children;
	}

	public void setChildren(List<? extends Tree> children) {
		this.children = children;
	}

}
