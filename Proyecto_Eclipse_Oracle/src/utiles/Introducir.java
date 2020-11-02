package utiles;

import java.time.LocalDate;

import ownLibrary.Introduce;

/**
 * Clase dedicada a metodos utiles para introducir datos.
 * 
 * @author Jose Manuel Gomez Martinez
 * @since 02/11/2020
 */
public class Introducir {

	/**
	 * Pide al usuario introducir por consola una fecha del formato LocalDate.
	 * 
	 * @return LocalDate introducida.
	 */
	public static LocalDate introducirLocalDate() {
		int anio, mes, dia;
		LocalDate fecha = null;
		boolean repetir = true;

		while (repetir) {
			System.out.println("Introduzca el año:");
			// Año variable entre el actual y 1970
			anio = Introduce.valueInt(LocalDate.now().getYear(), 1970);
			System.out.println("Introduzca el mes:");
			mes = Introduce.valueInt(12, 1);
			System.out.println("Introduzca el dia:");
			dia = Introduce.valueInt(31, 1);

			try {
				fecha = LocalDate.of(anio, mes, dia);
				repetir = false;
			} catch (Exception e) {
				System.out.println("Fecha no valida. Por favor, introduzca otra:");
			}
		}

		return fecha;
	}

}
