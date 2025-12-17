package com.phegon.FoodApp.email_notification.entity;

import java.time.LocalDateTime;

import com.phegon.FoodApp.enums.NotificationType;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@Entity
@Table(name = "notifications")
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    @NotBlank(message = "recipient is required")
    private String recipient;

    @Lob
    private String body;

    @Enumerated(EnumType.STRING)
    private NotificationType type;

    private final LocalDateTime createAt = LocalDateTime.now();

    private boolean isHtml;

}
