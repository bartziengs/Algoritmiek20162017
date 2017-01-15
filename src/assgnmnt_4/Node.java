package assgnmnt_4;

import java.util.ArrayList;
import java.util.Collection;

public class Node {

	protected String label;
	protected Collection<Edge> edges;

	public Node(String label) {
		this.label = label;
		this.edges = new ArrayList<Edge>();
	}

	public void addEdge(Node to, int capacity) {
		Edge e = new Edge(capacity, this, to);
		edges.add(e);
		to.getEdges().add(e.getBackwards());
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

}
