package com.app.entity;

import java.util.*;

import javax.persistence.*;

import com.app.entity.enums.Brande;
import com.app.entity.enums.Fuel;
import com.app.entity.enums.GearBox;
import com.app.entity.enums.Style;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.*;

@Entity
@Table(name="Cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Car {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Name")
	private String name;

	@Enumerated(EnumType.STRING)
	@Column(name = "Brande")
	private Brande brande;
	
	@Column(name = "Matricule")
	private String matricule;
	
	@Column(name = "Mileage")
	private Double mileage;
	
	@Column(name = "Model")
	private int model;
	
	@Column(name = "HorsPower")
	private int horsPower;
	
	@Column(name = "Consumption")
	private Double consumption;

	@Enumerated(EnumType.STRING)
	@Column(name = "fuel")
	private Fuel fuel;
	
	@Column(name = "Bluetooth")
	private Boolean bluetooth;
	
	@Column(name = "AirBag")
	private Boolean airBag;

	@Enumerated(EnumType.STRING)
	@Column(name = "GearBox")
	private GearBox gearBox;
	
	@Column(name = "Seat")
	private int seat;
	
	@Column(name = "Door")
	private int door;

	@Enumerated(EnumType.STRING)
	@Column(name = "Style")
	private Style style;
	
	@Column(name = "bootSize")
	private int bootSize;
	
	@Column(name = "Price")
	private Double price;
	
	@Column(name = "Rate")
	private Double rate;
	
	//-------------------Assurence-------------------
	
	@Column(name = "CDM")
	private Boolean cdm;
	
	@Column(name = "ProtectionVol")
	private Boolean protectionVol;
	
	@Column(name = "RespoCivile")
	private Boolean respoCivile;

	@Column(name = "BrisGlacePneus")
	private Boolean brisGlacePneus;
	
	//-----------------------------------------------
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private Photo photo;
	
	@OneToMany(mappedBy = "car")
    private List<Order> orders;
}
