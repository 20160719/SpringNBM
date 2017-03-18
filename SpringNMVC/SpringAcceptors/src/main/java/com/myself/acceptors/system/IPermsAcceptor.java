package com.myself.acceptors.system;

import java.util.List;

import com.myself.acceptors.IAbstractAcceptor;
import com.myself.persistences.entity.system.Permssion;

public abstract interface IPermsAcceptor extends IAbstractAcceptor<Permssion> {
	
	public abstract List<Permssion> queryPermssions();

}
