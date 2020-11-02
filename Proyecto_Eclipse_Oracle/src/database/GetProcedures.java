package database;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import oracle.jdbc.OracleTypes;
import pojos.Alumno;
import pojos.Asignatura;
import pojos.Curso;
import pojos.enums.TipoAsignatura;
import pojos.enums.Turno;
import pojos.requeridos.Direccion;
import pojos.requeridos.Notas;

/**
 * Clase dedicadas a los procedimientos get de la base de datos.
 * 
 * @author Jose Manuel Gomez Martinez
 * @since 01/11/2020
 */
public class GetProcedures {

//	https://mkyong.com/jdbc/jdbc-callablestatement-stored-procedure-out-parameter-example/

	/**
	 * Recoge los datos del alumno de la base de datos.
	 * 
	 * @param dni Dni del alumno a construir.
	 * @return el objeto alumno si consiguio leerlo, null si hubo algun error.
	 */
	public static Alumno getAlumno(String dni) {
		Alumno alumno = null;
		ConexionDB con = new ConexionDB();
		con.establecerConexion();
		CallableStatement cstmt = null;

		if (con.validarConexion()) {
			try {
				cstmt = con.getConexion().prepareCall("{ CALL GET_ALUMNO(?, ?)}");
				// Registro entradas y salidas
				cstmt.setString(1, dni);
				cstmt.registerOutParameter(2, OracleTypes.CURSOR);
				// Recojo la salida
				ResultSet rs = (ResultSet) cstmt.getObject(2);
				// Construyo el objeto
				while (rs.next()) {
					alumno = new Alumno(null, null, new Direccion(null, null, 0, null), new String[2], null,
							new Curso());
					// Cojo los datos de la tupla
					alumno.setDni(rs.getString(1));
					alumno.setNombre(rs.getString(2));
					alumno.getDireccion().setDireccion(rs.getString(3));
					alumno.getDireccion().setPoblacion(rs.getString(4));
					alumno.getDireccion().setCodpostal(rs.getInt(5));
					alumno.getDireccion().setProvincia(rs.getString(6));
					alumno.getTelefonos()[0] = rs.getString(7);
					alumno.getTelefonos()[1] = rs.getString(8);
					alumno.setFecha_nac(rs.getDate(9).toLocalDate());
					alumno.getCurso().setId_curso(rs.getInt(10));
					alumno.getCurso().setDescripcion(rs.getString(11));
					alumno.getCurso().setNivel(rs.getString(12));
					alumno.getCurso().setTurno(Turno.valueOf(rs.getString(13)));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				alumno = null;
			} finally {
				ConexionDB.close(con.getConexion());
				ConexionDB.close(cstmt);
			}

		}

		return alumno;
	}

	/**
	 * Recoge los datos las notas de un alumno de la base de datos.
	 * 
	 * @param alumno Alumno a añadir las notas.
	 * @return true si se pudieron añadir, false si hubo algun error
	 */
	public static boolean getNotas(Alumno alumno) {
		boolean resultado = false;
		ConexionDB con = new ConexionDB();
		con.establecerConexion();
		CallableStatement cstmt = null;
		
		if (con.validarConexion()) {
			try {
				cstmt = con.getConexion().prepareCall("{ CALL GET_NOTAS_ALUMNO(?, ?)}");
				// Registro entradas y salidas
				cstmt.setString(1, alumno.getDni());
				cstmt.registerOutParameter(2, OracleTypes.CURSOR);
				// Recojo la salida
				ResultSet rs = (ResultSet) cstmt.getObject(2);
				// Construyo el objeto
				while (rs.next()) {
					// Cojo los datos de la tupla
					Notas notas = new Notas(new Asignatura(), -1, -1, -1, -1, -1);
					notas.getAsignatura().setCod_asig(rs.getInt(1));
					notas.getAsignatura().setNombre(rs.getString(2));
					notas.getAsignatura().setTipo(TipoAsignatura.valueOf(rs.getString(3)));
					notas.setNota1ev(rs.getFloat(4));
					notas.setNota2ev(rs.getFloat(5));
					notas.setNota3ev(rs.getFloat(6));
					notas.setNotafjun(rs.getFloat(7));
					notas.setNotasept(rs.getFloat(8));
					// añado las notas al alumno
					alumno.getNotas().add(notas);
				}

				resultado = true;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				resultado = false;
			} finally {
				ConexionDB.close(con.getConexion());
				ConexionDB.close(cstmt);
			}

		}

		return resultado;
	}

	/**
	 * Recoge los datos de la asignatura de la base de datos.
	 * 
	 * @param cod_asig codigo de la asignatura a leer.
	 * @return el objeto asignatura si consiguio leerlo, null si hubo algun error.
	 */
	public static Asignatura getAsignatura(int cod_asig) {
		Asignatura asignatura = null;
		ConexionDB con = new ConexionDB();
		con.establecerConexion();
		CallableStatement cstmt = null;
		
		if (con.validarConexion()) {
			try {
				cstmt = con.getConexion().prepareCall("{ CALL GET_ASIGNATURA(?, ?)}");
				// Registro entradas y salidas
				cstmt.setInt(1, cod_asig);
				cstmt.registerOutParameter(2, OracleTypes.CURSOR);
				// Recojo la salida
				ResultSet rs = (ResultSet) cstmt.getObject(2);
				// Construyo el objeto
				while (rs.next()) {
					asignatura = new Asignatura();
					// Cojo los datos de la tupla
					asignatura.setCod_asig(rs.getInt(1));
					asignatura.setNombre(rs.getString(2));
					asignatura.setTipo(TipoAsignatura.valueOf(rs.getString(3)));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				asignatura = null;
			} finally {
				ConexionDB.close(con.getConexion());
				ConexionDB.close(cstmt);
			}

		}

		return asignatura;
	}

	/**
	 * Recoge los datos del curso de la base de datos.
	 * 
	 * @param id_curso id del curso a leer.
	 * @return el objeto curso si consiguio leerlo, null si hubo algun error.
	 */
	public static Curso getCurso(int id_curso) {
		Curso curso = null;
		ConexionDB con = new ConexionDB();
		con.establecerConexion();
		CallableStatement cstmt = null;

		if (con.validarConexion()) {
			try {
				cstmt = con.getConexion().prepareCall("{ CALL GET_ASIGNATURA(?, ?)}");
				// Registro entradas y salidas
				cstmt.setInt(1, id_curso);
				cstmt.registerOutParameter(2, OracleTypes.CURSOR);
				// Recojo la salida
				ResultSet rs = (ResultSet) cstmt.getObject(2);
				// Construyo el objeto
				while (rs.next()) {
					curso = new Curso();
					// Cojo los datos de la tupla
					curso.setId_curso(rs.getInt(1));
					curso.setDescripcion(rs.getString(2));
					curso.setNivel(rs.getString(3));
					curso.setTurno(Turno.valueOf(rs.getString(4)));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
//				e.printStackTrace();
				curso = null;
			} finally {
				ConexionDB.close(con.getConexion());
				ConexionDB.close(cstmt);
			}

		}

		return curso;
	}
}
