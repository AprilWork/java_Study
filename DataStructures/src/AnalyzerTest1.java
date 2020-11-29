import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AnalyzerTest1 {
	//Analyzer openFile;
	@Before
	public void setUp() throws Exception {
		//openFile = new Analyzer();
	}

	@Test
	public void testReadFile() {
		//fail("Not yet implemented"); // TODO
		assertTrue(Analyzer.readFile("test1.txt") != null);
		assertEquals(1, Analyzer.readFile("test1.txt").size());
		
		assertTrue(Analyzer.readFile("test2.txt") != null);
		assertEquals(1, Analyzer.readFile("test2.txt").size());
		
		assertTrue(Analyzer.readFile("test3.txt") != null);
		assertEquals(3, Analyzer.readFile("test3.txt").size());
		
		assertTrue(Analyzer.readFile("test4.txt") != null);
		assertEquals(3, Analyzer.readFile("test4.txt").size());
		
		assertTrue(Analyzer.readFile("test5.txt") != null);
		assertEquals(2, Analyzer.readFile("test5.txt").size());
		
		assertTrue(Analyzer.readFile("test6.txt") != null);
		assertEquals(2, Analyzer.readFile("test6.txt").size());
		
		assertTrue(Analyzer.readFile("test7.txt") != null);
		assertEquals(2, Analyzer.readFile("test7.txt").size());
		
		assertTrue(Analyzer.readFile("test17.txt") != null);
		assertEquals(0, Analyzer.readFile("test17.txt").size());
	}

}
