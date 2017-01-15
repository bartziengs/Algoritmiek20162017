package assgnmnt_4;

import java.util.Collection;

public class Graph {

	protected Collection<Node> nodes;
	protected Node source;
	protected Node sink;

	public Graph(Collection<Node> nodes, Node source, Node sink) {
		this.nodes = nodes;
		this.source = source;
		this.sink = sink;
	}

	public Node getSink() {
		return sink;
	}

	public Node getSource() {
		return source;
	}

}
