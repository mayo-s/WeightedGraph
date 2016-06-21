
public class WeightedGraph {

	private Edge edge;
	private Edge[][] matrix;

	public static void main(String[] args) {
		new WeightedGraph();
	}

	public WeightedGraph() {
		int vertices = (int) (Math.random() * 10 + 1);
		System.out.println("random# of vertices " +vertices);
		matrix = new Edge[vertices][vertices];
	}

	private void addEdge() {

	}

	private void setEdgeWeightCost(int edgeName, int weight, int cost) {
		edge.setCost(cost);
		edge.setWeight(weight);
	}

	private void addVertex() {

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
