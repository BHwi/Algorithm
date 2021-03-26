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
		
		Node (int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	public static final int INF = 100 * 10_000;
	public static int N, M, X, S, E, W;
	public static ArrayList<Node> list1[], list2[];
	public static int[] d1, d2;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list1 = new ArrayList[N + 1];
		list2 = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++) {
			list1[i] = new ArrayList<>();
			list2[i] = new ArrayList<>();
		}
		
		while(M --> 0) {
			st = new StringTokenizer(br.readLine());
			
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			list1[E].add(new Node(S, W));
			list2[S].add(new Node(E, W));
		}
		
		d1 = dijkstra(list1, X);
		d2 = dijkstra(list2, X);
		
		int ans = 0;
		
		for(int i = 1; i <= N; i++) 
			ans = Math.max(ans, d1[i] + d2[i]);
		
		System.out.println(ans);
	}
	
	public static int[] dijkstra(ArrayList<Node>[] list, int start) {
		int[] d = new int[N + 1];
		visited = new boolean[N + 1];
		
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
		
		return d;
	}

}
