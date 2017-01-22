package assgnmnt_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Task_6 {

	public static void main(String a[]){
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("src/assgnmnt_4/testcases/example1.in"));
			//br = new BufferedReader(new FileReader("src/assgnmnt_4/example.in"));
			int n = Integer.parseInt(br.readLine());
			ArrayList<Node> nodes = new ArrayList<Node>(n);
			int[] st = new int[4];
			Node s = new Node("s",st,0);
			Node t = new Node("t",st,0);
		
			for (int i = 0; i < n; i++) {
				int[] values = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
				nodes.add(new Node(i+1 +"", values,n));
			}
			
			nodes.get(0).incrementTotalcalls(1);
			
			int m = Integer.parseInt(br.readLine());
			ArrayDeque<Functioncall> fc = new ArrayDeque<>(m);
			
			for (int i = 0; i < m; i++) {
				int[] values = Arrays.asList(br.readLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
				fc.add(new Functioncall(values[0], values[1], values[2]));
				nodes.get(values[1]-1).incrementTotalcalls(values[2]);
			}

			int overhead = Integer.parseInt(br.readLine());
			
			for(Node i : nodes){
				s.addEdge(i, i.getTotalcalls()*i.getCompiled() + i.getCompilation());
				i.addEdge(t, i.getNotcompiled() * i.getTotalcalls());
			}
				
			while(!fc.isEmpty()){
				Functioncall temp = fc.poll();
				if(!(nodes.get(temp.getFrom()-1).containsEdge(nodes.get(temp.getTo()-1)))){
					nodes.get(temp.getFrom()-1).addEdge(nodes.get(temp.getTo()-1), temp.getAmount()*overhead);
					nodes.get(temp.getTo()-1).addEdge(nodes.get(temp.getFrom()-1), temp.getAmount()*overhead);
			}
			}
			
			
			
			
			Graph g = new Graph(nodes, s, t);

			
			MaxFlow.maximizeFlow(g);
			
			int res = 0;
			for(Edge e : s.getEdges()){
				res += e.getFlow();
			}
						
			System.out.println("Maximum flow : "+res);
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	}
	


