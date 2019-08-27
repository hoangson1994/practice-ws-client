<%@ page import="mypackage.Employee" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: HOANG SON
  Date: 8/26/2019
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List Place</title>
    <style>
        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 100%;
        }

        td, th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        tr:nth-child(even) {
            background-color: #dddddd;
        }
    </style>
</head>
<body>
<% Employee[] employees =  (Employee[]) request.getAttribute("employees");%>
<table>
    <tr>
        <th>#</th>
        <th>Name</th>
        <th>Salary</th>
        <th>Action</th>
    </tr>
    <c:forEach items="<%=employees%>" var="e">
        <tr>
            <td>${e.id}</td>
            <td>${e.name}</td>
            <td>${e.salary}</td>
            <td><a href="/create?id=${e.id}">Edit</a></td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
