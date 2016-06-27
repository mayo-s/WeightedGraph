
public class Vertex {
	
	String name;
	int cost;

	public Vertex(String name, int cost){
		this.name = name;
		this.cost = cost;
	}
	
	public String getName(){
		return name;
	}
	public int getCost(){
		return cost;
	}
	public void setCost(int cost){
		this.cost = cost;
	}
}
