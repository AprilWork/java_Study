package linkedListUtils;
import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class LinkedListUtilsTest extends LinkedListUtils {
	LinkedListUtils my;
	
	@Before
	public void setUp() throws Exception {
		
		my = new LinkedListUtils();
		/*
		for (int i = 0; i < 10; i++) {
			list.addLast(2*i);
		}	
		*/
	}

	@Test
	public void testInsertSorted() {
		//fail("Not yet implemented"); // TODO
		LinkedList<Integer> list; 
		list = new LinkedList<Integer>();
		LinkedListUtils.insertSorted(list, 3);
		LinkedListUtils.insertSorted(list, 5);
		LinkedListUtils.insertSorted(list, 4);
		LinkedListUtils.insertSorted(list, 2);
		LinkedListUtils.insertSorted(list, 12);
		LinkedListUtils.insertSorted(list, 13);
		LinkedListUtils.insertSorted(list, 4);
		LinkedListUtils.insertSorted(list, 10);
		
		String str = "";
		Iterator<Integer> iterator = list.iterator();
		while (iterator.hasNext()) {
			str = str  + iterator.next() + " ";
		}
		//System.out.println("in list " + str);
		assertEquals(8,list.size());
		assertEquals("2 3 4 4 5 10 12 13 ",str);
	}

	@Test
	public void testRemoveMaximumValues() {
		//fail("Not yet implemented"); // TODO
		LinkedList<String> list; 
		list = new LinkedList<String>();

		list.addLast("lion");
		list.addLast("zebra");
		list.addLast("lion");
		list.addLast("porcupine");
		list.addLast("zebra");
		
		String str = "";
		Iterator<String> iterator = list.iterator();
		while (iterator.hasNext()) {
			str = str  + iterator.next() + " ";
		}
		System.out.println("in list: " + str);
		
		LinkedListUtils.removeMaximumValues(list, 2);
		

	}
		

	@Test
	public void testContainsSubsequence() {
		fail("Not yet implemented"); // TODO
	}

}
