package com.myself.acceptors;

import com.myself.dto.EntityDto;

public abstract interface IDoAcceptor {
	
	public abstract Object doAcceptor(EntityDto entityDto) throws Exception;

}
