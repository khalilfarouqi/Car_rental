package com.app.entity;

import java.util.Set;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="Roles")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(name = "Name")
	private String Name;
	
	@OneToMany(mappedBy = "role")
    private Set<User> user;
	
}
