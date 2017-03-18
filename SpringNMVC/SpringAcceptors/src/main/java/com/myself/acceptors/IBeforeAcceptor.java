package com.myself.acceptors;

import com.myself.dto.EntityDto;
import com.myself.exception.CustomException;

public abstract interface IBeforeAcceptor {

	public abstract Object beforeAcceptor(EntityDto entityDto) throws CustomException;

}
