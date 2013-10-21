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

import com.eggs.Foods;
import com.eggs.Menu;
import com.eggs.MenuBuilder;
import com.eggs.MenuRepository;
import com.eggs.Restor;

public class YamlFileXRepo implements MenuRepository {
	
	private List<Menu> menus = new ArrayList<Menu>(); 
	
	public List<Menu> getAllmenu() {
		return menus;
	}
	

	
	
	private void processRestaurant() {
		
		Constructor constructor = new Constructor(Restor.class);
		TypeDescription RestorDescription = new TypeDescription(Restor.class);
		RestorDescription.putListPropertyType("foods", Foods.class);
		constructor.addTypeDescription(RestorDescription);
		Yaml yaml = new Yaml(constructor);
		
		InputStream input;
		try {
			input = new FileInputStream(new File("C:/Users/tmp/Breakfast/rantotta/src/main/resources/Menus.yaml"));
	        for (Object data : yaml.loadAll(input)) {
	        	Restor restor = (Restor) data;
	        	MenuBuilder builder = MenuBuilder.menu().restaurant(restor.getname());
	        	List<Foods> foods = restor.getFoods();
	        	builder.food(foods.get(0).getId(), foods.get(0).getDesc(), foods.get(0).getPrice());
	        	builder.food(foods.get(1).getId(), foods.get(1).getDesc(), foods.get(1).getPrice());
	        	builder.food(foods.get(2).getId(), foods.get(2).getDesc(), foods.get(2).getPrice());
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


