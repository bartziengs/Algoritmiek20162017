package assgnmnt_3;

public class UFNode {
	 int id;
	 int rank;
	 UFNode parent;
	 double[] coordinates;
	 /**
	     * Constructor
	     * @param id so that the node can store some information
	     */
	    public UFNode(int id, double[] coordinates) {
	        this.id = id;
	        this.rank = 0;
	        this.parent = this;
	        this.coordinates = coordinates;
	    }

	    /**
	     * Implements the `find` operation for the Union-Find datastructure
	     * @return the root of the tree that this UFNode is connected to (or this if it is the root).
	     */
	    public UFNode findSet() {
	        if (this.parent != this) {
	            this.parent = this.parent.findSet();
	        }
	        return this.parent;
	    }
	    
	    public boolean equals(UFNode that){
	    	return this.id == that.id;
	    }
	    
	    public String toString(){
	    	StringBuilder sb = new StringBuilder();
	    	sb.append("["+this.id+"| ");
	    	for(double b : coordinates){
	    		sb.append(b+" ");
	    	}
	    	return sb.toString().substring(0,sb.length()-1) +"]";
	    }

	    /**
	     * Merges two trees in the Union-Find datastructure
	     * @param x a node in the first tree
	     * @param y a node in the second tree
	     */
	    public static void union(UFNode x, UFNode y) {
	        UFNode xRoot = x.findSet();
	        UFNode yRoot = y.findSet();

	        if (xRoot.id == yRoot.id) {
	            return;
	        }
	        if (xRoot.rank < yRoot.rank){
	            xRoot.parent = yRoot;
	        } else if (xRoot.rank > yRoot.rank) {
	            yRoot.parent = xRoot;
	        } else {
	            yRoot.parent = xRoot;
	            xRoot.rank++;
	        }

	    }
	    
	    public double calculateEdge(UFNode that){
	    	int s = this.coordinates.length;
	    	double[][] vectors = new double[2][s];
			vectors[0] = this.coordinates;
			vectors[1] = that.coordinates;
			double[][] M = new double[s][s];
			
			M[0][0] = Math.abs(vectors[0][0] - vectors[1][0]);
			for (int i = 1; i < s; i++) {
				M[0][i] = M[0][i-1] + Math.abs(vectors[0][i] - vectors[1][0]);
			}
			for (int i = 1; i < s; i++) {
				M[i][0] = M[i-1][0] + Math.abs(vectors[1][i] - vectors[0][0]);
			}
			
			for (int i = 1; i < s; i++) {
				for (int j = 1; j < s; j++) {
					double dist = Math.abs(vectors[0][j] - vectors[1][i]);
					M[i][j] = dist + Math.min((M[i-1][j-1] ),  Math.min(M[i-1][j], M[i][j-1]));
					}
				}
			return M[s-1][s-1];
	    }
	}
