<%@ taglib prefix="mine" uri="DiceFunctions" %>
<html>
<body>
<%@ include file="header.jsp" %>
<br>
<p>The number of your rolling is: ${mine:rollIt()}</p>
<% if (request.getParameter("username") == null) { %>
    <jsp:forward page="HandleIt.jsp"/>
<% } %>
<p>Hello ${param.username}</p>
<%@ include file="footer.jsp" %>
</body>
</html>
