package com.app.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.*;

@Entity
@Table(name="Users")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
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
    private List<Order> orders;

}
