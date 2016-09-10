<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ISSUE BOOK</title>
</head>

<form:form action="POST" >
  <tr>
    <td><label for="userid">UserId: </label> </td>
    <td><form:input path="userid" id="userid"/></td>
  </tr>
  <tr>
    <td><label for="id">Bookid: </label> </td>
    <td><form:input path="id" id="id"/></td>
  </tr>
  <tr>
    <td><label for="name">Book Name: </label> </td>
    <td><form:input path="name" id="name"/></td>
  </tr>

  <tr colspan="3">
  <td><input type="submit" value="Update"/></td>
  </tr>
</form:form>

</body>
  <br/>
  <br/>
  Go back to <a href="<c:url value='/list' />">List of All Books</a>
</html>
