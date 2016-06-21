import java.util.Random;

public class WeightedGraph {

	private int vertices;
	private Edge[][] matrix;

	public static void main(String[] args) {
		WeightedGraph myGraph = new WeightedGraph(20,45);
		myGraph.printMatrix();
	}

	public WeightedGraph(int vertices, int edges) {
		this.vertices = vertices;
		createMatrix(vertices,edges);
	
		
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
	
	private void createMatrix(int vertices, int edges){
		
		matrix = new Edge[vertices][vertices];
		
		
		for(int i = edges-1; i >= 0; i--){
			Edge toAdd = makeRandomEdge();
			placeEdgeRandomly(toAdd,vertices-1);
		}
		
	}
	
	private void placeEdgeRandomly(Edge toPlace, int vertices){
		Random rn = new Random();
		int ranVertices = rn.nextInt((vertices + 1) - 1) + 1;
		
		matrix[ranVertices][ranVertices] = toPlace;
		
	}
	
	private Edge makeRandomEdge(){
		Random rn = new Random();
		int weight = rn.nextInt((10 + 1) - 1) + 1;
		int cost = rn.nextInt((10 + 1) - 1) + 1;
		return new Edge(weight,cost);
	}
	
	private void printMatrix(){
		for(Edge[] curr : matrix){
			for(Edge e : curr)
				if(e != null){
					System.out.println("[" + e.getWeight() + "," + e.getCost() + "]");
				}
			
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
