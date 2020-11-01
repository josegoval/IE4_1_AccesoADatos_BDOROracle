package ownLibrary;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Clase especifica para probar los metodos de la libreria.
 * @author Jose
 *
 */
public class Test {

	public static void main(String[] args) {
		
//		int[] v = Generate.randomIntArray(4, 110, 0);
//		int[][] z = Generate.randomIntMatrix(4, 7, 777, 0);
//		
//		Display.arrayOfIntsTable(v, true);
//		Display.matrixOfIntsTable(z, false);
		
//		String text = Introduce.SSFormat();
		
//		Integer.max(a, b);
//		
//		class Clase {
//			private int n;
//			
//			public Clase(int n) {
//				this.n=n;
//			}
//			
//			public int getN() {
//				return n;
//			}
//		}
//		
//		List<Integer> num = new ArrayList<Integer>();
//		num.add(2);
//		num.add(2);
//		num.add(2);
//		num.add(2);
//				
//		List<Clase> c = new ArrayList<Clase>();
//		c.add(new Clase(2));
//		c.add(new Clase(7));
//		c.add(new Clase(3));
//
//		System.out.println(num.stream().reduce(1, (x, y) -> x+y).toString());
//		System.out.println(num.stream().reduce(Integer::max).get().intValue());
//		System.out.println(num.stream().max(Integer::max).get().intValue());
//		System.out.println(c.stream().max(Comparator.comparing(Clase::getN)).get().getN());
//		System.out.println(c.stream().map(s -> s.getN()).reduce(Integer::max).get().intValue());
		
//		Period periodo = Period.between(LocalDate.of(2000, 1, 1), LocalDate.of(2000, 1, 3));
//		// ChronoUnits
//		System.out.println(periodo);
//		System.out.println(LocalDate.of(2000, 1, 1).until(LocalDate.of(2000, 1, 3), ChronoUnit.DAYS));
		
		 List<String> list = Arrays.asList("Ram","Shyam","Shiv","Mahesh");
	        String result=  list.stream().collect(Collectors.joining("\n"));
	        System.out.println(result);
	}

}
