package ownLibrary;

public class Generate {
	
//	RANDOM NUMBERS
	/**
	 * Generate a random boolean true or false
	 * @return (boolean) true or false
	 */
	public static boolean randomBoolean() {
		
		int x = (int)(Math.random() * 2);
		
		if (x == 1) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Generate a random int between a range
	 * @param max Max valor
	 * @param min Min valor
	 * @return (int) Random number generated
	 */
	public static int randomInt(int max, int min) {
		return (int)(Math.random() * (max - min + 1) + min);
	}
	
	/**
	 * Generate a random float between a range
	 * @param max Max valor
	 * @param min Min valor
	 * @return (float) Random number generated
	 */
	public static float randomFloat(float max, float min) {
		return (float)(Math.random() * (max - min + 0.000001) + min);
	}
	
	/**
	 * Generate a random double between a range
	 * @param max Max valor
	 * @param min Min valor
	 * @return (double) Random number generated
	 */
	public static double randomDouble(double max, double min) {
		return (double)(Math.random() * (max - min + 0.0000001) + min);
	}
	
//	ARRAYS
	/**
	 * Generate and fill an array of ints with numbers between max and min.
	 * @param arrayLenght Lenght of the array
	 * @param max Maximum random number
	 * @param min Minimum random number
	 * @return int[] The array of int generated
	 */
	public static int[] randomIntArray(int arrayLenght, int max, int min) {
		int[] arr = new int[arrayLenght];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = randomInt(max, min);
		}
		
		return arr;
	}
	
	/**
	 * Generate and fill an array of floats with numbers between max and min.
	 * @param arrayLenght Lenght of the array
	 * @param max Maximum random number
	 * @param min Minimum random number
	 * @return float[] The array of float generated
	 */
	public static float[] randomFloatArray(int arrayLenght, float max, float min) {
		float[] arr = new float[arrayLenght];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = randomFloat(max, min);
		}
		
		return arr;
	}
	
	/**
	 * Generate and fill an array of doubles with numbers between max and min.
	 * @param arrayLenght Lenght of the array
	 * @param max Maximum random number
	 * @param min Minimum random number
	 * @return double[] The array of double generated
	 */
	public static double[] randomDoubleArray(int arrayLenght, double max, double min) {
		double[] arr = new double[arrayLenght];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = randomDouble(max, min);
		}
		
		return arr;
	}
	
	
//	ARRAYS OF ARRAYS / MATRIX
	/**
	 * Generate and fill an array of arrays with numbers between max and min. 
	 * @param matrixLenght Matrix lenght (number of arrays)
	 * @param arrayLenght Arrays lenght (Size of those arrays)
	 * @param max Maximum random number
	 * @param min Minimum random number
	 * @return int[][] matrix (array of arrays) generated
	 */
	public static int[][] randomIntMatrix(int matrixLenght, int arrayLenght, 
			int max, int min) {
//		Create an array of arrays
		int[][] matrix = new int[matrixLenght][arrayLenght];
//		Fill that array with random int arrays
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = randomIntArray(arrayLenght, max, min);
		}
//		Return that array
		return matrix;
	}
	
	/**
	 * Generate and fill an array of arrays with numbers between max and min. 
	 * @param matrixLenght Matrix lenght (number of arrays)
	 * @param arrayLenght Arrays lenght (Size of those arrays)
	 * @param max Maximum random number
	 * @param min Minimum random number
	 * @return float[][] matrix (array of arrays) generated
	 */
	public static float[][] randomFloatMatrix(int matrixLenght, int arrayLenght, 
			int max, int min) {
//		Create an array of arrays
		float[][] matrix = new float[matrixLenght][arrayLenght];
//		Fill that array with random int arrays
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = randomFloatArray(arrayLenght, max, min);
		}
//		Return that array
		return matrix;
	}
	
	/**
	 * Generate and fill an array of arrays with numbers between max and min. 
	 * @param matrixLenght Matrix lenght (number of arrays)
	 * @param arrayLenght Arrays lenght (Size of those arrays)
	 * @param max Maximum random number
	 * @param min Minimum random number
	 * @return double[][] matrix (array of arrays) generated
	 */
	public static double[][] randomDoubleMatrix(int matrixLenght, int arrayLenght, 
			int max, int min) {
//		Create an array of arrays
		double[][] matrix = new double[matrixLenght][arrayLenght];
//		Fill that array with random int arrays
		for (int i = 0; i < matrix.length; i++) {
			matrix[i] = randomDoubleArray(arrayLenght, max, min);
		}
//		Return that array
		return matrix;
	}
	
	
//	SAME FOR FLOAT AND DOUBLES
}
