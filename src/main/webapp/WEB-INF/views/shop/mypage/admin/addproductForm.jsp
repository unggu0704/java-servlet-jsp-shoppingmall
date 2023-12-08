<%--
  Created by IntelliJ IDEA.
  User: gimgyuhyeong
  Date: 12/7/23
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container">

    <div class="row">

        <div class="col-md-3">
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="#">유저 목록</a>
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
            <form method="post" action="/admin/addProductAction.do">
                <h2>상품 등록 </h2>

                <div class="form-group">
                    <label for="categoryID">Category:</label>
                    <input type="text" class="form-control" id="categoryID" name="categoryID" placeholder="카테고리 숫자를 입력해주새요 (1 ~ 5)" required>
                    </select>
                </div>
                <div class="form-group">
                    <label for="modelNumber">Model Number:</label>
                    <input type="text" class="form-control" id="modelNumber" name="modelNumber" placeholder="모델 넘버를 입력해주세요" required>
                </div>
                <div class="form-group">
                    <label for="modelName">Model Name:</label>
                    <input type="text" class="form-control" id="modelName" name="modelName" placeholder="상품 이름을 입력해주세요" required>
                </div>
                <div class="form-group">
                    <label for="productImage">Product Image URL:</label>
                    <input type="url" class="form-control" id="productImage" name="productImage" placeholder="이미지를 URL 형식으로 입력해주세요." required>
                </div>
                <div class="form-group">
                    <label for="unitCost">Unit Cost:</label>
                    <input type="number" step="0.01" class="form-control" id="unitCost" name="unitCost" placeholder="가격을 입력해주세요." required>
                </div>
                <div class="form-group">
                    <label for="description">Description:</label>
                    <textarea class="form-control" id="description" name="description" rows="3" placeholder="상품 설명을 입력해주세요."></textarea>
                </div>
                <br>
                <button type="submit" class="btn btn-primary">상품 등록</button>
            </form>

        </div>

        <br>

        <c:if test="${requestScope.successMessage == true}">
            <div class="alert alert-success">
                <strong>성공!</strong> 상품이 성공적으로 등록되었습니다.
            </div>
        </c:if>

        <c:if test="${requestScope.errorMessage == true}">
            <div class="alert alert-danger">
                <strong>오류!</strong> 상품이 등록되지 않았습니다.
            </div>
        </c:if>

    </div>

</div>