<%@ page import="com.nhnacademy.shoppingmall.Product.domain.Product" %>
<%@ page import="com.nhnacademy.shoppingmall.common.page.Page" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.nhnacademy.shoppingmall.Product.Service.impl.ProductServiceImpl" %>
<%@ page import="com.nhnacademy.shoppingmall.Product.repository.impl.ProductRepositoryImpl" %>
<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    int pageSize = 9; // 한 페이지에 표시할 상품 개수
    int currentPage = 1;
    if (request.getParameter("currentPage") != null) {
        currentPage = Integer.parseInt(request.getParameter("currentPage"));
    }
    Page<Product> pageProducts = new ProductServiceImpl(new ProductRepositoryImpl()).getProductPageList(pageSize, currentPage);
    long totalPage = pageProducts.getTotalCount() / pageSize; // 전체 페이지 알기

    // 페이지 처리를 위한 변수 선언
    int beginPage = (currentPage - 1) / pageSize * pageSize + 1;
    long endPage = Math.min(totalPage, beginPage + pageSize);

%>

<%-- 상품 목록 --%>
<div class="row row-cols-1 row-cols-sm-2 row-cols-md-3 g-3">
    <% for (Product product : pageProducts.getContent()) { %>
    <div class="col">
        <div class="card shadow-sm">
            <img src="src/main/webapp/resources/no-image.png" class="card-img-top" alt="상품 이미지">
            <div class="card-body">
                <h5 class="card-title"><%= product.getModelName() %></h5>
                <p class="card-text"><%= product.getDescription() %></p>
                <p class="card-text">가격: <span class="price"><%= product.getUnitCost().toPlainString() %>원</span></p>
                <div class="d-flex justify-content-between align-items-center">
                    <div class="btn-group">
                        <button type="button" class="btn btn-sm btn-outline-secondary">View</button>
                        <button type="button" class="btn btn-sm btn-outline-secondary">Edit</button>
                    </div>
                    <small class="text-muted">9 mins</small>
                </div>
            </div>
        </div>
    </div>
    <% } %>
</div>

<%-- 페이징 처리 --%>
<div class="row">
    <div class="col-md-12">
        <br>
        <ul class="pagination justify-content-center">
            <% for (int i = beginPage; i <= endPage; i++) { %>
            <li class="page-item <%= currentPage == i ? "active" : "" %>">
                <a class="page-link" href="?currentPage=<%= i %>"><%= i %></a>
            </li>
            <% } %>
        </ul>
    </div>
</div>