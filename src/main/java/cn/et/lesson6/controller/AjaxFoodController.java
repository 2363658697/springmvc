package cn.et.lesson6.controller;

import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.et.lesson6.service.AjaxFoodService;

@Controller
public class AjaxFoodController {
	@Autowired
	private AjaxFoodService ajaxFoodService;

	/**
	 * ajax获取数据的最原始方式：OutputStream os
	 * 		os.write(通过第三方json-lib转换的json字符串.getByte())
	 * 	
	 * @param outputStream
	 * @param foodName
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/queryAFood", method = RequestMethod.GET)
	public String queryFood(OutputStream outputStream, String foodName)
			throws Exception {
		List<Map<String, Object>> queryFoodList = ajaxFoodService
				.queryFoodList(foodName);

		JSONArray jsonArray = JSONArray.fromObject(queryFoodList);
		String jString = jsonArray.toString();

		outputStream.write(jString.getBytes("UTF-8"));
		return null;
	}

	
	/**
	 * 直接返回 字符数组 + @ResponseBody
	 *  减少流的输出动作代码
	 *    os.write(jsonStr.getBytes("UTF-8"));
	 * @param foodname
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/queryAFoodByte", method = RequestMethod.GET)
	public byte[] queryFoodByte(OutputStream outputStream, String foodName)
			throws Exception {
		List<Map<String, Object>> queryFoodList = ajaxFoodService
				.queryFoodList(foodName);

		JSONArray jsonArray = JSONArray.fromObject(queryFoodList);
		String jString = jsonArray.toString();

		return jString.getBytes("UTF-8");
	}
	
	/**
	 * 直接返回对象 springmvc自动转换成json:需要配置消息转换器，引入jar包
	 * @param foodname
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping(value = "/queryAFoodList", method = RequestMethod.GET)
	public List<Map<String, Object>> queryFoodList(OutputStream outputStream, String foodName)
			throws Exception {
		List<Map<String, Object>> queryFoodList = ajaxFoodService
				.queryFoodList(foodName);
		return queryFoodList;
	}
	
	
	
	
	@RequestMapping(value = "/food", method = RequestMethod.POST)
	public String saveFood(String foodName,String price,OutputStream outputStream) throws Exception {
		try {
			ajaxFoodService.saveFood(foodName, price);
			outputStream.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			outputStream.write("0".getBytes("UTF-8"));
		}
		return null;
	}

	@RequestMapping(value = "/food/{foodId}", method = RequestMethod.PUT)
	public String updateFood(@PathVariable String foodId, String foodName,
			String price, OutputStream outputStream) throws Exception {
		try {
			ajaxFoodService.updateFood(foodId, foodName, price);
			outputStream.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			outputStream.write("0".getBytes("UTF-8"));
		}
		return null;
	}

	@RequestMapping(value = "/food/{foodId}", method = RequestMethod.DELETE)
	public String deleteFood(@PathVariable String foodId,
			OutputStream outputStream) throws Exception {
		try {
			ajaxFoodService.deleteFood(foodId);
			outputStream.write("1".getBytes("UTF-8"));
		} catch (Exception e) {
			outputStream.write("0".getBytes("UTF-8"));
		}
		return null;
	}

}
