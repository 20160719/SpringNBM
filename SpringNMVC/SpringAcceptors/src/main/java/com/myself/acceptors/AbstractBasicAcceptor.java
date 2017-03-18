package com.myself.acceptors;

import javax.annotation.Resource;

import com.myself.services.basic.IBookService;
import com.myself.services.basic.IBookTypeService;

public abstract class AbstractBasicAcceptor<T> extends AbstractAcceptor<T> {

	@Resource(name = "bookServiceImpl")
	private IBookService bookService;
	@Resource(name = "bookTypeServiceImpl")
	private IBookTypeService bookTypeService;

	protected final IBookService getBookService() {
		return this.bookService;
	}

	protected final IBookTypeService getBookTypeService() {
		return this.bookTypeService;
	}

}
