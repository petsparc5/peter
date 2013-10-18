package com.eggs.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.eggs.Menu;
import com.eggs.MenuBuilder;
import com.eggs.MenuRepository;

public class YAMLFileMenuRepository implements MenuRepository {

	private List<Menu> menus = new ArrayList<Menu>();

	private void processRestaurants(String file) {
		try {
			String filename = file + ".yaml";
			
			InputStream stream = getClass().getClassLoader().getSystemClassLoader().getResourceAsStream(filename);
			BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

			MenuBuilder builder = null;
			boolean check = false;
			String line;
			String[] temp = new String[2];
			while (!(line = reader.readLine()).contains("...")) {
				//System.out.println(line);
				if (line.contains("---")) {
					if(check){
						menus.add(builder.build());
					}
					builder = MenuBuilder.menu();
					line = reader.readLine();
					String[] fields = line.split(":");
					builder.restaurant(fields[1]);
					check = true;
				}
				else if  (line.contains("Foods")) {
					
				}
				else {processMenuLine(builder, line, temp);
				}	
			}
			menus.add(builder.build());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String[] processMenuLine(MenuBuilder builder, String line, String[] list) {
		String[] fields = line.split(":");
		if (fields[0].contains("ID")) {
			list[0] = fields[1].trim();
		}
		if (fields[0].contains("Desc")) {
			list[1] = fields[1].trim();
		}
		if (fields[0].contains("Price")) {
			float price = Float.parseFloat(fields[1]);
			builder.food(list[0], list[1],price);
			list[0] = "";
			list[1] = "";
		}
		
		return list;
	}

	public List<Menu> getAllmenu() {
		return menus;
	}

	public static void main(String[] args) {
		YAMLFileMenuRepository repository = new YAMLFileMenuRepository();
		repository.processRestaurants("Menus");
		ConsoleMenuPrinter printer = new ConsoleMenuPrinter(repository);
		
		printer.printMenus();
	}

}
