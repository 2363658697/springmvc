package cn.et.mvc.lesson2.controller;

import java.awt.image.BufferedImage;
import java.io.File;

import java.io.IOException;
import java.net.URLEncoder;

import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import cn.et.mvc.lesson2.service.FoodService;
import cn.et.mvc.lesson2.utils.PageTools;

@Controller
public class FoodController {
	@Autowired
	FoodService foodService;
	
	

	/**
	 * 查出所有菜品信息
	 * 
	 * @param foodName
	 *            菜品名
	 * @param model
	 *            Model
	 * @return "/detail/foodList.jsp"
	 */
	@RequestMapping(value = "/queryFood", method = RequestMethod.GET)
	public String getFoodList(String foodName, Model model,Integer curPage) {
		PageTools pageTools=foodService.getFoodList(foodName, curPage);
		model.addAttribute("list",pageTools);
		return "/detail/foodList.jsp";
	}

	/**
	 * 根据菜品编号获取菜品详情
	 * 
	 * @param foodId
	 *            菜品编号
	 * @param model
	 *            Model
	 * @return "/foodDetail.ftl"
	 */
	@RequestMapping(value = "/queryFoodDatail/{foodId}", method = RequestMethod.GET)
	public String queryFoodDatail(@PathVariable String foodId, Model model) {
		Map<String, Object> map = foodService.queryFoodById(foodId);
		model.addAttribute("map", map);
		return "/foodDetail.ftl";
	}

	/**
	 * 添加菜品
	 * @param foodName 菜品编号
	 * @param price  菜品价格
	 * @param imageUrl 菜品图片路径
	 * @param model Model
	 * @return getFoodList(null, model)
	 * @throws Exception
	 */
	@RequestMapping(value = "/saveFood", method = RequestMethod.POST)
	public String saveFoode(String foodName, String price,
			MultipartFile imageUrl, Model model) throws Exception {
		String path = imageUrl.getOriginalFilename();
		String absPath = "D:/images";
		imageUrl.transferTo(new File(absPath + "/" + path));
		foodService.saveFoode(foodName, price, path);
		return getFoodList(null, model,1);
	}
	
	/**
	 * 删除菜品
	 * @param foodId 菜品编号
	 * @param model Model
	 * @return getFoodList(null, model)
	 */
	@RequestMapping("/deleteFood/{foodId}")
	public String deleteFood(@PathVariable String foodId, Model model) {
		foodService.deleteFood(foodId);
		return getFoodList(null, model,1);
	}
	
	/**
	 * 更新菜品
	 * @param foodId 菜品编号
	 * @param price 菜品价格
	 * @param foodName 菜品名
	 * @param model Model
	 * @param imageUrl 菜品图片路径
	 * @return getFoodList(null, model)
	 * @throws Exception
	 */
	@RequestMapping(value = "/updateFood", method = RequestMethod.POST)
	public String updateFood(String foodId, String price, String foodname,
			Model model, MultipartFile imageUrl) throws Exception {
		String path = imageUrl.getOriginalFilename();
		String absPath = "D:/images";
		imageUrl.transferTo(new File(absPath + "/" + path));
		foodService.updateFood(foodId, price, foodname, path);
		return getFoodList(null, model,1);
	}
	
	/**
	 * 显示菜品图片
	 * @param path 菜品图片路径
	 * @param response  HttpServletResponse
	 * @throws IOException
	 */
	@RequestMapping("/image")
	public void getImage(String path, HttpServletResponse response)
			throws IOException {
		String imagePath = "D:/images/" + path;
		BufferedImage bi = ImageIO.read(new File(imagePath));
		ImageIO.write(bi, "jpg", response.getOutputStream());
	}

	/**
	 * 下载菜品图片
	 * @param path 菜品图片路径
	 * @return ResponseEntity<byte[]>
	 * @throws Exception
	 */
	@RequestMapping(value = "/download", method = RequestMethod.GET)
	public ResponseEntity<byte[]> fileDowload(String path) throws Exception {
		System.out.println(path);
		String absPath = "D:/images/" + path;

		String fileName = path;
		// 需要下载的目标文件
		File file = new File(absPath);
		// 设置响应头
		HttpHeaders hh = new HttpHeaders();
		// 设置下载的文件的名称
		hh.setContentDispositionFormData("attachment",
				URLEncoder.encode(fileName, "UTF-8"));
		// 读取目标文件为二进制数组
		byte[] fileByte = FileCopyUtils.copyToByteArray(file);
		// 构建ResponseEntity对象
		ResponseEntity<byte[]> re = new ResponseEntity<byte[]>(fileByte, hh,
				HttpStatus.CREATED);
		return re;
	}

}
