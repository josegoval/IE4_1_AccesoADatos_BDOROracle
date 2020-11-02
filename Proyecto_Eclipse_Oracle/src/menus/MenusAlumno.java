package menus;

import java.time.LocalDate;

import database.InsertFunctions;
import ownLibrary.Introduce;
import pojos.Alumno;
import pojos.Curso;
import pojos.enums.Turno;
import pojos.requeridos.Direccion;
import utiles.Introducir;

/**
 * Clase que contene los menus interactivos relacionados con Alumno.
 * 
 * @author Jose Manuel Gomez Martinez
 * @since 02/11/2020
 */
public class MenusAlumno {

	/**
	 * Menu interactivo y guiado para introducir un alumno en la base de datos.
	 */
	public static void aniadirUnNuevoAlumno() {
		String dni, nombre, direccion, poblacion, provincia, telefono1, telefono2;
		int codpostal, id_curso;
		LocalDate fecha_nac;
		// Se introducen los datos:
		System.out.println("Introduzca el DNI del alumno:");
		dni = Introduce.stringRange(10, 8);
		System.out.println("Introduzca el nombre del alumno:");
		nombre = Introduce.stringRange(50, 2);
		System.out.println("Introduzca la direccion del alumno:");
		direccion = Introduce.stringRange(50, 2);
		System.out.println("Introduzca la poblacion del alumno:");
		poblacion = Introduce.stringRange(50, 2);
		System.out.println("Introduzca el codigo postal del alumno:");
		codpostal = Introduce.valueInt(99999, 10000);
		System.out.println("Introduzca la provincia del alumno:");
		provincia = Introduce.stringRange(40, 2);
		System.out.println("Introduzca el primer telefono del alumno:");
		telefono1 = Introduce.stringRange(15, 6);
		System.out.println("Introduzca el segundo telefono del alumno:");
		telefono2 = Introduce.stringRange(15, 6);
		System.out.println("Introduzca la fecha de nacimiento del alumno:");
		fecha_nac = Introducir.introducirLocalDate();
		System.out.println(
				"Introduzca el id del curso\n(Asegúrese de que exista el curso antes de añadirlo o podria dar error).");
		id_curso = Introduce.valueInt(9999, 1000);
		Alumno alumno = new Alumno(dni, nombre, new Direccion(direccion, poblacion, codpostal, provincia),
				new String[] { telefono1, telefono2 }, fecha_nac, new Curso(id_curso, "Sin Descripcion", "niv", Turno.D.getTurno()));
		
		// Se inserta en la base de datos:
		if (InsertFunctions.createAlumno(alumno)) {
			System.out.println("Alumno añadido con exito.");
		} else {
			System.out.println("No se pudo añadir el Alumno a la base de datos.");
		};
	}

	/**
	 * Menu interactivo y guiado para matricular un alumno en una asignatura.
	 */
	public static void matricularAsignaturaAlumno() {
		String dni;
		int cod_asig;
		// Se recogen los datos:
		System.out.println("Introduzca el dni del Alumno\n(Asegúrese de que exista el alumno antes de añadirlo o podria dar error)");
		dni = Introduce.stringRange(10, 8);
		System.out.println("Introduzca el codigo de la Asignatura\n(Asegúrese de que exista la asignatura antes de añadirla o podria dar error)");
		cod_asig = Introduce.valueInt(9999, 1000);
		
		// Se introducen en la base de datos.
		if (InsertFunctions.matricularAsignatura(dni, cod_asig)) {
			System.out.println("Alumno matriculado con exito.");
		} else {
			System.out.println("No se pudo matricular al alumno.");
		}
	}
	
}
