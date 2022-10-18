package com.app.entity;

import java.time.LocalDate;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="Users")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(name = "LastCheckIn")
	private LocalDate Last_CheckIn;
	
	@Column(name = "UserName")
	private String UserName;
	
	@Column(name = "PassWord")
	private String PassWord;

}
