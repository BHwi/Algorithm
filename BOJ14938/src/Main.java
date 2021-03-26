import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Node implements Comparable<Node> {
		int end;
		int weight;
		
		Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	public static final int INF = 10000;
	public static int N, M, R, max = 0;
	public static int[] cost;
	public static ArrayList<Node> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		cost = new int[N + 1];
		list = new ArrayList[N + 1];
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) 
			cost[i] = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i <= N; i++)
			list[i] = new ArrayList<>();
		
		while(R --> 0) {
			st = new StringTokenizer(br.readLine());
			
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			list[S].add(new Node(E, C));
			list[E].add(new Node(S, C));
		}
		
		for(int i = 1; i <= N; i++) {
			max = Math.max(max, solve(i));
		}
		
		System.out.println(max);
	}
	
	public static int solve(int start) {
		int[] d = new int[N + 1];
		boolean[] visited = new boolean[N + 1];
		
		Arrays.fill(d, INF);
		d[start] = 0;
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		q.add(new Node(start, 0));
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int curNode = cur.end;
			int curWeight = cur.weight;

			visited[curNode] = true;
			
			for(int i = 0; i < list[curNode].size(); i++) {
				int nextNode = list[curNode].get(i).end;
				int nextWeight = list[curNode].get(i).weight;
				
				if(!visited[nextNode] && d[nextNode] > curWeight + nextWeight) {
					d[nextNode] = curWeight + nextWeight;
					q.add(new Node(nextNode, d[nextNode]));
				}
			}
		}
		
		int ans = 0;
		
		for(int i = 1; i <= N; i++) {
			if(d[i] <= M) ans += cost[i]; 
		}
		
		return ans;
	}

}
