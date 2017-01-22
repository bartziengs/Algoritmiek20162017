package CC_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class longest_increasing_subsequence {

	public static void main(String[] args){
		ArrayList<Integer> seq = new ArrayList<>(9);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			while(n-->0){
				int t = Integer.parseInt(br.readLine());
				int[] values = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
				int[] tekst = new int[t];
				tekst[0] = 1;
				seq.add(1);
				for (int i = 1; i < t; i++) {
					if(values[i] == 1){
						tekst[i] = 0;
						
					}else{ 
						if(values[i] == values[i+1]){
							tekst[i] = tekst[i-1]+2;
							seq.add(tekst[i-1]+2);
						}
						if(values[i] > values[i+1]){
							
						}
						if(values[i] < values[i+1]){
							int temp =  seq.get(seq.size()-1)+1;
							tekst[i] = temp;
							seq.add(temp);
						}
					}	
					
				}
				
			}
			
			
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
