import java.io.*;
import java.util.*;

public class Main {
	public static class Point implements Comparable<Point> {
		int end;
		int weight;
		
		Point(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Point o) {
			return this.weight - o.weight;
		}
	}
	
	public static final int INF = 200000000;
	public static List<Point> list[];
	public static int dist[];
	public static boolean check[];
	public static int N, E;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++)
			list[i] = new ArrayList<>();
		
		dist = new int[N + 1];
		check = new boolean[N + 1];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			list[start].add(new Point(end, weight));
			list[end].add(new Point(start, weight));
		}
		
		st = new StringTokenizer(br.readLine());
		int p1 = Integer.parseInt(st.nextToken());
		int p2 = Integer.parseInt(st.nextToken());
		
		System.out.println(solve(p1, p2));
	}
	
	public static int solve(int p1, int p2) {
		int result1 = 0;
		int result2 = 0;
		
		result1 += dijkstra(1, p1);
		result1 += dijkstra(p1, p2);
		result1 += dijkstra(p2, N);
		
		result2 += dijkstra(1, p2);
		result2 += dijkstra(p2, p1);
		result2 += dijkstra(p1, N);
		
		if(result1 >= INF && result2 >= INF) return -1;
		else return Math.min(result1, result2);
	}
	
	public static int dijkstra(int start, int end) {
		Arrays.fill(dist, INF);
		Arrays.fill(check, false);
		
		PriorityQueue<Point> q = new PriorityQueue<>();
		q.add(new Point(start, 0));
		dist[start] = 0;
		
		while(!q.isEmpty()) {
			Point curPoint = q.poll();
			int curNode = curPoint.end;
			int curWeight = curPoint.weight;
			
			if(check[curNode]) continue;
			check[curNode] = true;
			
			for(int i = 0; i < list[curNode].size(); i++) {
				int nextNode = list[curNode].get(i).end;
				int nextWeight = list[curNode].get(i).weight;
				
				if(!check[nextNode] && dist[nextNode] > curWeight + nextWeight) {
					dist[nextNode] = curWeight + nextWeight;
					q.add(new Point(nextNode, dist[nextNode]));
				}
			}
		}
		
		return dist[end];
	}

}
