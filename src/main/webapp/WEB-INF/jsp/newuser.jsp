<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>User Registration Form</title>

  <style>

    .error {
      color: #ff0000;
    }
  </style>

</head>

<body>

<h2>User Registration Form</h2>

<form:form method="post"  modelAttribute="user">

  <table>
   <tr>
      <td><label for="fullName">Full Name: </label> </td>
      <td><form:input path="fullName" id="fullName"/></td>
      <td><form:errors path="fullName" cssClass="error"/></td>
    </tr>


    <tr>
      <td><label for="address">Address: </label> </td>
      <td><form:input path="address" id="address"/></td>
      <td><form:errors path="address" cssClass="error"/></td>
    </tr>

    <tr>
      <td><label for="gsmNumber">Gsm Phone: </label> </td>
      <td><form:input path="gsmNumber" id="gsmNumber"/></td>
      <td><form:errors path="gsmNumber" cssClass="error"/></td>
    </tr>

    <tr>
      <td><label for="phoneNumber"> Phone Number: </label> </td>
      <td><form:input path="phoneNumber" id="phoneNumber"/></td>
      <td><form:errors path="phoneNumber" cssClass="error"/></td>
    </tr>


    <tr>
      <td><label for="email"> Email: </label> </td>
      <td><form:input path="email" id="email"/></td>
      <td><form:errors path="email" cssClass="error"/></td>
    </tr>

      <tr>
          <td><label for="userProfiles"> Roles: </label> </td>
          <td>
          <form:select path="userProfiles"  items="${roles}"   multiple="true"  itemValue="id"  itemlabel="type"  />
         </td>
          <td><form:errors path="userProfiles" cssClass="error"/></td>
      </tr>

    <tr>
      <td><label for="state">State: </label> </td>
      <td><form:input path="state" id="state"/></td>
      <td><form:errors path="state" cssClass="error"/></td>
    </tr>

    <tr>
      <td colspan="3">
        <c:choose>
          <c:when test="${edit}">
            <input type="submit" value="Update"/>
          </c:when>
          <c:otherwise>
            <input type="submit" value="Register"/>
          </c:otherwise>
        </c:choose>
      </td>
    </tr>
  </table>
</form:form>
<br/>
<br/>
Go back to <a href="<c:url value='/userlist' />">List of All Users</a>
</body>
</html>