package com.myself.acceptors.system;

import com.myself.acceptors.IAbstractAcceptor;
import com.myself.exception.CustomException;
import com.myself.persistences.entity.system.User;

public interface IUserAcceptor extends IAbstractAcceptor<User> {
	
	public User load(User user) throws CustomException;

}
