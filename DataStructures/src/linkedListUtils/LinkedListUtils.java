package linkedListUtils;
import java.util.LinkedList;
import java.util.ListIterator;

/*
 * SD2x Homework #1
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class LinkedListUtils {
	
	public static void insertSorted(LinkedList<Integer> list, int value) {
		//TODO
		/* This method assumes the input LinkedList is already sorted in non-descending order 
		 * (i.e.,such that each element is greater than or equal to the one that is before it, 
		 * and inserts the input int value into the correct location of the list. 
		 * Note that the method does not return anything, 
		 * but rather modifies the input LinkedList as a side effect. 
		 * If the input LinkedList is null, this method should simply terminate.
		 */
		/* IMPLEMENT THIS METHOD! */
		
		if (list == null) return;
		Integer counter = 0;
		// index implementation
		/*
		for (int i = 0; i < list.size(); i++) {
			counter = list.get(i);
			if (value <= counter) {
				list.add(i,value);
				return;
			}
		}
		list.addLast(value);
		*/
		// iterator implementation
		if (list.isEmpty()) {
			list.addLast(value);
			//System.out.println("add value " + value + " in empty list.");
			return;
		}
		ListIterator<Integer> iterator = list.listIterator();
		while (iterator.hasNext()) {
			counter = iterator.next();
			//System.out.println("iterator.next() " + counter);
			//System.out.println("value " + value);
			if (value <= counter) {
				//System.out.println("value smaller than " + counter);
				if (iterator.hasPrevious()) {
					iterator.previous();
				}
				iterator.add(value);
				return;
			} else {
				//System.out.println("value greater than " + counter);
			}
			
		}
		//System.out.println("value is greater than any numbers in the list");
		list.addLast(value); // add in the end of the list
	}
	

	public static void removeMaximumValues(LinkedList<String> list, int N) {
		//TODO
		/*
		 * This method removes all instances of the N largest values in the LinkedList. 
		 * Because the values are Strings, 
		 * you will need to use the String class’ compareTo method to find the largest elements; 
		 * see the Java API for help with that method. 
		 * If the input LinkedList is null or if N is non-positive, 
		 * this method should simply return without any modifications to the input LinkedList. 
		 * Keep in mind that if any of the N largest values appear more than once in the LinkedList, 
		 * this method should return remove all instances, 
		 * so it may remove more than N elements overall. 
		 * The other elements in the LinkedList should not be modified and their order must not be changed.
		 */
		/* IMPLEMENT THIS METHOD! */
		if (list == null || N <= 0) return;
		//System.out.println("N = " + N);
		
		String value = ""; 
		String max = "";
		
		ListIterator<String> iterator = list.listIterator();
		for (int i = 1; i <= N; i++) {
			value = ""; 
			max = "";
			while (iterator.hasNext()) {
				value = iterator.next();
				//System.out.println("iteraror.next() " + value);
				if (value.compareTo(max) > 0) {
					//System.out.println(value + " > " +  max);
					max = value;
				}
			}
			while (iterator.hasPrevious()) {
				value = iterator.previous();
				if (value.equals(max)) {
					//System.out.println("remove " + value);
					iterator.remove();
				}
			}
		}
	}
	
	public static boolean containsSubsequence(LinkedList<Integer> one, LinkedList<Integer> two) {
		//TODO
		/*
		 * This method determines whether any part of the first LinkedList 
		 * contains all elements of the second in the same order 
		 * with no other elements in the sequence, 
		 * i.e. it should return true if the second LinkedList is a subsequence of the first, 
		 * and false if it is not. The method should return false if either input is null or empty.
		 */
		/* IMPLEMENT THIS METHOD! */
		if (one == null || two == null) return false;
		if (one.isEmpty() || two.isEmpty()) return false;
		
		ListIterator<Integer> iterator1 = one.listIterator();
		ListIterator<Integer> iterator2;

		Integer value1;
		Integer value2; 
		boolean same;
		
		while (iterator1.hasNext()) {
			same = true; 	
			iterator2 = two.listIterator(); // iterator of second list started from beginning

			//System.out.println("new sequence from first list begin from "); 
			
			while (iterator1.hasNext() && iterator2.hasNext() && same) {
				
				value1 = iterator1.next(); 
				value2 = iterator2.next();
				same = (value1 == value2);
				
				//System.out.println("value1 " + value1); 
				//System.out.println("value2 " + value2);
				//System.out.println("same = " + same);
				
			}
			
			if (same && !iterator2.hasNext()) return true;
			
		}
		return false; 
	}
	
}
