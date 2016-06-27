import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class WeightedGraph {

	private int vertices;
	private int[][] matrix;
	int[] dist;
	int[] prev;

	public static void main(String[] args) {
		WeightedGraph myGraph = new WeightedGraph(20, 100);
		myGraph.printMatrix();
		//System.out.println(myGraph.neighboursOf(1).toString());
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

	private boolean isFilled(int xCord, int yCord) {
		if (matrix[xCord][yCord] != Integer.MAX_VALUE) {
			return true;
		} else {
			return false;
		}
	}

	private void createMatrix(int vertices, int edges) {
		matrix = new int[vertices][vertices];

		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for (int i = 0; i < edges; i++) {
			placeEdgeRandomly(vertices);
		}
	}

	private void placeEdgeRandomly(int vertices) {
		Random rn = new Random();
		int randVertexX = 0;
		int randVertexY = 0;
		do {
			randVertexX = rn.nextInt(vertices);
			randVertexY = rn.nextInt(vertices);

		} while (isFilled(randVertexX, randVertexY) || randVertexX == randVertexY);

		int randCost = rn.nextInt(20) + 1;

		matrix[randVertexX][randVertexY] = randCost;
		matrix[randVertexY][randVertexX] = randCost;

	}

	private void printMatrix() {
		System.out.print("\t");
		for (int i = 0; i < vertices; i++) {
			System.out.print(i + "\t");
		}
		System.out.println();

		for (int i = 0; i < vertices; i++) {
			System.out.print(i + "\t");
			for (int j = 0; j < vertices; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
				
			System.out.println();
		}
	}

	private void dijkstra(int origin) {
		HashSet<Integer> vertSet = new HashSet<Integer>();
		dist = new int[matrix.length];
		prev = new int[matrix.length];

		for (int i = 0; i < matrix.length; i++) {
			vertSet.add(i);
			dist[i] = Integer.MAX_VALUE;
			prev[i] = -1;
		}
		dist[origin] = 0;

		while (!vertSet.isEmpty()) {
			int curr = cheapestVertex(vertSet);
			vertSet.remove(curr);

			ArrayList<Integer> neighbours = neighboursOf(curr);

			for (int neighbour : neighbours) {
				if (!vertSet.contains(neighbour)) {
					break;
				}

				int total = dist[curr] + matrix[curr][neighbour];
				if (total < dist[neighbour]) {
					dist[neighbour] = total;
					prev[neighbour] = curr;
				}
			}
		}
	}

	private int cheapestVertex(HashSet<Integer> vertSet) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;
		
		for (int curr : vertSet) {
			if (dist[curr] <= min) {
				min = dist[curr];
				minIndex = curr;
			}
		}
		return minIndex;
	}

	private ArrayList<Integer> neighboursOf(int vert) {
		ArrayList<Integer> result = new ArrayList<Integer>();

		for (int i = 0; i < matrix[vert].length; i++) {
			if (matrix[vert][i] != 0) {
				result.add(i);
			}
		}
		return result;
	}

	private void printArrays() {
		System.out.println("This is dist[]:");
		for (int curr : dist) {
			System.out.print(curr + " ");
		}
		
		System.out.println();
		System.out.println("This is prev[]");
		for (int curr : prev) {
			System.out.print(curr + " ");
		}
	}

}
