package assgnmnt_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PreciousStones {
	
	public static void main(String[] args){
		
		BufferedReader br; 
		try {
			//br = new BufferedReader(new FileReader("src/out.out"));
			br = new BufferedReader(new InputStreamReader(System.in));
			int n = Integer.parseInt(br.readLine());
			for (int i = 1; i < n+1; i++) {
			String chain = br.readLine();
			int templongest = 1, longest = 1, seclongest = 1;
			char previous = chain.charAt(0);
				for (int j = 1; j < chain.length(); j++) {
					if(chain.charAt(j) == previous){
						previous = chain.charAt(j);
						templongest++;
						if(templongest >= longest){
							seclongest = longest;
							longest = templongest;
						}
					}else{
						previous = chain.charAt(j);
						templongest = 1;
					}
				}
			
				if(longest < n){
				for (int j = 0; j < longest; j++) {
					if(chain.charAt(j) == previous){
						previous = chain.charAt(j);
						templongest++;
						if(templongest >= longest){
							seclongest = longest;
							longest = templongest;
						}
					}else{
						previous = chain.charAt(j);
						templongest = 1;
					}
				}
				}
			int res = (templongest + longest == 4) && longest == 2 ? 3 : (int)Math.max(Math.floor(longest/2), seclongest); 	
			System.out.println("Case "+i+": "+res);	
			}
			br.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			
			
		}

}
