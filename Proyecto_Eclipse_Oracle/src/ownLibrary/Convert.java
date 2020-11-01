package ownLibrary;

import java.util.ArrayList;

public class Convert {
	
//	Arrays conversions
	/**
	 * Convert an int into int[]
	 * @param num int to convert
	 * @return int[] converted
	 */
	public static int[] intToArray(int num) {
		String number = Integer.toString(num);
		int[] arr = new int[number.length()];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = number.charAt(i);
		}
		
		return arr;
	}
	
	/**
	 * Covert an int[] into int
	 * @param arrayOfInts The array of int to covert
	 * @return int converted
	 */
	public static int arrayToInt(int[] arrayOfInts) {
		String arr = arrayOfInts.toString();
		int number = Integer.parseInt(arr);
		return number;
	}
	
	/**
	 * Convert an array of int into an array of Integers
	 * @param arrayOfInts Array to convert
	 * @return Integer[] Array converted
	 */
	public static Integer[] arrayOfIntToInteger(int[] arrayOfInts) {
		Integer[] arr = new Integer[arrayOfInts.length];
		
//		Set those values to the new array
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arrayOfInts[i];
		}
		
		return arr;
	}
	
	/**
	 * Convert an array of Integer into an array of int
	 * @param arrayOfIntegers Array to convert
	 * @return int[] Array converted
	 */
	public static int[] arrayOfIntegerToInt(Integer[] arrayOfIntegers) {
		int[] arr = new int[arrayOfIntegers.length];
		
//		Set those values to the new array
		for (int i = 0; i < arr.length; i++) {
			arr[i] = arrayOfIntegers[i];
		}
		
		return arr;
	}
	
	/**
	 * Convert a String into an array of int. If any of those "numbers"
	 * is not a number, it will crash. No handle exceptions.
	 * @param numbers Text of stacked numbers to convert
	 * @return int[] Text converted into int array.
	 */
	public static int[] stringToIntArray(String numbers) {
		int arr[] = new int[numbers.length()];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(Character.toString(numbers.charAt(i)));
		}
		
		return arr;
	}
}
