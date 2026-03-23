package com.example.ShoppingCart;
import jakarta.persistence.*;

@Entity
@Table(name = "CartItem")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    public void setId(long id) {this.id = id;}
    public Long getId() {return id;}

    public void setProduct(Product product) {this.product = product;}
    public Product getProduct() {return product;}

    public void setQuantity(Integer quantity) {this.quantity = quantity;}
    public Integer getQuantity() {return quantity;}
}
