<%-- 
    Document   : shipperdetail
    Created on : Aug 31, 2022, 3:16:14 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">Chi tiết shipper</h1>

<div class="row">
    <div class="col-md-4">
        <img src="${shipper.userAvatar}" alt="${shipper.userLastname}" class="img-fluid" width="200" height="200"/>
    </div>
    <div class="col-md-7">
        <h1>Họ tên: ${shipper.userFirstname} ${shipper.userLastname}</h1>
        <h3>Ngày sinh: ${shipper.userDateofbirth}</h3>
        <h3>Giới tính: ${shipper.userGender}</h3>
        <h3>Số điện thoại: 0${shipper.userPhonenumber}</h3>
        <h3>Email: ${shipper.userGmail}</h3>
    </div>
</div>
