<%--
  Created by IntelliJ IDEA.
  User: Oleksandr
  Date: 12.12.15
  Time: 12:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <h3>Edit page</h3>
    <hr>
    <style>
        dl {
            background: none repeat scroll 0 0 #fafafa;
            margin: 8px 0;
            padding: 0;
        }
        dt {
            display: inline-block;
            width: 170px;
        }
        dd {
            display: inline-block;
            margin-left: 8px;
            vertical-align: top;
        }
    </style>
</head>
<body>
<form method="post" action="/mealList">
    <jsp:useBean id="meal" type="ru.javawebinar.topjava.model.UserMeal" scope="request"/>
    <input type="hidden" value="${meal.id}" name="id">
<dl>
    <dt>Дата : </dt>
    <dd><input type="datetime-local" value="${meal.dateTime}" name="dateTime"> </dd>
</dl>
    <dl>
    <dt>Описание : </dt>
    <dd><input type="text" value="${meal.description}" name="Description"></dd>
    </dl>
    <dl>
    <dt>Калории</dt>
    <dd><input type="number" value="${meal.calories}" name="Calories"></dd>
    </dl>
    <button type="submit">Save</button>
    <button onclick="window.history.back()">Cancel</button>
</form>
</body>
</html>
