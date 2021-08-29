package com.example.demo.repositry;

import com.example.demo.config.ConnectionFactory;
import com.example.demo.config.NativeJDBC;
import com.example.demo.constants.SqlStatements;
import com.example.demo.entity.Product;
import com.example.demo.exceptionHandler.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Repository
public class DatabaseOpsImplementation implements DatabaseOperations {

    @Autowired
    private NativeJDBC nativeJDBC;

    @Override
    public boolean addProduct(Product product) {

        try {
            boolean temp = nativeJDBC.addProduct(product);
            return temp;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        //users.add(user);
        return false;
    }

    @Override
    public Product searchProductByName(String name) {
        return null;
    }

    @Override
    public boolean updateProductPrice(Long id, Double change) {
        return false;
    }

    @Override
    public boolean deleteProduct(Long pID) {
        return false;
    }

    @Override
    public Product searchProductByID(Long id) {
        return null;
    }


}
