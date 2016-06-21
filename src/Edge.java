
public class Edge {
	
	private int distance;
	private int cost;

	public Edge(int distance, int cost){
		this.cost = cost;
		this.distance = distance;
	}
	
	public int getDistance(){
		return this.distance;
	}
	
	public int getCost(){
		return this.cost;
	}
	
	
}
