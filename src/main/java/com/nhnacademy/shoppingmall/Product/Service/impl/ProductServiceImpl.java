package com.nhnacademy.shoppingmall.Product.Service.impl;

import com.nhnacademy.shoppingmall.Product.Service.ProductService;
import com.nhnacademy.shoppingmall.Product.domain.Product;
import com.nhnacademy.shoppingmall.Product.repository.ProductRepository;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * 상품 ID로 상품을 조회합니다.
     *
     * @param productId 상품 ID
     * @return 상품
     */
    @Override
    public Product getProduct(int productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (optionalProduct.isEmpty()) {
            throw new RuntimeException("상품 ID " + productId + " 에 해당하는 상품이 없습니다.");

        }

        Product product = optionalProduct.get();
        return product;
    }

    @Override
    public Map<Integer, Product> getProductMap() {
        Optional<Map<Integer, Product>> productMapOptional = productRepository.findAllProducts();

        if (!productMapOptional.isPresent()) {
            throw new RuntimeException("상품들을 불러오는데 실패했습니다.");
        }

        return productMapOptional.get();
    }


    /**
     * 새 상품을 저장합니다.
     *
     * @param product 저장할 상품
     */
    @Override
    public void saveProduct(Product product) {
        if (productRepository.findById(product.getProductId()).isPresent()) {
            throw new RuntimeException("상품 ID " + product.getProductId() + " 에 해당하는 상품이 이미 존재합니다.");
        }

        productRepository.save(product);
    }

    /**
     * 기존 상품을 수정합니다.
     *
     * @param product 수정할 상품
     */
    @Override
    public void updateProduct(Product product) {
        if (!productRepository.findById(product.getProductId()).isPresent()) {
            throw new RuntimeException("상품 ID " + product.getProductId() + " 에 해당하는 상품이 없습니다.");
        }

        productRepository.update(product);
    }

    /**
     * 상품 ID로 상품을 삭제합니다.
     *
     * @param productId 삭제할 상품 ID
     */
    @Override
    public void deleteProduct(int productId) {
        if (!productRepository.findById(productId).isPresent()) {
            throw new RuntimeException("상품 ID " + productId + " 에 해당하는 상품이 없습니다.");
        }

        productRepository.deleteByProductId(String.valueOf(productId));
    }
}