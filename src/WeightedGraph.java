import java.util.Random;

public class WeightedGraph {

	private int vertices;
	private int[][] matrix;

	public static void main(String[] args) {
		WeightedGraph myGraph = new WeightedGraph(20,45);
		myGraph.printMatrix();
	}

	public WeightedGraph(int vertices, int edges) {
		this.vertices = vertices;
		createMatrix(vertices,edges);
	
		
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

	
	private boolean isFilled(int xCord, int yCord){
		if (matrix[xCord][yCord] != 0) {
			return true;
		} else {
			return false;
		}
	}
	
	private void createMatrix(int vertices, int edges){
		
		matrix = new int[vertices+1][vertices+1];
		
		
		for(int i = edges-1; i >= 0; i--){
			placeEdgeRandomly(vertices);
		}
		
	}
	
	private void placeEdgeRandomly(int vertices){
		Random rn = new Random();
		int ranVerticeX = rn.nextInt((vertices + 1) - 1) + 1;
		int ranVerticeY = rn.nextInt((vertices + 1) - 1) + 1;
		int ranCost = rn.nextInt((20 + 1) - 1) + 1;
		
		matrix[ranVerticeX][ranVerticeY] = ranCost;
		
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
	            System.out.print(getEdge(i, j) + " ");
	        System.out.println();
	    }
	    
	    System.out.println();
			
	}
	

}
