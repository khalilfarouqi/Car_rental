package com.app.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="Admins")
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User {
	
	@Column(name = "FullName")
	private String Full_Name;

    public enum Brande {

        Honda,
        AlfaRomeo,
        Audi,
        BMW,
        Volkswagen,
        Chevrolet,
        Fiat,
        Ford,
        Hyundai,
        Renault,
        Nissan,
        Mitsubishi,
        Jeep,
        Kia,
        LandRover,
        Dacia,
        MercedesBenz,
        Citroën,
        Peugeot;



    }
}
