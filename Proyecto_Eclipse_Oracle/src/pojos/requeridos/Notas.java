package pojos.requeridos;

import pojos.Asignatura;
import utiles.validadores;

public class Notas {
//	PROPIEDADES-ATRIBUTSO
	private Asignatura asignatura;
	private float nota1ev;
	private float nota2ev;
	private float nota3ev;
	private float notafjun;
	private float notasept;

//	CONSTRUCTORES
	/**
	 * Constructor que inicializa todos los atributos de la clase.
	 * 
	 * @param asignatura
	 * @param nota1ev
	 * @param nota2ev
	 * @param nota3ev
	 * @param notafjun
	 * @param notasept
	 */
	public Notas(Asignatura asignatura, float nota1ev, float nota2ev, float nota3ev, float notafjun, float notasept) {
		this.asignatura = asignatura;
		this.nota1ev = nota1ev;
		this.nota2ev = nota2ev;
		this.nota3ev = nota3ev;
		this.notafjun = notafjun;
		this.notasept = notasept;
	}

//	METODOS
	/**
	 * Muestra los datos por consola.
	 */
	public void mostrarDatos() {
		asignatura.mostrarDatos();
		System.out.println("Nota primera evaluacion: " + nota1ev);
		System.out.println("Nota segunda evaluacion: " + nota2ev);
		System.out.println("Nota tercera evaluacion: " + nota3ev);
		System.out.println("Nota junio: " + notafjun);
		System.out.println("Nota septiembre: " + notasept);
	}

	/**
	 * Valida si la asignatura cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarAsignatura() {
		return asignatura != null;
	}

	/**
	 * Valida si la nota cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarNota1ev() {
		return validadores.validarNota(nota1ev);
	}

	/**
	 * Valida si la nota cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarNota2ev() {
		return validadores.validarNota(nota2ev);
	}

	/**
	 * Valida si la nota cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarNota3ev() {
		return validadores.validarNota(nota3ev);
	}

	/**
	 * Valida si la nota cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarNotafjun() {
		return validadores.validarNota(notafjun);
	}

	/**
	 * Valida si la nota cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarNotasept() {
		return validadores.validarNota(notasept);
	}

//	SETTERS & GETTERS
	public Asignatura getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(Asignatura asignatura) {
		this.asignatura = asignatura;
	}

	public float getNota1ev() {
		return nota1ev;
	}

	public void setNota1ev(float nota1ev) {
		this.nota1ev = nota1ev;
	}

	public float getNota2ev() {
		return nota2ev;
	}

	public void setNota2ev(float nota2ev) {
		this.nota2ev = nota2ev;
	}

	public float getNota3ev() {
		return nota3ev;
	}

	public void setNota3ev(float nota3ev) {
		this.nota3ev = nota3ev;
	}

	public float getNotafjun() {
		return notafjun;
	}

	public void setNotafjun(float notafjun) {
		this.notafjun = notafjun;
	}

	public float getNotasept() {
		return notasept;
	}

	public void setNotasept(float notasept) {
		this.notasept = notasept;
	}

}
