import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AnalyzerTest3 {
	Set<Word> setWord;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testTokenizeSentence() {
		//fail("Not yet implemented"); // TODO
		Sentence snt = new Sentence(1,"I forget what cat it's my $cat.");
		setWord = Analyzer.tokenize(snt);
		assertTrue(setWord != null);
		assertTrue(setWord.size() == 6);
		Iterator<Word> iteratorWords = setWord.iterator();
		while (iteratorWords.hasNext()) {
			assertTrue(iteratorWords.next().getTotal() == 0);
		}
	}

}
