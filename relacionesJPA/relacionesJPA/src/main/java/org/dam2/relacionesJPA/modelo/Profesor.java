package org.dam2.relacionesJPA.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

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
public class Profesor {
	@Id
	@EqualsAndHashCode.Include
	private String dni;
	private String nombre;
	private String especialidad;
}
