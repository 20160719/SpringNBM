package com.myself.persistence.entity.system;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.myself.persistences.entity.system.Org;

public class OrgTest {

	@Test
	public void test_01() {
		Org root = new Org();
		List<Org> children = Arrays.asList(new Org(), new Org(), new Org());
		root.setChildren(children);
		
		Org org1 = (Org) root.getChildren().get(0);
		System.out.println(org1);
		
	}

}
