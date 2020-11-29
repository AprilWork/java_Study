import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class AnalyzerTest2 {
	Set<Word> setWord;
	List<Sentence> sentences;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAllWords() {
		//fail("Not yet implemented"); // TODO
		//assertTrue(Analyzer.allWords(Analyzer.readFile("test1.txt")) != null);
		//System.out.println(Analyzer.allWords(Analyzer.readFile("test1.txt")).size());
		//Sentence snt = new Sentence(1,"I forget what cat it's my $cat.");
		//setWord = Analyzer.tokenize(snt);
		sentences = Analyzer.readFile("test3.txt");
		setWord = Analyzer.allWords(sentences);
		assertTrue(setWord != null);
		assertTrue(setWord.size() == 10);
		Iterator<Word> iteratorWords = setWord.iterator();
		while (iteratorWords.hasNext()) {
			Word word = iteratorWords.next();
			System.out.println(word.getText() + " total " + word.getTotal() + 
					" count " + word.getCount());
		}
	}

}
