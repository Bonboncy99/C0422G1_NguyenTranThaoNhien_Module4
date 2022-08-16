<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/16/2022
  Time: 3:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>CALCULATOR <3</h1>
<form id="formCalc" action="/calculate" method="get">
    <p>Nhập số thứ nhất</p>
    <input type="number" name="num1" value="${num1}" id="num1">
    <p>Nhập số thứ hai</p>
    <input type="number" name="num2" value="${num2}" id="num2">
    <br>
    <%--    <button type="reset">Clean</button>--%>
    <br>
    <br>
    <button type="submit" name="operand" value="addition">Addition (+)</button>
    <button type="submit" name="operand" value="subtraction">Subtraction (-)</button>
    <button type="submit" name="operand" value="multiplication">Multiplication (x)</button>
    <button type="submit" name="operand" value="division">Division (/)</button>
</form>
<%--<button type="button" onclick="resetForm()" value="Clear">Clear</button>--%>

<c:if test="${result!=null}">
    <p>Kết quả là: ${result}</p>
</c:if>
<%--<script>--%>
<%--    function resetForm() {--%>
<%--        document.getElementById("num1").value = "";--%>
<%--        document.getElementById("num2").value = "";--%>
<%--    }--%>
<%--</script>--%>
</body>
</html>
