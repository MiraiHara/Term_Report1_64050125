<%-- 
    Document   : CheckShoppingCart
    Created on : Oct 21, 2023, 11:53:22 PM
    Author     : MiraiHara
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.ShoppingcartTable"%>
<%@page import="Model.Shoppingcart"%>
<%@page import="Model.ProductsTable"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Model.Products"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping Cart</title>
    </head>
   <!--List<Shoppingcart> cartList = ShoppingcartTable.findAllCart();: รายการสินค้าถูกดึงมาจากฐานข้อมูลโดยใช้เมธอด findAllCart() และเก็บไว้ใน cartList.t-->
    <jsp:useBean id="cart" class="Model.Shoppingcart" scope="request"/>
    <%
            List<Shoppingcart> cartList = ShoppingcartTable.findAllCart();
            Iterator<Shoppingcart> itr = cartList.iterator();      
            Integer cartId = (Integer) request.getAttribute("cartId");
            int total = 0;
            
     %>
    <body>
        <form name="index" action="ShowConfirmation.jsp" method="POST">
            <center>
            <h1>DVD Catalog</h1>
        <table border="1">
            <tr>
                <th>DVD Names</th>
                <th>Rating</th>
                <th>Year</th>
                <th>Price/Unit</th>
                <th>Quantity</th>
                <th>Price</th>
            </tr>
            <!--การารางถูกใช้ในการแสดงรายการสินค้า โดยใช้ลูป while เพื่อแสดงข้อมูลสินค้าที่อยู่ใน cartList. รายการที่มี cartId ตรงกับค่า cartId ที่ถูกกำหนด-->
            <%
                while(itr.hasNext()) {
                    cart = itr.next(); 
                    if(cart.getShoppingcartPK().getCartId() == cartId){
                    total += cart.getProducts().getPrice() * cart.getQuantity();    
            %>
            <tr>
                <td> <%= cart.getProducts().getMovie() %></td>
                <td><%= cart.getProducts().getRating() %></td>
                <td><%= cart.getProducts().getYearcreate() %></td>
                <td><%= cart.getProducts().getPrice() %></td>
                <td><%= cart.getQuantity() %></td>
                 <td><%= cart.getProducts().getPrice() * cart.getQuantity() %></td>
            </tr>
            
            <%
                    }
                }    
            %>
             <tr>
            <td colspan="5" >Total</td>
            <td ><%= total %></td>
             <input type="hidden" name="total" value="<%= total %>">
         
            </tr>
        </table>
        
         <td><input type='submit' name='Submit' value='Check out'></td>
        
         <br>
         

        </form>
        
    </body>
</html>
