package assgnmnt_3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Task_E {
	
	public static void main(String[] args) {
		BufferedReader br;
		long startTime = System.currentTimeMillis();
		try {
			br = new BufferedReader(new FileReader("src/assgnmnt_3/E/Datasets/sample12500.in"));
		
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			double delta = Double.parseDouble(st.nextToken()); 
			double[][] vectors = new double[2][n];
			double[][] M = new double[n][n];
			
			for (int i = 0; i < 2; i++) {
				double[] coordinates = new double[n];
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					coordinates[j] = Double.parseDouble(st.nextToken());
				}
				vectors[i] = coordinates;
				
			}
			br.close();
			M[0][0] = Math.abs(vectors[0][0] - vectors[1][0]);
			for (int i = 1; i < n; i++) {
				M[0][i] = M[0][i-1] + Math.abs(vectors[0][i] - vectors[1][0]);
			}
			for (int i = 1; i < n; i++) {
				M[i][0] = M[i-1][0] + Math.abs(vectors[1][i] - vectors[0][0]);
			}
			
			
			//big for loop
			for (int i = 1; i < n; i++) {
				for (int j = 1; j < n; j++) {
					if( delta != 0 && Math.abs(Math.abs(vectors[1][i] - vectors[0][j]) ) > delta){
						M[i][j] = Double.MAX_VALUE;
					}else{
					double dist = Math.abs(vectors[0][j] - vectors[1][i]);
					M[i][j] = dist + Math.min((M[i-1][j-1] ),  Math.min(M[i-1][j], M[i][j-1]));
					}
				}
				
			}
		System.out.println(M[n-1][n-1]);
		long stopTime = System.currentTimeMillis();
	      long elapsedTime = stopTime - startTime;
	      System.out.println("Total time taken "+elapsedTime+"ms");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static String printArray(double M[][]){
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < M[0].length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				sb.append(M[i][j]+ " ");
			}
			sb.append("\n");
		}
		return sb.toString();
	}

}
