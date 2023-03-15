package com.app.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="Admins")
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends User {
	
	@Column(name = "FullName")
	private String fullName;
}
