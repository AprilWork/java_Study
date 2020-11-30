package genericsStudy;

import java.util.*;
import java.lang.*;


public class Boxing {
	
	public static int sum (List<Integer> ints) {
		  int s = 0;
		  for (int n : ints) { s += n; }
		  return s;
		}
	
	public static double sumNumbers(List<? extends Number> list) {
		double s = 0.0;
		for(Number n : list) { s += n.doubleValue(); }
		return s;
	}
	
	public static void removeNegative(List<Double> v) {
		//Java Generics and Collections: Speed Up the Java Development Process (p. 23). O'Reilly Media. Kindle Edition. 
		  for (Iterator<Double> it = v.iterator(); it.hasNext();) {
			Double k =  it.next(); 
		    if (k < 0) { 
		    	it.remove();
		    }
		  } 
		}
	
	public static <T extends Comparable<T>> void removeUniversal(List<T> v, T d ) {
		for (Iterator<T> it = (Iterator<T>) v.iterator(); it.hasNext();) {
			if (it.next().compareTo(d) < 0) it.remove();
		}
	}

		
	@SafeVarargs
	public static <T> List<T> toList(T... arr) {
	//public static <T> List<T> toList(T[] arr) {
	    List<T> list = new ArrayList<T>();
	    for (T elt : arr) list.add(elt);
	    return list;
	  }
	
	public static void addNumbers(List<? super Integer> list) {
		for (int i = 1; i <= 10; i++ ) {
			list.add(i);
		}
		
	}

	 
	

	
	public static void main(String[] args ) {
		//Boxing box;
		/*
		 * Since the returned List is a fixed-size List, we can’t add/remove elements.
		 * An attempt to add more elements would cause UnsupportedOperationException:
		 * The root of this Exception is that the returned object doesn't implement the add() or remove() operation 
		 * since it isn't the same as java.util.ArrayList. 
		 * It's an ArrayList, from java.util.Arrays.
		 */
		List<Double> db = new ArrayList<>(Arrays.asList(1.0,-2.0,2.0,3.0));
		System.out.println(db.toString());
		assert db.toString().equals("[1.0, -2.0, 2.0, 3.0]");

		 
		Boxing.removeNegative(db);
		//Boxing.removeUniversal(db,0.0);
		System.out.println(db.toString());
		assert db.size() == 3;
		//List<Double> db1 = toList(new Double[] {1,2,3});
		List<Double> db1 = toList(1.3,2.0,-2.0,3.0);
		//List<Double> db1 = Boxing.<Double>toList(-1.7,2.4,3.1);
		//Boxing.removeNegative(db1);
		System.out.println(db1.toString());
		Boxing.removeUniversal(db1,0.0);
		System.out.println(db1.toString());
		assert db1.size() == 3;
		double s1 = sumNumbers(db1);
		System.out.println("sum = " + s1);
		assert s1 == 6.3;
		
		List<Integer> ints = toList(1,2,3);
		int s = sum(ints);
		assert s == 6;
		s1 = sumNumbers(ints);
		assert s1 == 6;
		
		ints.add(200);
		System.out.println(ints.toString());
		Boxing.removeUniversal(ints,145);
		//assert ints.size() == 2;
		System.out.println(ints.toString());
		
		List<String> str = toList("abc","ab","cd");
		System.out.println(str.toString());
		Boxing.removeUniversal(str,"abcd");
		//assert ints.size() == 2;
		System.out.println(str.toString());
		
		//List<Integer> num1 = toList(11,12);
		List<Object> num1 = toList(11,12);
		addNumbers(num1);
		System.out.println(num1.toString());
		
		List<EvenNumber> le = new ArrayList<>();
		List<? extends NaturalNumber> ln = le;
		List<? super EvenNumber> lse = le;
		List<? extends EvenNumber> lee = le;

		//ln.add(new NaturalNumber(35));  // compile-time err
		//lse.add(new NaturalNumber(45)); // compile-time err
		//lee.add(new EvenNumber(25)); // compile-time err
		//lee.add(new NaturalNumber(9)); // compile-time err
		
		lse.add(new EvenNumber(25));  
		le.add(new EvenNumber(35));
		
		int i = 0;
		
		System.out.println("le " + le.get(i).toString());
		System.out.println("ln " + ln.get(i).toString());
		System.out.println("lse " + lse.get(i).toString());
		System.out.println("lee " + lee.get(i).toString());
		
	}
		 
	

}
