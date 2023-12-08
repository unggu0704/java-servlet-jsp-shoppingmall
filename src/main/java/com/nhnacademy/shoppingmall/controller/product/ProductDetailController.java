package com.nhnacademy.shoppingmall.controller.product;
import com.nhnacademy.shoppingmall.Product.Service.ProductService;
import com.nhnacademy.shoppingmall.Product.Service.impl.ProductServiceImpl;
import com.nhnacademy.shoppingmall.Product.domain.Product;
import com.nhnacademy.shoppingmall.Product.repository.impl.ProductRepositoryImpl;
import com.nhnacademy.shoppingmall.common.mvc.annotation.RequestMapping;
import com.nhnacademy.shoppingmall.common.mvc.controller.BaseController;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping(method = RequestMapping.Method.POST,value = "/product/prodcutDetail.do")
public class ProductDetailController implements BaseController{
    private final ProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String input = req.getParameter("productID");
        int productID = Integer.parseInt(req.getParameter("productID"));
        Product product = productService.getProduct(productID);
        log.debug("img 값 " + product.getProductImage());
        req.setAttribute("product", product);

        return "shop/product/productDetail";
    }
}
