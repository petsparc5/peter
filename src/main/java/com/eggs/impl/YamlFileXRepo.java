package com.eggs.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.yaml.snakeyaml.TypeDescription;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import com.eggs.Food;
import com.eggs.Menu;
import com.eggs.MenuBuilder;
import com.eggs.MenuList;
import com.eggs.MenuRepository;

public class YamlFileXRepo implements MenuRepository {
	
	private List<Menu> menus = new ArrayList<Menu>(); 
	
	public List<Menu> getAllmenu() {
		return menus;
	}
	

	
	
	private void processRestaurant() {
		
		Constructor constructor = new Constructor(MenuList.class);
		TypeDescription RestorDescription = new TypeDescription(MenuList.class);
		RestorDescription.putListPropertyType("foods", Menu.class);
		constructor.addTypeDescription(RestorDescription);
		Yaml yaml = new Yaml(constructor);
		
		InputStream input;
		try {
			input = new FileInputStream(new File("C:/Users/tmp/Breakfast/rantotta/src/main/resources/Menus.yaml"));
	        MenuList menulist = (MenuList) yaml.load(input);
	        List<Menu> list = menulist.getMenuList();
	        for (int i= 0; i<list.size(); i++) {
	        	
	        	MenuBuilder builder = MenuBuilder.menu().restaurant(list.get(i).getRestaurant().getName());
	        	List<Food> foodlist = list.get(i).getFoodList();
	        	builder.food(foodlist.get(0).getId(), foodlist.get(0).getName(), foodlist.get(0).getPrice());
	        	builder.food(foodlist.get(1).getId(), foodlist.get(1).getName(), foodlist.get(1).getPrice());
	        	builder.food(foodlist.get(2).getId(), foodlist.get(2).getName(), foodlist.get(2).getPrice());
	        	menus.add(builder.build());
	        }
   
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	        

	    
	}
	
	public static void main(String[] args) {
		YamlFileXRepo repository = new YamlFileXRepo();
		repository.processRestaurant();
		ConsoleMenuPrinter printer = new ConsoleMenuPrinter(repository);
		
		printer.printMenus();
	}
	
}


