import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static LinkedList<Integer> list[];
	public static int min_length = 100000;
	public static int min_Node = 0;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		list = new LinkedList[N + 1];
		
		for(int i = 1; i <= N; i++) 
			list[i] = new LinkedList<Integer>();
		
		while(M --> 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i = 1; i <= N; i++) {
			PriorityQueue<Node> pq = new PriorityQueue<>();
			boolean[] visited = new boolean[N + 1];
			Node[] d = new Node[N + 1];
			
			for(int j = 1; j <= N; j++) {
				d[j] = new Node(j, 100000);
			}
			
			pq.add(d[i]);
			d[i].val = 0;
			
			while(!pq.isEmpty()) {
				Node now = pq.poll();
				visited[now.idx] = true;
				
				Iterator<Integer> itr = list[now.idx].iterator();
				
				while(itr.hasNext()) {
					int tmp = itr.next();
					d[tmp].val = Math.min(d[tmp].val, d[now.idx].val + 1);
					if(!visited[tmp]) {
						pq.add(d[tmp]);
					}
				}
			}
			
			int count = 0;
			for(int j = 1; j <= N; j++) 
				count += d[j].val;
			
			if(count < min_length) {
				min_Node = i;
				min_length = count;
			}
		}
		
		System.out.println(min_Node);

	}
	
	public static class Node implements Comparable<Node> {
		int idx;
		int val;
		
		Node(int idx, int val) {
			this.idx = idx;
			this.val = val;
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.val - o.val;
		}
		
	}

}
