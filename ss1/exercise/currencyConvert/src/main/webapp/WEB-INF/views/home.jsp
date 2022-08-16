<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/12/2022
  Time: 3:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/convert">
    <p>Số tiền cần đổi:</p>
    <input type="number" name="money" required value="${money}">
    <p>Tỉ giá</p>
    <input type="number" name="rate" required value="${rate}">

    <button>Chuyển đổi</button>
</form>
<p>${result}</p>
<p>${mess}</p>
</body>
</html>
