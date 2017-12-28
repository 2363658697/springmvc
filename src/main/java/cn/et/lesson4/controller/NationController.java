package cn.et.lesson4.controller;

import java.io.OutputStream;
import java.util.Locale;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.lesson4.entity.UserInfo;

@Controller
public class NationController {
	@Autowired
	MessageSource mSource;

	@RequestMapping(value = "/nation", method = RequestMethod.GET)
	public String resolver(OutputStream outputStream,Locale locale,HttpServletResponse response) throws Exception{
		response.setContentType("text/html;charset=UTF-8");
		outputStream.write(mSource.getMessage("key", null, locale).getBytes("UTF-8"));
		return null;
	}
	
	@RequestMapping(value = "/mid", method = RequestMethod.GET)
	public String mid(){
		return "/lesson4/reg.jsp";
	}
	
	
	@RequestMapping(value = "/m", method = RequestMethod.POST)
	public String mid(@ModelAttribute("user") @Valid UserInfo user,BindingResult error){
		if(error.hasErrors()){
			return "/lesson4/reg.jsp";
		}
		return null;
	}
	
}
