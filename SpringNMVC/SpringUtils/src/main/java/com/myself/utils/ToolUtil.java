package com.myself.utils;

public class ToolUtil {
	
	private ToolUtil() {
		
	}
	
	public static boolean isNull(Object obj) {
		return null == obj;
	}
	
	public static boolean isNotNull(Object obj) {
		return null != obj;
	}

}
