<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>reg</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function checkSubmit(){
			document.forms[0].submit();
		}
		
	</script>



  </head>
  
  <body>
  	<a href="${pageContext.request.contextPath}/mid?language=zh_CN">中文</a><a href="${pageContext.request.contextPath}/mid?language=en_US">英文</a>
    <form action="<%=path%>/m" method="post">
    	<tags:message code="userName"></tags:message>：<input type="text" name="userName" /><font color="red"><form:errors path="user.userName"></form:errors></font></br>
    	<tags:message code="age"></tags:message>：<input type="text" name="age" /><font color="red"><form:errors path="user.age"></form:errors></font></br>
    	<tags:message code="password"></tags:message>:<input type="password" name="password" /><font color="red"><form:errors path="user.password"></form:errors></font></br>
    	<tags:message code="repassword"></tags:message>：<input type="password" name="repassword"><font color="red"><form:errors path="user.repassword"></form:errors></font></br>
    	<tags:message code="phone"></tags:message>：<input type="text" name="phone" /><font color="red"><form:errors path="user.phone"></form:errors></font></br>
    	<tags:message code="email"></tags:message>：<input type="text" name="email" /><font color="red"><form:errors path="user.email"></form:errors></font></br>
    	<tags:message code="website"></tags:message>：<input type="text" name="website"><font color="red"><form:errors path="user.website"></form:errors></font></br>
    	<tags:message code="date"></tags:message>：    <input type="date" name="date" />  <br>
    	<input type="button" onclick="checkSubmit()" value="<tags:message code="button"></tags:message>">
    </form>
  </body>
</html>
