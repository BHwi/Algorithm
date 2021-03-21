import java.io.*;
import java.util.*;

public class Main {	
	
	public static class Node implements Comparable<Node>{
		int end;
		int weight;
		
		Node (int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
	
		@Override
		public int compareTo(Main.Node o) {
			// TODO Auto-generated method stub
			return weight - o.weight;
		}
	}
	
	public static final int MAX_COST = 987654321;
	public static int[] d;
	public static int[][] map;
	public static boolean[] visited;
	public static ArrayList<ArrayList<Node>> a;
	public static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		d = new int[N + 1];
		map = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		a = new ArrayList<>();
		
		Arrays.fill(d, MAX_COST);
		
		for(int i = 0; i <= N; i++) {
			a.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			a.get(start).add(new Node(end, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		System.out.println(dijkstra(start, end));
		
	}
	
	public static int dijkstra(int start, int end) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[N + 1];
		pq.offer(new Node(start, 0));
		d[start] = 0;
		
		while(!pq.isEmpty()) {
			Node tmp = pq.poll();
			int current = tmp.end;
			
			if(!check[current]) {
				check[current] = true;
				
				for(Node node : a.get(current)) {
					if(!check[node.end] && d[node.end] > d[current] + node.weight) {
						d[node.end] = d[current] + node.weight;
						pq.add(new Node(node.end, d[node.end]));
					}
				}
			}
		}
		
		return d[end];
	}
	

}
