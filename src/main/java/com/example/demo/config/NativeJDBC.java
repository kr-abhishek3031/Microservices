package com.example.demo.config;

import com.example.demo.constants.SqlStatements;
import com.example.demo.entity.Product;
import com.example.demo.exceptionHandler.ApplicationException;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class NativeJDBC {


    public boolean addProduct(Product product) {

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement ps = connection.prepareStatement(SqlStatements.INSERT);){
            ps.setLong(1, product.getpId());
            ps.setString(2, product.getpName());
            ps.setDouble(3, product.getPrice());
            ps.setLong(4, product.getQuantity());
            int i = ps.executeUpdate();

            if(i == 1) {
                System.out.println("Product Record successfully added");
                return true;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Product searchProductByID(Long id) {
        Product product = null;
        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement ps = connection.prepareStatement(SqlStatements.SELECT);) {
             ps.setLong(1, id);
             ResultSet rs = ps.executeQuery();
             product = getProductInfo(rs);
             return product;

        } catch (Exception throwables) {
            throwables.printStackTrace();
        }
        return product;
    }

    private Product getProductInfo(ResultSet rs) throws SQLException{
        Product product = new Product();
        product.setpId( rs.getLong("id")) ;
        product.setpName( rs.getString("name") );
        product.setPrice(rs.getDouble("price"));
        product.setQuantity(rs.getLong("quantity"));
        return product;
    }
}
