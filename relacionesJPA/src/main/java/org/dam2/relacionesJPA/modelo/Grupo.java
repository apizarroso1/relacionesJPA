package org.dam2.relacionesJPA.modelo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
	@ManyToMany(fetch=FetchType.EAGER)
	private Set<Alumno> alumnos;
}
