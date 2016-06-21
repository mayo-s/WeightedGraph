public class Edge {
	
	private int weight;
	private int cost;

	public Edge(int weight, int cost){
		this.cost = cost;
		this.weight = weight;
	}
	
	public int getWeight(){
		return this.weight;
	}
	
	public int getCost(){
		return this.cost;
	}
	
	public void setWeight(int weight){
		this.weight = weight;
	}
	
	public void setCost(int cost){
		this.cost = cost;
	}
	
	
}
