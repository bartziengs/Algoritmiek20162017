package assgnmnt_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args){
	BufferedReader br;
	try {
	br = new BufferedReader(new FileReader("src/assgnmnt_4/sample.in"));
	//br = new BufferedReader(new InputStreamReader(System.in));
	int t = Integer.parseInt(br.readLine());
	int n,m,l;
		while(t-->0){
			String[] nmval = br.readLine().split(" ");
			n = l = Integer.parseInt(nmval[0]);
			m = Integer.parseInt(nmval[1]);
			System.out.println(n+" "+m);
			String[][] nm = new String[n][m];
				while(n-- > 0){		
					nm[n] = br.readLine().split("");
				}
		//		isStable(nm);
		}
	
	br.close();
		
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
		
	}
	
//	public static String isStable(String[][] nm){
//		
//		
//		
//		return "yes";
//	}
	
	
	public static void printArray(String[] input){
	
		for(String c : input){
			System.out.println(c);
		}
		System.out.println("END");

	}
	
}
