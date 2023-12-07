package com.nhnacademy.shoppingmall.Product.domain;

import java.math.BigDecimal;

public class Product {
    private int productId;
    private int categoryId;
    private String modelNumber;
    private String modelName;
    private String productImage;
    private BigDecimal unitCost;
    private String description;

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getProductImage() {
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public BigDecimal getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(BigDecimal unitCost) {
        this.unitCost = unitCost;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Constructors
    public Product() {}

    public Product(int productId, int categoryId, String modelNumber, String modelName, String productImage, BigDecimal unitCost, String description) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.modelNumber = modelNumber;
        this.modelName = modelName;
        this.productImage = productImage;
        this.unitCost = unitCost;
        this.description = description;
    }

    // Other methods

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", categoryId=" + categoryId +
                ", modelNumber='" + modelNumber + '\'' +
                ", modelName='" + modelName + '\'' +
                ", productImage='" + productImage + '\'' +
                ", unitCost=" + unitCost +
                ", description='" + description + '\'' +
                '}';
    }
}