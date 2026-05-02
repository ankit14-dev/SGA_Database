<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books</title>
    <link rel="stylesheet" href="/css/style.css" />
</head>
<body>
<div class="container">
    <h1>Books</h1>
    <a class="btn" href="/books/new">Add Book</a>
    <h2>All Books</h2>
    <table>
        <tr><th>ID</th><th>Title</th><th>ISBN</th><th>Author</th><th>Actions</th></tr>
        <c:forEach items="${books}" var="b">
            <tr>
                <td>${b.id}</td>
                <td>${b.title}</td>
                <td>${b.isbn}</td>
                <td>${b.author.name}</td>
                <td><a href="/books/edit/${b.id}">Edit</a></td>
            </tr>
        </c:forEach>
    </table>

    <h2>Join Results (book title, isbn, author name)</h2>
    <table>
        <tr><th>Title</th><th>ISBN</th><th>Author</th></tr>
        <c:forEach items="${joinRows}" var="row">
            <tr>
                <td>${row[0]}</td>
                <td>${row[1]}</td>
                <td>${row[2]}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
