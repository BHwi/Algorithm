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
		int w;
		
		Node(int end, int w) {
			this.end = end;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	public static final int INF = 100_000;
	public static int N, M, S, E, d[], ans[] = new int[3];
	public static boolean visited[];
	public static ArrayList<Node> list[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		d = new int[N + 1];
		visited = new boolean[N + 1];
		
		Arrays.fill(d, INF);
		
		for(int i = 0; i <= N; i++) list[i] = new ArrayList<>();
		
		while(M --> 0) {
			st = new StringTokenizer(br.readLine());
			
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			list[S].add(new Node(E, 1));
			list[E].add(new Node(S, 1));
		}
		
		bfs();
		
		for(int i = 1; i <= N; i++) {
			if(ans[1] < d[i] && d[i] != INF) {
				ans[0] = i;
				ans[1] = d[i];
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(d[i] == ans[1]) {
				ans[2]++;
			}
		}
		
		System.out.println(ans[0] + " " + ans[1] + " " + ans[2]);
	}
	
	public static void bfs() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.add(new Node(1, 0));
		d[1] = 0;
		visited[1] = true;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int curNode = cur.end;
			int curWeight = cur.w;
			
			for(int i = 0; i < list[curNode].size(); i++) {
				int nextNode = list[curNode].get(i).end;
				int nextWeight = list[curNode].get(i).w;
				
				if(!visited[nextNode] && d[nextNode] > curWeight + nextWeight) {
					visited[nextNode] = true;
					d[nextNode] = curWeight + nextWeight;
					pq.add(new Node(nextNode, d[nextNode]));
				}
			}
		}
	}

}
