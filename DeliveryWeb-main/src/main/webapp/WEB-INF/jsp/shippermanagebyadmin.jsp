<%-- 
    Document   : shippermanagebyadmin
    Created on : Aug 30, 2022, 4:59:37 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>

<h1 class="text-center">Quản lý shipper</h1>

<c:url value="/admin/shippermanagebyadmin" var="action"/>
<form:form method="post" action="${action}" modelAttribute="shipper">
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="licensePlate" class="form-control" id="licensePlate" placeholder="licensePlate" name="licensePlate"/>
        <label for="licensePlate">Số xe</label>
    </div>
    <div class="form-floating">
        <form:select path="cityId" class="form-select" id="city" name="city">
            <c:forEach items="${cities}" var="c">
                <option value="${c.id}">${c.cityName}</option>
            </c:forEach>
        </form:select>
        <label for="city" class="form-label">Danh mục thành phố</label>   
    </div>
    <div class="form-floating">
        <form:select path="accountId" class="form-select" id="acc" name="acc">
            <c:forEach items="${accs}" var="a">
                <option value="${a.id}">${a.userFirstname} ${a.userLastname} - ${a.userRole}</option>
            </c:forEach>
        </form:select>
        <label for="acc" class="form-label">Danh mục accounts</label>   
    </div>
    <div>
        <br>
        <input type="submit" value="Thêm shipper" class="btn btn-danger"/>
    </div>
</form:form>

<div class="spinner-border text-success" id="mySpinner"></div>

<br>

<table class="table table-striped table-hover table-bordered">
    <thead>
        <tr>
            <th>Hình đại diện</th>
            <th>Tên</th>
            <th>Số xe</th>
            <th>Quyền</th>
        </tr>
    </thead>
    <tbody id="myShipper">
        <tr>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </tbody>
</table>

<script src="<c:url value="/js/shipper.js"/>"></script>
<script>
    <c:url value="/api/shippermanagebyadmin" var="u"/>
    window.onload = function () {
        getShippers('${u}');
    };
</script>

