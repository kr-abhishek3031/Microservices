package com.example.demo.entity;

public class Product {
    private String pName;
    private Long pId;
    private Double price;
    private Long quantity;

    public Product(){}
    public Product(String pName, Long pId, Double price, Long quantity) {
        this.pName = pName;
        this.pId = pId;
        this.price = price;
        this.quantity = quantity;
    }

    public String getpName() {
        return this.pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public Long getpId() {
        return pId;
    }

    public void setpId(Long pId) {
        this.pId = pId;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }
}
