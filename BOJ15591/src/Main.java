import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static class Node{
		int end;
		long weight;
		
		Node(int end, long weight) {
			this.end = end;
			this.weight = weight;
		}
	}
	public static ArrayList<Node> list[];
	public static int N, Q;
	public static final long MAX = (long) 1_000_000_000 * (long) 5_001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];
		
		for(int i = 0; i <= N; i++) list[i] = new ArrayList<>();
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			list[s].add(new Node(e, w));
			list[e].add(new Node(s, w));
		}
		
		for(int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			
			long k = Long.parseLong(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			sb.append(dijkstra(k, v) + "\n");
		}
		
		System.out.print(sb.toString());
	}
	
	public static int dijkstra(long k, int v) {
		int answer = 0;
		ArrayDeque<Node> q = new ArrayDeque<>();
		
		q.add(new Node(v, MAX));
		boolean[] visited = new boolean[N + 1];
		visited[v] = true;
		
		while(!q.isEmpty()) {
			Node node = q.poll();
			int curNode = node.end;
			long weight = node.weight;
			
			for(int i = 0; i < list[curNode].size(); i++) {
				if(visited[list[curNode].get(i).end]) continue;
				if(list[curNode].get(i).weight < k) continue;
				
				answer++;
				q.add(new Node(list[curNode].get(i).end, list[curNode].get(i).weight));
				visited[list[curNode].get(i).end] = true;
			}
		}
		
		return answer;
	}

}
