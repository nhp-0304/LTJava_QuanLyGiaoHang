<%-- 
    Document   : register
    Created on : Aug 28, 2022, 12:11:15 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--<h1 class="text-center text-danger">ĐĂNG KÝ</h1>-->

<c:if test="${errMsg != null}">
    <div class="alert alert-danger">
        ${errMsg}
    </div>
</c:if>

<c:url value="/register" var="action"/>
<header class="bg-gradient-dark">
    <div style ="background-image: url('https://png.pngtree.com/png-clipart/20220131/original/pngtree-big-isolated-vehicle-vector-colorful-icons-flat-illustrations-of-delivery-by-png-image_7255246.png')">
        <span class="mask bg-gradient-dark opacity-6"></span>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8 text-center mx-auto my-auto">
                    <h1 class="text-danger" style="">Đăng ký tài khoản</h1>
                </div>
            </div>
        </div>

        <div>
            <section>
                <div class="container py-4">
                    <div class="row">
                        <div class="col-lg-7 mx-auto d-flex justify-content-center flex-column">
                            <form:form method="post" action="${action}" modelAttribute="useraccount" enctype="multipart/form-data">
                                <div class="form-group">
                                    <label for="firstname"><b>First name</b></label>
                                    <form:input type="text" id="firstname" path="userFirstname" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label for="lastname"><b>Last name</b></label>
                                    <form:input type="text" id="lastname" path="userLastname" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label for="gender"><b>Gender</b></label>
                                    <form:input type="text" id="gender" path="userGender" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label for="address"><b>Address</b></label>
                                    <form:input type="text" id="address" path="userAddress" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label for="email"><b>Email</b></label>
                                    <form:input type="email" id="email" path="userGmail" class="form-control" />
                                </div>
                                <div class="mb-4">
                                    <div class="d-flex flex-column input-group input-group-dynamic mb-4">
                                        <label for="userAvatar"><b>Avatar</b></label>
                                        <form:input type="file" id="userAvatar" path="file" class="form-control"/>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="username"><b>Username</b></label>
                                    <form:input type="text" id="username" path="userName" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label for="password"><b>Password</b></label>
                                    <form:input type="password" id="password" path="userPassword" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <label for="confirm-password"><b>Confirm Password</b></label>
                                    <form:input type="password" id="confirm-password" path="confirmUserPassword" class="form-control" />
                                </div>
                                <div class="form-group">
                                    <input type="submit" value="Đăng ký" class="btn btn-danger" />
                                </div>
                            </form:form>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
</header>
