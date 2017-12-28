package cn.et.lesson3.controller;

import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import cn.et.lesson3.entity.User;

@SessionAttributes("user")
@Controller
public class SessionController {

	@ModelAttribute("user")
	public User getUser() {
		User user = new User();
		return user;
	}

	/**
	 * http://localhost:8080/s/session?id=1 
	 * 请求转发 forward: 不需要任何处理
	 * 
	 *  请求重定向 redirect:
	 * 		使用SessionAttribute方式 用于在重定向中传至 将值存储在session中 【用完记住清除】
	 * @param map
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/session", method = RequestMethod.GET)
	public String case1(@ModelAttribute("user") User user) throws Exception {
		return "redirect:/session2";
	}

	@RequestMapping(value = "/session2", method = RequestMethod.GET)
	public String case2(Map map, HttpServletResponse res,SessionStatus sessionStatus) throws Exception {
		User user = (User) map.get("user");
		res.getWriter().println(user.getId());
		sessionStatus.setComplete();
		return null;
	}

}
