package org.dam2.relacionesJPA.modelo;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

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
	@OneToOne (cascade = CascadeType.ALL)
	private Direccion direccion;
//	@Singular
//	@OneToMany (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name = "idAlumno")
//	private Set<Calificacion> calificaciones;
//	
//	public void addCalificacion(Calificacion cal) {
//		if (calificaciones == null) {
//			calificaciones = new HashSet<>();
//		}
//		calificaciones.add(cal);
//	}
}
