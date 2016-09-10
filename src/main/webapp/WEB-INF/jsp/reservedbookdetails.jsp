<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>RESERVED BOOK DETAILS</title>
</head>
<body>

<form:form method="post" modelAttribute="bookDetailsForm">
    <table>
        <tr>
            <td>
                <form:select path="user" id="userListSelect">
                    <form:options items="${userList}"  itemValue="userId" itemLabel="fullName" />
                </form:select>
            </td>
        </tr>

        <br/>
        <tr><td> <input type="submit" value="Submit"> </td> </tr>
    </table>
</form:form>





<c:choose>
    <c:when test="${infook}">
        <table>
            <tr>
                <td>   BOOK NAME  </td>
                <td>FULL NAME</td>
                <td>EMAIL</td>
                <td>ADDRESS</td>
                <td>GSM NUMBER</td>
                <td>PHONE NUMBER</td>
                <td>STATE</td>
                <td>REGISTRATION DATE</td>
            </tr>

            <c:forEach items="${bookDetailsFormsList}"  var="bdf">
                <tr>

                    <td>${bdf.book.name}</td>
                    <td>${bdf.user.fullName}</td>
                    <td>${bdf.user.email}</td>
                    <td>${bdf.user.address}</td>
                    <td>${bdf.user.gsmNumber}</td>
                    <td>${bdf.user.phoneNumber}</td>
                    <td>${bdf.user.state}</td>
                    <td>${bdf.user.regDate}</td>
                </tr>


            </c:forEach>

        </table>
    </c:when>
    <c:otherwise>
        <table>
            <tr>
                <td>
                 ${message}
                </td>
              </tr>
          </table>
     </c:otherwise>
</c:choose>

</body>
</html>
