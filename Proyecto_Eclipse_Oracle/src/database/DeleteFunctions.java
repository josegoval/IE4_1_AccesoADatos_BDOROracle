package database;

import java.sql.CallableStatement;
import java.sql.SQLException;
import java.sql.Types;

import pojos.Alumno;
import pojos.Asignatura;
import pojos.Curso;

/**
 * Clase dedicada a las funciones de delete de la base de datos.
 * 
 * @author Jose Manuel Gomez Martinez
 * @since 02/11/2020
 */
public class DeleteFunctions {

	/**
	 * Elimina el alumno en la base de datos.
	 * 
	 * @param alumno Alumno a eliminar.
	 * @return true si se realizo con exito, false si hubo algun error.
	 */
	public static boolean deleteAlumno(Alumno alumno) {
		ConexionDB con = new ConexionDB();
		con.establecerConexion();
		CallableStatement cstmt = null;
		// Si se pudo conectar...
		if (con.validarConexion()) {
			try {
				// Se prepara
				cstmt = con.getConexion().prepareCall("{? = call DELETE_ALUMNO(?)}");
				cstmt.registerOutParameter(1, Types.INTEGER);
				cstmt.setString(2, alumno.getDni());
				// Se ejecuta
				cstmt.execute();
				if (cstmt.getInt(1) == 1) {
					return true;
				}
				return false;
			} catch (SQLException e) {
				return false;
			} finally {
				ConexionDB.close(con.getConexion());
				ConexionDB.close(cstmt);
			}
		}

		return false;
	}

	/**
	 * Elimina la asignatura dada del alumno en la base de datos.
	 * 
	 * @param alumno Alumno del que eliminar la asignatura.
	 * @param asignatura Asignatura del alumno a eliminar.
	 * @return true si se realizo con exito, false si hubo algun error.
	 */
	public static boolean deleteAlumnoAsignatura(Alumno alumno, Asignatura asignatura) {
		ConexionDB con = new ConexionDB();
		con.establecerConexion();
		CallableStatement cstmt = null;
		// Si se pudo conectar...
		if (con.validarConexion()) {
			try {
				// Se prepara
				cstmt = con.getConexion().prepareCall("{? = call DELETE_ALUMNO_ASIGNATURA(?,?)}");
				cstmt.registerOutParameter(1, Types.INTEGER);
				cstmt.setString(2, alumno.getDni());
				cstmt.setInt(3, asignatura.getCod_asig());
				// Se ejecuta
				cstmt.execute();
				if (cstmt.getInt(1) == 1) {
					return true;
				}
				return false;
			} catch (SQLException e) {
				return false;
			} finally {
				ConexionDB.close(con.getConexion());
				ConexionDB.close(cstmt);
			}
		}

		return false;
	}

	/**
	 * Elimina la asignatura en la base de datos.
	 * 
	 * @param asignatura Asignatura a eliminar.
	 * @return true si se realizo con exito, false si hubo algun error.
	 */
	public static boolean deleteAsignatura(Asignatura asignatura) {
		ConexionDB con = new ConexionDB();
		con.establecerConexion();
		CallableStatement cstmt = null;
		// Si se pudo conectar...
		if (con.validarConexion()) {
			try {
				// Se prepara
				cstmt = con.getConexion().prepareCall("{? = call DELETE_ASIGNATURA(?)}");
				cstmt.registerOutParameter(1, Types.INTEGER);
				cstmt.setInt(2, asignatura.getCod_asig());
				// Se ejecuta
				cstmt.execute();
				if (cstmt.getInt(1) == 1) {
					return true;
				}
				return false;
			} catch (SQLException e) {
				return false;
			} finally {
				ConexionDB.close(con.getConexion());
				ConexionDB.close(cstmt);
			}
		}

		return false;
	}

	/**
	 * Elimina el curso en la base de datos.
	 * 
	 * @param curso Curso a eliminar.
	 * @return true si se realizo con exito, false si hubo algun error.
	 */
	public static boolean deleteCurso(Curso curso) {
		ConexionDB con = new ConexionDB();
		con.establecerConexion();
		CallableStatement cstmt = null;
		// Si se pudo conectar...
		if (con.validarConexion()) {
			try {
				// Se prepara
				cstmt = con.getConexion().prepareCall("{? = call DELETE_CURSO(?)}");
				cstmt.registerOutParameter(1, Types.INTEGER);
				cstmt.setInt(2, curso.getId_curso());
				// Se ejecuta
				cstmt.execute();
				if (cstmt.getInt(1) == 1) {
					return true;
				}
				return false;
			} catch (SQLException e) {
				return false;
			} finally {
				ConexionDB.close(con.getConexion());
				ConexionDB.close(cstmt);
			}
		}

		return false;
	}
}
