package com.encuentro.matrimonial.modelo;

import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "paciente")
public class Paciente {

	@Id
	@Column
	private Long id;

	@Column
	private Long id_cedula;

	@Column
	private String tipo_documento;

	@Column
	private String nombre_paciente;

	@Column
	private String apellido_paciente;

	@Column
	private Date fecha_nacimiento;

	@Column
	private int comorbilidades;

	@ManyToOne
	@JoinColumn(name = "id_ocupacion", referencedColumnName = "id", nullable = false)
	private Ocupacion ocupacion;

	@ManyToOne
	@JoinColumn(name = "id_centro_salud", referencedColumnName = "id", nullable = false)
	private CentroSalud centroSalud;

	@ManyToOne
	@JoinColumn(name = "id_etapa", referencedColumnName = "id", nullable = false)
	private Etapa etapa;

	@ManyToOne
	@JoinColumn(name = "id_estado_paciente", referencedColumnName = "id", nullable = false)
	private EstadoPaciente estadoPaciente;

}
