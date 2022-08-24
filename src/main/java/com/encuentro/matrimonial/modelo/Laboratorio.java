package com.encuentro.matrimonial.modelo;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "laboratorio")
public class Laboratorio {

	@Id
	@Column
	private Long id;

	@Column(nullable = false)
	private String nombre;




}
