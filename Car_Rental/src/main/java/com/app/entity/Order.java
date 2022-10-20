package com.app.entity;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="Orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
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
	
	@Column(name = "StartDate")
	private LocalDate Start_Date;
	
	@Column(name = "EndDate")
	private LocalDate End_Date;
	
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
