import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}
	public static double stod(String s) {return Double.parseDouble(s);}
	public static class Edge implements Comparable<Edge> {
		int start, end;
		double w;
		
		Edge(int s, int e, double w) {
			this.start = s;
			this.end = e;
			this.w = w;
		}
		
		@Override
		public int compareTo(Edge o) {
			if(this.w - o.w > 0) return 1;
			else if(this.w - o.w == 0) return 0;
			else return -1;
		}
	}
	public static class Point {
		double x, y;
		
		Point(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		double answer = 0;
		int N = stoi(br.readLine());
		parent = new int[N];
		Point[] point = new Point[N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			point[i] = new Point(stod(st.nextToken()), stod(st.nextToken()));
		}
		
		ArrayList<Edge> list = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i == j) continue;
				else {
					list.add(new Edge(i, j, d(point[i].x, point[j].x, point[i].y, point[j].y)));
				}
			}
		}
		
		Collections.sort(list);
		
		for(int i = 0; i < N; i++) parent[i] = i;
		
		for(int i = 0; i < list.size(); i++) {
			Edge e = list.get(i);
			
			if(find(e.start) != find(e.end)) {
				union(e.start, e.end);
				answer += e.w;
			}
		}
		
		System.out.println(answer);
	}
	
	public static double d(double x1, double x2, double y1, double y2) {
		double tmp = (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
		
		return Math.sqrt(tmp);
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
