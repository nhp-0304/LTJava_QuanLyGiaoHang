<%-- 
    Document   : frequencystats
    Created on : Sep 1, 2022, 3:05:00 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-info">Tần suất giao hàng của shipper</h1>

<div class="row">
    <div class="col-md-6 col-cs-12">
        <table class="table">
            <tr>
                <th>Id Shipper</th>
                <th>Tên shipper</th>
                <th>Số lượng đơn hàng / tháng</th>
            </tr>
            <c:forEach items="${frequencyStats}" var="f">
                <tr>
                    <td>${f[0]}</td>
                    <td>${f[1]} ${f[2]}</td>
                    <td>${f[3]}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="col-md-6 col-cs-12">
        <c:url value="/admin/frequencystats" var="action" />
        <form action="${action}">
            <div class="mb-3 mt-3">
                <select class="form-control" name="month">
                    <c:forEach begin="1" end="12" var="i">
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
        <canvas id="myFrequencyChart"></canvas>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
<script src="<c:url value="/js/frequencystats.js"/>"></script>
<script>
    window.onload = function () {
        let data = [];
        let lables = [];

    <c:forEach items="${frequencyStats}" var="f">
        data.push(${f[3]});
        lables.push('${f[1]} ${f[2]}');
    </c:forEach>

                spFrequencyStats(lables, data);
            };
</script>
