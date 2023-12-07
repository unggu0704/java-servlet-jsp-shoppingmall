package com.nhnacademy.shoppingmall.Product.Service;

import com.nhnacademy.shoppingmall.Product.domain.Product;

public interface ProductService {

    Product getProduct(int productId);

    void saveProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(int productId);
}
