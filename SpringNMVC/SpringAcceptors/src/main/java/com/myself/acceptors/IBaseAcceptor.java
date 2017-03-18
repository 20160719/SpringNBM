package com.myself.acceptors;

import com.myself.busiobj.AbsBusObj;
import com.myself.exception.CustomException;

public abstract interface IBaseAcceptor<T> {

	public abstract BusinessResult businessAcceptor(AbsBusObj<T> absBusObj)
			throws CustomException;

	public abstract BusinessResult businessAcceptor(AbsBusObj<T> absBusObj,
			IBeforeAcceptor beforeAcceptor, IDoAcceptor doAcceptor,
			IAfterAcceptor endAcceptor) throws CustomException;
}
