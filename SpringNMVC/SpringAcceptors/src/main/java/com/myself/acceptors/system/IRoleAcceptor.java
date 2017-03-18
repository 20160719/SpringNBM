package com.myself.acceptors.system;

import java.util.List;

import com.myself.acceptors.IAbstractAcceptor;
import com.myself.exception.CustomException;
import com.myself.persistences.entity.Tree;

public abstract interface IRoleAcceptor extends IAbstractAcceptor<Tree> {
	
	public abstract List<Tree> queryRoleTrees(Tree tree) throws CustomException;

}
