package com.myself.acceptors;

import com.myself.busiobj.AbsBusObj;
import com.myself.exception.CustomException;

public interface IAbstractAcceptor<T> {

	public BusinessResult creates(AbsBusObj<T> absBusObj) throws CustomException;

	public BusinessResult modifys(AbsBusObj<T> absBusObj) throws CustomException;

	public BusinessResult deletes(AbsBusObj<T> absBusObj) throws CustomException;
	
}
