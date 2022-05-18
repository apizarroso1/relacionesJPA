package org.dam2.relacionesJPA.modelo;

import java.util.HashSet;
import java.util.Set;

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
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Grupo {
	@Id
	@EqualsAndHashCode.Include
	private String nombre;
	private String ubicacion;
	@OneToOne
	private Profesor tutor;
	@Singular
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name = "idGrupo")
	private Set<Alumno> alumnos;
	
	public void addAlumno(Alumno a) {
		if (alumnos ==  null) {
			alumnos = new HashSet<>();
		}
		alumnos.add(a);
	}
}
