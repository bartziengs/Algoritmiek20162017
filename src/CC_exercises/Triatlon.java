package CC_exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Triatlon {
	
	public static void main(String[] args){
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			String[] vals = new String[3];
			//int tp = 0,tr = 0;
			PriorityQueue<Participant> pq = new PriorityQueue<Participant>(n);
			while(n-- > 0){
				vals = br.readLine().split(" ");
				pq.add(new Participant(Integer.parseInt(vals[0]), Integer.parseInt(vals[1]) + Integer.parseInt(vals[2])));
			}
			int finishtime = 0;
			Participant p = pq.poll();
			finishtime += p.tprogramming;
			int pmax = p.trest + p.tprogramming;
			int tempmax = 0;
			while(!pq.isEmpty()){
				p = pq.poll();
				finishtime += p.tprogramming;
				tempmax = p.trest + p.tprogramming;
				pmax = tempmax > pmax ? tempmax : pmax;
			}
			finishtime += p.trest;
			System.out.println(Math.max(pmax,finishtime));
			
			
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}