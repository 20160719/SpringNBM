package com.myself.services;

import java.util.List;
import java.util.Map;

import com.myself.persistences.entity.Operation;
import com.myself.persistences.entity.Tree;


public abstract interface IBaseService<T> {

	/**
	 * 锟斤拷锟斤拷锟斤拷史锟斤拷锟斤拷锟斤拷为默锟较凤拷锟斤拷锟斤拷
	 * 
	 * @param listHis
	 * @return
	 * @throws Exception
	 * @return Integer TODO
	 */
	public abstract Integer createHiss(List<T> list, Operation operation) throws Exception;

	/**
	 * 锟斤拷锟斤拷
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 * @return Integer TODO
	 */
	public abstract Integer creates(List<T> list) throws Exception;

	/**
	 * 删锟斤拷
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 * @return Integer TODO
	 */
	public abstract Integer deletes(List<T> list) throws Exception;

	/**
	 * 锟睫革拷
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 * @return Integer TODO
	 */
	public abstract Integer modifys(List<T> list) throws Exception;
	
	/**
	 * 锟斤拷询锟斤拷锟斤拷锟斤拷录
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 * @return T TODO
	 */
	public abstract T load(T obj) throws Exception;

	/**
	 * 锟斤拷询锟斤拷锟斤拷锟斤拷录
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 * @return List<T> TODO
	 */
	public abstract List<T> querys(T obj) throws Exception;

	/**
	 * 锟斤拷询锟斤拷锟斤拷锟斤拷录
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 * @return List<T> TODO
	 */
	public abstract List<T> query(Map<String, Object> map) throws Exception;
	
	/**
	 * 
	 * @return
	 * @throws Exception
	 * @return List<BaseTree>
	 * TODO
	 */
	public abstract List<Tree> queryTrees() throws Exception;
	
}
