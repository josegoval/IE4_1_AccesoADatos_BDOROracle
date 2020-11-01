package pojos.requeridos;

import utiles.validadores;

/**
 * Clase requerida por Alumno, Direccion.
 * 
 * @author Jose Manuel Gomez Martinez
 * @since 01/11/2020
 */
public class Direccion {
//	PROPIEDADES-ATRIBUTOS
	private String direccion;
	private String poblacion;
	private int codpostal;
	private String provincia;

//	CONSTRUCTORES
	/**
	 * Constructor que inicializa todos los atributos de la clase.
	 * @param direccion
	 * @param poblacion
	 * @param codpostal
	 * @param provincia
	 */
	public Direccion(String direccion, String poblacion, int codpostal, String provincia) {
		this.direccion = direccion;
		this.poblacion = poblacion;
		this.codpostal = codpostal;
		this.provincia = provincia;
	}

//	METODOS
	/**
	 * Valida si la direccion cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarDireccion() {
		return validadores.validarLongitud(this.direccion, 50);
	}

	/**
	 * Valida si la poblacion cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarPoblacion() {
		return validadores.validarLongitud(this.poblacion, 50);
	}

	/**
	 * Valida si el codigo postal cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarCodPostal() {
		return validadores.validarNumero(codpostal, 99999);
	}

	/**
	 * Valida si la provincia cumple con las condiciones de la base de datos.
	 * 
	 * @return true si las cumple, false si no.
	 */
	public boolean validarProvincia() {
		return validadores.validarLongitud(provincia, 40);
	}

//	GETTERS & SETTERS
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public int getCodpostal() {
		return codpostal;
	}

	public void setCodpostal(int codpostal) {
		this.codpostal = codpostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

}
