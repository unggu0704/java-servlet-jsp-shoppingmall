<%--
  Created by IntelliJ IDEA.
  User: gimgyuhyeong
  Date: 12/8/23
  Time: 6:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

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

                <div class="row">
                    <c:forEach items="${list}" var="product">
                        <div class="col-md-4">
                            <div class="card">
                                <img src="${product.productImage}" alt="${product.modelName}" class="card-img-top">
                                <div class="card-body">
                                    <h5 class="card-title">${product.modelName}</h5>
                                    <p class="card-text">${product.description}</p>
                                    <a href="#" class="btn btn-primary">상세보기</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>

            </c:if>

            <c:if test="${empty list}">

                <p>상품이 없습니다.</p>

            </c:if>

        </div>

    </div>

</div>