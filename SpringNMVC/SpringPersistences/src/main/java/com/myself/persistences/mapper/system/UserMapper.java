package com.myself.persistences.mapper.system;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myself.persistences.entity.system.Permssion;
import com.myself.persistences.entity.system.Role;
import com.myself.persistences.entity.system.User;
import com.myself.persistences.mapper.IAbstractMapper;


public abstract interface UserMapper extends IAbstractMapper<User> {
	
	/**
	 * ��ѯ��ɫ
	 * @param record
	 * @return
	 * @throws Exception
	 * @return List<Role>
	 * TODO
	 */
	public abstract List<Role> queryRoles(@Param("record") User record) throws Exception;
	
	/**
	 * ��ѯȨ��
	 * @param record
	 * @return
	 * @throws Exception
	 * @return List<Permssion>
	 * TODO
	 */
	public abstract List<Permssion> queryPermssions(@Param("record") User record) throws Exception;

}
