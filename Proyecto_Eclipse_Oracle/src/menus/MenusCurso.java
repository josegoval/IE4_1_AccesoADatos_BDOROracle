package menus;

import database.DeleteFunctions;
import database.GetProcedures;
import database.InsertFunctions;
import database.UpdateFunctions;
import ownLibrary.Introduce;
import pojos.Curso;
import pojos.enums.Turno;

/**
 * Clase que contene los menus interactivos relacionados con Curso.
 * 
 * @author Jose Manuel Gomez Martinez
 * @since 02/11/2020
 */
public class MenusCurso {

	/**
	 * Menu interactivo y guiado para añadir un nuevo curso a la base de datos.
	 */
	public static void aniadirNuevoCurso() {
		Curso curso = new Curso();
		// Se piden los datos
		System.out.println("Introduzca el id del curso:");
		curso.setId_curso(Introduce.valueInt(9999, 1000));
		System.out.println("Introduzca la descripcion del curso:");
		curso.setDescripcion(Introduce.stringRange(60, 2));
		System.out.println("Introduzca el nivel del curso:");
		curso.setNivel(Introduce.stringRange(3, 1));
		curso.setTurno(introducirTurno());
		// Se inserta
		if (InsertFunctions.createCurso(curso)) {
			System.out.println("Curso añadido con exito.");
		} else {
			System.out.println("No se pudo añadir el curso.");
		}
	}

	/**
	 * Menu interctivo y guiado para modificar una asignatura.
	 */
	public static void modificarCurso() {
		Curso curso = getCurso();

		if (curso == null) {
			System.out.println("El curso no existe o hubo algun error.");
		} else {
			System.out.println("¿Desea cambiar la descripcion?");
			if (MenusBasicos.introducirSiNo()) {
				System.out.println("Introduzca la nueva descripcion");
				curso.setDescripcion(Introduce.stringRange(60, 2));
			}
			System.out.println("¿Desea cambiar el nivel?");
			if (MenusBasicos.introducirSiNo()) {
				System.out.println("Introduzca el nuevo nivel");
				curso.setNivel(Introduce.stringRange(3, 1));
			}
			System.out.println("¿Desea cambiar el turno?");
			if (MenusBasicos.introducirSiNo()) {
				curso.setTurno(introducirTurno());
			}
		}

		// Se actualiza en la base de datos:
		if (UpdateFunctions.updateCurso(curso)) {
			System.out.println("Curso actualizado con exito.");
		} else {
			System.out.println("No se pudo actualizar el curso en la base de datos.");
		}
	}

	/**
	 * Menu interactivo y guiado para elegir un turno.
	 * 
	 * @return Turno escogido.
	 */
	private static Turno introducirTurno() {
		Turno turno;

		System.out.println("Introduzca un turno:");
		System.out.println("1.- D (Diurno)");
		System.out.println("2.- N (Nocturno)");

		switch (Introduce.valueInt(2, 1)) {
		case 1:
			turno = Turno.D;
			break;

		default:
			turno = Turno.N;
			break;
		}

		return turno;
	}

	/**
	 * Metodo interactivo que lee un curso de la base de datos.
	 * 
	 * @return Curso leido, o null si hubo algun error.
	 */
	public static Curso getCurso() {
		Curso curso;

		System.out.println("Introduzca el id del curso:");
		curso = GetProcedures.getCurso(Introduce.valueInt(9999, 1000));

		return curso;
	}

	/**
	 * Menu interctivo y guiado para consultar la informacion de un curso
	 */
	public static void consultarCurso() {
		Curso curso = getCurso();

		if (curso == null) {
			System.out.println("El curso no existe o hubo algun error.");
		} else {
			curso.mostrarDatos();
		}
	}

	/**
	 * Menu interactivo y guiado para eliminar un curso de la base de datos.
	 */
	public static void eliminarCurso() {
		Curso curso = getCurso();

		if (curso == null) {
			System.out.println("El curso no existe o hubo algun error.");
		} else {
			if (DeleteFunctions.deleteCurso(curso)) {
				System.out.println("Curso eliminado con exito.");
			} else {
				System.out.println("No se pudo eliminar el curso.");
				System.out.println("Recuerde que debe eliminar todos los alumnos matriculados en dicho curso antes.");
			}
		}
	}
}
