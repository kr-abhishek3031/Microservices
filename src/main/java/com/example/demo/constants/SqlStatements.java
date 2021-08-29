package com.example.demo.constants;

public interface SqlStatements {
    String INSERT = "INSERT INTO ProductCatalog VALUES (?, ?, ?, ?)";
    String DELETE = "DELETE FROM ProductCatalog WHERE id= ?";
    String SELECT = "SELECT * FROM ProductCatalog WHERE id= ?";
    String SELECT_ALL = "SELECT * FROM ProductCatalog";
    String UPDATE = "UPDATE Students SET name=?, price=?, quantity=? WHERE id=?";
    String CREATE_PRODUCT_CATALOG = "CREATE TABLE ProductCatalog " +
            "(Id BIGINT not NULL," +
            "Name varchar(255), "+
            "Price double, " +
            "Quantity Bigint " +
            "PRIMARY KEY (Id)";

}
