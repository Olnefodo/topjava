<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 07.12.15
  Time: 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/mealList" method="post">
    <h3>Add new meal:</h3><br/>
    Date : <input type="text" name="date"><br/>
    Description : <input type="text" name="description"><br/>
    Calories : <input type="text" name="calories"><br/>
    <input type="submit">
</form>
<table border="20px">
    <tr>
        <th>date</th>
        <th>decription</th>
        <th>calories</th>
        <th>exceed</th>
    </tr>
    <c:forEach var="lists" items="${list}">
    <tr bgcolor="${lists.exceed eq true ? 'red' : 'green'}">
        <td><c:out value="${lists.dateTime}"/></td>
        <td><c:out value="${lists.description}"/></td>
        <td><c:out value="${lists.calories}"/></td>
        <td><c:out value="${lists.exceed}"/></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
