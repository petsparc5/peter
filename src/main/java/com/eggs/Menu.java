package com.eggs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Menu {
	private Restaurant restaurant;
	private Map<String, Food> foodMap = new HashMap<String, Food>();
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public List<Food> getFoodList() {
		ArrayList list = new ArrayList(foodMap.values());
		return list;
	}
	public void setFoodList(List<Food> foodlist) {
		for (int i = 0; i<foodlist.size(); i++) {
			foodMap.put(foodlist.get(i).getId(), foodlist.get(i));
		}
	}
	public void setFoodMap(Map<String, Food> foodMap) {
		this.foodMap = foodMap;
	}
	public void addFood(Food food) {
		foodMap.put(food.getId(), food);
		
	}
}
