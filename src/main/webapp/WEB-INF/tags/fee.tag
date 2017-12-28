<%@ tag language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ attribute name="token" required="false"%>

<%
	String random=UUID.randomUUID().toString();
	String key=(token==null?"myToken":token);
	session.setAttribute(key, random);
%>
<input type="hidden" name="<%=key%>" value="<%=random%>" />