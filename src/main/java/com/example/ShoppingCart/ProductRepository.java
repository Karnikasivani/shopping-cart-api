package com.example.ShoppingCart;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>{
    // Method name query
    List<Product> findByNameContaining(String keyword);
    List<Product> findByPriceLessThan(Double price);
    List<Product> findByStockGreaterThan(Integer stock);

    //JPQA query
    @Query("SELECT p FROM Product p WHERE p.stock=0")
    List<Product> findOutOfStock();
}
