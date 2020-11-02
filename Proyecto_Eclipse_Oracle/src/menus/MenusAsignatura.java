package menus;

import database.InsertFunctions;
import ownLibrary.Introduce;
import pojos.Asignatura;
import pojos.enums.TipoAsignatura;

/**
 * Clase que contene los menus interactivos relacionados con Asignatura.
 * 
 * @author Jose Manuel Gomez Martinez
 * @since 02/11/2020
 */
public class MenusAsignatura {

	public static void aniadirNuevaAsignatura() {
		Asignatura asignatura = new Asignatura();

		// Se piden los datos
		System.out.println("Introduzca el codigo de la asignatura:");
		asignatura.setCod_asig(Introduce.valueInt(9999, 1000));
		System.out.println("Introduzca el nombre de la asignatura:");
		asignatura.setNombre(Introduce.stringRange(80, 2));
		asignatura.setTipo(introducirTipoAsignatura());
		
		// Se insertan en la base de datos
		if (InsertFunctions.createAsignatura(asignatura)) {
			System.out.println("Asignatura añadida con exito.");
		} else {
			System.out.println("No se pudo añadir la asignatura a la base de datos.");
		}
	}

	/**
	 * Menu interactivo para introducir el tipo de asignatura.
	 * @return TipoAsignatura seleccionado.
	 */
	private static TipoAsignatura introducirTipoAsignatura() {
		TipoAsignatura tipo;
		
		System.out.println("Introduzca el tipo de la asignatura:");
		System.out.println("1- Optativa");
		System.out.println("2.- Obligatoria");
		System.out.println("3.- Libre Configuracion");
		switch (Introduce.valueInt(3, 1)) {
		case 1:
			tipo = TipoAsignatura.OPTATIVA;
			break;
		case 2:
			tipo = TipoAsignatura.OBLIGATORIA;
			break;
		default:
			tipo =TipoAsignatura.LIBRE_CONFIGURACION;
			break;
		}
		
		return tipo;
	}
}
