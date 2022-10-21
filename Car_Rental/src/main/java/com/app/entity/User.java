package com.app.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "LastCheckIn")
	private Date Last_CheckIn;
	
	@Column(name = "UserName")
	private String UserName;
	
	@Column(name = "PassWord")
	private String PassWord;
	
	@ManyToOne
    @JoinColumn(name="role_id", nullable=false)
    private Role role;
	
	@OneToMany(mappedBy = "user")
    private Set<Order> orders;

}
