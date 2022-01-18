import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}
	public static class Edge implements Comparable<Edge>{
		int s, e, w;
		
		Edge(int s, int e, int w) {
			this.s = s;
			this.e = e;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			return this.w - o.w;
		}
	}
	public static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		
		parent = new int[N + 1];
		Edge[] edge = new Edge[M];
		
		for(int i = 0; i <= N; i++) parent[i] = i;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = stoi(st.nextToken());
			int e = stoi(st.nextToken());
			int w = stoi(st.nextToken());
			
			edge[i] = new Edge(s, e, w);
		}
		
		Arrays.sort(edge);
		
		int answer = 0;
		
		ArrayList<Edge> list = new ArrayList<>();
		
		for(int i = 0; i < M; i++) {
			if(find(edge[i].s) != find(edge[i].e)) {
				union(edge[i].s, edge[i].e);
				answer += edge[i].w;
				list.add(edge[i]);
			}
		}
		
		System.out.println(answer - list.get(list.size() - 1).w);
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
	
	public static int find(int x) {
		if(parent[x] == x) return x;
		else return find(parent[x]);
	}

}
