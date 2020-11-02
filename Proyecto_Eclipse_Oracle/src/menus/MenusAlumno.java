package menus;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicInteger;

import database.GetProcedures;
import database.InsertFunctions;
import database.UpdateFunctions;
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
				new String[] { telefono1, telefono2 }, fecha_nac,
				new Curso(id_curso, "Sin Descripcion", "niv", Turno.D.getTurno()));

		// Se inserta en la base de datos:
		if (InsertFunctions.createAlumno(alumno)) {
			System.out.println("Alumno añadido con exito.");
		} else {
			System.out.println("No se pudo añadir el Alumno a la base de datos.");
		}
		;
	}

	/**
	 * Menu interactivo y guiado para matricular un alumno en una asignatura.
	 */
	public static void matricularAsignaturaAlumno() {
		String dni;
		int cod_asig;
		// Se recogen los datos:
		System.out.println(
				"Introduzca el dni del Alumno\n(Asegúrese de que exista el alumno antes de añadirlo o podria dar error)");
		dni = Introduce.stringRange(10, 8);
		System.out.println(
				"Introduzca el codigo de la Asignatura\n(Asegúrese de que exista la asignatura antes de añadirla o podria dar error)");
		cod_asig = Introduce.valueInt(9999, 1000);

		// Se introducen en la base de datos.
		if (InsertFunctions.matricularAsignatura(dni, cod_asig)) {
			System.out.println("Alumno matriculado con exito.");
		} else {
			System.out.println("No se pudo matricular al alumno.");
		}
	}

	/**
	 * Menu interactivo y guiado para modificar un alumno en la base de datos.
	 */
	public static void modificarDatosAlumno() {
		Alumno alumno = getAlumno();

		if (alumno == null) {
			System.out.println("El alumno no existe o hubo algun error.");
		} else {
			System.out.println("¿Desea cambiar el nombre?");
			if (MenusBasicos.introducirSiNo()) {
				System.out.println("Introduzca el nuevo nombre");
				alumno.setNombre(Introduce.stringRange(50, 2));
			}
			System.out.println("¿Desea cambiar la direccion?");
			if (MenusBasicos.introducirSiNo()) {
				System.out.println("Introduzca la nueva direccion del alumno:");
				alumno.getDireccion().setDireccion(Introduce.stringRange(50, 2));
				System.out.println("Introduzca la nueva poblacion del alumno:");
				alumno.getDireccion().setPoblacion(Introduce.stringRange(50, 2));
				System.out.println("Introduzca el nueva codigo postal del alumno:");
				alumno.getDireccion().setCodpostal(Introduce.valueInt(99999, 10000));
				System.out.println("Introduzca la nueva provincia del alumno:");
				alumno.getDireccion().setProvincia(Introduce.stringRange(40, 2));
			}
			System.out.println("¿Desea cambiar los telefonos?");
			if (MenusBasicos.introducirSiNo()) {
				System.out.println("Introduzca el primer telefono del alumno:");
				alumno.getTelefonos()[0] = Introduce.stringRange(15, 6);
				System.out.println("Introduzca el segundo telefono del alumno:");
				alumno.getTelefonos()[1] = Introduce.stringRange(15, 6);
			}
			System.out.println("¿Desea cambiar la fecha de nacimiento?");
			if (MenusBasicos.introducirSiNo()) {
				System.out.println("Introduzca la fecha de nacimiento del alumno:");
				alumno.setFecha_nac(Introducir.introducirLocalDate());
				;
			}
			System.out.println("¿Desea cambiar el curso?");
			if (MenusBasicos.introducirSiNo()) {
				System.out.println(
						"Introduzca el id del curso\n(Asegúrese de que exista el curso antes de añadirlo o podria dar error).");
				alumno.getCurso().setId_curso(Introduce.valueInt(9999, 1000));
			}
		}

		// Se actualiza en la base de datos:
		if (UpdateFunctions.updateAlumno(alumno)) {
			System.out.println("Alumno actualizado con exito.");
		} else {
			System.out.println("No se pudo actualizar el Alumno en la base de datos.");
		}
	}

	public static void modificarNotasAsignaturaAlumno() {
		AtomicInteger indice = new AtomicInteger(0);
		int elegida;
		Alumno alumno = getAlumno();

		if (alumno == null) {
			System.out.println("El alumno no existe o hubo algun error.");
		} else {
			if (alumno.getNotas().isEmpty()) {
				System.out.println("El alumno no esta matriculado en ninguna asignatura.");
			} else {
				System.out.println("¿Que asignatura desea modificar?");
				alumno.getNotas().forEach(notas -> {
					System.out.println(indice.getAndIncrement() + "- " + notas.getAsignatura().getCod_asig());
				});
				elegida = Introduce.valueInt(alumno.getNotas().size() - 1, 0);
				System.out.println("¿Desea cambiar la nota de la primera evaluacion?");
				if (MenusBasicos.introducirSiNo()) {
					System.out.println("Introduzca la nueva nota");
					alumno.getNotas().get(elegida).setNota1ev((float) Introduce.valueDouble(10, 0));
				}
				System.out.println("¿Desea cambiar la nota de la segunda evaluacion?");
				if (MenusBasicos.introducirSiNo()) {
					System.out.println("Introduzca la nueva nota");
					alumno.getNotas().get(elegida).setNota2ev((float) Introduce.valueDouble(10, 0));
				}
				System.out.println("¿Desea cambiar la nota de la tercera evaluacion?");
				if (MenusBasicos.introducirSiNo()) {
					System.out.println("Introduzca la nueva nota");
					alumno.getNotas().get(elegida).setNota3ev((float) Introduce.valueDouble(10, 0));
				}
				System.out.println("¿Desea cambiar la nota de junio?");
				if (MenusBasicos.introducirSiNo()) {
					System.out.println("Introduzca la nueva nota");
					alumno.getNotas().get(elegida).setNotafjun((float) Introduce.valueDouble(10, 0));
				}
				System.out.println("¿Desea cambiar la nota de septiembre?");
				if (MenusBasicos.introducirSiNo()) {
					System.out.println("Introduzca la nueva nota");
					alumno.getNotas().get(elegida).setNotasept((float) Introduce.valueDouble(10, 0));
				}
			}
			// Se actualiza en la base de datos:
			if (UpdateFunctions.updateNotas(alumno)) {
				System.out.println("Alumno actualizado con exito.");
			} else {
				System.out.println("No se pudo actualizar el Alumno en la base de datos.");
			}
		}
	}

	/**
	 * Metodo interactivo que lee un alumno de la base de datos.
	 * 
	 * @return Alumno leido, o null si hubo algun error.
	 */
	public static Alumno getAlumno() {
		Alumno alumno;

		System.out.println("Introduzca el dni del alumno:");
		alumno = GetProcedures.getAlumno(Introduce.stringRange(10, 8));

		return alumno;
	}
}
