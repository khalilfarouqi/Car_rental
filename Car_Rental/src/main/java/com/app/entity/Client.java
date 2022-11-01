package com.app.entity;

import java.util.Date;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@Entity
@Table(name="Clients")
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client extends User {
	
	@Column(name = "FirstName")
	private String First_Name;
	
	@Column(name = "LastName")
	private String Last_Name;

	@Enumerated(EnumType.STRING)
	@Column(name = "Gender")
	private Gender gender;

	//Null
	@Column(name = "Age")
	private int Age;
	
	@Column(name = "Adress")
	private String Adress;
	
	@Column(name = "Tel")
	private String Tel;
	
	@Column(name = "City")
	private String City;
	
	@Column(name = "Cantry")
	private String Cantry;
	
	@Column(name = "CIN")
	private String CIN;
	
	@Column(name = "Licence")
	private String Licence;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "DateLicence")
	private Date Date_Licence;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "DateCreation")
	private Date Date_Creation;
	
	@Column(name = "Email")
	private String Email;
	
	@Column(name = "VolNumbre")
	private int Vol_Numbre;
	
}
