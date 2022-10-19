package com.app.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Table(name="Cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Photo {
	
	@Id@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	
	@Column(name = "Photo1")
	private String Photo_1;
	
	@Column(name = "Photo2")
	private String Photo_2;
	
	@Column(name = "Photo3")
	private String Photo_3;
	
	@Column(name = "Photo4")
	private String Photo_4;
	
	@OneToOne(mappedBy = "photo")
    private Car car;

}
