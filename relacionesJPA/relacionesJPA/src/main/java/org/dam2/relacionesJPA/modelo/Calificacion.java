package org.dam2.relacionesJPA.modelo;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Calificacion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int calificacion;
	// @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER) // ojo cascade
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idModulo")
	private Modulo modulo;

	// @ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idAlumno")
	private Alumno alumno;
}
