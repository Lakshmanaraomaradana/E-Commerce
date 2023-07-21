<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>This is E-commerce site</h1>

<table>
<tr>
<th>id</th>
<th>name</th>
<th>firstname</th>
<th>lastname</th>
<th>email</th>
       <c:forEach items="${user}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.firstName}</td>
                <td>${user.lastName}</td>
                <td>${user.email}</td>
                <td>${user.contactNo}</td>
            </tr>
        </c:forEach>
        
        




</table>



</body>
</html>