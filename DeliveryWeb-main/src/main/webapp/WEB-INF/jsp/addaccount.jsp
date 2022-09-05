<%-- 
    Document   : addaccount
    Created on : Sep 3, 2022, 9:27:33 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<h1 class="text-center text-danger">Thêm user account</h1>
<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/admin/manageaccount/addaccount" var="action" />

<form:form method="post" action="${action}" 
           enctype="multipart/form-data" modelAttribute="addAccount">

    <div class="form-group">
        <form:errors path="userName" class="text-danger" element="div" />
        <label for="userName">Username</label>
        <form:input type="text" id="userName" path="userName" class="form-control" />
    </div>
    <div class="form-group">
        <form:errors path="userPassword" class="text-danger" element="div" />
        <label for="userPassword">Password</label>
        <form:input type="password" id="userPassword" path="userPassword" class="form-control"/>
        <p>Mặc định: $2a$10$5X9k5N1sTc1/CjVH5XJoje3QMYijH3ETpgkox00R0MdPaJPPrf7wO</p>
    </div>
    <div class="form-group">
        <form:errors path="userFirstname" class="text-danger" element="div" />
        <label for="userFirstname">Firstname</label>
        <form:input type="text" id="userFirstname" path="userFirstname" class="form-control" />
    </div>
    <div class="form-group">
        <form:errors path="userLastname" class="text-danger" element="div" />
        <label for="userLastname">Lastname</label>
        <form:input type="text" id="userLastname" path="userLastname" class="form-control" />
    </div>
    <div class="form-group">
        <form:errors path="userGender" class="text-danger" element="div" />
        <label for="userGender">Gender</label>
        <form:input type="text" id="userGender" path="userGender" class="form-control" />
    </div>
    <div class="form-group">
        <form:errors path="userAddress" class="text-danger" element="div" />
        <label for="userAddress">Address</label>
        <form:input type="text" id="userAddress" path="userAddress" class="form-control" />
    </div>
    <div class="form-group">
        <form:errors path="userGmail" class="text-danger" element="div" />
        <label for="userGmail">Gmail</label>
        <form:input type="text" id="userGmail" path="userGmail" class="form-control" />
    </div>   
    <div class="form-group">
        <form:errors path="userRole" class="text-danger" element="div" />
        <label for="userRole">User role</label>
        <form:input type="text" id="userRole" path="userRole" class="form-control"/>
        <p>ROLE_SHIPPER / ROLE_CUSTOMER</p>
    </div>
    <div class="form-group">
        <input type="submit" value="Thêm" class="btn btn-danger" />
    </div> 
</form:form>
