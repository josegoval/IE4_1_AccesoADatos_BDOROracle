package ownLibrary;

import java.util.Scanner;

public class Introduce {
	
//	INTEGERS
	/**
	 * value take a value between max and min.
	 * If the value introduced is not correct will ask again until
	 * reach a correct number.
	 * @param max Maximum value (int)
	 * @param min Minimum value (int)
	 * @return the correct value
	 * @see #intException()
	 */
	public static int valueInt(int max, int min) {
		int value = 0;
		
		value = intException();
		
		/* Check if the value introduced is within the range, if
		 * not keep repeating it.
		 */
		while (value < min || value > max) {
			System.out.println("Por favor, introduzca un valor entre "
					+ max + " y " + min);
			value = intException();
		}
		
		return value;
	}
	
	/**
	 * Introduce and return an int not less than zero.
	 * If the value introduced is not correct will ask again until
	 * reach a correct number.
	 * @return (int) above or equal 0.
	 * @see #intException()
	 */
	public static int positiveInt() {
		int value;
		
		value = intException();
		/* Check if the value introduced is within the range, if
		 * not keep repeating it.
		 */
		while (value < 0) {
			System.out.println("Por favor, introduzca un valor positivo:");
			value = intException();
		}
		
		return value;
	}
	
//	LONGS
	/**
	 * value take a value between max and min.
	 * If the value introduced is not correct will ask again until
	 * reach a correct number.
	 * @param max Maximum value (long)
	 * @param min Minimum value (long)
	 * @return the correct value
	 * @see #longException()
	 */
	public static long valueLong(long max, long min) {
		long value = 0;
		
		value = longException();
		
		/* Check if the value introduced is within the range, if
		 * not keep repeating it.
		 */
		while (value < min || value > max) {
			System.out.println("Por favor, introduzca un valor entre "
					+ max + " y " + min);
			value = longException();
		}
		
		return value;
	}
	
	/**
	 * Introduce and return an long not less than zero.
	 * If the value introduced is not correct will ask again until
	 * reach a correct number.
	 * @return (long) above or equal 0.
	 * @see #longException()
	 */
	public static long positiveLong() {
		long value;
		
		value = longException();
		/* Check if the value introduced is within the range, if
		 * not keep repeating it.
		 */
		while (value < 0) {
			System.out.println("Por favor, introduzca un valor positivo:");
			value = longException();
		}
		
		return value;
	}
	
//	FLOATS
	/**
	 * Introduce and return a float not less than zero.
	 * If the value introduced is not correct will ask again until
	 * reach a correct number.
	 * @return (float) above or equal 0.
	 * @see #floatException()
	 */
	public static float positiveFloat() {
		float value;
		Scanner input = new Scanner(System.in);
		
		value = floatException();
		/* Check if the value introduced is within the range, if
		 * not keep repeating it.
		 */
		while (value < 0) {
			System.out.println("Por favor, introduzca un valor positivo:");
			value = floatException();
		}
		
		return value;
	}
	
//	DOUBLES
	/**
	 * value take a value between max and min.
	 * If the value introduced is not correct will ask again until
	 * reach a correct number.
	 * @param max Maximum value (double)
	 * @param min Minimum value (double)
	 * @return the correct value
	 * @see #doubleException()
	 */
	public static double valueDouble(double max, double min) {
		double value = 0;
		
		value = doubleException();
		
		/* Check if the value introduced is within the range, if
		 * not keep repeating it.
		 */
		while (value < min || value > max) {
			System.out.println("Por favor, introduzca un valor entre "
					+ max + " y " + min);
			value = doubleException();
		}
		
		return value;
	}
	
