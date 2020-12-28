
import java.util.List;
import java.util.Set;

/*
 * SD2x Homework #6
 * Implement the methods below according to the specification in the assignment description.
 * Please be sure not to change the signature of any of the methods!
 */

public class GraphUtils {

	public static int minDistance(Graph graph, String src, String dest) {

		/* IMPLEMENT THIS METHOD! */
		
		if ((graph == null) || (src == null) || (dest == null)) return -1;
		if (!graph.containsElement(src)) return -1;
		if (!graph.containsElement(dest)) return -1;
		
		BreadthFirstSearch bread = new BreadthFirstSearch(graph);
		
		Node start = graph.getNode(src);	
		return bread.shortestPath(start,dest);
	}
	

	public static Set<String> nodesWithinDistance(Graph graph, String src, int distance) {

		/* IMPLEMENT THIS METHOD! */
		
		if (graph == null || src == null || (!graph.containsElement(src)) || distance <= 0) return null;
		
		BreadthFirstSearch bread = new BreadthFirstSearch(graph);
		Node start = graph.getNode(src);
		
		return bread.nodeSet(start, distance); 
	}


	public static boolean isHamiltonianPath(Graph g, List<String> values) {

		/* IMPLEMENT THIS METHOD! */
		if (g == null  || values == null || values.isEmpty()) return false;
			
		int lastIndex = values.size()-1;
		boolean a = values.get(0).equals(values.get(lastIndex));
		if (!a) {
			return false;
		}
		
		for (String element : values) {
			if (!g.containsElement(element)) {
				return false;
			}
		}
		
		
		if (!checkLinkedPair(g, values)) {
			return false;
		}
		if (!checkContains(g, values)) {
			return false;
		}
		return true; 
	}
	
	public static boolean checkLinkedPair(Graph g, List<String> values) {
		Set<String> destinations = null;
		for (String value: values) {
			if (destinations != null) {
				if (!destinations.contains(value)) {
					return false;
				}
			}
			
			destinations = nodesWithinDistance(g, value, 1);
		}
		return true;
	}
	
	public static boolean checkContains(Graph g, List<String> values) {
		for (Node point : g.getAllNodes()) {
			String check = point.getElement();
			if (!values.contains(check)) {
				return false;
			}
		}
		//System.out.println(true);
		// comments
		return true;
	}
	
}
