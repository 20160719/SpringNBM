package com.myself.persistences.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myself.persistences.entity.Operation;

public abstract interface IBaseMapper<T> {

	/**
	 * ����
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 * @return Integer TODO
	 */
	public abstract Integer creates(@Param("list") List<T> list)
			throws Exception;

	/**
	 * ������ʷ
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 * @return Integer TODO
	 */
	public abstract Integer createHiss(@Param("list") List<T> list,
			@Param("operation") Operation operation) throws Exception;

	/**
	 * ɾ��
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 * @return Integer TODO
	 */
	public abstract Integer deletes(@Param("list") List<T> list)
			throws Exception;

	/**
	 * �޸�
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 * @return Integer TODO
	 */
	public abstract Integer modifys(@Param("list") List<T> list)
			throws Exception;

	/**
	 * ��ѯ������¼
	 * 
	 * @param list
	 * @return
	 * @throws Exception
	 * @return T TODO
	 */
	public abstract T load(@Param("record") T record) throws Exception;

	/**
	 * ��ѯ������¼
	 * 
	 * @param obj
	 * @return
	 * @throws Exception
	 * @return List<T> TODO
	 */
	public abstract List<T> querys(@Param("record") T record) throws Exception;

	/**
	 * ��ѯ������¼
	 * 
	 * @param map
	 * @return
	 * @throws Exception
	 * @return List<T> TODO
	 */
	public abstract List<T> query(@Param("map") Map<String, Object> map)
			throws Exception;

}
