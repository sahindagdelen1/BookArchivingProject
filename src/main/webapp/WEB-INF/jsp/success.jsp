<%--
  Created by IntelliJ IDEA.
  User: sahin.dagdelen
  Date: 1/31/2016
  Time: 10:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SUCCESS page</title>
</head>
<body>
message : ${success}
<br/><br/>
Go back to <a href="<c:url value='/list' />">List of All Books</a>
<br/><br/>
Go back to <a href="<c:url value='/userlist' />">List of All Users</a>
<br/><br/>
Go back to <a href="<c:url value='/home' />">Home Page</a>
</body>
</html>
