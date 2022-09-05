<%-- 
    Document   : ordershipdetail
    Created on : Sep 3, 2022, 11:02:30 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">Chi tiết đơn hàng</h1>

<div class="row">
    <div class="col-md-7">
        <h3>Tên người nhận: ${order.shipName}</h3>
        <h3>Địa chỉ: ${order.shipAddress}</h3>
        <h3>Ngày đặt: ${order.orderDate}</h3>
        <h3>Ngày yêu cầu: ${order.requiredDate}</h3>
        <h3>Ngày giao: ${order.shippedDate}</h3>
        <h3>Code: ${order.shipPostalcode}</h3>
        <h3>Trạng thái giao hàng: ${order.shipStatus}</h3>
        <h3>Trạng thái thanh toán: ${order.paymentStatus}</h3>
    </div>
</div>
