package com.app.entity;

import java.util.*;

import javax.persistence.*;

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
	private Long ID;
	
	@Column(name = "Name")
	private String Name;

	@Enumerated(EnumType.STRING)
	@Column(name = "Brande")
	private Brande brande;
	
	@Column(name = "Matricule")
	private String Matricule;
	
	@Column(name = "Mileage")
	private Double Mileage;
	
	@Column(name = "Model")
	private int Model;
	
	@Column(name = "HorsPower")
	private int HorsPower;
	
	@Column(name = "Consumption")
	private Double Consumption;

	@Enumerated(EnumType.STRING)
	@Column(name = "fuel")
	private Fuel fuel;
	
	@Column(name = "Bluetooth")
	private Boolean Bluetooth;
	
	@Column(name = "AirBag")
	private Boolean AirBag;

	@Enumerated(EnumType.STRING)
	@Column(name = "GearBox")
	private GearBox gearBox;
	
	@Column(name = "Seat")
	private int Seat;
	
	@Column(name = "Door")
	private int Door;

	@Enumerated(EnumType.STRING)
	@Column(name = "Style")
	private Style style;
	
	@Column(name = "SizeCofer")
	private int Size_Cofer;
	
	@Column(name = "Price")
	private Double Price;
	
	@Column(name = "Rate")
	private Double Rate;
	
	//-------------------Assurence-------------------
	
	@Column(name = "CDM")
	private Boolean CDM;
	
	@Column(name = "ProtectionVol")
	private Boolean Protection_Vol;
	
	@Column(name = "RespoCivile")
	private Boolean Respo_Civile;

	@Column(name = "BrisGlacePneus")
	private Boolean Bris_Glace_Pneus;
	
	//-----------------------------------------------
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "photo_id", referencedColumnName = "id")
    private Photo photo;
	
	@OneToMany(mappedBy = "car")
    private List<Order> orders;
}
