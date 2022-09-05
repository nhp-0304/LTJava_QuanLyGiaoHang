<%-- 
    Document   : discountmanagebyadmin
    Created on : Aug 29, 2022, 10:38:21 AM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<h1 class="text-center">Quản lý danh sách discount</h1>

<c:url value="/admin/discountmanagebyadmin" var="action"/>
<form:form method="post" action="${action}" modelAttribute="discount">
    <form:errors path="*" element="div" cssClass="alert alert-danger"/>
    <div class="form-floating mb-3 mt-3">
        <form:input type="text" path="discountName" class="form-control" id="discountName" placeholder="discountName" name="discountName"/>
        <label for="discountName">Tên</label>
    </div>
    <div class="form-floating mb-3 mt-3">
        <form:input type="number" path="discountPercent" class="form-control" id="discountPercent" placeholder="discountPercent" name="discountPercent"/>
        <label for="discountPercent">Discount(%)</label>
    </div
    <div>
        <input type="submit" value="Thêm discount" class="btn btn-danger"/>
    </div>
</form:form>

<div class="spinner-border text-success" id="mySpinner"></div>

<br>

<table class="table table-striped table-hover table-bordered">
    <thead>
        <tr>
            <th>Tên <i class="fa fa-sort"></i></th>
            <th>Discount(%)<i class="fa fa-sort"></i></th>
            <th>Quyền</th>
        </tr>
    </thead>
    <tbody id="myDiscount">
        <tr>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    </tbody>
</table>

<script src="<c:url value="/js/discount.js"/>"></script>
<script>
    <c:url value="/api/discountmanagebyadmin" var="u"/>
    window.onload = function () {
        getDiscounts('${u}');
    };
</script>