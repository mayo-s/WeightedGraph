import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class WeightedGraph {

	private int vertices;
	private int[][] matrix;
	int[] dist;
	int[] prev;

	public static void main(String[] args) {
		WeightedGraph myGraph = new WeightedGraph(20, 45);
		myGraph.printMatrix();
		System.out.println(myGraph.neighboursOf(1).toString());
		myGraph.dijkstra(5);
		

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

		matrix = new int[vertices + 1][vertices + 1];

		for (int i = edges - 1; i >= 0; i--) {
			placeEdgeRandomly(vertices);
		}

	}

	private void placeEdgeRandomly(int vertices) {
		Random rn = new Random();
		int ranVerticeX = 0;
		int ranVerticeY = 0;
		do {
			ranVerticeX = rn.nextInt((vertices + 1) - 1) + 1;
			ranVerticeY = rn.nextInt((vertices + 1) - 1) + 1;

		} while (isFilled(ranVerticeX, ranVerticeY) || ranVerticeX == ranVerticeY);

		int ranCost = rn.nextInt((20 + 1) - 1) + 1;

		matrix[ranVerticeX][ranVerticeY] = ranCost;
		matrix[ranVerticeY][ranVerticeX] = ranCost;

	}

	private void printMatrix() {

		System.out.print("  ");
		for (int i = 1; i <= vertices; i++)
			System.out.print(i + " ");
		System.out.println();

		for (int i = 1; i <= vertices; i++) {
			System.out.print(i + " ");
			for (int j = 1; j <= vertices; j++)
				System.out.print(getEdge(i, j) + " ");
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
			int curr = min(origin);
			vertSet.remove(curr);

			ArrayList<Integer> neighbours = neighboursOf(curr);

			for (int i = 0; i < neighbours.size(); i++) {

				int total = dist[curr] + matrix[curr][i];
				if (total < dist[i]) {
					dist[i] = total;
					prev[i] = curr;
				}

			}
		}

	}

	private int min(int vertArr) {

		int min = Integer.MAX_VALUE;

		for (int curr : matrix[vertArr]) {
			if (curr < min && curr != 0) {
				min = curr;
			}
		}

		return min;
	}

	private ArrayList<Integer> neighboursOf(int vert) {

		ArrayList<Integer> result = new ArrayList();

		for (int i = 0; i < matrix[vert].length; i++) {
			if (matrix[vert][i] != 0) {
				result.add(i);
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
