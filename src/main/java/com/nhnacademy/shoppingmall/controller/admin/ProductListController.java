package com.nhnacademy.shoppingmall.controller.admin;

import com.nhnacademy.shoppingmall.Product.Service.ProductService;
import com.nhnacademy.shoppingmall.Product.Service.impl.ProductServiceImpl;
import com.nhnacademy.shoppingmall.Product.domain.Product;
import com.nhnacademy.shoppingmall.Product.repository.impl.ProductRepositoryImpl;
import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(method = RequestMapping.Method.GET,value = "/admin/productList.do")
public class ProductListController implements BaseController {

    ProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

        List<Product> productList = productService.getAllProdcutList();
        HttpSession session = req.getSession(false);
        session.setAttribute("list", productList);

        return "shop/mypage/admin/printProductList";
    }
}
