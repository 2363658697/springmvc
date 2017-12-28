package cn.et.mvc.lesson2.service;

import java.util.Map;

import cn.et.mvc.lesson2.utils.PageTools;

public interface FoodService {

	public abstract PageTools getFoodList(String foodName,Integer curPage);

	public abstract void saveFoode(String foodName, String price, String path);

	public abstract void deleteFood(String foodId);

	public abstract void updateFood(String foodId, String price,
			String foodName, String path);

	public abstract Map<String, Object> queryFoodById(String foodId);
}