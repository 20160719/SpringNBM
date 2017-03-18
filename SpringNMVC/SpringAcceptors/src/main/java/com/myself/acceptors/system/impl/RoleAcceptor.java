package com.myself.acceptors.system.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.myself.acceptors.AbstractSystemAcceptor;
import com.myself.acceptors.BusinessResult;
import com.myself.acceptors.system.IRoleAcceptor;
import com.myself.busiobj.AbsBusObj;
import com.myself.dto.EntityDto;
import com.myself.exception.CustomException;
import com.myself.persistences.entity.Tree;

@Service(value = "roleAcceptor")
@Scope(value = "prototype")
public class RoleAcceptor extends AbstractSystemAcceptor<Tree> implements IRoleAcceptor {

	@Override
	protected void init(EntityDto entityDto) throws CustomException {
		this.list = transTree(entityDto.getTargetJson());
	}
	
	@Override
	public BusinessResult creates(AbsBusObj<Tree> absBusObj) throws CustomException {
		return businessAcceptor(absBusObj, (entityDto) -> {
			return getRoleService().creates(this.list);
		});
	}

	@Override
	public BusinessResult modifys(AbsBusObj<Tree> absBusObj) throws CustomException {
		return businessAcceptor(absBusObj, (entityDto) -> {
			return getRoleService().modifys(this.list);
		});
	}

	@Override
	public BusinessResult deletes(AbsBusObj<Tree> absBusObj) throws CustomException {
		return businessAcceptor(absBusObj, (entityDto) -> {
			return getRoleService().deletes(this.list);
		});
	}

	@Override
	public List<Tree> queryRoleTrees(Tree tree) throws CustomException {
		return transTrees(() -> getRoleService().queryTrees(), tree);
	}

}
