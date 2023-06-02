<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <h1>Test context attributes set by listener</h1>
        <p>===== for listener and servlet =====</p>
        <jsp:useBean id="dog" class="com.wangjue.entity.Dog" scope="request" />
        <p>Dog's breed is: <jsp:getProperty name="dog" property="breed" /></p>
        				
        <jsp:useBean id="person" class="com.wangjue.entity.Person" scope="request">
            <!--jsp:setProperty name="person"  property="name" />
            <jsp:setProperty name="person" property="userID"/-->
            <jsp:setProperty name="person"  property="*" />
        </jsp:useBean>
        <br><p>===== Only for JSP =====</p>
        <p><%= request.getAttribute("person") %></p>		
    </body>
</html>