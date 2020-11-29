import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.PatternSyntaxException;




/*
 * SD2x Homework #3
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the method signatures!
 */
public class Analyzer {
	
	/*
	 * Implement this method in Part 1
	 */
	public static List<Sentence> readFile(String filename) {

		/* IMPLEMENT THIS METHOD! */
		File textFile;
		Scanner scnr;
		String line = "";
		Sentence sentence;
		LinkedList<Sentence> sentences = new LinkedList<Sentence> ();
		
		try {
			textFile = new File(filename);
			scnr = new Scanner(textFile);
			while (scnr.hasNextLine()) {
			    line = scnr.nextLine();
			    
			    //System.out.println(line);
			    sentence = tokenize(line);
			    if (sentence != null) {
			    	sentences.add(sentence);
			    }	
			}
			scnr.close();
			return sentences;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			return sentences;
			//e.printStackTrace();
		} catch (NumberFormatException e ) {
			e.printStackTrace();
		} finally {
			return sentences;
		}
		
		
		//return sentences; // this line is here only so this code will compile if you don't modify it

	}
	
	public static Sentence tokenize(String line) {
		String[] arrOfStr = {};
		int score = 0;
		String text = "";
		Sentence sentence;

		if (line  == null) {
			return null;
		}
	    if (!line.isEmpty()) {
			try {
				arrOfStr = line.split(" ", 2);
				score = Integer.valueOf(arrOfStr[0]);
				text = arrOfStr[1];
				if (score >= -2 && score <= 2 && !text.isEmpty()) {
					sentence = new Sentence(score, text);
					return sentence;
				} else {
					return null;
				}
			} catch (PatternSyntaxException e) {
				return null;
				//e.printStackTrace();
			} catch (NumberFormatException e) {
				return null;
				//e.printStackTrace();
			} catch (ArrayIndexOutOfBoundsException e ) {
				return null;
			}
	    }
		return null;
	}
	
	public static Set<Word> tokenizeString(String line) {
		String[] arrOfStr = {};
		String lowerCase = "";
		
		Set<Word> setWord = new HashSet<Word> ();
		
		if (line == null || line.isEmpty()) {
			return setWord;
		}
		
		lowerCase = line.toLowerCase();
		//System.out.println(lowerCase);
		lowerCase = lowerCase.replace("'s ", " ");
		lowerCase = lowerCase.replace(".", "");
		lowerCase = lowerCase.replace(",", "");
		lowerCase = lowerCase.replace("  ", " ");
		lowerCase = lowerCase.trim();
		//System.out.println("after replace::" + lowerCase);
		arrOfStr = lowerCase.split(" ");
		
		for (int i = 0; i < arrOfStr.length; i++) {
			//remove string with non letter 
			String strWord = arrOfStr[i];
			boolean isWord = true;
			if (strWord.isBlank()) {
				isWord = false;
			} else {
				char chr = strWord.charAt(0);
				if (!Character.isLetter(chr)) {
					isWord = false;
				}
			}
			
			if (isWord) {
				Word myWord = new Word(strWord);
				if (setWord.add(myWord)) {
					//System.out.println(strWord);
				}	
			}
		}
		return setWord;
	}
	
	public static Set<Word> tokenize(Sentence sentence) {
		//TODO
		Set<Word> setWord = new HashSet<Word> ();
		
		if (sentence == null || sentence.getText().isEmpty()) {
			return setWord;
		}
		
		setWord = tokenizeString(sentence.getText());
		return setWord;
	}
	
	public static Word getWordFromSet(Word word, Set<Word> setWords) {
		if (setWords == null || setWords.isEmpty() ) {
			return null;
		}
		Word nextWord;
		Iterator<Word> iteratorWords = setWords.iterator();
		while (iteratorWords.hasNext()) {
			nextWord = iteratorWords.next();
			if (nextWord.equals(word)) {
				return nextWord;
			}
		}
		return null;
	}
	
	/*
	 * Implement this method in Part 2
	 */
	public static Set<Word> allWords(List<Sentence> sentences) {
		//TODO
		/*
		 * As an example, consider this text: 
		 * It 's a lot of fun to learn about data structures. 
		 * Your program should convert " It " to " it " (to make it lowercase) and 
		 * ignore " 's " and the period at the end of the sentence since 
		 * those tokens do not start with a letter.
		 */
		/* IMPLEMENT THIS METHOD! */
		Set<Word> setWord = new HashSet<Word> ();
		if (sentences == null) {
			return setWord;
		} 
		
		Sentence sentence; 
		ListIterator<Sentence> iterator = sentences.listIterator();
		Word word;
		
		Set<Word> newWords; 
		
		
		while (iterator.hasNext()) {
			sentence = iterator.next();
			if (sentence != null) {
				newWords = tokenize(sentence);
				Iterator<Word> iteratorWords = newWords.iterator();
				while (iteratorWords.hasNext()) {
					word = iteratorWords.next();
					//word.increaseTotal(sentence.getScore());
					if (setWord.add(word)) {
						word.increaseTotal(sentence.getScore());
					} else {
						Word oldWord = getWordFromSet(word, setWord);
						oldWord.increaseTotal(sentence.getScore());
					}
				}
			}

		}	
		return setWord;
		//return null; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 3
	 */
	public static Map<String, Double> calculateScores(Set<Word> words) {

		/* IMPLEMENT THIS METHOD! */
		
		Map<String, Double> map = new HashMap<String, Double> ();
		if (words == null || words.isEmpty()) {
			return map;
		}
		
		Iterator<Word> iterator = words.iterator();
		
		while (iterator.hasNext()) {
			Word word = iterator.next();
			if (word != null) {
				String lowerCase = word.getText().toLowerCase();
				map.put(lowerCase, word.calculateScore());
			}	
		}
		
		return map; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * Implement this method in Part 4
	 */
	public static double calculateSentenceScore(Map<String, Double> wordScores, String sentence) {

		/* IMPLEMENT THIS METHOD! */
		
		if (wordScores == null || wordScores.isEmpty() || 
				sentence == null || sentence.isEmpty() ) {
			return 0;
		}
		
		
		Set<Word> wordsFromSentence = new HashSet<Word> ();
		String str = sentence.toLowerCase();
		wordsFromSentence = tokenizeString(str);
		
		try {
			
			
		} catch (NullPointerException e ) {
			System.out.println("Something wrong: NullPointerException");
			return 0;
		}
				
		Iterator<Word> wordIterator = wordsFromSentence.iterator();
		double total = 0;
		int count = 0;
		
		while (wordIterator.hasNext()) {
			Word word = wordIterator.next();
			
			if (wordScores.containsKey(word.getText())) {
				total += wordScores.get(word.getText());
				count++;
			} else {
				count++;
			}
			
		}
		if (count == 0) {
			return 0;
		}
		return ((double) total) / count;
		//return 0; // this line is here only so this code will compile if you don't modify it

	}
	
	/*
	 * This method is here to help you run your program. Y
	 * You may modify it as needed.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Please specify the name of the input file");
			System.exit(0);
		}
		String filename = args[0];
		System.out.print("Please enter a sentence: ");
		Scanner in = new Scanner(System.in);
		String sentence = in.nextLine();
		in.close();
		List<Sentence> sentences = Analyzer.readFile(filename);
		Set<Word> words = Analyzer.allWords(sentences);
		Map<String, Double> wordScores = Analyzer.calculateScores(words);
		double score = Analyzer.calculateSentenceScore(wordScores, sentence);
		System.out.println("The sentiment score is " + score);
	}
}
