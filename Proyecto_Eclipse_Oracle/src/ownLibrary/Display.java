package ownLibrary;

public class Display {

//	ARRAYS
	/**
	 * Print an array with that separator
	 * @param array Array to print
	 * @param separator Separator to use among slots
	 */
	public static void arraySeparator(int[] array, String separator) {
		for (int i = 0; i < array.length; i++) {
			if (i==0) {
				System.out.print(array[i]);
			} else if (i == array.length-1) {
				System.out.println(separator + array[i]);
			}else {
				System.out.print(separator + array[i]);
			}
		}
	}
	
	/**
	 * Print an array in table format.
	 * @param array The array to display
	 * @param close Set true if you want to add and ending table bar. Set true always in normal use.
	 * @param alignLeft	True if you want to align left, false if you want to do it to the right.
	 */
	public static void arrayOfIntsTable(int[] array, boolean alignLeft) {
//		Longest number format
		int longestFormat = 1;
		int contentLength;
//		Get the longest number in the array
		for (int i = 0; i < array.length; i++) {
			contentLength = Integer.toString(array[i]).length();
			if (contentLength > longestFormat) {
				longestFormat = contentLength;
			}
		}
//		Call to the real method to simplify it.
		arrayOfIntsTableForMatrix(array, true, alignLeft, longestFormat);
	}
	
	/**
	 * Reserved method for matrix. Its the same than arrayOfIntsTable, but have variables to
	 * interact with. This make easier to modify and adapt to matrix behaviour.
	 * @param array
	 * @param close
	 * @param alignLeft
	 * @param maxLongestFormat
	 */
	private static void arrayOfIntsTableForMatrix(int[] array, boolean close, 
			boolean alignLeft, int maxLongestFormat) {
//		Basic format
		String topSeparator = "-";
		String bottomSeparator = "-";
		String separator = "|";
//		Content display setup
		String top = "";
		String content = separator;
		String bottom = "";
//		Separators in the inner table
		String innerFitSpace = "";
//		Where am I in the array (To matrix format)
		String iniBar = " ";
		String endBar = " ";
		

				
//		Create the table content
		for (int i = 0; i < array.length; i++) {
//		Fill the top with the proper appearance
//			If am in the beginning
			if (i == 0) {
				top += iniBar;
			} else {
				top += " ";
			}
//			If am in the end
			for (int j = 0; j < maxLongestFormat+2; j++) {
				top += topSeparator;
				bottom += bottomSeparator;
			}
			
//			Fill with the ending format top/bottom print
			if (i == array.length-1) {
				top += endBar;
			}
//		Fill the content with the array info plus display
//			If the number to show is smaller that the current maximum grid size,
//			fill it with the enough spaces.
			innerFitSpace = "";
			if (Integer.toString(array[i]).length() < maxLongestFormat) {
				for (int j = Integer.toString(array[i]).length(); j < maxLongestFormat; j++) {
					innerFitSpace += " ";
				}
			}
//			Display the grid size
			if (alignLeft) {
				content += " " + array[i] + innerFitSpace + " " + separator;
			} else {
				content += " " + innerFitSpace + array[i] + " " + separator;
			}
		}
		
//		Set bottom like top
		bottom = top;
		
//		Print the table format, and close it if true
		System.out.println(top);
		System.out.println(content);
		if (close == true) {
			System.out.println(bottom);
		}
	}
	
//	ARRAYS OF ARRAYS / MATRIX
	/**
	 * Print a table format matrix
	 * @param matrix Matrix to display (array of arrays)
	 * @param alignLeft True to align left, false to right.
	 */
	public static void matrixOfIntsTable(int[][] matrix, boolean alignLeft) {
		boolean close = false;
		int maxLongestFormat = 1;
//		Go through matrix and get the maxLongestFormat
		for (int i = 0; i < matrix.length; i++) {
//			Get the maximum length format in the matrix
			for (int j = 0; j < matrix[i].length; j++) {
				if (Integer.toString(matrix[i][j]).length() > maxLongestFormat) {
					maxLongestFormat = Integer.toString(matrix[i][j]).length();
				}
			}
		}

//		Print the array in the table
		for (int j = 0; j < matrix.length; j++) {
//			Set the last bar format if last index
			if (j == matrix.length-1) {
				close = true;
			}
//			Print each array
			arrayOfIntsTableForMatrix(matrix[j], close, alignLeft, maxLongestFormat);
		}
		
	}
	
}
