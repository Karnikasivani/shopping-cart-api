package com.example.ShoppingCart;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping()
    public CartItem addTocart(@RequestBody CartItemRequest cartItemRequest){
        return cartService.addTocart(cartItemRequest);
    }

    @GetMapping()
    public List<CartItem> getCartItems() {
        return cartService.getCartItems();
    }

    @GetMapping("/total")
    public Double getCartTotal() {
        return cartService.getCartTotal();
    }

    @DeleteMapping("/{id}")
    public void deleteFromCart(@PathVariable Long id) {
        cartService.deleteFromCart(id);
    }

}
