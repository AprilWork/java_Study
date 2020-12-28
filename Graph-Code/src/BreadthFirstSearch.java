

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
 * SD2x Homework #6
 * This is an implementation of Breadth First Search (BFS) on a graph.
 * You may modify and submit this code if you'd like.
 */

public class BreadthFirstSearch {
	protected Set<Node> marked;
	protected Graph graph;
	int count;

	public BreadthFirstSearch(Graph graphToSearch) {
		marked = new HashSet<Node>();
		graph = graphToSearch;
		count = 0;
	}
	
	/**
	 * This method was discussed in the lesson
	 */
	public boolean bfs(Node start, String elementToFind) {
		if (!graph.containsNode(start)) {
			return false;
		}
		if (start.getElement().equals(elementToFind)) {
			//count = 0;
			return true;
		}

		Queue<Node> toExplore = new LinkedList<Node>();
		marked.clear();
		marked.add(start);                                                     
		toExplore.add(start);  

		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					if (neighbor.getElement().equals(elementToFind)) {
						return true;
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
				}
			}
		}
		return false;
	}

	public boolean isPath(String src, String dest) {
		Node start = graph.getNode(src);
		return bfs(start, dest);

	}


	public int shortestPath(Node start, String elementToFind) {
		count = 0;
		marked.clear();
		if (!graph.containsNode(start)) {
			count = -1;
			return count;
		}
		if (start.getElement().equals(elementToFind)) {
			count = 0;
			return count;
		}
		Map<Node, Integer> depth = new HashMap<Node, Integer>();
		Queue<Node> toExplore = new LinkedList<Node>();

		marked.add(start);                                                     
		toExplore.add(start);  
		depth.put(start, count);
		while (!toExplore.isEmpty()) {
			Node current = toExplore.remove();
			for (Node neighbor : graph.getNodeNeighbors(current)) {
				if (!marked.contains(neighbor)) {
					if (neighbor.getElement().equals(elementToFind)) {

						count = depth.get(current);
						count++;
						return count;
					}
					marked.add(neighbor);
					toExplore.add(neighbor);
					count = depth.get(current);
					count++;
					depth.put(neighbor, count);
				}
			}
		}
		count = -1;
		return count;
	}


	public Set<String> nodeSet(Node start, int distance) {
		if (!graph.containsNode(start)) {
			return null;
		}

		Set<String> myNodes = new HashSet<String>();

		if (graph.getNumNodes() == 1) {
			return myNodes;
		}

		Set<Node> nodes = graph.getAllNodes();
		for (Node checkNode : nodes) {
			String elementToFind = checkNode.getElement();
			int minPath = shortestPath(start, elementToFind);	
			if ( (minPath <= distance) && (minPath >= 1)) {
				myNodes.add(elementToFind);
			}	
		}
		return myNodes;
	}
}
