<%-- 
    Document   : index
    Created on : Oct 21, 2023, 11:19:29 PM
    Author     : MiraiHara
--%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.ProductsTable"%>
<%@page import="java.util.List"%>
<%@page import="Model.Products"%>
<%@page import="Model.Products"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <jsp:useBean id="pd" class="Model.Products" scope="request"/>
    <%                
            List<Products> pdList = ProductsTable.findAllProducts();
            Iterator<Products> itr = pdList.iterator();
            /*list product*/
     %>
    <body>
        <form name="index" action="indexController" method="POST">
            <center>
            <h1>DVD Catalog</h1>
        <table border="1">
            <tr>
                <th>DVD Names</th>
                <th>Rate</th>
                <th>Year</th>
                <th>Price</th>
                <th>Quantity</th>
            </tr>
            <%
                while(itr.hasNext()) {
                    pd = itr.next();
                    /*check all product*/
            %>
            <tr>
                <td> <input type='checkbox' name='selectedMovies' value="<%= Integer.toString(pd.getId()) %>"/> <%= pd.getMovie() %> </td>
                <td><%= pd.getRating() %></td>
                <td><%= pd.getYearcreate() %></td>
                <td><%= pd.getPrice() %></td>
                <td><input type='text' name='quantity' value='0' size='5'/></td>
            </tr>

            <%
                    }
            %>
        </table>

        <td><input type='submit' name='Submit' value='Add To Cart'></td>
        </form>
    </body>
</html>

