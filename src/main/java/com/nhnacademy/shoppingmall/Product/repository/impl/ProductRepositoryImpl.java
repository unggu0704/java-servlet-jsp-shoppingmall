package com.nhnacademy.shoppingmall.Product.repository.impl;

import com.nhnacademy.shoppingmall.Product.domain.Product;
import com.nhnacademy.shoppingmall.Product.repository.ProductRepository;
import com.nhnacademy.shoppingmall.common.mvc.transaction.DbConnectionThreadLocal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.*;

public class ProductRepositoryImpl implements ProductRepository {

    @Override
    public Optional<Product> findById(int productId) {
        Connection connection = DbConnectionThreadLocal.getConnection();
        String sql = "SELECT ProductId, CategoryId, ModelNumber, ModelName, ProductImage, UnitCost, Description FROM Products WHERE ProductId = ?";

        try {
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.setInt(1, productId);

            ResultSet resultSet = psmt.executeQuery();

            if (resultSet.next()) {
                Product product = new Product(
                        resultSet.getInt("ProductId"),
                        resultSet.getInt("CategoryId"),
                        resultSet.getString("ModelNumber"),
                        resultSet.getString("ModelName"),
                        resultSet.getString("ProductImage"),
                        resultSet.getBigDecimal("UnitCost"),
                        resultSet.getString("Description")
                );
                return Optional.ofNullable(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Map<Integer, Product>> findAllProducts() {
        Connection connection = DbConnectionThreadLocal.getConnection();

        String sql = "SELECT * FROM Products";
        try {
            PreparedStatement psmt = connection.prepareStatement(sql);
            ResultSet resultSet = psmt.executeQuery();

            // 상품 정보를 Map에 저장합니다.
            Map<Integer, Product> products = new HashMap<>();
            while (resultSet.next()) {
                Product product = new Product(
                        resultSet.getInt("ProductId"),
                        resultSet.getInt("CategoryId"),
                        resultSet.getString("ModelNumber"),
                        resultSet.getString("ModelName"),
                        resultSet.getString("ProductImage"),
                        resultSet.getBigDecimal("UnitCost"),
                        resultSet.getString("Description")
                );
                products.put(product.getProductId(), product);
            }
            return Optional.of(products);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int save(Product product) {
        Connection connection = DbConnectionThreadLocal.getConnection();
        String sql = "INSERT INTO Products (CategoryId, ModelNumber, ModelName, ProductImage, UnitCost, Description) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.setInt(1, product.getCategoryId());
            psmt.setString(2, product.getModelNumber());
            psmt.setString(3, product.getModelName());
            psmt.setString(4, product.getProductImage());
            psmt.setBigDecimal(5, product.getUnitCost());
            psmt.setString(6, product.getDescription());

            return psmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int deleteByProductId(String productId) {
        Connection connection = DbConnectionThreadLocal.getConnection();
        String sql = "DELETE FROM Products WHERE ProductId = ?";

        try {
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.setString(1, productId);

            return psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public int update(Product product) {
        Connection connection = DbConnectionThreadLocal.getConnection();
        String sql = "UPDATE Products SET CategoryId = ?, ModelNumber = ?, ModelName = ?, ProductImage = ?, UnitCost = ?, Description = ? WHERE ProductId = ?";

        try {
            PreparedStatement psmt = connection.prepareStatement(sql);
            psmt.setInt(1, product.getCategoryId());
            psmt.setString(2, product.getModelNumber());
            psmt.setString(3, product.getModelName());
            psmt.setString(4, product.getProductImage());
            psmt.setBigDecimal(5, product.getUnitCost());
            psmt.setString(6, product.getDescription());
            psmt.setInt(7, product.getProductId());

            return psmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
