package cn.et.lesson4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ResolverController {

	/**
	 * 视图解析器类型：
		InternalResourceViewResolver 
		FreeMarkerViewResolver
		BeanNameViewResolver
		XmlViewResolver ...
	 * 
	 * servletname-servlet.xml配置：
	 * 
	 * 
	 * 
	 * 配置视图解析器后：
	 * 	视图url可以省略：前缀“/” ，后缀“.jsp/html/jstl”
	 * 	列如：
	 * 		return "/lesson3/suc.jsp";可以写成：return "lesson3/suc"
	 * 
	 * @return
	 */

	@RequestMapping(value = "/resolver", method = RequestMethod.GET)
	public String resolver() {
		return "lesson3/suc";
	}
}
