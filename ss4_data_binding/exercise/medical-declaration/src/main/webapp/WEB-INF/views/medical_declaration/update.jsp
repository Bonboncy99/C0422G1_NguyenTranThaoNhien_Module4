<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 8/17/2022
  Time: 2:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="Form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>$Title$</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div>
        <h1 class="p-3 bg-warning text-center text-white">CẬP NHẬT TỜ KHAI Y TẾ</h1>
        <h3 class="text-center">ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN
            THIẾT ĐỂ PHÒNG CHỐNG DỊCH BỆNH TRUYỀN NHIỄM</h3>
        <p class="text-center text-danger">Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể
            xử lý hình sự</p>
    </div>
</div>

<div class="container">
    <form:form action="/update" method="post" modelAttribute="medicalDeclaration">
        <div class="mb-3">
            <form:hidden path="id"/>
        </div>
        <div class="mb-3">
            <label for="name">Họ tên (ghi chữ IN HOA) <span class="text-danger">(*)</span></label>
            <form:input cssClass="form-control" path="name"/>
        </div>
        <div class="row mb-3">
            <div class="col-md-4">
                <label for="yearOfBirth">Năm sinh<span class="text-danger">(*)</span></label>
                <form:select cssClass="form-control" path="yearOfBirth" items="${years}"/>
            </div>
            <div class="col-md-4">
                <label for="gender">Giới tính<span class="text-danger">(*)</span></label>
                <form:select cssClass="form-control" path="gender" items="${genders}"/>
            </div>
            <div class="col-md-4">
                <label for="nationality">Quốc tịch<span class="text-danger">(*)</span></label>
                <form:select cssClass="form-control" path="nationality" items="${nationalities}"/>
            </div>
        </div>
        <div class="mb-3">
            <label for="idCode">Số hộ chiếu hoặc số CMND hoặc giấy thông hành hợp pháp khác<span
                    class="text-danger">(*)</span></label>
            <form:input cssClass="form-control" path="idCode"/>
        </div>
        <div class="mb-3">
            <label for="vehicles">Thông tin đi lại<span class="text-danger">(*)</span></label>
            <Form:radiobuttons path="vehicles" items="${vehicles}"/>
        </div>
        <div class="row mb-3">
            <div class="col-md-6">
                <label for="vehicleCode">Số hiệu phương tiện</label>
                <form:input cssClass="form-control" path="vehicleCode"/>
            </div>
            <div class="col-md-6">
                <label for="numberOfSeat">Số ghế</label>
                <form:input cssClass="form-control" path="numberOfSeat"/>
            </div>
        </div>
        <div class="row mb-3">
            <div class="col-md-6">
                <label class="text-center">Ngày khởi hành</label>
                <div class="row">
                    <div class="col-md-4">
                        <form:select cssClass="form-control" path="startDay" items="${days}"/>
                    </div>
                    <div class="col-md-4">
                        <form:select cssClass="form-control" path="startMonth" items="${months}"/>
                    </div>
                    <div class="col-md-4">
                        <form:select cssClass="form-control" path="startYear" items="${years}"/>
                    </div>
                </div>
            </div>
            <div class="col-md-6">
                <label class="text-center">Ngày kết thúc</label>
                <div class="row">
                    <div class="col-md-4">
                        <form:select cssClass="form-control" path="endDay" items="${days}"/>
                    </div>
                    <div class="col-md-4">
                        <form:select cssClass="form-control" path="endMonth" items="${months}"/>
                    </div>
                    <div class="col-md-4">
                        <form:select cssClass="form-control" path="endYear" items="${years}"/>
                    </div>
                </div>
            </div>
        </div>
        <div class="mb-3">
            <h5>Những ngày qua đến thành phố nào</h5>
            <label for="name">Trong vòng 14 ngày qua, Anh/Chị có đến tỉnh/thành phố nào?<span
                    class="text-danger">(*)</span></label>
            <form:textarea cssClass="form-control" path="city"/>
        </div>
        <button class="btn btn-outline-warning">Cập nhật</button>
        <a  class="btn btn-success" href="/list">Quay lại</a>
    </form:form>
</div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
