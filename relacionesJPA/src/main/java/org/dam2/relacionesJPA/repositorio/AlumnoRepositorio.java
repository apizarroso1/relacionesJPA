package org.dam2.relacionesJPA.repositorio;

import org.dam2.relacionesJPA.modelo.Alumno;
import org.springframework.data.repository.CrudRepository;

public interface AlumnoRepositorio extends CrudRepository<Alumno, String> {

}
