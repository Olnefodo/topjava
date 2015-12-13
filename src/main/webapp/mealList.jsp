<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
    <style>
        .normal {color: green;}
        .exceed {color: red;}
    </style>
</head>
<body>
<h3 align="center">Meal page</h3>
<hr>

<a href="/mealList?action=create&id=${meal.id}">Add meal</a>
<table border="1" align="center" cellspacing="1" >
    <thead>
        <tr>
            <td>dateTime</td>
            <td>description</td>
            <td>calories</td>
            <td colspan="2">actions</td>
        </tr>
    </thead>
    <c:forEach items="${meals}" var="meal">
        <tr>
            <td>
                <fmt:formatDate pattern="yyyy-mm-dd'T'hh:mm" value="${meal.dateTime}" var="formattedDate"/>
                <fmt:parseDate value="${formattedDate}" pattern="YYYY MM dd HH:mm" var="parsedDate" />

            ${parsedDate}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td><a href="/mealList?action=delete&id=${meal.id}">delete</a> </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
