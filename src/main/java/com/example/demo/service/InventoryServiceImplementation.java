package com.example.demo.service;

import com.example.demo.config.NativeJDBC;
import com.example.demo.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class InventoryServiceImplementation implements InventoryService{
    private static final AtomicLong productCounter = new AtomicLong();

    private static List<Product> products;
    static {
        products = populateInventory();
    }

    @Autowired
    NativeJDBC nativeJDBC;

    @Override
    public boolean addProduct(Product p) {
        boolean temp = nativeJDBC.addProduct(p);
        return temp;
    }

    @Override
    public Product searchProductByName(String name) {
        //System.out.println(name);
        for(Product p : products){
            //System.out.println(p.getpName());
            if(p.getpName().equalsIgnoreCase(name)){
                //System.out.println("Hurrah!!");
                return p;
            }
        }
        return null;
    }

    @Override
    public boolean updateProductPrice(Long id, Double change) {
        Product p = searchProductByID(id);
        if(p!=null){
            Double updatedPrice = p.getPrice() + change;
            p.setPrice(updatedPrice);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteProduct(Long id) {
        Product p = searchProductByID(id);
        if(p!=null){
            products.remove(p);
            return false;
        }
        return true;
    }

    @Override
    public Product searchProductByID(Long id) {
        Product p = nativeJDBC.searchProductByID(id);
        /*
        for(Product p : products){
            if(p.getpId().equals(id)){
                return p;
            }
        }*/
        return p;
    }

    private static List<Product> populateInventory(){
        List<Product> initialProducts = new ArrayList<Product>();
        initialProducts.add(new Product("Nike",productCounter.incrementAndGet(),2000.0, 10L));
        initialProducts.add(new Product("Adidas",productCounter.incrementAndGet(),1000.0, 20L));
        initialProducts.add(new Product("Adidas",productCounter.incrementAndGet(),1000.0, 20L));
        return initialProducts;
    }
}
