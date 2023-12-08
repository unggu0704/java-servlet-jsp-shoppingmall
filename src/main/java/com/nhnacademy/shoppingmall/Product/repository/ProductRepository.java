package com.nhnacademy.shoppingmall.Product.repository;

import com.nhnacademy.shoppingmall.Product.domain.Product;
import com.nhnacademy.shoppingmall.common.page.Page;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(int productId);

    Optional<Page<Product>> findProductList(int pageSize, int currentPage);

    int save(Product product);
    int deleteByProductId(String productId);
    int update(Product product);

}
