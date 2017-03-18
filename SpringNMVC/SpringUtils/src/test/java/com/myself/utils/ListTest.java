package com.myself.utils;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.myself.persistences.entity.Tree;

public class ListTest {

	@Test
	public void test() {
		List<String> list = new ArrayList<String>();
		list.add("aaa");
		list.add("bbb");
		list.add("ccc");
		list.add("ddd");
		List<String> list1 = new ArrayList<String>();
		list1.add("aaa");
		list1.add("bbb");
		boolean flag = list.addAll(list1);
		System.out.println(flag);
		System.out.println(list);
		System.out.println(list.removeAll(list1));
		System.out.println(list);
	}
	
	public void test_01() {
		List<Tree> list = CollectionUtils.getList();
		
	}

}
