package com.myself.acceptors;

import java.util.List;

public interface IAcceptorQuerys<T> {
	
	public abstract List<T> querys() throws Exception;

}
