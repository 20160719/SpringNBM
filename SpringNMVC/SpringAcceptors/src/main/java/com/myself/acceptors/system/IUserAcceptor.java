package com.myself.acceptors.system;

import java.util.List;

import com.myself.acceptors.IAbstractAcceptor;
import com.myself.exception.CustomException;
import com.myself.persistences.entity.system.Permssion;
import com.myself.persistences.entity.system.Role;
import com.myself.persistences.entity.system.User;

public interface IUserAcceptor extends IAbstractAcceptor<User> {
	
	public User load(User user) throws CustomException;
	
	public List<Role> queryRoles(User user) throws CustomException;
	
	public List<Permssion> queryPerms(User user) throws CustomException;

}
