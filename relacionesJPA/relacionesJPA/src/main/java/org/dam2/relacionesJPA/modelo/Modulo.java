package org.dam2.relacionesJPA.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Singular;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Modulo {
	@Id
	@EqualsAndHashCode.Include
	private String id;
	private String nombre;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idModulo")
	private Profesor profesor;
//	@OneToMany
//	@JoinColumn(name = "idModulo")
//	@Singular
//	private Set<Calificacion> calificaciones;
//	
//	
//	public void addCalificacion(Calificacion cal) {
//		if (calificaciones == null) {
//			calificaciones = new HashSet<>();
//		}
//		calificaciones.add(cal);
//	}
}
