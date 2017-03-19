package com.myself.acceptors.system.impl;

import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.myself.acceptors.AbstractSystemAcceptor;
import com.myself.acceptors.BusinessResult;
import com.myself.acceptors.system.IMenuAcceptor;
import com.myself.busiobj.AbsBusObj;
import com.myself.dto.EntityDto;
import com.myself.exception.CustomException;
import com.myself.persistences.entity.Operation;
import com.myself.persistences.entity.Tree;

@Service(value = "menuAcceptor")
@Scope(value = "prototype")
public class MenuAcceptor extends AbstractSystemAcceptor<Tree> implements IMenuAcceptor {

	@Override
	protected void init(EntityDto entityDto) throws CustomException {
		this.list = transTree(entityDto.getTargetJson());
	}

	@Override
	public BusinessResult creates(AbsBusObj<Tree> absBusObj) throws CustomException {
		absBusObj.getOperation().setOpTyle(Operation.OP_CREATE);
		return businessAcceptor(absBusObj, (entityDto) -> {
			return getMenuService().creates(this.list);
		});
	}

	@Override
	public BusinessResult modifys(AbsBusObj<Tree> absBusObj) throws CustomException {
		absBusObj.getOperation().setOpTyle(Operation.OP_MODIFY);
		return businessAcceptor(absBusObj, (entityDto) -> {
			return getMenuService().modifys(this.list);
		});
	}

	@Override
	public BusinessResult deletes(AbsBusObj<Tree> absBusObj) throws CustomException {
		absBusObj.getOperation().setOpTyle(Operation.OP_DELETE);
		return businessAcceptor(absBusObj, (entityDto) -> {
			return getMenuService().deletes(this.list);
		});
	}

	@Override
	public List<Tree> queryMenuTrees(Tree tree) throws CustomException {
		return transTrees(() -> getMenuService().queryTrees(), tree);
	}


}
