package assgnmnt_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CapitalMovement {
	
	public static void main(String[] args){
		BufferedReader br;
		try {
		//br = new BufferedReader(new FileReader("src/assgnmnt_4/sample.in"));
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		HashMap<Integer, ArrayList<Integer>> hm;
		
		while(t-->0){ //TESTCASES
			int n = Integer.parseInt(br.readLine());
			int size = n;
			long temppopulation;
			
			long[] planets = new long[n+1];
			st = new StringTokenizer(br.readLine());
			hm = new HashMap<Integer, ArrayList<Integer>>(n+1);
			
			for (int i = 1; i < n+1;   i++) { //READ PLANETS
				temppopulation = Long.parseLong(st.nextToken());
				planets[i] = temppopulation;
			}
			
			
				while(n-->1){
				String[] vals = br.readLine().split(" ");
				int from = Integer.parseInt(vals[0]);
				int to = Integer.parseInt(vals[1]);
				hm.putIfAbsent(from, new ArrayList<Integer>());
				hm.get(from).add(to);
				hm.putIfAbsent(to, new ArrayList<Integer>());
				hm.get(to).add(from);
				}
		
				for (int i = 1; i < size+1; i++){
					int correctplanet = 0;
					long biggestpop = 0;
					for (int j = 1; j <size+1; j++) {
						System.out.println(i);
						if(i != j && !hm.get(i).contains(j)){
						
							if(planets[j]> biggestpop){
								biggestpop = planets[j];
								correctplanet = j;
							}
						}
					}
				System.out.print(correctplanet+" ");	
				}
				
                System.out.println("");

				} 
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
			
		}
	
	
	

}
