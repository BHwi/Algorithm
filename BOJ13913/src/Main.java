import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}
	public static class Node {
		int cur;
		int d;
		
		Node(int cur, int d) {this.cur = cur; this.d = d;}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = stoi(st.nextToken());
		int K = stoi(st.nextToken());
		
		bfs(N, K);
	}
	
	public static void bfs(int N, int K) {
		if(N >= K) {
			System.out.println(N - K);
			for(int i = N; i >= K; i--) System.out.print(i + " ");
			return;
		}
		
		ArrayDeque<Node> q = new ArrayDeque<>();
		
		boolean[] visited = new boolean[222222];
		int[] d = new int[222222];
		int[] parent = new int[222222];
		
		Arrays.fill(d, Integer.MAX_VALUE);
		
		q.add(new Node(N, 0));
		d[N] = 0;
		
		parent[N] = N;
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			int curPoint = curNode.cur;
			int curD = curNode.d;
			
			if(visited[curPoint]) continue;
			visited[curPoint] = true;
			
			if(curPoint == K) {
				Stack<Integer> s = new Stack<>();
				
				for(int i = K; i != parent[N]; i = parent[i]) s.add(i);
				
				System.out.println(s.size());
				
				System.out.print(N + " ");
				
				while(!s.isEmpty()) {
					System.out.print(s.pop() + " ");
				}
				
				return;
			}
			
			int nextPoint, nextD;
			
			if(curPoint + 1 <= 100000) {
				nextPoint = curPoint + 1;
				nextD = curD + 1;
				
				if(d[nextPoint] > nextD) {
					d[nextPoint] = nextD;
					parent[nextPoint] = curPoint;
					q.add(new Node(nextPoint, nextD));
				}
			}
			if(curPoint - 1 >= 0) {
				nextPoint = curPoint - 1;
				nextD = curD + 1;
				
				if(d[nextPoint] > nextD) {
					d[nextPoint] = nextD;
					parent[nextPoint] = curPoint;
					q.add(new Node(nextPoint, nextD));
				}
			}
			if(curPoint * 2 <= 200000) {
				nextPoint = curPoint * 2;
				nextD = curD + 1;
				
				if(d[nextPoint] > nextD) {
					d[nextPoint] = nextD;
					parent[nextPoint] = curPoint;
					q.add(new Node(nextPoint, nextD));
				}
			}
		}
		
	}
	
}
