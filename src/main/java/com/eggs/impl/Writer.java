package com.eggs.impl;

import java.util.ArrayList;
import java.util.List;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import com.eggs.Food;
import com.eggs.Menu;
import com.eggs.Restaurant;
import com.eggs.MenuList;

public class Writer {
	
	private void maker() {
		
		Menu menu1 = new Menu();
		Menu menu2 = new Menu();
		Restaurant restaurant1 = new Restaurant();
		Restaurant restaurant2 = new Restaurant();
		
		restaurant1.setName("Karesz");
		restaurant2.setName("Marcello");
		
		menu1.setRestaurant(restaurant1);
		menu2.setRestaurant(restaurant2);
		
		Food food1 = new Food();
		Food food2 = new Food();
		Food food3 = new Food();
		Food food4 = new Food();
		Food food5 = new Food();
		Food food6 = new Food();
		
		
		food1.setName("Hagymas Rantotta");
		food1.setId("k1");
		food1.setPrice(450);
		
		food2.setName("Ham and Eggs");
		food2.setId("k2");
		food2.setPrice(540);

		food3.setName("Kroasszon");
		food3.setId("k3");
		food3.setPrice(320);
		
		food4.setName("Margherita");
		food4.setId("m1");
		food4.setPrice(250);
		
		food5.setName("Grilled Cat");
		food5.setId("m2");
		food5.setPrice(890);
		
		food6.setName("Ostriga");
		food6.setId("m3");
		food6.setPrice(1490);
		
		List<Food> foodlist1 = new ArrayList<Food>();
		List<Food> foodlist2 = new ArrayList<Food>();
		
		foodlist1.add(food1);
		foodlist1.add(food2);
		foodlist1.add(food3);
		foodlist2.add(food4);
		foodlist2.add(food5);
		foodlist2.add(food6);
		
		menu1.setFoodList(foodlist1);
		menu2.setFoodList(foodlist2);
		
		MenuList menulist = new MenuList();
		menulist.addMenuList(menu1);
		menulist.addMenuList(menu2);
				
	    DumperOptions options = new DumperOptions();
	    options.setExplicitStart(true);
	    Yaml yaml = new Yaml(options);
	    System.out.println(yaml.dump(menulist));
	}
	
	public static void main(String[] args) {
		
		Writer w = new Writer();
		w.maker();
	}
	
	

}
