<!DOCTYPE html>
<html>
    <head></head>
    <body>
        <h1>Test context attributes set by listener</h1>
        <p>===== for listener and servlet =====</p>
        <P>**** JSP ****</P>
        <jsp:useBean id="dog" class="com.wangjue.entity.Dog" scope="request" />
        <p>Dog's breed is: <jsp:getProperty name="dog" property="breed" /></p>
        <p>**** EL ****</p>
        <p>Dog's breed is: ${dog[b]}</p>
        		
        <p>===== Only for JSP =====</p>
        <P>**** JSP ****</P>
        <jsp:useBean id="person" class="com.wangjue.entity.Person" scope="request">
            <!--jsp:setProperty name="person"  property="name" /-->
            <!--jsp:setProperty name="person" property="userID"/-->
            <jsp:setProperty name="person"  property="*" />
        </jsp:useBean>
        <p><%= request.getAttribute("person") %></p>
        <p>*** EL ****</p>
        <p>${person}</p>
        <p>The person's name is <b>${person.name}</b></p>
        <p>The person's ID is <strong>${person["userID"]}</strong></p>		
        <p>The person's first food is <strong>${param.food}</strong></p>
        <p>The person's second food is <b>${paramValues.food[1]}</b></p>
        <br>
        <p>The host is <span style="color: red">${header["host"]}</span></p>
        <p>Method is <b>${pageContext.request["method"]}</b></p>
    </body>
</html>