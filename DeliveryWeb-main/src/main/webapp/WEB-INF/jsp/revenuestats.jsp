<%-- 
    Document   : revenueStats
    Created on : Sep 1, 2022, 10:02:53 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">Thống kê doanh thu của shipper</h1>

<div class="row">
    <div class="col-md-6 col-cs-12">
        <table class="table">
            <tr>
                <th>Id Shipper</th>
                <th>Tên shipper</th>
                <th>Doanh thu</th>
            </tr>
            <c:forEach items="${revenueStats}" var="r">
                <tr>
                    <td>${r[0]}</td>
                    <td>${r[1]} ${r[2]}</td>
                    <td>
                        <fmt:formatNumber type="number" value="${r[3]}" maxFractionDigits="3"/> VND
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-6 col-cs-12">
        <c:url value="/admin/revenuestats" var="action" />
        <form action="${action}">
            <div class="mb-3 mt-3">
                <select class="form-control" name="quarter">
                    <c:forEach begin="1" end="4" var="i">
                        <option value="${i}">${i}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="mb-3">
                <input type="number" class="form-control" placeholder="Nhập năm" name="year">
            </div>
            <button type="submit" class="btn btn-primary">Tra cứu</button>
        </form>
        <br>
        <canvas id="myRevenueChart"></canvas>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/revenuestats.js"/>"></script>
<script>
    window.onload = function () {
        let data = [];
        let lables = [];

    <c:forEach items="${revenueStats}" var="r">
        data.push(${r[3]});
        lables.push('${r[1]} ${r[2]}');
    </c:forEach>

                spRevenueStats(lables, data);
            };
</script>
