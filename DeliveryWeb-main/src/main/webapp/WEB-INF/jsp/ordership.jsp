<%-- 
    Document   : ordership
    Created on : Aug 26, 2022, 10:28:02 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="card card-body shadow-xl mx-3 mx-md-4 mt-n6">
    <section class="py-7">
        <div class="container">
            <h1 class="text-center">Quản lý đơn hàng</h1>
            <div class="row">
                <div class="table-responsive table-hover">
                    <div class="table-wrapper">
                        <div class="table-title">
                            <div class="row">
                                <div class="col-sm-4">
                                    <form class="form-inline" action="<c:url value="/admin/ordership" />">
                                        <input class="form-control mr-sm-2" name="kw" type="text" placeholder="Nhập tên người nhận...">
                                        <br>
                                        <button class="btn btn-success" type="submit">Tìm kiếm</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <br>
                        <div class="card card-body shadow-xl mx-3 mx-md-4 mt-n6">
                            <table id="dtBasicExample" class="table table-hover table-bordered table-sm" cellspacing="0" width="100%">
                                <thead>
                                    <tr>
                                        <th class="th-sm">Tên người nhận
                                        </th>
                                        <th class="th-sm">Thời gian đặt
                                        </th>
                                        <th class="th-sm">Thời gian gửi
                                        </th>
                                        <th class="th-sm">Thời gian nhận
                                        </th>
                                        <th class="th-sm">Quyền
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${orderList}" var="o">
                                        <tr>
                                            <td>${o.shipName}</td>
                                            <td>${o.orderDate}</td>
                                            <td>${o.requiredDate}</td>
                                            <td>${o.shippedDate}</td>
                                            <td>
                                                <a href="<c:url value="/admin/ordership/ordershipdetail/${o.id}" />" class="btn btn-primary">Xem chi tiet</a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                                <ul class="pagination">
                                    <c:forEach begin="1" end="${Math.ceil(accountOrder/8)}" var="i">
                                        <c:url value="/admin/ordership" var="s">
                                            <c:param value="${i}" name="page"  />
                                        </c:url>
                                        <li class="page-item"><a class="page-link" href="${s}"  >${i}</a></li>
                                        </c:forEach>
                                </ul>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</div>