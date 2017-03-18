package com.myself.persistences.mapper.system;

import java.sql.Timestamp;
import java.util.Date;

import org.apache.ibatis.annotations.Param;

public abstract interface CommonMapper {
	
	/**
	 * ��ѯ���к�
	 * @param seqName
	 * @return
	 * @throws Exception
	 * @return long
	 * TODO
	 */
	public abstract Long querySeqByName(@Param("seqName") String seqName) throws Exception;
	
	/**
	 * ��ȡϵͳʱ��
	 * @return
	 * @throws Exception
	 * @return Date
	 * TODO
	 */
	public abstract Date queryDateTime() throws Exception;
	
	/**
	 * ��ȡϵͳʱ���
	 * @return
	 * @throws Exception
	 * @return Timestamp
	 * TODO
	 */
	public abstract Timestamp queryTimestamp() throws Exception;
	

	
}