	/**
	 * Introduce and return a double not less than zero.
	 * If the value introduced is not correct will ask again until
	 * reach a correct number.
	 * @return (double) above or equal 0.
	 * @see #doubleException()
	 */
	public static double positiveDouble() {
		double value;
		Scanner input = new Scanner(System.in);
		
		value = doubleException();
		/* Check if the value introduced is within the range, if
		 * not keep repeating it.
		 */
		while (value < 0) {
			System.out.println("Por favor, introduzca un valor positivo:");
			value = doubleException();
		}
		
		return value;
	}
	
//	STRINGS
	/**
	 * Ask to user to introduce an String.
	 * @return (String) Introduced text.
	 */
	public static String string() {
		String text = null;
		Scanner input = new Scanner(System.in);
		
		text = input.nextLine();
		
		return text;
	}
	
	/**
	 * Ask to user to introduce an String that is not null or empty.
	 * @return (String) Introduced text.
	 */
	public static String stringNotNull() {
		String text = null;
		Scanner input = new Scanner(System.in);
		
		text = input.nextLine();
		// Control if the text is null
		while (text.equals("") || text.equals(null)) {
			System.out.println("Por favor, introduzca algun texto:");
			text = input.nextLine();
		}
		
		return text;
	}
	
	/**
	 * Ask to user to introduce an String within a range, if the value mismatch, it will
	 * ask again, and so on so forth.
	 * @param max Maximum text size.
	 * @param min Minimum text size
	 * @return (String) Introduced text.
	 */
	public static String stringRange(int max, int min) {
		String text = null;
		Scanner input = new Scanner(System.in);
		
		text = input.nextLine();
		// Control if the text is longer
		while (text.length() > max || text.length() < min) {
			System.out.println("Por favor, introduzca una cadena de texto de "
					+ "longitud minima " + min + " y maxima " + max + ":");
			text = input.nextLine();
		}
		
		return text;
	}
	
//	FORMATS
	/**
	 * Ask to user to introduce an DNI or NIF with the correct format of 8 
	 * numbers and a letter, for example: 12345678P
	 * @return (String) Introduced NIF-DNI
	 */
	public static String nifFormat() {
		String nif; 
		String onlyDigits;
		boolean complete = true;
		do {
			complete = true;
			// Get the correct length first...
			nif = stringRange(9, 9);
			// Analize the format
			// If the last char is a letter...
			if (Character.isLetter(nif.charAt(nif.length()-1))) {
				// Save only the first 8 digits
				onlyDigits = nif.substring(0, nif.length()-1);
				// Try to parse them
				try {
					Long.parseLong(onlyDigits);
				} catch (Exception e) {
					System.err.println("Introduzca un formato de NIF correcto: 8 numeros y 1 letra.");
					complete=false;
				}
			} else {
				System.err.println("Introduzca un formato de NIF correcto: 8 numeros y 1 letra.");
				complete=false;
			}
		} while (complete==false);
		
		return nif;
	}
	
	/**
	 * Ask to user to introduce a SS number with the correct format of 12 Digits.
	 * @return (String) Introduced ssNumber.
	 */
	public static String SSFormat() {
		String ssNumber;
		String part1, part2;
		boolean complete = true;
		
		do {
			complete = true;
			ssNumber = Introduce.stringRange(12, 12);
			part1 = ssNumber.substring(0, 6);
			part2 = ssNumber.substring(6);
			
			try {
				Long.parseLong(part1);
				Long.parseLong(part2);
			} catch (Exception e) {
				System.err.println("Solo se admiten 12 numeros, no valen letras "
						+ "u otros caracteres.");
				complete = false;
			}
		} while (complete==false);
		
		return ssNumber;
	}
	
//	HAY Q BUSCARLO
//	public static String emailAddress() {
//		try {
//			javax.email
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//	}
	
//	TRY AND CATCH EXCEPTIONS
	/**
	 * Ask to user to introduce an int number, if the value mismatch, it will
	 * ask again, and so on so forth.
	 * @return (int) Introduced value.
	 */
	public static int intException() {
		int value = 0;
		boolean loop = false;	//flag to control exception looping
		Scanner input = new Scanner(System.in);
		
		// Control exceptions loop
		do {
			// By default you dont loop
			loop = false;
			try {
				value = Integer.parseInt(input.nextLine());
			} catch (Exception e) {
				System.out.println("Por favor, introduzca solo numeros sin decimales:");
				// Loop true to ask again
				loop = true;
			}
		} while (loop == true);
		
		return value;
	}

