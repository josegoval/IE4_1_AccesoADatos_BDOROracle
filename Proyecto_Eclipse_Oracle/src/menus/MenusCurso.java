package menus;

import database.InsertFunctions;
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
}
