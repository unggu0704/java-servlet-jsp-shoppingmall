package com.nhnacademy.shoppingmall.Product.Service;

import com.nhnacademy.shoppingmall.Product.domain.Product;
import com.nhnacademy.shoppingmall.common.page.Page;
import java.util.Map;

public interface ProductService {

    Product getProduct(int productId);

    Page<Product> getProductPageList(int pageSize, int currentPage);

    void saveProduct(Product product);


    void updateProduct(Product product);

    void deleteProduct(int productId);
}
