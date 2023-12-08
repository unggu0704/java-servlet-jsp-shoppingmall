package com.nhnacademy.shoppingmall.Product.repository;

import com.nhnacademy.shoppingmall.Product.domain.Product;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(int productId);

    Optional<Map<Integer, Product>> findAllProducts();

    int save(Product product);
    int deleteByProductId(String productId);
    int update(Product product);

}
