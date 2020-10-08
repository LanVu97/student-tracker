<%-- 
    Document   : examaple
    Created on : Sep 26, 2020, 11:24:18 AM
    Author     : default
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">



<html>
    <head>
        <title>Java Code Geeks Snippets - Sample JSP Page</title>
        <link type="text/css" rel ="stylesheet" href="Css/style.css">

    <body>
        <h1> UNIVERSITY </h1>
        <c:set  var ="listStudents" value = "${list_Student}" />
        <a href = "add-student-form.jsp" >ADD STUDENT</a>

        <table>
            <tr class ="headerColor">
                <td >First name </td>
                <td>Email </td>
                <td> Action </td>
            </tr>

            <c:forEach items = "${listStudents}" var = "Student">
                <c:url var = "The_student" value = "Student-List">
                    <c:param name ="command" value ="load"/>
                    <c:param name ="studentID" value ="${Student.id}"/>
                </c:url>

                <tr>
                    <td> ${Student.first_name}</td>
                    <td> ${Student.email}</td>
                    <td><a href="${The_student}">Update</a></td>

                </tr>
            </c:forEach>

        </table>



    </body>
</html>
