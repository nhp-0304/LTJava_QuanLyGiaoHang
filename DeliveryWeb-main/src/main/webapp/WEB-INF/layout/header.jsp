<%-- 
    Document   : header
    Created on : Aug 7, 2022, 3:50:18 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!--<nav class="navbar navbar-expand-lg navbar-transparent  bg-primary  navbar-absolute">-->
<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
    <div class="container-fluid">
        <div class="navbar-wrapper">
            <div class="navbar-toggle">
                <button type="button" class="navbar-toggler">
                    <span class="navbar-toggler-bar bar1"></span>
                    <span class="navbar-toggler-bar bar2"></span>
                    <span class="navbar-toggler-bar bar3"></span>
                </button>
            </div>
            <a class="navbar-brand" href="<c:url value="/"/>">P&LMove</a>
        </div>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navigation">
            <ul class="navbar-nav">
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name == null}">
                        <li class="nav-item">
                            <a class="nav-link text-primary" href="<c:url value="/login"/>">
                                Đăng nhập
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-primary" href="<c:url value="/register"/>" >
                                Đăng ký khách hàng
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link text-primary" href="<c:url value="/registershipper"/>" >
                                Đăng ký shipper
                            </a>
                        </li>
                    </c:when>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        <li class="nav-item">
                            <a class="nav-link text-primary" href="<c:url value="/"/>">
                                Xin chào ${pageContext.request.userPrincipal.name}
                            </a>
                        </li>
                        <li class="nav-item" >
                            <a class="nav-link text-primary" href="<c:url value="/logout"/>">
                                Đăng xuất
                            </a>
                        </li>
                    </c:when>
                </c:choose>
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/"/>">
                                <i class="now-ui-icons users_single-02"></i>
                                <p>
                                    <span class="d-lg-none d-md-block">Account</span>
                                </p>
                            </a>
                        </li>
            </ul>
        </div>
    </div>
</nav>
