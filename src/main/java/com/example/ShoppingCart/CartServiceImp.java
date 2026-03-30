package com.example.ShoppingCart;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImp implements CartService{
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    public CartServiceImp(CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CartItem addTocart(CartItemRequest cartItemRequest) {
        Product product = productRepository.findById(cartItemRequest.productId()).orElse(null);
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(cartItemRequest.quantity());
        return cartItemRepository.save(cartItem);
    }

    @Override
    public List<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }

    @Override
    public Double getCartTotal() {
        List<CartItem> cartItems = cartItemRepository.findAll();
        Double total = 0.0;
        for(CartItem cartItem : cartItems) {
            total += cartItem.getProduct().getPrice() * cartItem.getQuantity();
        }
        return total;
    }

    @Override
    public void deleteFromCart(Long id) {
        cartItemRepository.deleteById(id);
    }
}
