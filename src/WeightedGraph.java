import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class WeightedGraph {

	private Edge[][] matrix;
	private static int MAX_VERTICES = 20;
	private static int MAX_EDGES = 40;

	public static void main(String[] args) {
		WeightedGraph wg = new WeightedGraph(MAX_VERTICES, MAX_EDGES);
		wg.printMatrix();
		System.out.println(wg.shortestPath());
	}

	public WeightedGraph(int vertices, int edge) {
		matrix = new Edge[vertices][vertices];
		randomEdges();
	}

	private void addEdge(int x, int y, Edge edgeToAdd) {
		matrix[x][y] = edgeToAdd;
	}

	private Edge getEdge(int x, int y) {
		return matrix[x][y];
	}

	private void randomEdges() {
		int edgeCnt = 0;
		int maxCost = 5;
		while (edgeCnt < MAX_EDGES) {
			for (int x = 1; x < MAX_VERTICES; x++) {
				for (int y = 1; y < MAX_VERTICES; y++) {
					int decision = (int) (Math.random() * 5);
					if (decision == 1 && x != y) {
						int cost = (int) (Math.random() * maxCost + 1);
						addEdge(x, y, new Edge(cost));
						edgeCnt++;
					} else {
						addEdge(x, y, null);
					}
				}
			}
		}
	}

	public void printMatrix() {
		int edge = 0;
		for (int x = 1; x < MAX_VERTICES; x++) {
			for (int y = 1; y < MAX_VERTICES; y++) {
				if (getEdge(x, y) != null) {
					edge = getEdge(x, y).getCost();
				} else {
					edge = 0;
				}
				System.out.print(" " + edge);
			}
			System.out.println("");
		}
	}

	private boolean containsEdge(int x, int y) {
		if (getEdge(x, y) != null) {
			return true;
		}
		return false;
	}

	private String shortestPath() {

		int from = (int) (Math.random() * MAX_VERTICES);
		int to = (int) (Math.random() * MAX_VERTICES);
		String result = null;

		// System.out.println("\nCalculating shortest Path from: " + from + " to
		// " + to);

		if (from == to) {
			shortestPath();
		} else if (containsEdge(from, to)) {
			result = "Shortest Path from: " + (from + 1) + " to " + (to + 1) + "\nIs connected directly. The costs are "
					+ getEdge(from, to).getCost();
		} else if (!containsEdge(from, to)) {
			dijkstra(from, to);
			result = "Shortest Path from: " + (from + 1) + " to " + (to + 1) + " can not yet be calculated.";
		}

		return result;
	}

	private void dijkstra(int from, int to) {
		HashSet<Vertex> visited = new HashSet<Vertex>();
		HashSet<Vertex> unvisited = createVertices();

		Iterator<Vertex> itu = unvisited.iterator();
		Iterator<Vertex> itv = visited.iterator();
		boolean done = false;
		while (itu.hasNext() && !done) {
			Vertex curr = itu.next();
			if (curr.getName().equals(Integer.toString(from))) {
				visited.add(curr);
				unvisited.remove(curr);
				done = true;
			}
		}
		HashSet<Integer> neighbors = getNeighbors(from);
		
		

	}

	private HashSet<Integer> getNeighbors(int from) {
		HashSet<Integer> neighbor = new HashSet<Integer>();
		for (int n = 0; n < MAX_VERTICES; n++) {
			if (containsEdge(from, n)) {
				neighbor.add(n);
			}
		}
		return neighbor;
	}

	private HashSet<Vertex> createVertices() {
		HashSet<Vertex> vertices = new HashSet<Vertex>();
		for (int n = 0; n < MAX_VERTICES; n++) {
			vertices.add(new Vertex((Integer.toString(n)), (int) (Double.POSITIVE_INFINITY)));
		}
		return vertices;
	}
}
