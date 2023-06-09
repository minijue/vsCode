<!DOCTYPE html>
<%@ page import="javax.servlet.http.Cookie" %>
<html>
	<head></head>
	<body>
		<p>==== JSP ====</p>
		<% 
		Cookie[] cookies = request.getCookies(); 
		if (cookies != null) { 
			for(Cookie cookie : cookies) { 
				if (cookie.getName().equals("username")) {
						String username = cookie.getValue();
		%>
		<span>User's name is <%= username %></span>
		<% break; } } } %>
		<p>==== EL ====</p>
		<p>${cookie.username.value}</p>
	</body>
</html>
