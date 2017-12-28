package cn.et.mvc.lesson2.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.mvc.lesson2.dao.FoodDao;

@Repository
public class FoodDaoImpl implements FoodDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	/* (non-Javadoc)
	 * @see cn.et.mvc.lesson2.dao.impl.FoodDao#getFoodCount(java.lang.String)
	 */
	public Integer getFoodCount(String foodName) {
		String sql = "select count(*) ct from food where foodname like '%"
				+ foodName + "%'";
		
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

		Integer count = Integer.parseInt(list.get(0).get("ct").toString());
		return count;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.et.mvc.lesson2.dao.impl.FoodDao#getFoodList(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see cn.et.mvc.lesson2.dao.impl.FoodDao#getFoodList(java.lang.String, java.lang.Integer, java.lang.Integer)
	 */
	public List<Map<String, Object>> getFoodList(String foodName,Integer startIndex,Integer pageCount) {
		String sql = "select * from food where foodname like '%" + foodName
				+ "%' limit "+startIndex+","+pageCount;
				
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

		return list;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.et.mvc.lesson2.dao.impl.FoodDao#saveFoode(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see cn.et.mvc.lesson2.dao.impl.FoodDao#saveFoode(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void saveFoode(String foodName, String price, String path) {
		String sql = "insert into food(foodname,price,path) values('"
				+ foodName + "'," + price + ", '" + path + "')";

		jdbcTemplate.execute(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.et.mvc.lesson2.dao.impl.FoodDao#deleteFood(java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see cn.et.mvc.lesson2.dao.impl.FoodDao#deleteFood(java.lang.String)
	 */
	public void deleteFood(String foodId) {
		String sql = "delete from food where foodId=" + foodId;
		jdbcTemplate.execute(sql);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.et.mvc.lesson2.dao.impl.FoodDao#updateFood(java.lang.String,
	 * java.lang.String, java.lang.String, java.lang.String)
	 */
	/* (non-Javadoc)
	 * @see cn.et.mvc.lesson2.dao.impl.FoodDao#updateFood(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void updateFood(String foodId, String price, String foodName,
			String path) {
		String sql = "update food set price=" + price + " , foodname='"
				+ foodName + "' , path='" + path + "' where foodid=" + foodId;	
				
		jdbcTemplate.execute(sql);
	}

	/* (non-Javadoc)
	 * @see cn.et.mvc.lesson2.dao.impl.FoodDao#queryFoodById(java.lang.String)
	 */
	public Map<String, Object> queryFoodById(String foodId) {
		String sql = "select * from food where foodid=" + foodId;
		
		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);
		return list.get(0);
	}

}
