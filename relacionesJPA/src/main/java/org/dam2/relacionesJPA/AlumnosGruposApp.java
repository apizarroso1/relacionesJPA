package org.dam2.relacionesJPA;

import java.time.LocalDate;

import org.dam2.relacionesJPA.modelo.Alumno;
import org.dam2.relacionesJPA.modelo.Direccion;
import org.dam2.relacionesJPA.modelo.Grupo;
import org.dam2.relacionesJPA.modelo.Modulo;
import org.dam2.relacionesJPA.modelo.Profesor;
import org.dam2.relacionesJPA.repositorio.AlumnoRepositorio;
import org.dam2.relacionesJPA.repositorio.GrupoRepositorio;
import org.dam2.relacionesJPA.repositorio.ModuloRepositorio;
import org.dam2.relacionesJPA.repositorio.ProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AlumnosGruposApp implements CommandLineRunner {

	@Autowired
	private AlumnoRepositorio alumnoDAO;
	@Autowired
	private ModuloRepositorio moduloDAO;
	@Autowired
	private GrupoRepositorio grupoDAO;
	@Autowired
	private ProfesorRepositorio profesorDAO;

	@Override
	public void run(String... args) throws Exception {
		// Realizar una aplicación que inserte 2 profesores, 2 grupos, 5 alumnos, 4
		// módulos. A continuación realizar las siguientes operaciones:

		Profesor p1, p2;
		Grupo g1, g2;
		Alumno a1, a2, a3, a4, a5;
		Modulo m1, m2, m3, m4;

		p1 = Profesor.builder().dni("001").nombre("Miguel Sutil").especialidad("Programacion").build();
		p2 = Profesor.builder().dni("002").nombre("Enrique Candil").especialidad("Gimnasia").build();

		a1 = Alumno.builder().dni("001").nombre("Alex Popo").fecha(LocalDate.of(2001, 7, 21))
				.direccion(Direccion.builder().calle("Villablanca").poblacion("Madrid").portal("8").build()).build();
		a2 = Alumno.builder().dni("002").nombre("Angel Moro").fecha(LocalDate.of(1999, 7, 21))
				.direccion(Direccion.builder().calle("Villanegra").poblacion("Moratalaz").portal("11").build()).build();
		a3 = Alumno.builder().dni("003").nombre("Javier Matutebox").fecha(LocalDate.of(1998, 7, 21))
				.direccion(Direccion.builder().calle("Villablanca").poblacion("San Fernando").portal("1000").build())
				.build();
		a4 = Alumno.builder().dni("004").nombre("Eugenio Castillejos").fecha(LocalDate.of(1950, 7, 21))
				.direccion(Direccion.builder().calle("Velilla de San Antonio").poblacion("Rivas").portal("8").build())
				.build();
		a5 = Alumno.builder().dni("005").nombre("Mario Santos").fecha(LocalDate.of(1970, 7, 21))
				.direccion(Direccion.builder().calle("ASaber").poblacion("Desconocida").portal("11").build()).build();

		// g1 =
		// Grupo.builder().nombre("DAM2").tutor(p1).ubicacion("Villablanca").alumno(a1).alumno(a2).alumno(a3).build();
		// g2 =
		// Grupo.builder().nombre("ASIR2").tutor(p2).ubicacion("Sanchinarro").alumno(a3).alumno(a4).alumno(a5)
		// .build();

//		m1 = Modulo.builder().id("1").nombre("AD").profesor(p1).alumno(a1, 7).alumno(a2, 3).alumno(a3, 5).alumno(a4, 10)
//				.alumno(a5, 8).build();
//		m2 = Modulo.builder().id("2").nombre("PSP").profesor(p1).alumno(a1, 5).alumno(a2, 10).alumno(a3, 7)
//				.alumno(a4, 8).alumno(a5, 8).build();
//		m3 = Modulo.builder().id("3").nombre("DI").profesor(p2).alumno(a1, 8).alumno(a2, 7).alumno(a3, 6).alumno(a4, 10)
//				.alumno(a5, 8).build();
//		m4 = Modulo.builder().id("4").nombre("IDIOMAS").profesor(p2).alumno(a1, 10).alumno(a2, 6).alumno(a3, 10)
//				.alumno(a4, 10).alumno(a5, 8).build();
		
		m1 = Modulo.builder().id("1").nombre("AD").build();
		m2 = Modulo.builder().id("2").nombre("PSP").build();
		m3 = Modulo.builder().id("3").nombre("DI").build();
		m4 = Modulo.builder().id("4").nombre("SGE").build();
	
		moduloDAO.save(m1);
		moduloDAO.save(m2);
		moduloDAO.save(m3);
		moduloDAO.save(m4);

		alumnoDAO.save(a1);
		alumnoDAO.save(a2);
		alumnoDAO.save(a3);
		alumnoDAO.save(a4);
		alumnoDAO.save(a5);
		
		profesorDAO.save(p1);
		profesorDAO.save(p2);
	}

}
