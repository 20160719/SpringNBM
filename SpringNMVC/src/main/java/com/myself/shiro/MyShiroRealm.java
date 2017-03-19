package com.myself.shiro;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.myself.acceptors.system.IUserAcceptor;
import com.myself.persistences.entity.system.Permssion;
import com.myself.persistences.entity.system.Role;
import com.myself.persistences.entity.system.User;
import com.myself.utils.StringUtils;
import com.myself.utils.ToolUtil;

public class MyShiroRealm extends AuthorizingRealm {
	
	private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);
	
	@Resource(name = "userAcceptor")
	private IUserAcceptor userAcceptor;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principal) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		try {
			String account = (String) principal.fromRealm(getName()).iterator().next();
			User user = new User();
			user.setAccount(account);
			List<Role> roleSet = userAcceptor.queryRoles(user);
			List<Permssion> permsSet = userAcceptor.queryPerms(user);
			Set<String> rolesSet = roleSet.stream().map(r -> r.getId()).collect(Collectors.toSet());
			Set<String> permssSet = permsSet.stream().map(perms -> perms.getValue()).collect(Collectors.toSet());
			info.addRoles(rolesSet);
			info.addStringPermissions(permssSet);
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
			String account = token.getUsername();
			if (!StringUtils.isNotBlank(account)) {
				logger.error("error:account must not be empty...");
			}
			User user = new User();
			user.setAccount(account);
			user = userAcceptor.load(user);
			if (ToolUtil.isNull(user)) {
				logger.error("error:the user not exist...");
			}
			info = new SimpleAuthenticationInfo(user.getAccount(), user.getPassword(), getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

}
