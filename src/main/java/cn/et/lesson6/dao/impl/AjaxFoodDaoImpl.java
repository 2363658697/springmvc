package cn.et.lesson6.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.et.lesson6.dao.AjaxFoodDao;

@Repository
public class AjaxFoodDaoImpl implements AjaxFoodDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	/*
	 * (non-Javadoc)
	 * 
	 * @see cn.et.lesson6.dao.impl.AjaxFoodDao#getFoodList(java.lang.String)
	 */
	public List<Map<String, Object>> queryFoodList(String foodName) {
		String sql = "select * from food where foodname like '%" + foodName
				+ "%'";

		List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

		return list;
	}

	public void deleteFood(String foodId) {
		String sql = "delete from food where foodId=" + foodId;
		jdbcTemplate.execute(sql);

	}

	
	public void updateFood(String foodId, String foodName, String price) {
		String sql = "update food set price=" + price + " , foodname='"
				+ foodName + "' where foodid=" + foodId;

		jdbcTemplate.execute(sql);

	}

	public void saveFood(String foodName, String price) {
		String sql = "insert into food(foodname,price) values('" + foodName
				+ "'," + price + ")";

		jdbcTemplate.execute(sql);

	}

}
