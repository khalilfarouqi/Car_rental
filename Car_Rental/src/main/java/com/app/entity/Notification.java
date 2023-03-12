package com.app.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="Notification")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Notification {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
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
