package com.innovation.biometric.Model;

import com.innovation.biometric.Model.Product;
import com.innovation.biometric.Model.User;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Cart{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cartId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;


    public Cart() {
    }

    public Cart(User user, Product product) {
        this.user = user;
        this.product = product;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
