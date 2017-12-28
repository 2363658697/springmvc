package cn.et.lesson5.contorller;

import java.io.OutputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.et.lesson5.service.FeeService;



@Controller
public class InterController {

	@Autowired
	private FeeService feeService;
	
	@RequestMapping(value = "/inter", method = RequestMethod.GET)
	public String resolver(OutputStream outputStream) throws Exception{
		outputStream.write("lll".getBytes());
		return null;
	}
	
	@RequestMapping(value = "/fee", method = RequestMethod.POST)
	public String fee(OutputStream outputStream,Integer fee) throws Exception{
		outputStream.write("dd".getBytes());
		feeService.addFee(fee);
		int count=feeService.queryFee();
		outputStream.write(("fee:"+count).getBytes());
		return null;
	}
	
}
