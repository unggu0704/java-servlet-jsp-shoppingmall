package com.nhnacademy.shoppingmall.controller.admin;

import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import com.nhnacademy.shoppingmall.Product.Service.ProductService;
import com.nhnacademy.shoppingmall.Product.Service.impl.ProductServiceImpl;
import com.nhnacademy.shoppingmall.Product.domain.Product;
import com.nhnacademy.shoppingmall.Product.repository.impl.ProductRepositoryImpl;
import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(method = RequestMapping.Method.POST,value = "/admin/deleteProductAction.do")
public class DeleteProductPostController implements BaseController {
    ProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        int prodcutID = Integer.parseInt(req.getParameter("productID"));
        req.setAttribute("errorMessage", false);
        req.setAttribute("successMessage", false);

        try {
            productService.getProduct(prodcutID);
        } catch (RuntimeException e) {
            req.setAttribute("errorMessage", true);
            log.info("삭제할 id가 없음");
            return "shop/mypage/admin/deleteproductForm";
        }

        productService.deleteProduct(prodcutID);

        req.setAttribute("successMessage", true);

        return "shop/mypage/admin/deleteproductForm";
    }
}
