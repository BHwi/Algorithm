import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Node implements Comparable<Node>{
		int end;
		int weight;
		
		Node (int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
		
	}
	public static final int INF = 1000000000;
	public static ArrayList<Node> list[];
	public static int[] d;
	public static boolean[] visited;
	public static int long_node, long_weight, V;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		
		list = new ArrayList[V + 1];
		
		for(int i = 0; i < V + 1; i++) list[i] = new ArrayList<>();
		
		for(int i = 0; i < V; i++) {
			st = new StringTokenizer(br.readLine());
			
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			while(E != -1) {
				list[S].add(new Node(E, W));
				list[E].add(new Node(S, W));
				
				E = Integer.parseInt(st.nextToken());
				if(E != -1) W = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(1);
		
		System.out.println(solve(long_node));
		
		
	}
	
	public static int solve(int start) {
		d = new int[V + 1];
		visited = new boolean[V + 1];
		
		Arrays.fill(d, INF);
		
		d[start] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int curNode = cur.end;
			int curWeight = cur.weight;
			
			visited[curNode] = true;
			
			for(int i = 0; i < list[curNode].size(); i++) {
				int nextNode = list[curNode].get(i).end;
				int nextWeight = list[curNode].get(i).weight;
				
				if(!visited[nextNode] && d[nextNode] > curWeight + nextWeight) {
					d[nextNode] = curWeight + nextWeight;
					pq.add(new Node(nextNode, d[nextNode]));
				}
			}
		}
		
		long_weight = 0;
		long_node = 0;
		
		for(int i = 1; i <= V; i++) {
			if(d[i] > long_weight) {
				long_node = i;
				long_weight = d[i];
			}
		}
		
		return long_weight;
	}

}
