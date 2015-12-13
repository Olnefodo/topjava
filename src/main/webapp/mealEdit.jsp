<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form method="post" action="/mealList">
    <input type="hidden" value="${meal.id}" name="id">
    <ld>
        <dt>dateTime</dt>
        <dd><input type="datetime-local" value="${meal.dateTime}" name="dateTime"></dd>
    </ld>
    <ld>
        <dt>description</dt>
        <dd><input type="text" value="${meal.description}" name="description"></dd>
    </ld>
    <ld>
        <dt>calories</dt>
        <dd><input type="dnumber" value="${meal.calories}" name="calories"></dd>
    </ld>
    <button type="submit">Save</button>
    <button onclick="window.history.back()">Cancel</button>
</form>

</body>
</html>
