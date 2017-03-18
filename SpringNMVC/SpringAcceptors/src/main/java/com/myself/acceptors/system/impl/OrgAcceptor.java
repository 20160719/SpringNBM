package com.myself.acceptors.system.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.myself.acceptors.AbstractSystemAcceptor;
import com.myself.acceptors.BusinessResult;
import com.myself.acceptors.system.IOrgAcceptor;
import com.myself.busiobj.AbsBusObj;
import com.myself.dto.EntityDto;
import com.myself.exception.CustomException;
import com.myself.persistences.entity.Tree;

@Service(value = "orgAcceptor")
@Scope(value = "prototype")
public class OrgAcceptor extends AbstractSystemAcceptor<Tree> implements IOrgAcceptor {

	@Override
	protected void init(EntityDto entityDto) throws CustomException {
		this.list = transTree(entityDto.getTargetJson());
	}
	
	@Override
	public BusinessResult creates(AbsBusObj<Tree> absBusObj) throws CustomException {
		return businessAcceptor(absBusObj, (entityDto) -> {
			return getOrgService().creates(this.list);
		});
	}

	@Override
	public BusinessResult modifys(AbsBusObj<Tree> absBusObj) throws CustomException {
		return businessAcceptor(absBusObj, (entityDto) -> {
			return getOrgService().modifys(this.list);
		});
	}

	@Override
	public BusinessResult deletes(AbsBusObj<Tree> absBusObj) throws CustomException {
		return businessAcceptor(absBusObj, (entityDto) -> {
			return getOrgService().deletes(this.list);
		});
	}

	@Override
	public List<Tree> queryOrgTrees(Tree tree) throws CustomException {
		return transTrees(() -> getOrgService().queryTrees(), tree);
	}

}
