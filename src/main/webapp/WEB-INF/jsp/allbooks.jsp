<%--
  Created by IntelliJ IDEA.
  User: sahin.dagdelen
  Date: 1/24/2016
  Time: 9:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title> BOOKS OF LIBRARY</title>

  <style>
    tr:first-child{
      font-weight: bold;
      background-color: #C6C9C4;
    }
  </style>
</head>
<body>
<h2>List of Books </h2>

<table>
<tr>
  <td>
    NAME
  </td>
<td>ADDED DATE</td> <td>CATEGORY</td>  <td>ISBN</td>
</tr>

  <c:forEach items="${books}"  var="book">
    <tr>
      <td>${book.name}</td>
      <td>${book.addedDate}</td>
      <td>${book.category}</td>
      <td>${book.isbn}</td>

      <td><a href="<c:url value='/edit-${book.id}-book' />">${book.id}</a></td>
      <td><a href="<c:url value='/delete-${book.id}-book' />">delete</a></td>
      <td><a href="<c:url value='/process-${book.id}-book' />">Issue or Reserve</a></td>
    </tr>


  </c:forEach>
</table>
<br/>
<a href="<c:url value='/new' />">Add New Book</a>
</body>
</html>
