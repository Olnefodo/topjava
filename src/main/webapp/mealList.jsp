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
<table border="20px">
    <tr>
        <th>date</th>
        <th>decription</th>
        <th>calories</th>
        <th>exceed</th>
    </tr>
    <c:forEach var="lists" items="${list}">
    <tr bgcolor="${lists.exceed == true ? 'red' : 'green'}">
        <td>${lists.dateTime}</td>
        <td>${lists.description}</td>
        <td>${lists.calories}</td>
        <td>${lists.exceed}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
