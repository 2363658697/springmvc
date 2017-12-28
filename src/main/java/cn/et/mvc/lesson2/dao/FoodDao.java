package cn.et.mvc.lesson2.dao;

import java.util.List;
import java.util.Map;

public interface FoodDao {

	public abstract Integer getFoodCount(String foodName);

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.et.mvc.lesson2.dao.impl.FoodDao#getFoodList(java.lang.String)
	 */
	public abstract List<Map<String, Object>> getFoodList(String foodName,
			Integer startIndex, Integer pageCount);

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.et.mvc.lesson2.dao.impl.FoodDao#saveFoode(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	public abstract void saveFoode(String foodName, String price, String path);

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.et.mvc.lesson2.dao.impl.FoodDao#deleteFood(java.lang.String)
	 */
	public abstract void deleteFood(String foodId);

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.et.mvc.lesson2.dao.impl.FoodDao#updateFood(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	public abstract void updateFood(String foodId, String price,
			String foodName, String path);

	public abstract Map<String, Object> queryFoodById(String foodId);

}