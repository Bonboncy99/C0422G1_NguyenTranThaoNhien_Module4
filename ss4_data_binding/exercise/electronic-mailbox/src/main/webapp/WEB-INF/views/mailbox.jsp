<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/17/2022
  Time: 9:56 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Setting</h1>

<form:form action="/create" method="post" modelAttribute="mailBox">
    Language: <form:select path="language" items="${languageList}"/>
    <br>
    <br>
    Page size: <form:select path="pageSize" items="${pageSizeList}"/> emails per page.
    <br>
    <br>
    Spams filter: <form:checkbox path="spamsFilter"/>
    <br>
    <br>
    Signature: <form:textarea path="signature"/>
    <br>
    <br>
    <button>Update</button>
    <button type="button">Cancel</button>
</form:form>

</body>
</html>
