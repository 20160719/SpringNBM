package com.myself.services;

import java.util.List;

public abstract interface IServiceQuerys<T> {
	
	public abstract List<T> querys() throws Exception;

}
