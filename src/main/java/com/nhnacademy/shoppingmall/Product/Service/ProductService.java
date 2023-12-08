package com.nhnacademy.shoppingmall.Product.Service;

import com.nhnacademy.shoppingmall.Product.domain.Product;
import java.util.Map;

public interface ProductService {

    Product getProduct(int productId);

    Map<Integer, Product> getProductMap();

    void saveProduct(Product product);


    void updateProduct(Product product);

    void deleteProduct(int productId);
}
