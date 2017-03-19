package com.myself.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myself.acceptors.BusinessResult;
import com.myself.busiobj.system.SystemObj;
import com.myself.controller.AbstractSystemController;
import com.myself.dto.system.SystemDto;
import com.myself.exception.CustomException;
import com.myself.persistences.entity.Tree;

@Controller
@RequestMapping(value = "/system/menu")
public class MenuController extends AbstractSystemController {

	@RequestMapping(value = "create" + SUFFIX, method = RequestMethod.POST)
	@ResponseBody
	public BusinessResult create(@RequestParam("menuTargetJson") String menuTargetJson) throws CustomException {
		SystemDto sysDto = getSystemDto();
		sysDto.setTargetJson(menuTargetJson);
		SystemObj<Tree> sysObj = doAction(sysDto);
		return getMenuAcceptor().creates(sysObj);
	}
	
	@RequestMapping(value = "querys" + SUFFIX, method = RequestMethod.POST)
	@ResponseBody
	public String querys(@ModelAttribute("tree") Tree tree) {
		
		return null;
	}
	
	@Override
	protected String getDirectory() {
		return "system/menu/";
	}

}
