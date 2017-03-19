package com.myself.services;

import javax.annotation.Resource;

import com.myself.persistences.mapper.basic.BookItemMapper;
import com.myself.persistences.mapper.basic.BookMapper;

public abstract class AbstractBasicService<T> extends AbstractService<T> {

	@Resource(name = "bookMapper")
	private BookMapper bookMapper;
	@Resource(name = "bookItemMapper")
	private BookItemMapper bookItemMapper;

	protected final BookMapper getBookMapper() {
		return this.bookMapper;
	}

	protected final BookItemMapper getBookItemMapper() {
		return bookItemMapper;
	}

}
