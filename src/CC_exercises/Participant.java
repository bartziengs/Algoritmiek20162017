package CC_exercises;

 public class Participant implements Comparable<Participant>{
	
	public int tprogramming;
	public int trest;
	
	public Participant(int tprogramming, int trest){
		this.tprogramming = tprogramming;
		this.trest = trest;
	}



	@Override
	public int compareTo(Participant o) {
		return this.trest == o.trest ? 0 : this.trest < o.trest ? 1 : -1;
	}
}