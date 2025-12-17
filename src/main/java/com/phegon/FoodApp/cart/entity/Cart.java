package com.phegon.FoodApp.cart.entity;

import java.util.List;

import com.phegon.FoodApp.auth_users.entity.User;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "carts")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem>cartItems;

    private String promoCode;


}
