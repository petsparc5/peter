package com.eggs;

import java.util.ArrayList;
import java.util.List;

public class MenuList {

	private List<Menu> menuList = new ArrayList<Menu>();
	
	public List<Menu> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	public void addMenuList (Menu menu) {
		menuList.add(menu);
	}
	
}
