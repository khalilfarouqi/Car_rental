package com.app.entity;

import java.util.*;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="Users")
public class User {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "LastCheckIn")
	private Date lastCheckIn;
	
	@Column(name = "UserName")
	private String userName;
	
	@Column(name = "PassWord")
	private String passWord;
	
	@OneToMany(mappedBy = "user")
    private List<Order> orders;

}
