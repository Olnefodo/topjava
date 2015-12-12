<%@ page import="ru.javawebinar.topjava.util.TimeUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
    <style>
        .normal {color : green;}
        .exceed {color : red;}
    </style>
</head>
<br>
<a href="index.html">HOME</a></br>
<a href="/mealList?action=create">Add meal</a>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>id</th>
        <th>date</th>
        <th>decription</th>
        <th>calories</th>
        <th>exceed</th>
        <th colspan="2">actions</th>
    </tr>
    </thead>
    <c:forEach var="lists" items="${list}">
        <jsp:useBean id="lists" scope="page" type="ru.javawebinar.topjava.model.UserMealWithExceed"/>
    <tr class="${lists.exceed ? 'exceed' : 'normal'}">
        <td><c:out value="${lists.id}"/> </td>
        <td>
        <%--<fmt:parseDate value="${lists.dateTime}" pattern="y-M-dd'T'H:m" var="parsedDate"/>--%>
        <%--<fmt:formatDate value="${parsedDate}" pattern="yyyy.MM.dd HH:mm"/>--%>
        <%=TimeUtil.toString(lists.getDateTime())%>
        </td>
        <td><c:out value="${lists.description}"/></td>
        <td><c:out value="${lists.calories}"/></td>
        <td><c:out value="${lists.exceed}"/></td>
        <td><a href="/mealList?action=update&id=${lists.id}">Edit</a> </td>
        <td><a href="/mealList?action=delete&id=${lists.id}">Remove</a> </td>
    </tr>
    </c:forEach>


</table>

</body>
</html>
