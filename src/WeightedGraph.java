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
		return new Edge(0,0);
	}

	private boolean containsEdge(int xCord, int yCord) {
		if (matrix[xCord][yCord] != null) {
			return true;
		} else {
			return false;
		}
	}
	
	private void createMatrix(int vertices, int edges){
		
		matrix = new Edge[vertices+1][vertices+1];
		
		
		for(int i = edges-1; i >= 0; i--){
			Edge toAdd = makeRandomEdge();
			placeEdgeRandomly(toAdd,vertices);
		}
		
	}
	
	private void placeEdgeRandomly(Edge toPlace, int vertices){
		Random rn = new Random();
		int ranVerticeX = rn.nextInt((vertices + 1) - 1) + 1;
		int ranVerticeY = rn.nextInt((vertices + 1) - 1) + 1;
		
		matrix[ranVerticeX][ranVerticeY] = toPlace;
		
	}
	
	private Edge makeRandomEdge(){
		Random rn = new Random();
		int weight = rn.nextInt((10 + 1) - 1) + 1;
		int cost = rn.nextInt((10 + 1) - 1) + 1;
		return new Edge(weight,cost);
	}
	
	private void printMatrix(){
		
		System.out.print("  ");
	    for (int i = 1; i <= vertices; i++)
	        System.out.print(i + " ");
	    System.out.println();

	    for (int i = 1; i <= vertices; i++)
	    {
	    	System.out.print(i + " ");
	        for (int j = 1; j <= vertices; j++)
	            System.out.print(getEdge(i, j).getCost() + " ");
	        System.out.println();
	    }
	    
	    System.out.println();
			
	}
	

}
