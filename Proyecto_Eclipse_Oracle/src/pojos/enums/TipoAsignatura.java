package pojos.enums;

/**
 * Enum de tipo de Asignaturas disponibles.
 * 
 * @author Jose Manuel Gomez Martinez
 * @since 01/11/2020
 */
public enum TipoAsignatura {
	OPTATIVA("OPTATIVA"), OBLIGATORIA("OBLIGATORIA"), LIBRE_CONFIGURACION("LIBRE CONFIGURACION");

	private String tipo;

	/**
	 * Constructor del Enum
	 * 
	 * @param tipo
	 */
	private TipoAsignatura(String tipo) {
		this.tipo = tipo;
	}

	public String getTipo() {
		return this.tipo;
	}
}
