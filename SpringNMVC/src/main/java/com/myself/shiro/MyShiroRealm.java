package com.myself.shiro;

import java.util.HashSet;
import java.util.Set;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import com.myself.persistences.entity.system.User;

public class MyShiroRealm extends AuthorizingRealm {
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		try {
			String userName = (String) principal.fromRealm(getName()).iterator().next();
			if (null != userName && "zhang".equals(userName)) {
				Set<String> roleSet = new HashSet<String>();
				roleSet.add("role1");
				roleSet.add("role2");
				info.addRoles(roleSet);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	// 获取认证信息
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
		AuthenticationInfo info = null;
		try {
			UsernamePasswordToken token = (UsernamePasswordToken) authToken;
			String userName = token.getUsername();
			if (null != userName && "zhang".equals(userName)) {
				User user = new User();
				user.setAccount(userName);
				info = new SimpleAuthenticationInfo(user.getAccount(), "123", getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

}
