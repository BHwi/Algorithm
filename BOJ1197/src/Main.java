import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}
	public static class Edge implements Comparable<Edge>{
		int from, to, weight;
		
		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}
	public static int V, E, parent[];
	public static Edge[] edgeList;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = stoi(st.nextToken());
		E = stoi(st.nextToken());
		
		edgeList = new Edge[E];
		parent = new int[V + 1];
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());	
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			int c = stoi(st.nextToken());
			
			edgeList[i] = new Edge(a, b, c);
		}
		
		System.out.println(kruskal());
	}
	
	public static int kruskal() {
		int res = 0, count = 0;
		
		Arrays.sort(edgeList);
		make();
		
		for(Edge edge : edgeList) {
			if(union(edge.from, edge.to)) {
				res += edge.weight;
				
				if(++count == V - 1) return res;
			}
		}
		
		return res;
	}
	
	public static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parent[aRoot] = bRoot;
		return true;
	}
	
	public static int find(int a) {
		if(a == parent[a]) return a;
		return parent[a] = find(parent[a]);
	}
	
	public static void make() {
		for(int i = 1; i <= V; i++) {
			parent[i] = i;
		}
	}
}