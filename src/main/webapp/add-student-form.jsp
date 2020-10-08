<%-- 
    Document   : add-list-student
    Created on : Sep 30, 2020, 8:44:31 AM
    Author     : default
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<f:view>
    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
        </head>
        <body>
            <h1>Add Student form</h1>
            
            <form action="Student-List" method="get">
                <input type="hidden" name="command" value="add">
                <label>First name </label>
                <input type="text" name ="first_name" placeholder="first_name">
                <br><br>
                <label>Email </label>
                <input type="text" name ="email" placeholder="your email">
                <br><br>
                 <input type="submit">
            </form>
        </body>
    </html>
</f:view>
