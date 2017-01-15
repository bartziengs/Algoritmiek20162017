package assgnmnt_3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Task_A {

	public static void main(String[] args) {
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("src/assgnmnt_3/A/Datasets/sample2.in"));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Graph graph = new Graph();
		
		for (int i = 0; i < n; i++) {
			double[] coordinates = new double[m];
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				coordinates[j] = Double.parseDouble(st.nextToken());
			}
			graph.addNode(new UFNode(i, coordinates));
		}
		
		for (int i = 0; i < n-1; i++) {
			UFNode node0 = graph.nodes.get(i);
				for (int j = i+1; j < n; j++) {
					UFNode node1 = graph.nodes.get(j);
					graph.edges.add(new Edge(node0, node1));
				}
		}
		br.close();
		double res = 0;
		int a = 0;
		while(a < n-k) {
			Edge e = graph.edges.poll();
			UFNode from = graph.nodes.get(e.from);
			UFNode to = graph.nodes.get(e.to);
				if(from.findSet() != to.findSet()){
					UFNode.union(from, to);
					res += e.weight;
					a++;
				}
					
		}
		//Double.toString(res);
		 
		System.out.println(res);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
