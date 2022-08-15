<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/15/2022
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>CUSTOMER INFO</h1>
<table border="1">
    <thead>
    <tr>
        <td>STT</td>
        <td>Id</td>
        <td>Name</td>
        <td>Email</td>
        <td>Address</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customerList}" varStatus="status">
        <tr>
            <td>${status.count}</td>
            <td>${customer.id}</td>
            <td>${customer.name}</td>
            <td>${customer.email}</td>
            <td>${customer.address}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
