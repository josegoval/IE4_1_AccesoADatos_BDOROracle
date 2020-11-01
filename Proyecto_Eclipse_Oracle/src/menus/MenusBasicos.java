package menus;

import database.ConexionDB;
import ownLibrary.Introduce;

/**
 * Clase que contiene los menus mas esenciales de la aplicacion.
 * 
 * @author Jose Manuel Gomez Martinez
 * @since 01/11/2020
 */
public class MenusBasicos {

	/**
	 * Menu de inicio de la aplicacion.
	 */
	public static void iniciar() {
		System.out.println("Bienvenido al programa.");
		System.out.println("Estableciendo conexión con la base de datos...");

		// Si no puede conectarse...
		if (!conectarDB()) {
			System.out.println("Cerrando el programa.");
			return;
		}

		// Si puede conectarse
		System.out.println("¿Qué desea hacer?");
	}

	/**
	 * Muestra las opciones y pide al usuario introducir una valida.
	 * 
	 * @return Opcion elegida.
	 */
	public static int opciones() {
		System.out.println("1.- Añadir un nuevo alumno.");
		System.out.println("2.- Añadir notas a un alumno.");
		System.out.println("3.- Añadir un nueva asignatura.");
		System.out.println("4.- Añadir un nuevo curso.");
		System.out.println("5.- Modificar un alumno.");
		System.out.println("6.- Modificar una asignatura.");
		System.out.println("7.- Modificar un curso.");
		System.out.println("8.- Consultar un alumno.");
		System.out.println("9.- Consultar una asignatura.");
		System.out.println("10.- Consultar un curso.");
		System.out.println("11.- Eliminar un alumno.");
		System.out.println("12.- Eliminar una asignatura.");
		System.out.println("13.- Eliminar un curso.");

		return Introduce.valueInt(13, 1);
	}

	/**
	 * Menu interactivo para introducir si o no.
	 * 
	 * @return Si = true, no = false;
	 */
	public static boolean introducirSiNo() {
		String opcion;

		do {
			System.out.println("¿Sí o no? (S/N)");
			opcion = Introduce.stringRange(1, 1);
		} while (!opcion.equalsIgnoreCase("y") && !opcion.equalsIgnoreCase("n"));

		return opcion.equalsIgnoreCase("y");
	}

	/**
	 * Menu referente a la conexion con la base de datos.
	 * 
	 * @return true conectado con exito, false, no se pudo contectar.
	 */
	public static boolean conectarDB() {
		// conectar con la base de datos
		ConexionDB baseDeDatos = new ConexionDB();
		baseDeDatos.establecerConexion();

		if (baseDeDatos.getConexion() != null) {
			System.out.println("Conexión establecida.");
			ConexionDB.close(baseDeDatos.getConexion());
			return true;
		}

		System.out.println("Error al conectar con la base de datos.");
		return false;
	}
}
