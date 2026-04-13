package com.example.ShoppingCart;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ProductRequest(
    @NotBlank(message = "Name cannot be empty")
    String name,

    @NotNull(message = "Price cannot be null")
    @Min(value = 0,message = "Price cannot be negative")
    Double price,

    @NotNull(message = "Stock cannot be null")
    @Min(value = 0,message = "Stock cannot be negative")
    Integer stock) {
}
