<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gimgyuhyeong
  Date: 12/7/23
  Time: 5:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="container my-5 border p-3 rounded shadow">
    <h2 class="text-center mb-4">유저 정보</h2>

    <div class="row text-center">
        <div class="col-md-4">
            <a href="/userInfo/userinfo.do" class="btn btn-primary">유저 정보 확인</a>
        </div>
        <c:if test="${sessionScope.user != null && sessionScope.user.userAuth == 'ROLE_ADMIN'}">
            <div class="col-md-4">
                <a href="/admin/adminPage.do" class="btn btn-primary">관리자 페이지</a>
            </div>
        </c:if>
    </div>
</div>
