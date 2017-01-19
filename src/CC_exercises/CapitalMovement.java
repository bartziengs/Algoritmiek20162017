package CC_exercises;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CapitalMovement {
	
//	public static void main(String[] args) throws IOException{
//		BufferedWriter out = new BufferedWriter(new FileWriter("src/out.out"));
//		System.out.println("yolo");
//		out.write(1+"\n");
//		//char c;
//		for (int i = 0; i < 5000000; i++) {
//			if(i%21 == 0)out.write('A');
//			else out.write('R');
//		}
//		out.flush();
//		out.close();
//	}
	
	public static void main(String[] args){
		BufferedReader br;
		try {
		//br = new BufferedReader(new FileReader("src/assgnmnt_4/sample.in"));
		br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		HashMap<Integer, ArrayList<Integer>> hm;
		//ArrayList<ArrayDeque<Integer>> al; 
		
		while(t-->0){ 
			int n = Integer.parseInt(br.readLine());
			int size = n;
			long temppopulation;
			
			long[] planets = new long[n+1];
			st = new StringTokenizer(br.readLine());
			hm = new HashMap<Integer, ArrayList<Integer>>();
			//al = new ArrayList<ArrayDeque<Integer>>();
			long max = 0;
			int big = 0;
			
			for (int i = 1; i < n+1;   i++) { //READ PLANETS
				temppopulation = Long.parseLong(st.nextToken());
				if(temppopulation > max){
					max = temppopulation;
					big = i;
				}
				planets[i] = temppopulation;
			}
			
			for (int i = 1; i < size; i++) {
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
					if(planets[i] == max || hm.get(i).contains(big)){
					long biggestpop = 0;
					for (int j = 1; j <size+1; j++) {
						if(i != j && !hm.get(i).contains(j)){
						
							if(planets[j]> biggestpop){
								biggestpop = planets[j];
								correctplanet = j;
							}
						}
					}
					}else{
						correctplanet = big;
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
