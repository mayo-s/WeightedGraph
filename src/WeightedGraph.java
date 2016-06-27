import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class WeightedGraph {

	private int vertices;
	private int[][] matrix;
	int[] dist;
	int[] prev;

	public static void main(String[] args) {
		WeightedGraph myGraph = new WeightedGraph(21, 45);
		myGraph.printMatrix();
		System.out.println(myGraph.neighboursOf(1).toString());
		myGraph.dijkstra(5);
		myGraph.printArrays();

	}

	public WeightedGraph(int vertices, int edges) {
		this.vertices = vertices;
		createMatrix(vertices, edges);

	}

	private void addEdge(int cost, int xCord, int yCord) {
		matrix[xCord][yCord] = cost;
	}

	private int getEdge(int xCord, int yCord) {

		if (isFilled(xCord, yCord)) {
			return matrix[xCord][yCord];
		}
		return 0;
	}

	private boolean isFilled(int xCord, int yCord) {
		if (matrix[xCord][yCord] != 0) {
			return true;
		} else {
			return false;
		}
	}

	private void createMatrix(int vertices, int edges) {

		matrix = new int[vertices][vertices ];

		for (int i = edges - 1; i >= 0; i--) {
			placeEdgeRandomly(vertices);
		}

	}

	private void placeEdgeRandomly(int vertices) {
		Random rn = new Random();
		int randVerticeX = 0;
		int randVerticeY = 0;
		do {
			randVerticeX = rn.nextInt((vertices) - 1) + 1;
			randVerticeY = rn.nextInt((vertices) - 1) + 1;

		} while (isFilled(randVerticeX, randVerticeY) || randVerticeX == randVerticeY);

		int ranCost = rn.nextInt((20 + 1) - 1) + 1;

		matrix[randVerticeX][randVerticeY] = ranCost;
		matrix[randVerticeY][randVerticeX] = ranCost;

	}

	private void printMatrix() {

		System.out.print("\t");
		for (int i = 1; i < vertices; i++)
			System.out.print(i-1 + "\t");
		System.out.println();

		for (int i = 1; i < vertices; i++) {
			System.out.print(i-1 + "\t");
			for (int j = 1; j < vertices; j++)
				System.out.print(getEdge(i, j) + "\t");
			System.out.println();
		}

		System.out.println();

	}

	private void dijkstra(int origin) {

		HashSet<Integer> vertSet = new HashSet<Integer>();
		dist = new int[matrix.length];
		prev = new int[matrix.length];

		for (int i = 0; i < matrix.length; i++) {

			vertSet.add(i);
			dist[i] = Integer.MAX_VALUE;
			prev[i] = 0;
		}
		dist[origin] = 0;

		while (!vertSet.isEmpty()) {
			int curr = cheapestVertex(vertSet);
			vertSet.remove(curr);

			ArrayList<Integer> neighbours = neighboursOf(curr);

			for (int i = 0; i < neighbours.size(); i++) {

				if (!vertSet.contains(i)) {
					break;
				}

				int total = dist[curr] + matrix[curr][i];
				if (total < dist[i]) {
					dist[i] = total;
					prev[i] = curr;
				}

			}
		}

	}

	private int cheapestVertex(HashSet<Integer> vertSet) {

		int min = Integer.MAX_VALUE;

		for (int curr : vertSet) {
			if (dist[curr] < min) {
				min = dist[curr];
			}
		}

		return min;
	}

	private ArrayList<Integer> neighboursOf(int vert) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < matrix[vert].length; i++) {
			if (matrix[vert][i] != 0) {
				result.add(i-1);
			}
		}
		return result;

	}

	private void printArrays() {
		for (int curr : dist) {
			System.out.println(curr);
		}

		for (int curr : prev) {
			System.out.println(curr);
		}
	}

}

// Remove length + 1!
