public class WeightedGraph {

	private Edge[][] matrix;

	public static void main(String[] args) {
		WeightedGraph myGraph = new WeightedGraph(20,45);
	}

	public WeightedGraph(int vertices, int edges) {
		System.out.println("random# of vertices " + vertices);
		matrix = new Edge[vertices][vertices];
	}

	private void addEdge(Edge edgeToAdd, int xCord, int yCord) {
		matrix[xCord][yCord] = edgeToAdd;
	}

	private Edge getEdge(int xCord, int yCord) {

		if (containsEdge(xCord, yCord)) {
			return matrix[xCord][yCord];
		}
		return null;
	}

	private boolean containsEdge(int xCord, int yCord) {
		if (matrix[xCord][yCord] != null) {
			return true;
		} else {
			return false;
		}
	}

	// addEdge, addEdge, addVertex, containsEdge, containsEdge, containsVertex,
	// edgeSet, edgesOf, getAllEdges, getEdge, getEdgeFactory, getEdgeSource,
	// getEdgeTarget, getEdgeWeight, removeAllEdges, removeAllEdges,
	// removeAllVertices, removeEdge, removeEdge, removeVertex, vertexSet

	// Field oder Klassen ? Edges & Vertices

	// get edge(edge, postion, add edge(edge, position),

	// Random edges,

}
