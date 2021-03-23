import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	
	public static class Node {
		int number;
		int weight;
		
		Node (int end, int weight) {
			this.number = end;
			this.weight = weight;
		}
	}
	
	public static ArrayList<Node> list[];
	public static int d[], max, index;
	public static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N + 1];
		d = new int[N + 1];
		visited = new boolean[N + 1];
		
		for(int i = 0; i <= N; i++) 
			list[i] = new ArrayList<>();
		
		for(int i = 1; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			list[S].add(new Node(E, W));
			list[E].add(new Node(S, W));
		}
		
		if(N > 1) {
			dfs(1, 0);
			visited = new boolean[N + 1];
			d = new int[N + 1];
			dfs(index, 0);
			System.out.println(max);
		}
		else 
			System.out.println(0);
		
	}
	
	public static void dfs(int node, int weight) {
		d[node] = weight;
		visited[node] = true;
		
		if(weight > max) {
			max = weight;
			index = node;
		}
		
		for(Node next : list[node]) {
			if(!visited[next.number])
				dfs(next.number, weight + next.weight);
		}
	}

}
