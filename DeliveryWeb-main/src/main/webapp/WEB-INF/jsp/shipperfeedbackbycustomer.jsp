<%-- 
    Document   : shipperfeedbackbycustomer
    Created on : Sep 1, 2022, 5:47:56 PM
    Author     : DELL
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<h1 class="text-center text-danger">Đánh giá shipper</h1>

<div class="row">
    <div class="col-md-4">
        <img src="${shipper2.avatarShipper}" alt="${shipper2.licensePlate}" class="img-fluid" width="100" height="100"/>
    </div>
    <div class="col-md-7">
        <h1>Số xe: ${shipper2.licensePlate}</h1>
    </div>
</div>

<c:url value="/api/shipperbycustomer/${shipper2.id}/feedbacks" var="endpoint"/>


<div class="form-group">
    <textarea class="form-control" placeholder="Nhập nội dung bình luận" id="commentId"></textarea>
</div>
<button class="btn btn-danger" onclick="addFeedback('${endpoint}', ${shipper2.id})">Gửi bình luận</button>

<br>

<ul id="feedbacks" class="list-group">
    <li>

    </li>
</ul>

<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.4/moment-with-locales.min.js"></script>
<script src="<c:url value="/js/feedback.js"/>"></script>
<script>
        window.onload = function () {
            loadFeedbacks('${endpoint}');
        };
</script>