<%@ page import="mypackage.Employee" %><%--
  Created by IntelliJ IDEA.
  User: HOANG SON
  Date: 8/26/2019
  Time: 10:47 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Employee employee = null;
    employee =  (Employee)request.getAttribute("employee");
%>

<h1>Create Form</h1>
<form action="/create" method="post">
    <div>
        Name <input type="text" name="name" value="<%= employee != null ? employee.getName() : ""%>">
    </div>
    <div>
        Salary <input type="number" name="salary" value="<%=employee != null ? employee.getSalary() : ""%>">
    </div>
    <div>
        <input type="submit" value="Submit">
    </div>
</form>
</body>
</html>
