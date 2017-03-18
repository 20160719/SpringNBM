package com.myself.services.system;

import java.util.List;

import com.myself.persistences.entity.system.Permssion;
import com.myself.persistences.entity.system.Role;
import com.myself.persistences.entity.system.User;
import com.myself.services.IBaseService;

public abstract interface IUserService extends IBaseService<User> {

	/**
	 * 查询角色
	 * @param record
	 * @return
	 * @throws Exception
	 * @return List<Role>
	 * TODO
	 */
	public abstract List<Role> queryRoles(User record) throws Exception;
	
	/**
	 * 查询权限
	 * @param record
	 * @return
	 * @throws Exception
	 * @return List<Permssion>
	 * TODO
	 */
	public abstract List<Permssion> queryPermssions(User record) throws Exception;
}
