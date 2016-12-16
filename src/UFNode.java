
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
	}
