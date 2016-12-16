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
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Graph: \n");
		for(UFNode n : nodes){
			sb.append(n.toString()+"\n");
		}
		for(Edge e: edges){
			sb.append(e.toString());
		}
		return sb.toString();
	}
}
