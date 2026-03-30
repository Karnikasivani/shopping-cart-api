package com.example.ShoppingCart;

import java.util.List;

public interface ProductService {
    Product createProduct(ProductRequest newProduct);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void deleteProduct(Long id);
}
