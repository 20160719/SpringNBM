package com.myself.services.basic.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.myself.persistences.entity.basic.BookItem;
import com.myself.services.AbstractBasicService;
import com.myself.services.basic.IBookItemService;

@Service(value = "bookItemServiceImpl")
public class BookItemServiceImpl extends AbstractBasicService<BookItem> implements IBookItemService {

	@Override
	public Integer creates(List<BookItem> list) throws Exception {
		return getBookItemMapper().creates(list);
	}

	@Override
	public Integer deletes(List<BookItem> list) throws Exception {
		return getBookItemMapper().deletes(list);
	}

	@Override
	public Integer modifys(List<BookItem> list) throws Exception {
		return getBookItemMapper().modifys(list);
	}

	@Override
	public BookItem load(BookItem obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookItem> querys(BookItem obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookItem> query(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