	/**
	 * Ask to user to introduce an long number, if the value mismatch, it will
	 * ask again, and so on so forth.
	 * @return (long) Introduced value.
	 */
	public static long longException() {
		long value = 0;
		boolean loop = false;	//flag to control exception looping
		Scanner input = new Scanner(System.in);
		
		// Control exceptions loop
		do {
			// By default you dont loop
			loop = false;
			try {
				value = Long.parseLong(input.nextLine());
			} catch (Exception e) {
				System.out.println("Por favor, introduzca solo numeros sin decimales:");
				// Loop true to ask again
				loop = true;
			}
		} while (loop == true);
		
		return value;
	}
	
	/**
	 * Ask to user to introduce an float number, if the value mismatch, it will
	 * ask again, and so on so forth.
	 * @return (float) Introduced value.
	 */
	public static float floatException() {
		String control = null;
		float value = 0;
		boolean loop = false;		//flag to control exception looping
		boolean comaOrSpace = false;		//flag to find comas and spaces
		Scanner input = new Scanner(System.in);
		
		// Control exceptions loop
		do {
			// By default you dont loop
			loop = false;
			comaOrSpace = false;
			// Find comas and spaces 
			control = input.nextLine();
			for (int i = 0; i < control.length() && comaOrSpace == false; i++) {
				if (control.charAt(i) == ',') {
					// Have found ,
					comaOrSpace = true;
					// Loop true to ask again
					loop = true;
					System.out.println("Por favor, introduzca los decimales "
							+ "separados por un punto, por ejemplo: 3.37");
				} else if (control.charAt(i) == ' ') {
					// Have found ,
					comaOrSpace = true;
					// Loop true to ask again
					loop = true;	
					System.out.println("Por favor, no introduzcas espacios");
				} 
			}			
			//Try and catch if didnt find comas or spaces before
			if (comaOrSpace == false) {
				try {
					value = Float.parseFloat(control);
				} catch (Exception e) {
					System.out.println("Por favor, introduzca solo numeros:");
					// Loop true to ask again
					loop = true;
				}
			}
			
		} while (loop == true);
		
		return value;
	}
	
	/**
	 * Ask to user to introduce an double number, if the value mismatch, it will
	 * ask again, and so on so forth.
	 * @return (double) Introduced value.
	 */
	public static double doubleException() {
		String control = null;
		double value = 0;
		boolean loop = false;		//flag to control exception looping
		boolean comaOrSpace = false;		//flag to find comas and spaces
		Scanner input = new Scanner(System.in);
		
		// Control exceptions loop
		do {
			// By default you dont loop
			loop = false;
			comaOrSpace = false;
			// Find comas and spaces 
			control = input.nextLine();
			for (int i = 0; i < control.length() && comaOrSpace == false; i++) {
				if (control.charAt(i) == ',') {
					// Have found ,
					comaOrSpace = true;
					// Loop true to ask again
					loop = true;
					System.out.println("Por favor, introduzca los decimales "
							+ "separados por un punto, por ejemplo: 3.37");
				} else if (control.charAt(i) == ' ') {
					// Have found ,
					comaOrSpace = true;
					// Loop true to ask again
					loop = true;	
					System.out.println("Por favor, no introduzcas espacios");
				} 
			}			
			//Try and catch if didnt find comas or spaces before
			if (comaOrSpace == false) {
				try {
					value = Double.parseDouble(control);
				} catch (Exception e) {
					System.out.println("Por favor, introduzca solo numeros:");
					// Loop true to ask again
					loop = true;
				}
			}
			
		} while (loop == true);
		
		return value;
	}
	
}
