<%-- 
    Document   : stats
    Created on : Sep 1, 2022, 8:53:49 AM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">Thống kê số lượng đơn hàng của shipper</h1>

<div class="row">
    <div class="col-md-6 col-cs-12">
        <table class="table">
            <tr>
                <th>Id Shipper</th>
                <th>Tên shipper</th>
                <th>Số đơn hàng</th>
            </tr>
            <c:forEach items="${spStats}" var="s">
                <tr>
                    <td>${s[0]}</td>
                    <td>${s[1]} ${s[2]}</td>
                    <td>${s[3]}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-6 col-cs-12">
        <canvas id="myChart"></canvas>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/stats.js"/>"></script>
<script>
    window.onload = function () {
        let data = [];
        let lables = [];

    <c:forEach items="${spStats}" var="s">
        data.push(${s[3]});
        lables.push('${s[1]} ${s[2]}');
    </c:forEach>

        spStats(lables, data);
    };
</script>