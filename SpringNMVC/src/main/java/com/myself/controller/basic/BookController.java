package com.myself.controller.basic;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myself.controller.AbstractBasicController;

@Controller
@RequestMapping(value = "/basic/book")
public class BookController extends AbstractBasicController {

	@Override
	protected String getDirectory() {
		// TODO Auto-generated method stub
		return null;
	}

}
