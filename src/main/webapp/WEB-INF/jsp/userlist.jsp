<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sahin.dagdelen
  Date: 2/14/2016
  Time: 11:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>USER LIST</title>

  <style>
    tr:first-child{
      font-weight: bold;
      background-color: #808080 ;
    }
  </style>
</head>
<body>


<table>
  <tr>
    <td>   USERID  </td>
    <td>FULL NAME</td>
    <td>EMAIL</td>
    <td>ADDRESS</td>
    <td>GSM NUMBER</td>
    <td>PHONE NUMBER</td>
    <td>STATE</td>
    <td>REGISTRATION DATE</td>
  </tr>

  <c:forEach items="${users}"  var="user">
    <tr>
      <td>${user.userId}</td>
      <td>${user.fullName}</td>
      <td>${user.email}</td>
      <td>${user.address}</td>
      <td>${user.gsmNumber}</td>
      <td>${user.phoneNumber}</td>
      <td>${user.state}</td>
      <td>${user.regDate}</td>

      <td><a href="<c:url value='/edit-${user.userId}-user' />">${user.userId}</a></td>
      <td><a href="<c:url value='/delete-${user.userId}-user' />">delete</a></td>
    </tr>


  </c:forEach>

</table>
<br/>
<a href="<c:url value='/newuser' />">Add New User</a>
</body>
</html>
