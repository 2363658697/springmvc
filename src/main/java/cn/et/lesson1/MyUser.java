package cn.et.lesson1;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyUser {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@RequestMapping(value="/user/{id}",method=RequestMethod.GET)
	public String query(@PathVariable("id") String nString,HttpServletResponse response) throws Exception{
		String sql="select * from myuser where id="+nString;
		List<Map<String, Object>> list=jdbcTemplate.queryForList(sql);
		
		String nameString=list.get(0).get("name").toString();
		String pasString=list.get(0).get("password").toString();
		response.getWriter().write("<table border='1'><tr><th>name</th><th>password</th></tr><tr><td>"+nameString+"</td><td>"+pasString+"</td></tr></table>");
		return null;
	}
	
	@RequestMapping(value="/user",method=RequestMethod.POST)
	public String save(String name,String password,HttpServletResponse response) throws Exception{
		String sql="insert into myuser(name,password) values('"+name+"','"+password+"')";
		jdbcTemplate.execute(sql);
		response.getWriter().write("success");
		return null;
	}
	
	@RequestMapping(value="/user",method=RequestMethod.PUT)
	public String update(String id,String name,String password,HttpServletResponse response) throws Exception{
		String sql="update myuser set name='"+name+"' , password='"+password+"' where id="+id;
		jdbcTemplate.execute(sql);
		response.getWriter().write("success");
		return null;
	}
	
	@RequestMapping(value="/user",method=RequestMethod.DELETE)
	public String delete(String id,HttpServletResponse response) throws Exception{
		String sql="delete from myuser where id="+id;
		jdbcTemplate.execute(sql);
		response.getWriter().write("success");
		return null;
	}
}
