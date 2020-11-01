package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionDB {

	private Connection conexion;

//	CONSTRUCTORES
	/**
	 * Constructor vacio que inicializa la conexion a null.
	 */
	public ConexionDB() {
		conexion = null;
	}

//	METODOS
	/**
	 * Establece la conexion con la base de datos.
	 */
	public void establecerConexion() {
		// solucion al error
		// https://stackoverflow.com/questions/18192521/ora-12505-tnslistener-does-not-currently-know-of-sid-given-in-connect-descript
		try {
			// Se carga el driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XE", "hr", "hr");
		} catch (Exception e) {
//			e.printStackTrace();
			conexion = null;
		}
	}

	/**
	 * Cierra la conexion introducida.
	 * 
	 * @param con Conexion a cerrar.
	 */
	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	/**
	 * Valida la conexion y muestra un mensaje informando de si hubo un error.
	 * @return false si no se pudo conectar, true si se pudo conectar.
	 */
	public boolean validarConexion() {
		if (conexion == null) {
			System.out.println("Error al conectar con la  base de datos, no se pudo realizar la tarea.");
			return false;
		} else {
			return true;
		}
	}
	
//	GETTERS & SETTERS
	public Connection getConexion() {
		return conexion;
	}
}
