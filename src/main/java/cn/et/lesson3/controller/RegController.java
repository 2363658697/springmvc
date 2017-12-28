package cn.et.lesson3.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.lesson3.entity.UserInfo;

@Controller
public class RegController {
	@RequestMapping(value="/reg",method=RequestMethod.POST)
	public String reg(@ModelAttribute("user") @Valid UserInfo user,BindingResult  error) {
		System.out.println(user.getDate());
		if(!user.getPassword().equals(user.getRepassword())){
			error.addError(new FieldError("user", "repassword", "两次密码不一致"));
		}
		if(error.hasErrors()){
			return "/lesson3/reg.jsp";
		}
		return "/lesson3/suc.jsp";
	}
}
