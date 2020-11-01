package pojos.enums;

/**
 * Enum de tipo de Turnos disponibles.
 * 
 * @author Jose Manuel Gomez Martinez
 * @since 01/11/2020
 */
public enum Turno {
	D('D'), N('N');

	private char turno;

	/**
	 * Constructor del Enum.
	 * 
	 * @param turno
	 */
	private Turno(char turno) {
		this.turno = turno;
	}

	public char getTurno() {
		return this.turno;
	}
}
