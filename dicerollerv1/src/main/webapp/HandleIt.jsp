<html>
    <body>        
    <jsp:include page="header.jsp">
        <jsp:param name="subTitle" value="We take the sting out of SOAP."/>
    </jsp:include>
<br>
        <p>We're sorry... you need to log in again.</p>
        <form action="index.jsp" method="GET">
            Name: <input name="username" type="text">
            <input type="submit" name="Submit">
        </form>
    </body>
</html>