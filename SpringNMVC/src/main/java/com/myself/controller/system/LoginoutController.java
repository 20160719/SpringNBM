package com.myself.controller.system;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.myself.controller.AbstractSystemController;
import com.myself.interceptor.repeat.Token;

@Controller
@RequestMapping(value = "/system/loginout")
public class LoginoutController extends AbstractSystemController {
	
	@RequestMapping(value = "toLogin" + SUFFIX, method = RequestMethod.GET)
	@Token(save = true)
	public String toLogin() {
		return getDirectory() + "login";
	}
	
	@RequestMapping(value = "login" + SUFFIX, method = RequestMethod.POST)
	@Token(remove = true)
	public String login(@RequestParam("account") String account,@RequestParam("password") String password) {
		UsernamePasswordToken token = new UsernamePasswordToken(account, password);
		setAccount(account);
		Subject subject = SecurityUtils.getSubject();
		try {
			Thread.sleep(3000);
			subject.login(token);
			return "redirect:/system/loginout/content.action";
		} catch (Exception e) {
			return getDirectory() + "login";
		}
	}
	
	@RequestMapping(value = "content" + SUFFIX, method = RequestMethod.GET)
	public String content() {
		return "content";
	}
	
	@RequestMapping(value = "navigation" + SUFFIX, method = RequestMethod.GET)
	public String navigation() {
		return "navigation";
	}
	
	@RequestMapping(value = "logout" + SUFFIX, method = RequestMethod.GET)
	public String logout() {
		return getDirectory() + "login";
	}
	
	@Override
	protected String getDirectory() {
		return "system/loginout/";
	}

}
