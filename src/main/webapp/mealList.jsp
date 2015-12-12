<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<table border="1" align="center" cellspacing="1" >
    <thead>
        <tr>
            <td>dateTime</td>
            <td>description</td>
            <td>calories</td>
            <td colspan="2">actions</td>
        </tr>
    </thead>
    <c:forEach items="meal" var="meals">
        <tr>
            <td>${meals.dateTime}</td>
            <td>${meals.description}</td>
            <td>${meals.calories}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
