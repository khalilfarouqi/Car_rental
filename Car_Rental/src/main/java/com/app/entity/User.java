package com.app.entity;

import java.util.*;

import javax.persistence.*;

import com.app.entity.enums.Roles;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Users")
@Inheritance(strategy = InheritanceType.JOINED)
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

	@Enumerated(EnumType.STRING)
	@Column(name = "Role")
    private Roles roles;
	
	@OneToMany(mappedBy = "user")
    private List<Order> orders;

}
