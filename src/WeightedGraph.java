import java.util.ArrayList;

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
		}
		if (containsEdge(from, to)) {
			result = "Shortest Path from: " + (from + 1) + " to " + (to + 1) + "\nIs connected directly. The costs are "
					+ getEdge(from, to).getCost();
		}
		if (!containsEdge(from, to)) {
			shortestPath(from, to);
			result = "Shortest Path from: " + (from + 1) + " to " + (to + 1) + " can not yet be calculated.";
		}

		return result;
	}

	private ArrayList<Integer> shortestPath(int from, int to) {
		int currentVertex = from;
		int cost = 0;
		ArrayList<Integer> path = new ArrayList<Integer>();

		do {
			ArrayList<Integer> currentNeighbor = new ArrayList<Integer>();
			for (int possibleNeighbor = 0; possibleNeighbor < matrix.length - 1; possibleNeighbor++) {
				currentNeighbor = neighbor(currentVertex, possibleNeighbor);
			}
			for(int n : currentNeighbor){
				currentVertex = currentNeighbor.get(n);
			}
		} while (currentVertex != to);

		return path;
	}

	private ArrayList<Integer> neighbor(int from, int to) {

		ArrayList<Integer> temp = new ArrayList<Integer>();
		for (int n = 0; n < matrix.length; n++) {
			if (containsEdge(from, n)) {
				temp.add(n);
			}
		}
		return temp;
	}
}
