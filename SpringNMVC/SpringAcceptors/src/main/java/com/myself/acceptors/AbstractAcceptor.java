package com.myself.acceptors;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import com.myself.batch.BatchWorker;
import com.myself.busiobj.AbsBusObj;
import com.myself.dto.EntityDto;
import com.myself.exception.CustomException;
import com.myself.services.IBaseService;

public abstract class AbstractAcceptor<T> implements IBaseAcceptor<T> {

	private static final Logger logger = LoggerFactory.getLogger(AbstractAcceptor.class);

	protected List<T> list;

	public BusinessResult businessAcceptor(AbsBusObj<T> absBusiObj) throws CustomException {
		return null;
	}

	public BusinessResult businessAcceptor(AbsBusObj<T> absBusiObj, IBeforeAcceptor beforeAcceptor,
			IDoAcceptor doAcceptor, IAfterAcceptor afterAcceptor) throws CustomException {
		Assert.isNull(absBusiObj, "the absBusiObj must not be null");
		EntityDto entityDto = absBusiObj.getEntityDto();
		beforeAcceptor.beforeAcceptor(entityDto);
		Object obj = processing(doAcceptor, entityDto);
		afterAcceptor.afterAcceptor();
		return getBusinessResult().setIntResult((Integer) obj);
	}

	public BusinessResult businessAcceptor(AbsBusObj<T> absBusiObj, IDoAcceptor doAcceptor) throws CustomException {
		return businessAcceptor(absBusiObj, beforeAcceptor, doAcceptor, afterAcceptor);
	}

	private Object processing(IDoAcceptor doAcceptor, EntityDto entityDto) throws CustomException {
		try {
			return doAcceptor.doAcceptor(entityDto);
		} catch (Exception e) {
			error(this.list.toString(), e);
			throw CustomException.getCustomException("aaa", e.getMessage());
		}
	}

	protected void init(EntityDto entityDto) throws CustomException {

	}

	protected IBeforeAcceptor beforeAcceptor = (entityDto) -> {
		Assert.isNull(entityDto.getTargetJson(), "the targetJson must not be empty");
		init(entityDto);
		return null;
	};

	protected IDoAcceptor doAcceptor = (entityDto) -> {
		return null;
	};

	protected IAfterAcceptor afterAcceptor = () -> {
		clear();
		return null;
	};

	/**
	 * 每次批处理的大小
	 */
	public static final int BATCH_NUMBER = 100;

	public static final int BATCH_MIN = 50;

	/**
	 * 将List分成多个List<BatchWorker<T>>
	 * 
	 * @param iBatchWorker
	 * @return
	 * @return List<BatchWorker<T>> TODO
	 */
	public List<BatchWorker<T>> getBatchWorkers(IBaseService<T> baseService, String batchType) {
		List<BatchWorker<T>> list = com.myself.utils.CollectionUtils.getList();
		int max = BATCH_MIN;
		int size = this.list.size();
		if (size > max) {
			size -= max;
		} else {
			max = 0;
		}
		int preSize = BATCH_NUMBER;
		int mod = (size % preSize);
		int page = (size / preSize);
		int count = mod == 0 ? page : page + 1;
		int fromIndex = 0;
		int toIndex = 0;
		List<T> newList = null;
		BatchWorker<T> batchWorker = null;
		for (int i = 0; i < count; i++) {
			fromIndex = i * preSize;
			toIndex = (i + 1) * preSize;
			if (toIndex > size) {
				toIndex = size + max;
			}
			newList = this.list.subList(fromIndex, toIndex);
			batchWorker = new BatchWorker<T>(batchType, newList, baseService);
			list.add(batchWorker);
		}
		return list;
	}
	
	/**
	 * 多线程批处理
	 * 
	 * @param iBatchWorker
	 * @return
	 * @return Integer TODO
	 */
	public Integer getCount(IBaseService<T> baseService, String batchType) {
		List<BatchWorker<T>> list = getBatchWorkers(baseService, batchType);
		int size = list.size();
		size = size / BATCH_NUMBER ;
		size = size > 5 ? 5 : size + 1;
		ExecutorService executor = Executors.newFixedThreadPool(size);
		int count = 0;
		try {
			List<Future<Integer>> results = executor.invokeAll(list);
			for (Future<Integer> f : results) {
				count += f.get();
			}
			executor.shutdown();
			executor = null;
		} catch (InterruptedException | ExecutionException e) {
			error(e.getMessage(), e);
		}
		return count;
	}
	
	/**
	 * 返回业务对象
	 * @return
	 * @return BusinessResult
	 * TODO
	 */
	public BusinessResult getBusinessResult() {
		return new BusinessResult();
	}
	
	/**
	 * 清理各种对象
	 * 
	 * @return void TODO
	 */
	protected void clear() {
		if (!CollectionUtils.isEmpty(this.list)) {
			this.list = null;
		}
	}

	protected void info(String message) {
		logger.info(message);
	}

	protected void error(String message, Exception e) {
		logger.error(message, e);
	}

}
