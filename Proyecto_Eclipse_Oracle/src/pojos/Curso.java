package pojos;

import pojos.enums.Turno;
import utiles.validadores;

/**
 * Clase basica Curso.
 * 
 * @author Jose Manuel Gomez Martinez
 * @since 01/11/2020
 */
public class Curso {
//	PROPIEDADES-ATRIBUTOS
	private int id_curso;
	private String descripcion;
	private String nivel;
	private Turno turno;

//	CONSTRUCTORES
	/**
	 * Constructor vacio;
	 */
	public Curso() {
	}

	/**
	 * Constructor que inicializa todos los atributos de la clase.
	 * 
	 * @param id_curso
	 * @param descripcion
	 * @param nivel
	 * @param turno
	 */
	public Curso(int id_curso, String descripcion, String nivel, char turno) {
		this.id_curso = id_curso;
		this.descripcion = descripcion;
		this.nivel = nivel;
		this.turno = Turno.valueOf(Character.toString(turno));
	}

//	METODOS
	/**
	 * Valida si el curso cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarId_Curso() {
		return validadores.validarNumero(id_curso, 9999);
	}

	/**
	 * Valida si la descripcion cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarDescripcion() {
		return validadores.validarLongitud(descripcion, 60);
	}

	/**
	 * Valida si el nivel cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarNivel() {
		return validadores.validarLongitud(nivel, 3);
	}

	/**
	 * Valida si el turno cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarTurno() {
		return turno == Turno.D || turno == Turno.N;
	}

//	GETTERS & SETTERS
	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

}
