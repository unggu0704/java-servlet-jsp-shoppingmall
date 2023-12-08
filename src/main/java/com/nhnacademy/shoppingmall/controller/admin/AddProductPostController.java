package com.nhnacademy.shoppingmall.controller.admin;


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
@RequestMapping(method = RequestMapping.Method.POST,value = "/admin/addProductAction.do")
public class AddProductPostController implements BaseController {
    ProductService productService = new ProductServiceImpl(new ProductRepositoryImpl());
    @Override
    public String execute(HttpServletRequest req, HttpServletResponse resp) {
        String categoryID = req.getParameter("categoryID"); // 카테고리 ID
        String modelNumber = req.getParameter("modelNumber"); // 모델 넘버
        String modelName = req.getParameter("modelName"); // 모델 이름
        String productImage = req.getParameter("productImage"); // 이미지 URL
        String unitCost =req.getParameter("unitCost"); // 가격
        String description = req.getParameter("description"); // 상품 설명
        req.setAttribute("successMessage", false);
        req.setAttribute("errorMessage", false);

        if (categoryID.isEmpty() || modelNumber.isEmpty() || modelName.isEmpty() ||
                productImage.isEmpty() || description.isEmpty()) {
            req.setAttribute("errorMessage", true);
            log.info("입력이 안된 칸이 있음");
            return "shop/mypage/admin/addproductForm";
        }

        log.info("product 객체 생성");
        // Product 객체 생성
        Product product = new Product();
        product.setCategoryId(Integer.parseInt(categoryID));
        product.setModelNumber(modelNumber);
        product.setModelName(modelName);
        product.setProductImage(productImage);
        product.setUnitCost(new BigDecimal(unitCost));
        product.setDescription(description);

        productService.saveProduct(product);

        // 성공 시 성공 메시지 설정
        req.setAttribute("successMessage", true);
        return "shop/mypage/admin/addproductForm";  // 상품 목록 페이지로 이동
    }

}
