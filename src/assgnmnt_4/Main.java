package assgnmnt_4;

//import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args){
	BufferedReader br;
	try {
	//br = new BufferedReader(new FileReader("src/assgnmnt_4/sample.in"));
	br = new BufferedReader(new InputStreamReader(System.in));
	int t = Integer.parseInt(br.readLine());
	int n,m;
		while(t-->0){
			String[] nmval = br.readLine().split(" ");
			n = Integer.parseInt(nmval[0]);
			m = Integer.parseInt(nmval[1]);
			char[][] nm = new char[n][m];
				while(n-- > 0){		
					nm[n] = br.readLine().toCharArray();
				}
				System.out.println(isStable(nm));
		}
	
	br.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
		
	}
	
	public static String isStable(char[][] nm){
		int n = nm.length;
		int m = nm[0].length;
		char c;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				c = nm[i][j];
				switch (c) 
				{
				case 'B': 	if(i == 0)break;
							if(nm[i-1][j] == 'A'  || nm[i-1][j] == 'W')return "no";
							break;
							
				case 'W': 	if(j == 0 || j == m-1)return "no";
							if(i != 0 && nm[i-1][j] == 'A')return "no";
							if(nm[i][j-1] == 'A' || nm[i][j+1] == 'A')return "no";
							break;
							
				default:	break;			
				}
			}
		}
		return "yes";
	}
}
