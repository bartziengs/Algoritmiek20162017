package assgnmnt_4;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.BufferedReader;

public class Cats_dogs {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
			Scanner sc; 
			//sc = new Scanner(new FileReader("src/assgnmnt_4/sample.in"));
			sc = new Scanner(System.in);
			int n = sc.nextInt();
			//System.out.println(n);
			
			while(n-- > 0){
			long c = sc.nextLong();
			long d = sc.nextLong();
			long l = sc.nextLong();
			
			boolean p= true;
			
			if(l%4 != 0){ // multiple of four and at least 4 times the amount of dogs of legs
				p = false;
			}else if((c+d)*4 < l){
				p = false;
			}
			else {
				if(c> 2*d){
					if(l < (d+(c-(2*d))*4)){
						p = false;
					}else if(l < d*4){
						p = false;
					}
				}
			}
			
			String res = p ? "yes" : "no";
			System.out.println(res);
			}
			
			
			}

}


//else if(l<      (d+(     (c>2*d)  ? (c-(2*d)) : 0 )      )*4){



