package com.myself.controller;

import javax.annotation.Resource;

import org.springframework.util.Assert;

import com.myself.acceptors.system.IMenuAcceptor;
import com.myself.acceptors.system.IOrgAcceptor;
import com.myself.acceptors.system.IPermsAcceptor;
import com.myself.acceptors.system.IRoleAcceptor;
import com.myself.busiobj.system.SystemObj;
import com.myself.dto.EntityDto;
import com.myself.exception.CustomException;
import com.myself.persistences.entity.Operation;

public abstract class AbstractSystemController extends AbstractController {

	@Resource(name = "roleAcceptor")
	private IRoleAcceptor roleAcceptor;
	
	@Resource(name = "menuAcceptor")
	private IMenuAcceptor menuAcceptor;
	
	@Resource(name = "orgAcceptor")
	private IOrgAcceptor orgAcceptor;
	
	@Resource(name = "permsAcceptor")
	private IPermsAcceptor permsAcceptor;
	
	public <T> SystemObj<T> doAction(EntityDto entityDto) throws CustomException {
		Assert.notNull(entityDto, "entityDto must not be null"); 
		SystemObj<T> businessObj = new SystemObj<T>();
		businessObj.setEntityDto(entityDto);
		Operation operation = getOperation();
		businessObj.setOperation(operation);
		return businessObj;
	}

	protected final IRoleAcceptor getRoleAcceptor() {
		return roleAcceptor;
	}

	protected final IMenuAcceptor getMenuAcceptor() {
		return menuAcceptor;
	}

	protected final IOrgAcceptor getOrgAcceptor() {
		return orgAcceptor;
	}

	protected IPermsAcceptor getPermsAcceptor() {
		return permsAcceptor;
	}

}
