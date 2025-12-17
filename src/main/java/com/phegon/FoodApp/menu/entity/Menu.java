package com.phegon.FoodApp.menu.entity;

import java.math.BigDecimal;
import java.util.List;

import com.phegon.FoodApp.category.entity.Category;
import com.phegon.FoodApp.order.entity.OrderItem;
import com.phegon.FoodApp.review.entity.Review;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "menus")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private BigDecimal price;
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "menu", cascade=CascadeType.ALL)
    private List<OrderItem>orderItems;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review>reviews;

}
