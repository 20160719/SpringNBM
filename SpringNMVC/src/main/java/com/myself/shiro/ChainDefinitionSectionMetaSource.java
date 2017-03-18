package com.myself.shiro;

import java.text.MessageFormat;

import org.apache.shiro.config.Ini;
import org.apache.shiro.config.Ini.Section;
import org.springframework.beans.factory.FactoryBean;

public class ChainDefinitionSectionMetaSource implements FactoryBean<Ini.Section> {

	private String fiterChainDefinitions;
	
	private static final String ROLE_STRING = "authc,roles[\"{0}\"]";
	
	@Override
	public Section getObject() throws Exception {
		Ini ini = new Ini();
		ini.load(fiterChainDefinitions);
		Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);
		section.put("/system/loginout/content.action", MessageFormat.format(ROLE_STRING, "role2"));
		return section;
	}

	@Override
	public Class<?> getObjectType() {
		return getClass();
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

	public void setFiterChainDefinitions(String fiterChainDefinitions) {
		this.fiterChainDefinitions = fiterChainDefinitions;
	}

}
