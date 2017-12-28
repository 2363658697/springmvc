package cn.et.mvc.lesson2.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.et.mvc.lesson2.dao.FoodDao;
import cn.et.mvc.lesson2.service.FoodService;
import cn.et.mvc.lesson2.utils.PageTools;

@Service
public class FoodServiceImpl implements FoodService {
	@Autowired
	FoodDao foodDao;



	/* (non-Javadoc)
	 * @see cn.et.mvc.lesson2.service.impl.FoodService#getFoodList(java.lang.String)
	 */
	public PageTools getFoodList(String foodName,Integer curPage) {
		if (foodName == null) {
			foodName = "";
		}
		if(curPage==null){
			curPage=1;
		}
				
		Integer totalCount=foodDao.getFoodCount(foodName);
		PageTools pageTools=new PageTools(curPage, 5, totalCount);
				
		List<Map<String, Object>> list = foodDao.getFoodList(foodName,pageTools.getStartIndex()-1,pageTools.getPageCount());
		pageTools.setData(list);
		return pageTools;
	}


	/* (non-Javadoc)
	 * @see cn.et.mvc.lesson2.service.impl.FoodService#saveFoode(java.lang.String, java.lang.String, java.lang.String)
	 */
	public void saveFoode(String foodName, String price, String path) {
		foodDao.saveFoode(foodName, price, path);
	}


	/* (non-Javadoc)
	 * @see cn.et.mvc.lesson2.service.impl.FoodService#deleteFood(java.lang.String)
	 */
	public void deleteFood(String foodId) {
		foodDao.deleteFood(foodId);
	}


	/* (non-Javadoc)
	 * @see cn.et.mvc.lesson2.service.impl.FoodService#updateFood(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public void updateFood(String foodId, String price, String foodName,
			String path) {
		foodDao.updateFood(foodId, price, foodName, path);
	}


	public Map<String, Object> queryFoodById(String foodId) {
		return foodDao.queryFoodById(foodId);
	}
}
