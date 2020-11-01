package utiles;

/**
 * Clase asistente para validar parametros.
 * 
 * @author Jose Manuel Gomez Martinez
 * @since 01/11/2020
 */
public class validadores {
	/**
	 * Comprueba si la cadena esta comprendida entre 0 y la longitud max inclusive.
	 * 
	 * @param cadena Cadena a analizar.
	 * @param max    Valor maximo de longitud incluido.
	 * @return true si cumple con los requisitos, false si no.
	 */
	public static boolean validarLongitud(String cadena, int max) {
		return cadena.length() > 0 && cadena.length() <= max;
	}

	/**
	 * Comprueba si el numero esta comprendido entre 0 y max inclusive.
	 * 
	 * @param numero Numero a analizar.
	 * @param max    Numero maximo.
	 * @return true si cumple con los requisitos, false si no.
	 */
	public static boolean validarNumero(int numero, int max) {
		return numero > 0 && numero <= max;
	}

	/**
	 * Comprueba si la nota esta comprendida entre 0 y 10.
	 * 
	 * @param nota Nota a analizar.
	 * @return true si cumple con los requisitos, false si no.
	 */
	public static boolean validarNota(float nota) {
		return nota >= 0 && nota <= 10;
	}
}
