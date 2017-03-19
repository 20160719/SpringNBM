package com.myself.acceptors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import com.alibaba.fastjson.JSONArray;
import com.myself.exception.CustomException;
import com.myself.persistences.entity.Tree;
import com.myself.services.system.IBookTypeService;
import com.myself.services.system.IMenuService;
import com.myself.services.system.IOrgService;
import com.myself.services.system.IPermsService;
import com.myself.services.system.IRoleService;
import com.myself.services.system.IUserService;
import com.myself.utils.CollectionUtils;

public abstract class AbstractSystemAcceptor<T> extends AbstractAcceptor<T> {

	@Resource(name = "userServiceImpl")
	private IUserService userService;
	@Resource(name = "roleServiceImpl")
	private IRoleService roleService;
	@Resource(name = "menuServiceImpl")
	private IMenuService menuService;
	@Resource(name = "permsServiceImpl")
	private IPermsService permsService;
	@Resource(name = "orgServiceImpl")
	private IOrgService orgService;
	@Resource(name = "bookTypeServiceImpl")
	private IBookTypeService bookTypeService;
	
	/**
	 * 将tree字符串转为List<Tree>集合
	 * @param treeStr
	 * @return
	 * @throws CustomException 
	 */
	protected List<Tree> transTree(String treeStr) throws CustomException {
		List<Tree> list = JSONArray.parseArray(treeStr, Tree.class);
		if (!CollectionUtils.isEmpty(list)) {
			throw CustomException.getCustomException("the list must not be empty");
		}
		return list;
	}
	
	/**
	 * 
	 * @param acceptorQuerys
	 * @return
	 * @throws CustomException
	 * @return List<T>
	 * TODO
	 */
	protected List<T> querys(IAcceptorQuerys<T> acceptorQuerys) throws CustomException {
		try {
			return acceptorQuerys.querys();
		} catch (Exception e) {
			throw CustomException.getCustomException(e.getMessage());
		}
	}
	
	/**
	 * 查询所有记录，并将设置children属性
	 * @param acceptorQuerys
	 * @return
	 * @throws CustomException
	 */
	protected List<Tree> queryTrees(IAcceptorQuerys<Tree> acceptorQuerys) throws CustomException {
		List<Tree> currentList = null;
		try {
			currentList = acceptorQuerys.querys();
			Map<String, List<Tree>> map = currentList.stream().collect(Collectors.groupingBy(Tree::getId));
			currentList = currentList.stream().filter(t -> {
				t.setChildren(map.get(t.getId()));
				return true;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			throw CustomException.getCustomException(e.getMessage());
		}
		return CollectionUtils.isEmpty(currentList) ? CollectionUtils.getList() : currentList;
	}
	
	/**
	 * 过滤List集合
	 * @param acceptorQuerys
	 * @param tree
	 * @return
	 * @throws CustomException
	 */
	protected List<Tree> transTrees(IAcceptorQuerys<Tree> acceptorQuerys, Tree tree) throws CustomException {
		List<Tree> treeList = queryTrees(acceptorQuerys);
		return treeList.stream().filter(t -> t.equalContent(tree)).collect(Collectors.toList());
	}

	protected final IUserService getUserService() {
		return this.userService;
	}

	protected final IRoleService getRoleService() {
		return this.roleService;
	}

	protected final IMenuService getMenuService() {
		return this.menuService;
	}

	protected final IPermsService getPermsService() {
		return this.permsService;
	}

	protected final IOrgService getOrgService() {
		return this.orgService;
	}

	protected IBookTypeService getBookTypeService() {
		return bookTypeService;
	}

}
