import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Node implements Comparable<Node> {
		int end, weight;
		
		Node (int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	public static final int INF = 100000;
	public static int N, M, x, y, i, j, d[];
	public static boolean visited[];
	public static ArrayList<Node> list[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N + 1];
		d = new int[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 1; i <= N; i++) list[i] = new ArrayList<>();
		Arrays.fill(d, INF);
		
		st = new StringTokenizer(br.readLine());
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		
		while(M --> 0) {
			st = new StringTokenizer(br.readLine());
			
			i = Integer.parseInt(st.nextToken());
			j = Integer.parseInt(st.nextToken());
			
			list[i].add(new Node(j, 1));
			list[j].add(new Node(i, 1));
		}
		
		solve(x);
		
		System.out.println(d[y] == INF ? "-1" : d[y]);
	}
	
	public static void solve(int start) {
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		q.add(new Node(start, 0));
		visited[start] = true;
		d[start] = 0;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int curNode = cur.end;
			int curWeight = cur.weight;
			
			for(int i = 0; i < list[curNode].size(); i++) {
				int nextNode = list[curNode].get(i).end;
				int nextWeight = list[curNode].get(i).weight;
				
				if(!visited[nextNode] && d[nextNode] > curWeight + nextWeight) {
					d[nextNode] = curWeight + nextWeight;
					visited[nextNode] = true;
					q.add(new Node(nextNode, d[nextNode]));
				}
			}
		}
	}
}
