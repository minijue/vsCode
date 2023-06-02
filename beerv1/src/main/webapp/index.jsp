<!DOCTYPE html>
<meta charset="utf-8">
<%@ page import="com.wangjue.*" %>
<html>
	<head>
		<% application.setAttribute("mail", config.getInitParameter("email")); %>
	</head>
	<body>
		<h1 style="text-align: center">Beer Selection Page</h1>
		<%! int count=0; %>
		<p>My E-mail: 
		<%--= application.getAttribute("mail") --%>
		<%--= pageContext.getAttribute("mail", PageContext.APPLICATION_SCOPE) --%>
		<%= pageContext.findAttribute("mail") %></p>
		<p>The page count is: <%= ++count %></p>
		<form method="POST" action="SelectBeer.html">
			<p>Select beer characteristics</p>
			<p>
				Color:&nbsp;
				<select name="color" size="1">
					<option value="lightpink">&nbsp;lightpink&nbsp;</option>
					<option value="antiquewhite">&nbsp;antiquewhite&nbsp;</option>
					<option value="brown">&nbsp;brown&nbsp;</option>
					<option value="darkblue">&nbsp;darkblue&nbsp;</option>
				</select>
			</p>
			<input type="submit" />
		</form>
		<br>
		<p>
		<form method="POST" action="GetDog.html">
			<p>Get a Dog</p>
			<input type="submit"/>
		</form>
		</p>
		<p>
			<form method="POST" action="CookieTest.html">
				<span>User: </span><input type="text" name="username"/>
				<input type="submit"/>
			</form>
		</p>
		<p>	
			<a href="checkcookie.do">Click here</a>
		</p>
		<p>
			<form action="dog.jsp">
				<p>name: <input type="text" name="name" value="zhang3"></p>
				<p>ID#: &nbsp;&nbsp;&nbsp;<input type="text" name="userID" value="li4"></p>
				<input type="submit">
			</form>
		</p>		
		
	</body>
</html>
