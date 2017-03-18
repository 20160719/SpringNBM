package com.myself.services.basic.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.myself.persistences.entity.basic.BookType;
import com.myself.services.AbstractBasicService;
import com.myself.services.basic.IBookTypeService;

@Service(value = "bookTypeServiceImpl")
public class BookTypeServiceImpl extends AbstractBasicService<BookType>
		implements IBookTypeService {

	public Integer creates(List<BookType> list) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer deletes(List<BookType> list) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer modifys(List<BookType> list) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public BookType load(BookType obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BookType> querys(BookType obj) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	public List<BookType> query(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
