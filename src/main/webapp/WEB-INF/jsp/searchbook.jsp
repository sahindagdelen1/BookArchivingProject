<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>SEARCH BOOK</title>
</head>
<body>
<form:form modelAttribute="bookSearchForm"  id="searchForm">
<table>
<tr>
    <td>
       SEARCH TEXT
    </td>
    <td>
        <form:input path="searchText" />
    </td>
</tr>

    <tr>
        <td>
         <form:radiobuttons path="searchType" items="${optionList}"  />
        </td>
     </tr>
    <tr>
        <td>
            <input type="submit"  value="Search" />
        </td>

    </tr>

</table>
</form:form>

</body>
</html>
