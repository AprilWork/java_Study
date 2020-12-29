package treeMaps_priorityQueues;


import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class MovieRatingsParser {

	public static TreeMap<String, PriorityQueue<Integer>> parseMovieRatings(List<UserMovieRating> allUsersRatings) {
		
		/* IMPLEMENT THIS METHOD! */
		TreeMap<String, PriorityQueue<Integer>> moviesRating = new TreeMap<>();
		
		
		if (allUsersRatings == null || allUsersRatings.isEmpty()) {
			return moviesRating;
		}
		//System.out.println("new list");
		for (UserMovieRating rating: allUsersRatings) {
			//System.out.println(rating.getMovie() + " " + rating.getUserRating());
			
			if (rating != null && 
					rating.getMovie() != null && !(rating.getMovie().isEmpty()) && 
							rating.getUserRating() >=0 ) {
				//System.out.println(rating.getMovie() + " " + rating.getUserRating());
				
				if (moviesRating.get(rating.getMovie().toLowerCase()) == null) {
					//System.out.println("put it!");
					PriorityQueue<Integer> value = new PriorityQueue<>();
					value.add(rating.getUserRating()); 
					moviesRating.put(rating.getMovie().toLowerCase(), value);
				} else {
					//System.out.println("I get it!");
					PriorityQueue<Integer> value = moviesRating.get(rating.getMovie().toLowerCase());
					value.add(rating.getUserRating());
				}
				
			}
		}
		
		return moviesRating; // this line is here only so this code will compile if you don't modify it
	}

}
