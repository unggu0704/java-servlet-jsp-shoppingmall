package com.nhnacademy.shoppingmall.controller.admin;

import com.nhnacademy.shoppingmall.Product.Service.ProductService;
import com.nhnacademy.shoppingmall.Product.Service.impl.ProductServiceImpl;
import com.nhnacademy.shoppingmall.Product.repository.impl.ProductRepositoryImpl;
import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@RequestMapping(method = RequestMapping.Method.GET,value = "/admin/addProduct.do")
public class AddProductGETController implements BaseController {
    ProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {

    }
}
