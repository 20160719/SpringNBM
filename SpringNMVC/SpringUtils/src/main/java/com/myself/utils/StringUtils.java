package com.myself.utils;

public class StringUtils extends org.apache.commons.lang.StringUtils {

	private StringUtils() {
		
	}
	
	public static boolean isNotBlank(String str) {
		return (!(org.apache.commons.lang.StringUtils
				.isBlank(org.apache.commons.lang.StringUtils.trimToEmpty(str))));
	}

}
