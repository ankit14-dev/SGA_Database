<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Edit Book</title>
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
<div class="container">
    <h1>Edit Book</h1>
    <form action="/books/update/${book.id}" method="post">
        <label>Title: <input type="text" name="title" value="${book.title}"/></label><br/>
        <label>ISBN: <input type="text" name="isbn" value="${book.isbn}"/></label><br/>
        <label>Author:
            <select name="author.id">
                <c:forEach items="${authors}" var="a">
                    <option value="${a.id}" ${a.id==book.author.id? 'selected' : ''}>${a.name}</option>
                </c:forEach>
            </select>
        </label><br/>
        <button type="submit">Update</button>
    </form>
    <a href="/books">Back to list</a>
</div>
</body>
</html>
