package com.phegon.FoodApp.review.entity;

import java.time.LocalDateTime;

import com.phegon.FoodApp.auth_users.entity.User;
import com.phegon.FoodApp.menu.entity.Menu;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Table(name = "reviews")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Integer rating;

    @Column(columnDefinition = "TEXT")
    private String comments;

    private LocalDateTime createAt;

    @Column(name = "order_id")
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "menu_id")
    private Menu menu;

}
