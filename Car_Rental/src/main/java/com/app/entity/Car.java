package com.app.entity;

import java.time.Year;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="Cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Car {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(name = "Name")
	private String Name;
	
	@Column(name = "Brande")
	private String Brande;//enum
	
	@Column(name = "Matricule")
	private String Matricule;
	
	@Column(name = "Mileage")
	private Double Mileage;
	
	@Column(name = "Model")
	private Year Model;
	
	@Column(name = "HorsPower")
	private int HorsPower;
	
	@Column(name = "Consumption")
	private Double Consumption;
	
	@Column(name = "Fioul")
	private String Fioul;//enum
	
	@Column(name = "Bluetooth")
	private Boolean Bluetooth;
	
	@Column(name = "AirBag")
	private Boolean AirBag;
	
	@Column(name = "GearBox")
	private String GearBox;//enum
	
	@Column(name = "Seat")
	private int Seat;
	
	@Column(name = "Door")
	private int Door;
	
	@Column(name = "TypeCar")
	private String Type_Car;//enum
	
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
}
