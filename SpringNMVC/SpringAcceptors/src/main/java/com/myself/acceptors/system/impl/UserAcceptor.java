package com.myself.acceptors.system.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.myself.acceptors.AbstractSystemAcceptor;
import com.myself.acceptors.BusinessResult;
import com.myself.acceptors.system.IUserAcceptor;
import com.myself.busiobj.AbsBusObj;
import com.myself.exception.CustomException;
import com.myself.persistences.entity.system.Permssion;
import com.myself.persistences.entity.system.Role;
import com.myself.persistences.entity.system.User;

@Service(value = "userAcceptor")
@Scope(value = "prototype")
public class UserAcceptor extends AbstractSystemAcceptor<User> implements IUserAcceptor {

	@Override
	public BusinessResult creates(AbsBusObj<User> absBusObj) throws CustomException {
		return businessAcceptor(absBusObj, (entityDto) -> {
			return getUserService().creates(this.list);
		});
	}

	@Override
	public BusinessResult modifys(AbsBusObj<User> absBusObj) throws CustomException {
		return businessAcceptor(absBusObj, (entityDto) -> {
			return getUserService().modifys(this.list);
		});
	}

	@Override
	public BusinessResult deletes(AbsBusObj<User> absBusObj) throws CustomException {
		return businessAcceptor(absBusObj, (entityDto) -> {
			return getUserService().deletes(this.list);
		});
	}

	@Override
	public User load(User user) throws CustomException {
		try {
			return getUserService().load(user);
		} catch (Exception e) {
			throw CustomException.getCustomException(e.getMessage());
		}
	}

	@Override
	public List<Role> queryRoles(User user) throws CustomException {
		try {
			return getUserService().queryRoles(user);
		} catch (Exception e) {
			throw CustomException.getCustomException(e.getMessage());
		}
	}

	@Override
	public List<Permssion> queryPerms(User user) throws CustomException {
		try {
			return getUserService().queryPermssions(user);
		} catch (Exception e) {
			throw CustomException.getCustomException(e.getMessage());
		}
	}

}
