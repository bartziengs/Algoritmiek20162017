import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Task_A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("src/A/Datasets/sample2.in"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			double[] coordinates = new double[m];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				coordinates[j] = Double.parseDouble(st.nextToken());
			}
			UFNode node =  new UFNode(i, coordinates);
			System.out.println(node.toString());
		}
		br.close();
	}

}
