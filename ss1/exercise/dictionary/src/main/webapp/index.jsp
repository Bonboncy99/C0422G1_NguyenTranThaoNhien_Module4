<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/12/2022
  Time: 4:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <p>Từ điển tiếng anh</p>

  <form action="/search" >
    <p>Nhập từ cần tìm</p>
    <input type="text" name="word" value="${word}">
    <button>Tìm kiếm</button>
  </form>

  <p>${word}: ${result}</p>
  </body>
</html>
