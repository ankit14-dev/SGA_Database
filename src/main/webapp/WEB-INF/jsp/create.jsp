<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Book</title>
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
<div class="container">
    <h1>Add Book</h1>
    <form action="/books" method="post">
        <label>Title: <input type="text" name="title"/></label><br/>
        <label>ISBN: <input type="text" name="isbn"/></label><br/>
        <label>Author:
            <select name="author.id">
                <c:forEach items="${authors}" var="a">
                    <option value="${a.id}">${a.name}</option>
                </c:forEach>
            </select>
        </label><br/>
        <button type="submit">Save</button>
    </form>
    <a href="/books">Back to list</a>
</div>
</body>
</html>
