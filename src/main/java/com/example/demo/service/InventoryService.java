package com.example.demo.service;

import com.example.demo.entity.Product;

public interface InventoryService {

    public void addProduct(Product p);
    public Product searchProductByName(String name);
    public boolean updateProductPrice( Long id, Double change);
    public boolean deleteProduct(Long pID);
    public Product searchProductByID(Long id);

}
