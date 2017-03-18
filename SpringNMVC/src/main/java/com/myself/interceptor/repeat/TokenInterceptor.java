package com.myself.interceptor.repeat;

import java.lang.reflect.Method;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class TokenInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = LoggerFactory.getLogger(TokenInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			Method method = handlerMethod.getMethod();
			Token token = method.getAnnotation(Token.class);
			if (null != token) {
				boolean saveFlag = token.save();
				if (saveFlag) {
					request.getSession().setAttribute("token", UUID.randomUUID().toString());
				}
				boolean removeFlag = token.remove();
				if (removeFlag) {
					boolean isRepeat = isRepeatSubmit(request);
					if(isRepeat) {
						logger.error("please don't repeat sumbit, url:" + request.getServletPath());
						return false;
					}
					request.getSession(true).removeAttribute("token");
				}
			}
			return true;
		} else {
//			response.sendRedirect("");
			return super.preHandle(request, response, handler);
		}

	}

	private boolean isRepeatSubmit(HttpServletRequest request) {
		String serverToken = (String) request.getSession(true).getAttribute("token");
		String clientToken = request.getParameter("token");
		boolean flag = null == serverToken ? true : null == clientToken ? true : !serverToken.equals(clientToken) ? true : false;
		return flag;
	}

}
