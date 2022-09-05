<%-- 
    Document   : shipperbycustomer
    Created on : Sep 1, 2022, 6:01:02 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<h1 class="text-center text-danger">Danh sách shipper</h1>

<div class="row">
    <c:forEach var="sp" items="${shippers2}">
        <div class="col-md-4 col-xs-12" style="padding: 15px">
            <div class="card">
                <c:choose>
                    <c:when test="${sp.avatarShipper != null && sp.avatarShipper.startsWith('https') == true}">
                        <img class="card-img-top img-fluid" src="${sp.avatarShipper}" alt="Card image">
                    </c:when>

                    <c:when test="${sp.avatarShipper == null || sp.avatarShipper.startsWith('https') == false}">
                        <img class="card-img-top img-fluid" src="<c:url value="/img/default-avatar.png" />" alt="Card image">
                    </c:when>
                </c:choose>

                <div class="card-body">
                    <h4 class="card-title">${sp.licensePlate}</h4>
                    <a href="<c:url value="/customer/shipperbycustomer/shipperfeedbackbycustomer/${sp.id}" />" class="btn btn-primary">Xem chi tiet</a>
                </div>
            </div>
        </div>
    </c:forEach>
</div>

<ul class="pagination">
    <c:forEach begin="1" end="${Math.ceil(shipperCounter/8)}" var="i">
        <c:url value="/customer/shipperbycustomer" var="s">
            <c:param value="${i}" name="page"  />
        </c:url>
        <li class="page-item"><a class="page-link" href="${s}"  >${i}</a></li>
    </c:forEach>
</ul>