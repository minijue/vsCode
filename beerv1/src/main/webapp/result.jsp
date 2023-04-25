<!DOCTYPE html>
<%@ page import="java.util.*" %>
<html>
  <body>
    <h1 style="text-align: center">Beer Recommendations JSP</h1>
    <p>Beer Selection Advice</p>
    <p>
      <%
        List<String> styles=(List<String>) request.getAttribute("styles");
        String c = (String) request.getParameter("color");
        for(String style : styles) {
          out.print("<br>try: <span style=\"color: " + c + ";\">" + style + "</span>");
        }
      %>
    </p>
  </body>
</html>