<%@ page import="com.nhnacademy.shoppingmall.Product.domain.Product" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gimgyuhyeong
  Date: 12/8/23
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  session = "true" %>

<div class="container">

    <div class="row">

        <div class="col-md-3">
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="/admin/productList.do">상품 목록</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/addProduct.do">상품 추가</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/admin/deleteProduct.do">상품 삭제</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">주문 관리</a>
                </li>
            </ul>
        </div>

        <div class="col-md-9">

            <h1>상품 목록</h1>

            <c:if test="${not empty list}">

                <table class="table table-striped">
                    <thead>
                    <tr>
                        <th>상품 ID</th>
                        <th>카데고리 ID</th>
                        <th>모델명</th>
                        <th>모델 번호</th>
                        <th>가격</th>
                        <th>설명</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${sessionScope.list}" var="product">
                        <tr>
                            <td>${product.productId}</td>
                            <td>${product.categoryId}</td>
                            <td>${product.modelName}</td>
                            <td>${product.modelNumber}</td>
                            <td>${product.unitCost}</td>
                            <td>${product.description}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

            </c:if>

            <c:if test="${empty list}">

                <p>상품이 없습니다.</p>

            </c:if>

        </div>

    </div>

</div>