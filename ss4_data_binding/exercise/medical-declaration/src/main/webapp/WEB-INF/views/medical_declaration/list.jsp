<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/17/2022
  Time: 4:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

</head>
<body>
<h1 class="p-3 bg-success text-white text-center">List Medical Daclaration</h1>

<p class="text-success text-center">${messCreate}</p>
<p class="text-success text-center">${messUpdate}</p>

<div class="container mt-5 mb-3">
    <a class="btn btn-success" href="/">Create</a>
</div>
<div class="container mb-5">
    <div class="row table-responsive">
        <table class="table table-hover table-bordered table-striped">
            <thead class="table-success">
            <tr>
                <th>STT</th>
                <th>ID</th>
                <th>Họ tên</th>
                <th>Năm sinh</th>
                <th>Giới tính</th>
                <th>Quốc tịch</th>
                <th>Số hộ chiếu hoặc cmnd</th>
                <th>Thông tin đi lại</th>
                <th>Số hiệu phương tiện</th>
                <th>Số ghế</th>
                <th colspan="3">Ngày khởi hành</th>
                <th colspan="3">Ngày kết thúc</th>
                <th>Thành phố đã đi qua</th>
                <th>Update</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${medicalDeclarationList}" varStatus="status" var="medicalDeclaration">
                <tr>
                    <td>${status.count}</td>
                    <td>${medicalDeclaration.id}</td>
                    <td>${medicalDeclaration.name}</td>
                    <td>${medicalDeclaration.yearOfBirth}</td>
                    <td>${medicalDeclaration.gender}</td>
                    <td>${medicalDeclaration.nationality}</td>
                    <td>${medicalDeclaration.idCode}</td>
                    <td>${medicalDeclaration.vehicles}</td>
                    <td>${medicalDeclaration.vehicleCode}</td>
                    <td>${medicalDeclaration.numberOfSeat}</td>
                    <td>${medicalDeclaration.startDay}</td>
                    <td>${medicalDeclaration.startMonth}</td>
                    <td>${medicalDeclaration.startYear}</td>
                    <td>${medicalDeclaration.endDay}</td>
                    <td>${medicalDeclaration.endMonth}</td>
                    <td>${medicalDeclaration.endYear}</td>
                    <td>${medicalDeclaration.city}</td>
                    <td>
                        <a class="btn btn-outline-warning" href="/update?id=${medicalDeclaration.id}">UPDATE</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
