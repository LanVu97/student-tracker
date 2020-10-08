<%-- 
    Document   : update-student-form
    Created on : Oct 1, 2020, 8:44:18 PM
    Author     : default
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%--<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>--%>

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
                <input type="hidden" name="command" value="update">
                
                <input type="hidden" name="studentID" value="${The_student.id}">
                
                <label>First name </label>
                <input type="text" name ="first_name" value ="${The_student.first_name}">
                <br><br>
                <label>Email </label>
                <input type="text" name ="email" value ="${The_student.email}">
                <br><br>
                <input type="submit" value="save">
            </form>
        </body>
    </html>
</f:view>
