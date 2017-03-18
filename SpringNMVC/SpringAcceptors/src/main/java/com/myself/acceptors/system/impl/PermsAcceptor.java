package com.myself.acceptors.system.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.myself.acceptors.AbstractSystemAcceptor;
import com.myself.acceptors.BusinessResult;
import com.myself.acceptors.system.IPermsAcceptor;
import com.myself.busiobj.AbsBusObj;
import com.myself.exception.CustomException;
import com.myself.persistences.entity.system.Permssion;

@Service(value = "permsAcceptor")
@Scope(value = "prototype")
public class PermsAcceptor extends AbstractSystemAcceptor<Permssion> implements
		IPermsAcceptor {

	@Override
	public BusinessResult creates(AbsBusObj<Permssion> absBusObj) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessResult modifys(AbsBusObj<Permssion> absBusObj) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessResult deletes(AbsBusObj<Permssion> absBusObj) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Permssion> queryPermssions() {
		// TODO Auto-generated method stub
		return null;
	}

}
