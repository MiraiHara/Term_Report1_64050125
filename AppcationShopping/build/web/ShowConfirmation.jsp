<%-- 
    Document   : ShowConfirmation
    Created on : Oct 21, 2023, 11:54:47 PM
    Author     : MiraiHara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String total = request.getParameter("total");
        %>  
        <h1>Your Order is confirmed</h1>
        <br>
        <h1>The total amount is $  <%= total %></h1>
        <br>
        <a href="index.jsp">Back to Home </a>
    </body>
</html>
