package com.myself.services;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myself.persistences.entity.Operation;
import com.myself.persistences.entity.Tree;
import com.myself.persistences.mapper.system.CommonMapper;

public abstract class AbstractService<T> implements IBaseService<T> {

	protected static final Logger logger = LoggerFactory.getLogger(AbstractService.class);

	@Resource(name = "commonMapper")
	private CommonMapper commonMapper;

	@Override
	public Integer createHiss(List<T> list, Operation operation) throws Exception {
		return null;
	}

	@Override
	public List<Tree> queryTrees() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public synchronized long querySeqByName(String seqName) throws Exception {
		return getCommonMapper().querySeqByName(seqName).longValue();
	}

	public synchronized Date queryDateTime() throws Exception {
		return getCommonMapper().queryDateTime();
	}

	protected void info(String message) {
		logger.info(message);
	}

	protected void error(String message, Exception e) {
		logger.error(message, e);
	}

	protected final CommonMapper getCommonMapper() {
		return this.commonMapper;
	}

}
