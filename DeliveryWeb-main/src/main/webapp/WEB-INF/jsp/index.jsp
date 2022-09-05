<%-- 
    Document   : Index
    Created on : Aug 5, 2022, 10:15:18 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body class="">
        <div class="wrapper ">
            <div class="sidebar" data-color="orange">
                <!--
                  Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red | yellow"
                -->
                <div class="logo">
                    <a  class="simple-text logo-normal">
                        P&LMove
                    </a>
                </div>
                <div class="sidebar-wrapper" id="sidebar-wrapper">
                    <ul class="nav">
                        <li class="active ">
                            <a href="./">
                                <i class="now-ui-icons design_app"></i>
                                <p>Trang chủ</p>
                            </a>
                        </li>
                        <li>
                            <a href="./">
                                <p>Về chúng tôi</p>
                            </a>
                        </li>
                        <li>
                            <a href="./">
                                <p>Bản đồ</p>
                            </a>
                        </li>
                        <li>
                            <a href="./">
                                <p>Thông báo</p>
                            </a>
                        </li>
                        <li>
                            <a href="./">
                                <p>Liên hệ</p>
                            </a>
                        </li>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <li class="active ">
                                <a href="<c:url value="/admin/manageaccount"/>">
                                    <p>Quản lý account</p>
                                </a>
                            </li>
                        </security:authorize>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <li class="active ">
                                <a href="<c:url value="/admin/ordership"/>">
                                    <p>Quản lý đơn hàng</p>
                                </a>
                            </li>
                        </security:authorize>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <li class="active ">
                                <a href="<c:url value="/admin/shippermanagebyadmin"/>">
                                    <p>Quản lý shipper</p>
                                </a>
                            </li>
                        </security:authorize>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <li class="active ">
                                <a href="<c:url value="/admin/discountmanagebyadmin"/>">
                                    <p>Danh sách discount</p>
                                </a>
                            </li>
                        </security:authorize>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <li class="active ">
                                <a href="<c:url value="/admin/stats"/>">
                                    <p>Thống kê đơn hàng của shipper</p>
                                </a>
                            </li>
                        </security:authorize>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <li class="active ">
                                <a href="<c:url value="/admin/frequencystats"/>">
                                    <p>Tần suất giao hàng của shipper</p>
                                </a>
                            </li>
                        </security:authorize>
                        <security:authorize access="hasRole('ROLE_ADMIN')">
                            <li class="active ">
                                <a href="<c:url value="/admin/revenuestats"/>">
                                    <p>Thống kê doanh thu của shipper</p>
                                </a>
                            </li>
                        </security:authorize>
                        <security:authorize access="hasRole('ROLE_CUSTOMER')">
                            <li class="active ">
                                <a href="<c:url value="/customer/infocustomer"/>">
                                    <p>Thông tin cá nhân</p>
                                </a>
                            </li>
                        </security:authorize>
                        <security:authorize access="hasRole('ROLE_CUSTOMER')">
                            <li class="active ">
                                <a href="<c:url value="/customer/makeorder"/>">
                                    <p>Đặt đơn</p>
                                </a>
                            </li>
                        </security:authorize>
                        <security:authorize access="hasRole('ROLE_CUSTOMER')">
                            <li class="active ">
                                <a href="<c:url value="/customer/shipperlist"/>">
                                    <p>Danh sách shipper</p>
                                </a>
                            </li>
                        </security:authorize>
                        <security:authorize access="hasRole('ROLE_CUSTOMER')">
                            <li class="active ">
                                <a href="<c:url value="/customer/shipperbycustomer"/>">
                                    <p>Đánh giá shipper</p>
                                </a>
                            </li>
                        </security:authorize>
                        <security:authorize access="hasRole('ROLE_SHIPPER')">
                            <li class="active ">
                                <a href="<c:url value="/shipper/infoshipper"/>">
                                    <p>Thông tin cá nhân</p>
                                </a>
                            </li>
                        </security:authorize>
                        <security:authorize access="hasRole('ROLE_SHIPPER')">
                            <li class="active ">
                                <a href="<c:url value="/shipper/takeorder"/>">
                                    <p>Nhận đơn</p>
                                </a>
                            </li>
                        </security:authorize>
                    </ul>
                </div>
            </div>
            <div class="main-panel" id="main-panel">

                <div class="panel-header panel-header-lg">
                    <canvas id="bigDashboardChart"></canvas>
                </div>
                <div class="content">
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="card card-chart">
                                <div class="card-header">
                                    <h4 class="card-title"><i class="fa fa-truck" aria-hidden="true"></i> P&L Truck</h4>
                                    <h5 class="card-body">Đa dạng phương tiện vận chuyển dành cho các mặt hàng lớn và cồng kềnh.</h5>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-4 col-md-6">
                            <div class="card card-chart">
                                <div class="card-header">
                                    <h4 class="card-title"><i class="fa fa-motorcycle" aria-hidden="true"></i> P&L Delivery</h4>
                                    <h5 class="card-body">Giao hàng nhanh, đảm bảo và giá tốt với dịch vụ phù hợp được tối ưu cho bạn.</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
