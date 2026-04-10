package com.example.ShoppingCart;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImp implements ProductService{
    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product createProduct(ProductRequest newProduct) {
        Product product = new Product();
        product.setName(newProduct.name());
        product.setPrice(newProduct.price());
        product.setStock(newProduct.stock());
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not fount with id:" + id));

    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
