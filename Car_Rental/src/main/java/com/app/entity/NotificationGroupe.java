package com.app.entity;

import com.app.entity.enums.NotificationType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name="NotificationGroupe")
public class NotificationGroupe {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String object;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String body;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

    private Boolean notificationWeb;

    private Date dateEnvoi;
}
