
public class WeightedGraph {

	private Edge[][] matrix;
	private static int MAX_VERTICES = 20;
	private static int MAX_EDGES = 40;

	public static void main(String[] args) {
		WeightedGraph wg = new WeightedGraph(MAX_VERTICES, MAX_EDGES);
		wg.printMatrix();
		wg.shortestPath();
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
		do {
			for (int x = 1; x < MAX_VERTICES; x++) {
				for (int y = 1; y < MAX_VERTICES; y++) {
					int decision = (int) (Math.random() * 5);
					if (decision == 1) {
						int cost = (int) (Math.random() * maxCost + 1);
						addEdge(x, y, new Edge(cost));
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

		if (from == to) {
			shortestPath();
		}
		if(containsEdge(from, to)){
			return "Shortest Path from: " + from + " to " + to + "\nIs connected directly.The costs are " + getEdge(from, to).getCost();
		}
		if(!containsEdge(from,to)){
			dijkstra(from, to);
		}
				
		return null;
	}
	
	private void dijkstra(int from, int to){
		
		
		// return null;
	}
}
