package com.app.entity;

import java.util.Date;

import javax.persistence.*;

import com.app.entity.enums.City;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Orders")
public class Order {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "Contry")
	private String contry;

	@Enumerated(EnumType.STRING)
	@Column(name = "BookingCity")
	private City bookingCity;

	@Enumerated(EnumType.STRING)
	@Column(name = "ReturnCity")
	private City returnCity;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "StartDate")
	private Date startDate;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "EndDate")
	private Date endDate;
	
	@Column(name = "ClientAge")
	private int clientAge;
	
	@Column(name = "TypeInsurance")
	private String typeInsurance;
	
	@Column(name = "OrderStatus")
	private String orderStatus;
	
	@ManyToOne
    @JoinColumn(name="car_id", nullable=false)
    private Car car;
	
	@ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;
	
}
