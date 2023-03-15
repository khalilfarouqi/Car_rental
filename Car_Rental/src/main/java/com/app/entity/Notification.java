package com.app.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="Notification")
public class Notification {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String object;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String body;

    private Boolean isRead;

    private Boolean notificationWeb;

    @ManyToOne
    private User user;

    @OneToOne
    private NotificationGroupe notificationGroupe;
}
