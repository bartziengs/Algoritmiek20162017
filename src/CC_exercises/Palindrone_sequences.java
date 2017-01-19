package CC_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Palindrone_sequences {
	
	public static void main(String[] args){
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			int n = Integer.parseInt(br.readLine());
			int[] values = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
			int totalpalin = 0;
			int[][]M = new int[n][n];
			
			M[0][0] = 1;
			
			//System.out.println(printArray(M));
			for (int i = 1; i < n; i++) {
				for (int j = 0; j < i+1; j++) {
					M[i][j] = Math.min(j+isPalindrome(Arrays.copyOfRange(values, j, i+1)), 1+M[i-1][j]);
					}
			}
			int[] temp = Arrays.copyOfRange(values, 0, 2);
			System.out.println("this is subarray");
			for(int p: temp)System.out.print(p +" ");
			System.out.println("");
			
			
			System.out.println(printArray(M));
			System.out.println("value"+M[n-1][n-1]);
			br.close();
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static int isPalindrome(int[] values){
		int n = values.length;
		if(n ==1)return 1;
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i < n/2.0; i++) {
			s.push(values[i]);
		}
		if(n%2 != 0)s.pop();
		for (int i = (int)Math.ceil(n/2.0); i <= n-1; i++){
			if(s.pop() != values[i])return 1;
		}
		return Integer.MAX_VALUE-2000;
	}
	
	public static String printArray(int M[][]){
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
