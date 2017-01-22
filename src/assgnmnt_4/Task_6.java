package assgnmnt_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Task_6 {

	public static void main(String a[]){
		BufferedReader br;
		try {
			
			//br = new BufferedReader(new FileReader("src/assgnmnt_4/testcases/example3.in"));
			br = new BufferedReader(new FileReader("src/assgnmnt_4/example.in"));
			
			int n = Integer.parseInt(br.readLine());
			ArrayList<Node> nodes = new ArrayList<Node>(n);
			
			int[] st = new int[3];
			Node s = new Node("s",st);
			Node t = new Node("t",st);
			
			
			//adding nodes and reading capacities of edges
			for (int i = 0; i < n; i++) {
				int[] values = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
				nodes.add(new Node(Integer.toString(i+1), values));
			}

			int m = Integer.parseInt(br.readLine());
			
			for (int i = 0; i < m; i++) {
				int[] values = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
				nodes.get(values[0]-1).getCallsTo().add(Arrays.copyOfRange(values, 1, 3));
				nodes.get(values[1]-1).incrementTotalcalls(values[2]);
			}
			
			int overhead = Integer.parseInt(br.readLine());
			nodes.get(0).incrementTotalcalls(1); //because main is always called once
			br.close();
			
			//adding edges
			for(Node i : nodes){
				s.addEdge(i, i.getTotalcalls()*i.getCompiled() + i.getCompilation());
				i.addEdge(t, i.getNotcompiled() * i.getTotalcalls());
				for(int[] c : i.getCallsTo()){
					if(!i.containsEdge(nodes.get(c[0]-1))){
					i.addEdge(nodes.get(c[0]-1), c[1]*overhead);
					nodes.get(c[0]-1).addEdge(i, c[1]*overhead);
					}
				}
			}			
			
			MaxFlow.maximizeFlow(new Graph(nodes, s, t));
			
			int res = 0;
			for(Edge e : s.getEdges()){
				res += e.getFlow();
			}
			System.out.println(res);
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}
	


