package org.dam2.relacionesJPA.modelo;

import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
public class Modulo {
	@Id
	@EqualsAndHashCode.Include
	private String id;
	private String nombre;
	@OneToOne
	private Profesor profesor;
	@Singular
	@OneToMany (fetch = FetchType.EAGER)
	private Map<Alumno, Integer> alumnos;
}
