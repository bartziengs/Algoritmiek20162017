package assgnmnt_3;

public class Edge implements Comparable<Edge> {
	int from;
	int to; 
	double weight;

public Edge(UFNode x, UFNode y){
	if(x.id < y.id){
		from = x.id;
		to = y.id;
	}else{
		from = y.id;
		to = x.id;
	}
	weight = x.calculateEdge(y);
}

@Override
public String toString(){
	return "["+this.from+"->"+this.to+": "+this.weight+"]\n";
}

@Override
public int compareTo(Edge o) {
	return this.weight == o.weight ? 0 : this.weight < o.weight ? -1 : 1; 
}

}


