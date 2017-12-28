package cn.et.lesson3.entity;


import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;

public class UserInfo {

	/*
	 * @NotEmpty：！=null && !"".equals(xx)
	 * 
	 * @NotNull:!=null
	 */

	@NotEmpty(message = "用户名不能为空")
	private String userName;
	@NotEmpty(message = "年龄不能为空")
	@Range(min = 1, max = 120, message = "输入的年龄不合法")
	private String age;

	@NotEmpty(message = "密码不能为空")
	@Size(max = 11, message = "输入的密码不能超过11位")
	private String password;
	@NotEmpty(message = "再次输入不能为空")
	private String repassword;
	@Size(min = 11, max = 11, message = "手机号码必须是11位")
	private String phone;
	@Email(message = "输入的不是一个合法的邮箱地址")
	private String email;
	@Pattern(message = "输入的网址格式不对", regexp = "^((https|http)?:\\/\\/)[^\\s]+")
	private String website;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String date;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepassword() {
		return repassword;
	}

	public void setRepassword(String repassword) {
		this.repassword = repassword;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
