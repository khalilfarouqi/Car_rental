package com.app.entity;

import javax.persistence.*;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="Admins")
public class Admin extends User {
	
	@Column(name = "FullName")
	private String fullName;
}
