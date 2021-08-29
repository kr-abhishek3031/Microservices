package com.example.demo.repositry;

import com.example.demo.entity.Product;

public interface DatabaseOperations {
    public boolean addProduct(Product p);
    public Product searchProductByName(String name);
    public boolean updateProductPrice( Long id, Double change);
    public boolean deleteProduct(Long pID);
    public Product searchProductByID(Long id);
}
