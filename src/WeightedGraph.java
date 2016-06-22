
public class WeightedGraph {

	private Edge[][] matrix;
	private static int MAX_VERTICES = 20;
	private static int MAX_EDGES = 40;
	private static int MAX_COST = 5;

	public static void main(String[] args) {
		new WeightedGraph(MAX_VERTICES, MAX_EDGES);
	}

	public WeightedGraph(int vertices, int edge) {
		matrix = new Edge[vertices][vertices];
		randomEdges();
		printMatrix();

	}

	private void addEdge(int x, int y, Edge edgeToAdd) {
		matrix[x][y] = edgeToAdd;
	}
	
	private Edge getEdge(int x, int y){
		return matrix[x][y];
	}

	private void randomEdges() {
		int edgeCnt = 0;
		do {
			for (int x = 1; x < MAX_VERTICES; x++) {
				for (int y = 1; y < MAX_VERTICES; y++) {
					int decision = (int) (Math.random() * 5);
					if (decision == 1) {
						addEdge(x, y, new Edge((int) (Math.random() * MAX_COST + 1)));
						edgeCnt++;
					} else {
						addEdge(x, y, null);
					}
				}
			}
		} while (edgeCnt < MAX_EDGES);
	}

	public void printMatrix() {

		int edge = 0;
		for (int x = 1; x < MAX_VERTICES; x++) {
			for (int y = 1; y < MAX_VERTICES; y++) {
				if (getEdge(x, y) != null)
					edge = getEdge(x,y).getCost();
				else
					edge = 0;

				System.out.print(" " + edge);
			}
			System.out.println("");
		}
	}

	private boolean containsEdge() {
		return false;
	}

	private boolean containsVertex() {
		return false;
	}

	// addEdge, addEdge, addVertex, containsEdge, containsEdge, containsVertex,
	// edgeSet, edgesOf, getAllEdges, getEdge, getEdgeFactory, getEdgeSource,
	// getEdgeTarget, getEdgeWeight, removeAllEdges, removeAllEdges,
	// removeAllVertices, removeEdge, removeEdge, removeVertex, vertexSet

}
