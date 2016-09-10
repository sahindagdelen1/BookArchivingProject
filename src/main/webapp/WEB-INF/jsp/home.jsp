<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>HOME PAGE</title>
</head>
<body>
<table>
  <tr>
    <td><a href="<c:url value='/list' />">ALL BOOKS</a></td>
  </tr>

  <tr>
    <td><a href="<c:url value='/userlist' />">ALL USERS</a></td>
  </tr>


  <tr>
    <td><a href="<c:url value='/reservebook' />">RESERVE BOOK</a></td>
  </tr>
</table>

</body>
</html>
