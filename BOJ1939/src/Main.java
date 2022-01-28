import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}
	public static class Edge implements Comparable<Edge>{
		int s, e, v;
		
		Edge(int s, int e, int v) {
			this.s = s;
			this.e = e;
			this.v = v;
		}
		
		@Override
		public int compareTo(Edge o) {
			return o.v - this.v;
		}
	}
	public static int[] parent;
	public static final int INF = 1_000_000_000;
	public static int answer = INF;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		Edge[] edge = new Edge[M];
		parent = new int[N + 1];
		
		for(int i = 0; i <= N; i++) parent[i] = i; 
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = stoi(st.nextToken());
			int e = stoi(st.nextToken());
			int v = stoi(st.nextToken());
			
			edge[i] = new Edge(s, e, v);
		}
		
		Arrays.sort(edge);
		st = new StringTokenizer(br.readLine());
		int s = stoi(st.nextToken());
		int e = stoi(st.nextToken());
		
		for(int i = 0; i < M; i++) {
			answer = edge[i].v;
			union(edge[i].s, edge[i].e);
			
			if(find(s) == find(e)) break;
		}
		
		System.out.println(answer);
		
	}
	
	public static void union(int a, int b) {
		a = find(a);
		b = find(b);
	
		if(a > b) {
			parent[a] = b;
		}
		else {
			parent[b] = a;
		}
	}
	
	public static int find(int n) {
		if(n == parent[n]) return n;
		else return parent[n] = find(parent[n]);
	}


}
