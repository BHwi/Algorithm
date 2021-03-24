import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

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
	public static final int INF = 10000001;
	public static int N, M;
	public static ArrayList<Point> list[];
	public static int[] d;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N + 1];
		for(int i = 0; i < N + 1; i++) list[i] = new ArrayList<>();
		
		d = new int[N + 1];
		visited = new boolean[N + 1];
		
		while(M --> 0) {
			st = new StringTokenizer(br.readLine());
			
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			list[S].add(new Point(E, W));
		}
		
		for(int i = 1; i <= N; i++) {
			Arrays.fill(d, INF);
			Arrays.fill(visited, false);
			
			d[i] = 0;
			
			dijkstra(i);
			
			for(int j = 1; j <= N; j++) {
				System.out.print((d[j] == INF ? 0 : d[j]) + " ");
			}
			
			System.out.println();
		}

	}
	
	public static void dijkstra(int i) {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		
		pq.add(new Point(i, 0));
		
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			int curPoint = p.end;
			int curWeight = p.weight;
			
			visited[curPoint] = true;
			
			for(int j = 0; j < list[curPoint].size(); j++) {
				int nextPoint = list[curPoint].get(j).end;
				int nextWeight = list[curPoint].get(j).weight;
				
				if(!visited[nextPoint] && d[nextPoint] > curWeight + nextWeight) {
					d[nextPoint] = curWeight + nextWeight;
					pq.add(new Point(nextPoint, d[nextPoint]));
				}
			}
		}
		
	}

}
