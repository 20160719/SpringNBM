package com.myself.acceptors.system.impl;

import com.myself.acceptors.AbstractSystemAcceptor;
import com.myself.acceptors.BusinessResult;
import com.myself.acceptors.basic.IBookAcceptor;
import com.myself.busiobj.AbsBusObj;
import com.myself.dto.EntityDto;
import com.myself.exception.CustomException;
import com.myself.persistences.entity.Tree;
import com.myself.persistences.entity.basic.Book;

public class BookTypeAcceptor extends AbstractSystemAcceptor<Tree> implements IBookAcceptor {

	@Override
	protected void init(EntityDto entityDto) throws CustomException {
		this.list = transTree(entityDto.getTargetJson());
	}
	
	@Override
	public BusinessResult creates(AbsBusObj<Book> absBusObj) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessResult modifys(AbsBusObj<Book> absBusObj) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BusinessResult deletes(AbsBusObj<Book> absBusObj) throws CustomException {
		// TODO Auto-generated method stub
		return null;
	}

}
