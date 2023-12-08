<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gimgyuhyeong
  Date: 12/7/23
  Time: 5:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<h1 > 마이 페이지 </h1>
<div class="row">
    <div class="col-md-4">
        <div class="list-group">
            <a href="/userInfo/userinfo.do" class="list-group-item">내 정보 확인</a>
        </div>
    </div>
    <c:if test="${sessionScope.user != null && sessionScope.user.userAuth == 'ROLE_ADMIN'}">
        <div class="col-md-4">
            <div class="list-group">
                <a href="/admin/adminPage.do" class="list-group-item">관리자 페이지 접속</a>
            </div>
        </div>
    </c:if>
</div>
