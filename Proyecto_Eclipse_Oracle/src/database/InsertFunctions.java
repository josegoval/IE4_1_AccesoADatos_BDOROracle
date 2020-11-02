package database;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;

import pojos.Alumno;
import pojos.Asignatura;
import pojos.Curso;

/**
 * Clase dedicadas a las funciones de insert de la base de datos.
 * 
 * @author Jose Manuel Gomez Martinez
 * @since 01/11/2020
 */
public class InsertFunctions {

	/**
	 * Inserta el alumno en la base de datos.
	 * 
	 * @param alumno Alumno a insertar.
	 * @return true si se realizo con exito, false si hubo algun error.
	 */
	public static boolean createAlumno(Alumno alumno) {
		boolean resultado = false;
		ConexionDB con = new ConexionDB();
		con.establecerConexion();
		CallableStatement cstmt = null;
		// Si se pudo conectar...
		if (con.validarConexion()) {
			try {
				// Se prepara
				cstmt = con.getConexion()
						.prepareCall("{? = CALL CREATE_ALUMNO(?,?,?,?,?,?,?,?,?,?)}");
				cstmt.registerOutParameter(1, Types.INTEGER);
				cstmt.setString(2, alumno.getDni());
				cstmt.setString(3, alumno.getNombre());
				cstmt.setString(4, alumno.getDireccion().getDireccion());
				cstmt.setString(5, alumno.getDireccion().getPoblacion());
				cstmt.setInt(6, alumno.getDireccion().getCodpostal());
				cstmt.setString(7, alumno.getDireccion().getProvincia());
				cstmt.setString(8, alumno.getTelefonos()[0]);
				cstmt.setString(9, alumno.getTelefonos()[1]);
				cstmt.setDate(10, Date.valueOf(alumno.getFecha_nac()));
				cstmt.setInt(11, alumno.getCurso().getId_curso());
				// Se ejecuta
				cstmt.execute();
				if (cstmt.getInt(1) == 1) {
					resultado = true;
				} else {
					resultado = false;
				}
			} catch (SQLException e) {
				resultado = false;
			} finally {
				ConexionDB.close(con.getConexion());
				ConexionDB.close(cstmt);
			}
		}

		return resultado;
	}

	/**
	 * Matricula al alumno en la asignatura dada, en la base de datos.
	 * 
	 * @param dni      dni del alumno a matricular.
	 * @param cod_asig codigo de la asignatura a matricular.
	 * @return true si se realizo con exito, false si hubo algun error.
	 */
	public static boolean matricularAsignatura(String dni, int cod_asig) {
		boolean resultado = false;
		ConexionDB con = new ConexionDB();
		con.establecerConexion();
		CallableStatement cstmt = null;
		// Si se pudo conectar...
		if (con.validarConexion()) {
			try {
				// Se prepara
				cstmt = con.getConexion().prepareCall("{? = CALL MATRICULAR_ASIGNATURA(?,?)}");
				cstmt.registerOutParameter(1, Types.INTEGER);
				cstmt.setString(2, dni);
				cstmt.setInt(3, cod_asig);
				// Se ejecuta
				cstmt.execute();
				if (cstmt.getInt(1) == 1) {
					resultado = true;
				} else {
					resultado = false;
				}
			} catch (SQLException e) {
				resultado = false;
			} finally {
				ConexionDB.close(con.getConexion());
				ConexionDB.close(cstmt);
			}
		}

		return resultado;
	}

	/**
	 * Crea e inserta la asignatura en la base de datos.
	 * 
	 * @param asignatura Asignatura a registrar.
	 * @return true si se realizo con exito, false si hubo algun error.
	 */
	public static boolean createAsignatura(Asignatura asignatura) {
		boolean resultado = false;
		ConexionDB con = new ConexionDB();
		con.establecerConexion();
		CallableStatement cstmt = null;
		// Si se pudo conectar...
		if (con.validarConexion()) {
			try {
				// Se prepara
				cstmt = con.getConexion().prepareCall("{? = CALL CREATE_ASIGNATURA(?,?,?)}");
				cstmt.registerOutParameter(1, Types.INTEGER);
				cstmt.setInt(2, asignatura.getCod_asig());
				cstmt.setString(3, asignatura.getNombre());
				cstmt.setString(4, asignatura.getTipo().getTipo());
				// Se ejecuta
				cstmt.execute();
				if (cstmt.getInt(1) == 1) {
					resultado = true;
				} else {
					resultado = false;
				}
			} catch (SQLException e) {
				resultado = false;
			} finally {
				ConexionDB.close(con.getConexion());
				ConexionDB.close(cstmt);
			}
		}

		return resultado;
	}

	/**
	 * Crea e inserta el curso en la base de datos.
	 * 
	 * @param curso Curso a registrar.
	 * @return true si se realizo con exito, false si hubo algun error.
	 */
	public static boolean createCurso(Curso curso) {
		boolean resultado = false;
		ConexionDB con = new ConexionDB();
		con.establecerConexion();
		CallableStatement cstmt = null;
		// Si se pudo conectar...
		if (con.validarConexion()) {
			try {
				// Se prepara
				cstmt = con.getConexion().prepareCall("{? = CALL CREATE_CURSO(?,?,?,?)}");
				cstmt.registerOutParameter(1, Types.INTEGER);
				cstmt.setInt(2, curso.getId_curso());
				cstmt.setString(3, curso.getDescripcion());
				cstmt.setString(4, curso.getNivel());
				cstmt.setString(5, Character.toString(curso.getTurno().getTurno()));
				// Se ejecuta
				cstmt.execute();
				if (cstmt.getInt(1) == 1) {
					resultado = true;
				} else {
					resultado = false;
				}
			} catch (SQLException e) {
				resultado = false;
			} finally {
				ConexionDB.close(con.getConexion());
				ConexionDB.close(cstmt);
			}
		}

		return resultado;
	}
}
