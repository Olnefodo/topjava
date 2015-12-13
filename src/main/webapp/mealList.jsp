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
            <td>exceed</td>
            <td colspan="2">actions</td>
        </tr>
    </thead>
    <c:forEach items="${meals}" var="meal">
        <tr class="${meal.exceed eq true ? 'exceed' : 'normal'}">
            <td>
                <fmt:parseDate value="${meal.dateTime}" pattern="y-M-dd'T'H:m" var="parsedDate" />
                <fmt:formatDate pattern="yyyy.MM.dd HH:mm" value="${parsedDate}"/>
            </td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td>${meal.exceed}</td>
            <td><a href="/mealList?action=delete&id=${meal.id}">delete</a> </td>
            <td><a href="/mealList?action=edit&id=${meal.id}">edit</a> </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
