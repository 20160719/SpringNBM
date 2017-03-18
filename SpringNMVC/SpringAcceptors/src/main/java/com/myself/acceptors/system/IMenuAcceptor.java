package com.myself.acceptors.system;

import java.util.List;

import com.myself.acceptors.IAbstractAcceptor;
import com.myself.exception.CustomException;
import com.myself.persistences.entity.Tree;

public interface IMenuAcceptor extends IAbstractAcceptor<Tree> {
	
	public abstract List<Tree> queryMenuTrees(Tree tree) throws CustomException;
	
}
