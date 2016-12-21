
public class test {

	
	public static void main(String[] boodschap){
		double[] vx = new double[4];
		double[] vy = new double[4];
		
		vx[0] = 1;
		vx[1] = 2;
		vx[2] = 2.4;
		vx[3] = 3.5;
		
		vy[0] = 2;
		vy[1] = 2.1;
		vy[2] = 2;
		vy[3] = 3.2;
		UFNode x = new UFNode(0, vx);
		UFNode y = new UFNode(1, vy);
		double res = x.calculateEdge(y);
		System.out.println(res);
	}
}
