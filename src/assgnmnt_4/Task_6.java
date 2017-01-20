package assgnmnt_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Task_6 {

	public static void main(String a[]){
		BufferedReader br;
		try {
			//br = new BufferedReader(new FileReader("src/assgnmnt_4/testcases/example1.in"));
			br = new BufferedReader(new FileReader("src/assgnmnt_4/example.in"));
			int n = Integer.parseInt(br.readLine());
			ArrayList<Node> nodes = new ArrayList<Node>(n);
			int[] st = new int[4];
			Node s = new Node("s",st,0);
			Node t = new Node("t",st,0);
		
			for (int i = 0; i < n; i++) {
				int[] values = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
				nodes.add(new Node(i+1 +"", values,n));
			}
			
			int m = Integer.parseInt(br.readLine());
			for (int i = 0; i < m; i++) {
				int[] values = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();

					nodes.get(values[1]-1).setCallsfrom(values[0], values[2]);
					nodes.get(values[1]-1).incrementTotalcalls(values[2]);
			}
			
			if(nodes.get(0).getTotalcalls() == 0){
			nodes.get(0).incrementTotalcalls(1);
			}
			
			int overhead = Integer.parseInt(br.readLine());
			
			for(Node i : nodes){
				if(i.getTotalcalls() > 0){
				s.addEdge(i, i.getNotcompiled() * i.getTotalcalls());
				i.addEdge(t, (i.getTotalcalls()*i.getCompiled()) + i.getCompilation());
				for (int j = 0; j < n; j++) {
					if(i.getCallsfrom()[j] != 0){
						if(!nodes.get(j).containsEdge(i) && i.containsEdge(nodes.get(j))){
						nodes.get(j).addEdge(i, (i.getCallsfrom()[j])*overhead);
						}
					}
				}
				}
				
			}
			
			Graph g = new Graph(nodes, s, t);
//			for(Node n2 : nodes){
//				System.out.println(n2);
//			}
			
			MaxFlow.maximizeFlow(g);
			
			int res = 0;
			for(Edge e : s.getEdges()){
				res += e.getFlow();
			}
			
						
			System.out.println("this :"+res);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
