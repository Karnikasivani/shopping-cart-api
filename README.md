# 🛒 Shopping Cart API

A REST API built with Spring Boot to manage a shopping cart with products and cart items.

## Technologies Used
- Java
- Spring Boot
- JPA/Hibernate
- H2 Database

## Project Structure
src/
├── Product.java               # Product entity
├── CartItem.java              # CartItem entity
├── ProductRequest.java        # Product DTO
├── CartItemRequest.java       # CartItem DTO
├── ProductRepository.java     # Product database operations
├── CartItemRepository.java    # CartItem database operations
├── ProductService.java        # Product service interface
├── CartService.java           # Cart service interface
├── ProductServiceImp.java     # Product business logic
├── CartServiceImp.java        # Cart business logic
├── ProductController.java     # Product REST endpoints
├── CartController.java        # Cart REST endpoints
├── ResourceNotFoundException  # Custom exception
├── ErrorResponse.java         # Error response structure
└── GlobalExceptionHandler     # Global exception handler

## Database Relationship
Product <── CartItem
One product can be in many cart items (@ManyToOne)

## Product Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| POST | `/products` | Add a new product |
| GET | `/products` | Get all products |
| GET | `/products/{id}` | Get a single product |
| DELETE | `/products/{id}` | Delete a product |

## Cart Endpoints

| Method | URL | Description |
|--------|-----|-------------|
| POST | `/cart` | Add product to cart |
| GET | `/cart` | Get all cart items |
| GET | `/cart/total` | Get cart total |
| DELETE | `/cart/{id}` | Remove from cart |

## How to Run
1. Clone the repository
2. Open in IntelliJ
3. Run `ShoppingCartApplication.java`
4. Test endpoints on `http://localhost:8080`

## Example Requests

### Add a Product
POST `/products`
```json
{
    "name": "iPhone",
    "price": 999.99,
    "stock": 10
}
```

### Add to Cart
POST `/cart`
```json
{
    "productId": 1,
    "quantity": 2
}
```

### Get Cart Total
GET `/cart/total`
```json
1999.98
```

## Error Handling
Returns proper error messages when resource is not found:
```json
{
    "status": 404,
    "message": "Product not found with id: 5"
}
```

## What I Learned
- Spring Boot REST APIs
- JPA/Hibernate table relationships (@ManyToOne)
- Custom exception handling
- Global exception handler (@RestControllerAdvice)
- DTOs and service layer pattern
