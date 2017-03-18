package com.myself.services.system.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.myself.persistences.entity.system.Permssion;
import com.myself.persistences.entity.system.Role;
import com.myself.persistences.entity.system.User;
import com.myself.services.AbstractSystemService;
import com.myself.services.system.IUserService;

@Service(value = "userServiceImpl")
public class UserServiceImpl extends AbstractSystemService<User> implements
		IUserService {

	public Integer creates(List<User> list) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer deletes(List<User> list) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer modifys(List<User> list) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public User load(User obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> querys(User obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<User> query(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Role> queryRoles(User record) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Permssion> queryPermssions(User record) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
