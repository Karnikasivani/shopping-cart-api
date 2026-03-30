package com.example.ShoppingCart;

import java.util.List;

public interface CartService {
    CartItem addTocart(CartItemRequest cartItemRequest);
    List<CartItem> getCartItems();
    Double getCartTotal();
    void deleteFromCart(Long id);
}