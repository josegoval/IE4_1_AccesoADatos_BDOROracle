package database;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Types;
import java.util.concurrent.atomic.AtomicBoolean;

import pojos.Alumno;
import pojos.Asignatura;
import pojos.Curso;

/**
 * Clase dedicada a las funciones de Update de la base de datos.
 * 
 * @author Jose Manuel Gomez Martinez
 * @since 02/11/2020
 */
public class UpdateFunctions {

	/**
	 * Actualiza el alumno en la base de datos.
	 * 
	 * @param alumno Alumno a actualizar.
	 * @return true si se realizo con exito, false si hubo algun error.
	 */
	public static boolean updateAlumno(Alumno alumno) {
		ConexionDB con = new ConexionDB();
		con.establecerConexion();
		CallableStatement cstmt = null;
		// Si se pudo conectar...
		if (con.validarConexion()) {
			try {
				// Se prepara
				cstmt = con.getConexion().prepareCall("{? = call UPDATE_ALUMNO(?,?,?,?,?,?,?,?,?,?)}");
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
					return true;
				}
				return false;
			} catch (SQLException e) {
//				e.printStackTrace();
				return false;
			} finally {
				ConexionDB.close(con.getConexion());
				ConexionDB.close(cstmt);
			}
		}

		return false;
	}

	/**
	 * Actualiza todas las notas del alumno en la base de datos.
	 * 
	 * @param alumno Alumno al que actualizar las notas.
	 * @return true si se realizo con exito, false si hubo algun error.
	 */
	public static boolean updateNotas(Alumno alumno) {
		AtomicBoolean resultado = new AtomicBoolean(false);
		// Recorro todas las notas y las introduzco individualmente.
		alumno.getNotas().stream().forEach(notas -> {
			ConexionDB con = new ConexionDB();
			con.establecerConexion();
			CallableStatement cstmt = null;
			// Si se pudo conectar...
			if (con.validarConexion()) {
				try {
					// Se prepara
					cstmt = con.getConexion().prepareCall("{? = call UPDATE_NOTAS(?,?,?,?,?,?,?)}");
					cstmt.registerOutParameter(1, Types.INTEGER);
					cstmt.setString(2, alumno.getDni());
					cstmt.setInt(3, notas.getAsignatura().getCod_asig());
					cstmt.setFloat(4, notas.getNota1ev());
					cstmt.setFloat(5, notas.getNota2ev());
					cstmt.setFloat(6, notas.getNota3ev());
					cstmt.setFloat(7, notas.getNotafjun());
					cstmt.setFloat(8, notas.getNotasept());
					// Se ejecuta
					cstmt.execute();
					if (cstmt.getInt(1) == 1) {
						resultado.set(true);
					} else {
						resultado.set(false);
					}
				} catch (SQLException e) {
//					e.printStackTrace();
					resultado.set(false);
				} finally {
					ConexionDB.close(con.getConexion());
					ConexionDB.close(cstmt);
				}
			}
		});

		return resultado.get();
	}

	/**
	 * Actualiza la asignatura en la base de datos.
	 * 
	 * @param asignatura Asignatura a actualizar.
	 * @return true si se realizo con exito, false si hubo algun error.
	 */
	public static boolean updateAsignatura(Asignatura asignatura) {
		ConexionDB con = new ConexionDB();
		con.establecerConexion();
		CallableStatement cstmt = null;
		// Si se pudo conectar...
		if (con.validarConexion()) {
			try {
				// Se prepara
				cstmt = con.getConexion().prepareCall("{? = call UPDATE_ASIGNATURA(?,?,?)}");
				cstmt.registerOutParameter(1, Types.INTEGER);
				cstmt.setInt(2, asignatura.getCod_asig());
				cstmt.setString(3, asignatura.getNombre());
				cstmt.setString(4, asignatura.getTipo().getTipo());
				// Se ejecuta
				cstmt.execute();
				if (cstmt.getInt(1) == 1) {
					return true;
				}
				return false;
			} catch (SQLException e) {
//				e.printStackTrace();
				return false;
			} finally {
				ConexionDB.close(con.getConexion());
				ConexionDB.close(cstmt);
			}
		}

		return false;
	}

	/**
	 * Actualiza el curso en la base de datos.
	 * 
	 * @param curso Curso a actualizar.
	 * @return true si se realizo con exito, false si hubo algun error.
	 */
	public static boolean updateCurso(Curso curso) {
		ConexionDB con = new ConexionDB();
		con.establecerConexion();
		CallableStatement cstmt = null;
		// Si se pudo conectar...
		if (con.validarConexion()) {
			try {
				// Se prepara
				cstmt = con.getConexion().prepareCall("{? = call UPDATE_CURSO(?,?,?,?)}");
				cstmt.registerOutParameter(1, Types.INTEGER);
				cstmt.setInt(2, curso.getId_curso());
				cstmt.setString(3, curso.getDescripcion());
				cstmt.setString(4, curso.getNivel());
				cstmt.setString(5, Character.toString(curso.getTurno().getTurno()));
				// Se ejecuta
				cstmt.execute();
				if (cstmt.getInt(1) == 1) {
					return true;
				}
				return false;
			} catch (SQLException e) {
//				e.printStackTrace();
				return false;
			} finally {
				ConexionDB.close(con.getConexion());
				ConexionDB.close(cstmt);
			}
		}

		return false;
	}
}
