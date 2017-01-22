package assgnmnt_4;

import java.util.ArrayList;
import java.util.Collection;

public class Node {

	protected String label;
	protected int compiled;
	protected int notcompiled;
	protected int compilation;
	protected int totalcalls;
	protected Collection<Edge> edges;

	public Node(String label, int[] compilation, int n) {
		this.label = label;
		this.compiled = compilation[0];
		this.notcompiled = compilation[1];
		this.compilation = compilation[2];
		this.edges = new ArrayList<Edge>();
	}

	public void addEdge(Node to, int capacity) {
		Edge e = new Edge(capacity, this, to);
		edges.add(e);
		to.getEdges().add(e.getBackwards());
	}
	
	public String toString(){
	StringBuilder sb = new StringBuilder();
	sb.append("Node: "+this.label+"\n");
	sb.append("cost when compiled: "+this.compiled+"\n");
	sb.append("cost when not compiled: "+this.notcompiled+"\n");
	sb.append("compilation costs: "+this.compilation+"\n");
	sb.append("total calls: "+this.totalcalls+ "\n");
	return sb.toString();
	}

	
	public int getTotalcalls() {
		return totalcalls;
	}
	
	public boolean containsEdge(Node n){
		for(Edge e : edges){
			if(e.getTo() == n)return true;
		}
		return false;
	}

	public void incrementTotalcalls(int amount) {
		this.totalcalls += amount;
	}

	public Collection<Edge> getEdges() {
		return edges;
	}
	
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}
	
	public int getCompiled() {
		return compiled;
	}

	public int getNotcompiled() {
		return notcompiled;
	}

	public int getCompilation() {
		return compilation;
	}
	
	
}
