package com.example.ShoppingCart;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CartItem> addTocart(@RequestBody CartItemRequest cartItemRequest){
        return new ResponseEntity<>(cartService.addTocart(cartItemRequest), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<CartItem>> getCartItems() {
        return ResponseEntity.ok(cartService.getCartItems());
    }

    @GetMapping("/total")
    public ResponseEntity<Double> getCartTotal() {
        return ResponseEntity.ok(cartService.getCartTotal());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFromCart(@PathVariable Long id) {
        cartService.deleteFromCart(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
