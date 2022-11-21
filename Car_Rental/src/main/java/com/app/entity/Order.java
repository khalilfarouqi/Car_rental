package com.app.entity;

import java.util.Date;

import javax.persistence.*;

import com.app.entity.enem.City;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.*;

@Entity
@Table(name="Orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Order {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(name = "Contry")
	private String Contry;

	@Enumerated(EnumType.STRING)
	@Column(name = "BookingCity")
	private City Booking_City;

	@Enumerated(EnumType.STRING)
	@Column(name = "ReturnCity")
	private City Return_City;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "StartDate")
	private Date Start_Date;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "EndDate")
	private Date End_Date;
	
	@Column(name = "ClientAge")
	private int Client_Age;
	
	@Column(name = "TypeInsurance")
	private String Type_Insurance;
	
	@Column(name = "OrderStatus")
	private String Order_Status;
	
	@ManyToOne
    @JoinColumn(name="car_id", nullable=false)
    private Car car;
	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
	
}
