<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/16/2022
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
<h1>Sandwich Condiments</h1>
  <form action="/save" method="post" >

    <c:forEach varStatus="status" var="condiment" items="${condimentList}">
      ${condiment.name} <input type="checkbox" name="condiments" value="${condiment.name}">
      <hr>
    </c:forEach>
    <button>Save</button>


<%--    <p>${condimentList}</p>--%>

      <c:if test="${mess!=null}">
          <p>${mess}</p>
      </c:if>

    <p>Your choose:</p>
    <c:forEach var="condimentChoose" items="${condimentChooseList}" varStatus="status">
        <p>${status.count}. ${condimentChoose}</p>
    </c:forEach>
  </form>


  </body>
</html>
