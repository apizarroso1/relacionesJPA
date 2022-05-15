package org.dam2.relacionesJPA.modelo;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Alumno {
	@EqualsAndHashCode.Include
	@Id
	@Column(length = 9)
	private String dni;
	@Column(length = 30)
	private String nombre;
	private LocalDate fecha;
	//@OneToOne(cascade = CascadeType.ALL)
	//@JoinColumn(name="idDireccion")
	@OneToOne 
	private Direccion direccion;
}
