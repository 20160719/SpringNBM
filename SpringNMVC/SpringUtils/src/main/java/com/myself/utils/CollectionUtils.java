package com.myself.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CollectionUtils extends org.springframework.util.CollectionUtils {
	
	private CollectionUtils () {
		
	}
	
	public static <T> List<T> getList() {
		return new ArrayList<T>();
	}
	
	public static <K, V> Map<K, V> getMap(){
		return new HashMap<K, V>();
	}

}
