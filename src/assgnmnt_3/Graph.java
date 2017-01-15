package assgnmnt_3;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph {
	
	PriorityQueue<Edge> edges;
	ArrayList<UFNode> nodes;
	
	public Graph(){
	edges = new PriorityQueue<Edge>();
	nodes = new ArrayList<UFNode>();
	}
	
	public void addNode(UFNode x){
		this.nodes.add(x);
	}
}


