package com.app.entity;

import com.app.entity.enem.NotificationType;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="NotificationGroupe")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class NotificationGroupe {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;

    private String object;

    @Column(columnDefinition = "NVARCHAR(MAX)")
    private String body;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NotificationType notificationType;

    private Boolean notificationWeb;

    private Date dateEnvoi;
}
