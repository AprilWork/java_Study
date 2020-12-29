package treeMaps_priorityQueues;


import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;


public class MovieRatingsProcessor {

	public static List<String> getAlphabeticalMovies(TreeMap<String, PriorityQueue<Integer>> movieRatings) {
		
		/* IMPLEMENT THIS METHOD! */
		LinkedList<String> AlphabeticalMovies = new LinkedList<> ();
		if (movieRatings == null || movieRatings.isEmpty()) {
			return AlphabeticalMovies;
		}
		//System.out.println("new sorted list");
		for (String movie: movieRatings.keySet()) {
			//System.out.println(movie);
			AlphabeticalMovies.add(movie);
		}
		return AlphabeticalMovies; // this line is here only so this code will compile if you don't modify it
	}

	public static List<String> getAlphabeticalMoviesAboveRating(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		/* IMPLEMENT THIS METHOD! */
		LinkedList<String> AlphabeticalMovies = new LinkedList<> ();
		if (movieRatings == null || movieRatings.isEmpty()) {
			return AlphabeticalMovies;
		}
		//System.out.println("new sorted list rating above " + rating);
		for (String movie: movieRatings.keySet()) {
			PriorityQueue<Integer> value = movieRatings.get(movie);
			//System.out.println(movie + " " + value.peek());
			if (value.peek() > rating) {
			    //System.out.println(movie);
			    AlphabeticalMovies.add(movie);
			}
		}
		return AlphabeticalMovies; // this line is here only so this code will compile if you don't modify it
	}
	
	public static TreeMap<String, Integer> removeAllRatingsBelow(TreeMap<String, PriorityQueue<Integer>> movieRatings, int rating) {
		
		/* IMPLEMENT THIS METHOD! */
		TreeMap<String, Integer> newMoviesRating = new TreeMap<>();
		if (movieRatings == null || movieRatings.isEmpty()) {
			return newMoviesRating;
		}
		//System.out.println("new map rating above " + rating);
		for (String movie: movieRatings.keySet()) {
			
			try {
				PriorityQueue<Integer> value = movieRatings.get(movie);
				int counter = 0;
				//System.out.println(value.peek());
				while (value.peek() != null && value.peek() < rating) {
					int number = value.poll();
					if ( number < rating) {
						counter++ ;
						//System.out.println(movie + " removed rating " + number);
					}
				}
				if (counter > 0) {
					newMoviesRating.put(movie, counter);
				}
			}
			finally {
				
			}
		}
		
		for (String movie: newMoviesRating.keySet()) {
			if (movieRatings.get(movie).isEmpty()) {
				//System.out.println(movie + " will removed");
				movieRatings.remove(movie);
			}
		}
		return newMoviesRating; // this line is here only so this code will compile if you don't modify it
	}
}
