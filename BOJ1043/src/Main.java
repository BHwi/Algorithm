import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, K, count = 0;
	public static Node[] node;
	public static ArrayList<Integer> party[];
	public static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// N : 사람 수 / M : 파티 수
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		node = new Node[N + 1];
		for(int i = 1; i <= N; i++) node[i] = new Node(i);
		
		party = new ArrayList[M];
		for(int i = 0; i < M; i++) party[i] = new ArrayList<>();
		visited = new boolean[N + 1];
		
		st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < K; i++) {
			node[Integer.parseInt(st.nextToken())].know = true;
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			K = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < K; j++) {
				party[i].add(Integer.parseInt(st.nextToken()));
			}
			
			for(int j = 0; j < K; j++) {
				for(int k = 0; k < K; k++) {
					if(j != k) node[party[i].get(j)].l.add(node[party[i].get(k)]);
				}
			}
		}
		
		bfs();
		
		for(int i = 0; i < party.length; i++) {
			if(check(party[i])) count++;
		}
		
		System.out.println(count);
		
	}
	
	public static class Node {
		ArrayList<Node> l = new ArrayList<>();
		boolean know = false;
		int value;
		
		Node(int value) {
			this.value = value;
		}
	}
	
	public static void bfs() {
		ArrayDeque<Node> q = new ArrayDeque<>();
		
		for(int i = 1; i <= N; i++)
			if(node[i].know) q.add(node[i]);
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			visited[tmp.value] = true;
			
			for(int i = 0; i < tmp.l.size(); i++) {
				if(!visited[tmp.l.get(i) .value]) {
					tmp.l.get(i).know = true;
					q.add(tmp.l.get(i));
				}
			}
		}
	}
	
	public static boolean check(ArrayList<Integer> l) {
		for(int i = 0; i < l.size(); i++) {
			if(node[l.get(i)].know) return false;
		}
		
		return true;
	}
}
