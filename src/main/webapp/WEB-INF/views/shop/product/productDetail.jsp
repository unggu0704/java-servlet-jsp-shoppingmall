<%@ page import="com.nhnacademy.shoppingmall.Product.domain.Product" %><%--
  Created by IntelliJ IDEA.
  User: gimgyuhyeong
  Date: 12/8/23
  Time: 11:30 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
  .product-detail {
    display: flex;
    align-items: center; /* 수직 중앙 정렬 */
  }



  .product-info {
    flex-grow: 1; /* 나머지 공간을 최대한 확장 */
    padding-left: 40px; /* 텍스트와 이미지 사이 간격을 위한 패딩 추가 */
    text-align-all: start;
  }

</style>

<div class="product-detail">
  <div class="product-image">
    <img src="${product.productImage}" alt="상품 이미지">
  </div>
  <div class="product-info">
    <h1 class="product-name">${product.modelName}</h1>
    <p class="product-description">${product.description}</p>
    <br>
    <h3 class="product-price">${product.unitCost.toPlainString()}원</h3>
    <p class="product-description">상품 번호: ${product.productId}</p>
    <button class="w-100 btn btn-lg btn-primary mt-3" type="submit">구매</button>
  </div>


</div>