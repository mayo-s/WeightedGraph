
public class Vertex {
	
	String name;
	int cost;
	boolean visited;

	public Vertex(String name, int cost, boolean visited){
		this.name = name;
		this.cost = cost;
		this.visited = false;
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
	
	public boolean getVisited(){
		return visited;
	}
	
	public void setVisited(boolean visited){
		this.visited = visited;
	}
}
