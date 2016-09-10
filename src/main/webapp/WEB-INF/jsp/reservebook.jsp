<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>RESERVATION OF BOOKS</title>
</head>
<body>
<form:form method="post" modelAttribute="bookDetailsForm">
    <table>
          <tr>
            <td><label for="user"> Borrower User </label> </td>
            <td>
                <form:select path="user" id="userListSelect">
                    <form:options items="${userList}"  itemValue="userId" itemLabel="fullName" />
                </form:select>
            </td>
        </tr>

         <tr>
            <td><label for="book"> BookList: </label> </td>
            <td>
                <form:select path="book" id="bookListSelect">
                    <form:options items="${bookList}"  itemValue="id" itemLabel="name" />
                </form:select>
              </td>
        </tr>

        <tr>
            <td>
                <label for="isReserved">Reserved</label>
            </td>
            <td>
                <form:checkbox path="bookDetails.isReserved" id="isReserved"/>
            </td>
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
</body>
</html>
