package org.dam2.relacionesJPA;

import java.time.LocalDate;
import java.util.HashSet;

import org.dam2.relacionesJPA.modelo.Alumno;
import org.dam2.relacionesJPA.modelo.Calificacion;
import org.dam2.relacionesJPA.modelo.Direccion;
import org.dam2.relacionesJPA.modelo.Grupo;
import org.dam2.relacionesJPA.modelo.Modulo;
import org.dam2.relacionesJPA.modelo.Profesor;
import org.dam2.relacionesJPA.repositorio.AlumnoRepositorio;
import org.dam2.relacionesJPA.repositorio.CalificacionRepositorio;
import org.dam2.relacionesJPA.repositorio.GrupoRepositorio;
import org.dam2.relacionesJPA.repositorio.ModuloRepositorio;
import org.dam2.relacionesJPA.repositorio.ProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import daw.com.Teclado;

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
	@Autowired
	private CalificacionRepositorio calificacionDAO;

	@Override
	public void run(String... args) throws Exception {

		load();

		setModules();

		setGroups();

		// setMark();

		// listByGroup();

		deleteAlumno();

	}

	public void deleteAlumno() {
		// Eliminar un alumno.
		Alumno a;
		String aId;

		alumnoDAO.findAll().forEach(System.out::println);

		aId = Teclado.leerString("\nId del alumno a eliminar");

		a = alumnoDAO.findById(aId).get();

		alumnoDAO.delete(a);

		alumnoDAO.findAll().forEach(System.out::println);
	}

	public void listByGroup() {
		// Listar los alumnos de un grupo.
		String gId;

		grupoDAO.findAll().forEach((g) -> System.out.println(g.getNombre()));

		gId = Teclado.leerString("\nId del grupo a listar");

		grupoDAO.findById(gId).get().getAlumnos().stream().forEach(System.out::println);
	}

	public void setMark() {
		// Poner una nota a un alumno en un módulo.
		Calificacion ca1;
		Alumno a;
		Modulo m;
		int mark;

		String aId = Teclado.leerString("\nId del alumno");
		String mId = Teclado.leerString("\nId del modulo");

		a = alumnoDAO.findById(aId).get();
		m = moduloDAO.findById(mId).get();

		mark = Teclado.leerInt("\nNota");

		ca1 = Calificacion.builder().alumno(a).modulo(m).calificacion(mark).build();
		calificacionDAO.save(ca1);
	}

	public void setGroups() {
		// Asociar los alumnos a los grupos.
		Grupo g1, g2;
		Alumno a1, a2, a3, a4, a5;

		g1 = grupoDAO.findById("DAM2").get();
		g2 = grupoDAO.findById("ASIR2").get();

		a1 = alumnoDAO.findById("001").get();
		a2 = alumnoDAO.findById("002").get();
		a3 = alumnoDAO.findById("003").get();
		a4 = alumnoDAO.findById("004").get();
		a5 = alumnoDAO.findById("005").get();

		g1.addAlumno(a1);
		g1.addAlumno(a2);
		g1.addAlumno(a3);
		g2.addAlumno(a4);
		g2.addAlumno(a5);

		grupoDAO.save(g1);
		grupoDAO.save(g2);
	}

	public void setModules() {
		// Adjudicar los módulos a los profesores.
		Modulo m1, m2, m3, m4;
		Profesor p1, p2;

		m1 = moduloDAO.findById("1").get();
		m2 = moduloDAO.findById("2").get();
		m3 = moduloDAO.findById("3").get();
		m4 = moduloDAO.findById("4").get();

		p1 = profesorDAO.findById("001").get();
		p2 = profesorDAO.findById("002").get();

		m1.setProfesor(p1);
		m2.setProfesor(p1);
		m3.setProfesor(p2);
		m4.setProfesor(p2);

		moduloDAO.save(m1);
		moduloDAO.save(m2);
		moduloDAO.save(m3);
		moduloDAO.save(m4);
	}

	public void load() {
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

		m1 = Modulo.builder().id("1").nombre("AD").build();
		m2 = Modulo.builder().id("2").nombre("PSP").build();
		m3 = Modulo.builder().id("3").nombre("DI").build();
		m4 = Modulo.builder().id("4").nombre("SGE").build();

		g1 = Grupo.builder().nombre("DAM2").tutor(p1).ubicacion("Villablanca").build();
		g2 = Grupo.builder().nombre("ASIR2").tutor(p2).ubicacion("Sanchinarro").build();

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

		grupoDAO.save(g1);
		grupoDAO.save(g2);
	}

}
