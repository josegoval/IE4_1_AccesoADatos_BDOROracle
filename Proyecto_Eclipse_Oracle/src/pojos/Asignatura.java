package pojos;

import pojos.enums.TipoAsignatura;
import utiles.validadores;

/**
 * Clase basica Asignatura.
 * 
 * @author Jose Manuel Gomez Martinez
 * @since 01/11/2020
 */
public class Asignatura {
//	PROPIEDADES-ATRIBUTOS
	/**
	 * Codigo de la asignatura (Longitud maxima de 4).
	 */
	private int cod_asig;
	/**
	 * Nombre de la asignatura (Longitud maxima de 80).
	 */
	private String nombre;
	/**
	 * Tipo de asignatura (entre "OPTATIVA", "OBLIGATORIA", "LIBRE CONFIGURACION"
	 */
	private TipoAsignatura tipo;

//	CONSTRUCTORES
	/**
	 * Constructor vacio.
	 */
	public Asignatura() {
	}

	/**
	 * Constructor con todos las propiedades de la clase.
	 * 
	 * @param cod_asig Código de la asignatura.
	 * @param nombre   Nombre de la Asignatura
	 * @param tipo     Tipo de Asignatura ("OPTATIVA", "OBLIGATORIA", "LIBRE
	 *                 CONFIGURACION")
	 */
	public Asignatura(int cod_asig, String nombre, String tipo) {
		this.cod_asig = cod_asig;
		this.nombre = nombre;
		this.tipo = TipoAsignatura.valueOf(tipo);
	}

//	METODOS
	/**
	 * Muestra los datos por consola.
	 */
	public void mostrarDatos() {
		System.out.println("Codigo de asignatura: " + cod_asig);
		System.out.println("Nombre de la asignatura: " + nombre);
		System.out.println("Tipo de asignatura: " + tipo.getTipo());
	}

	/**
	 * Valida si el codigo de la asignatura cumple con las condiciones de la base de
	 * datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarCod_Asig() {
		return validadores.validarNumero(cod_asig, 9999);
	}

	/**
	 * Valida si el nombre cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarNombre() {
		return validadores.validarLongitud(nombre, 80);
	}

	/**
	 * Valida si el tipo cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarTipo() {
		return tipo == TipoAsignatura.OPTATIVA || tipo == TipoAsignatura.OBLIGATORIA
				|| tipo == TipoAsignatura.LIBRE_CONFIGURACION;
	}

//	GETTERS & SETTERS
	public int getCod_asig() {
		return cod_asig;
	}

	public void setCod_asig(int cod_asig) {
		this.cod_asig = cod_asig;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TipoAsignatura getTipo() {
		return tipo;
	}

	public void setTipo(TipoAsignatura tipo) {
		this.tipo = tipo;
	}

}
