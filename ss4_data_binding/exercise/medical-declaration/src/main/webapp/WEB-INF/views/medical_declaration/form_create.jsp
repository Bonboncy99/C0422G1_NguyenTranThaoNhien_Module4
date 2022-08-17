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
<h1>TỜ KHAI Y TẾ</h1>
<h2>ĐÂY LÀ TÀI LIỆU QUAN TRỌNG, THÔNG TIN CỦA ANH CHỊ SẼ GIÚP CƠ QUAN Y TẾ LIÊN LẠC KHI CẦN THIẾT ĐỂ PHÒNG CHỐNG DỊCH
    BỆNH TRUYỀN NHIỄM</h2>
<p>Khuyến cáo: Khai báo thông tin sai là vi phạm pháp luật Việt Nam và có thể xử lý hình sự</p>

<form:form action="/create" method="post" modelAttribute="medicalDeclaration">
    <div>
        <h5>Họ tên</h5>
        <form:input path="name"/>
    </div>
    <div>
        <h5>Năm sinh</h5>
        <form:select path="yearOfBirth" items="${years}"/>
    </div>
    <div>
        <h5>Giới tính</h5>
        <form:select path="gender" items="${genders}"/>
    </div>
    <div>
        <h5>Quốc tịch</h5>
        <form:select path="nationality" items="${nationalities}"/>
    </div>
    <div>
        <h5>Số CMND/Hộ Khẩu</h5>
        <form:input path="idCode"/>
    </div>
    <div>
        <h5>Số hiệu phương tiện</h5>
        <form:input path="vehicleCode"/>
    </div>
    <div>
        <h5>Thông tin đi lại</h5>
        <Form:radiobuttons path="vehicles" items="${vehicles}"/>
    </div>
    <div>
        <h5>Số ghế</h5>
        <form:input path="numberOfSeat"/>
    </div>
    <div>
        <h5>Ngày Khởi hành</h5>
        <form:select path="startDay" items="${days}"/>
        <form:select path="startMonth" items="${months}"/>
        <form:select path="startYear" items="${years}"/>
    </div>
    <div>
        <h5>Ngày kết thúc</h5>
        <form:select path="endDay" items="${days}"/>
        <form:select path="endMonth" items="${months}"/>
        <form:select path="endYear" items="${years}"/>
    </div>
    <div>
        <h5>Những ngày qua đến thành phố nào</h5>
        <form:textarea path="city"/>
    </div>

    <button>SAVE</button>
</form:form>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
