import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Node implements Comparable<Node>{
		int end;
		int weight;
		
		Node(int end, int weight) {this.end = end; this.weight = weight;}
		
		@Override
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	public static int N;
	public static ArrayList<Node>[] list;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int point = 100;
		ArrayList<Integer> answer = new ArrayList<>();
		
		N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		
		for(int i = 0; i <= N; i++) list[i] = new ArrayList<>();
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1) {
				break;
			}
			
			list[a].add(new Node(b, 1));
			list[b].add(new Node(a, 1));
		}
		
		for(int i = 1; i <= N; i++) {
			int p = dijkstra(i);
			
			if(point < p) {
				continue;
			}
			else if(point == p) {
				answer.add(i);
			}
			else {
				point = p;
				answer = new ArrayList<>();
				answer.add(i);
			}
		}
		
		System.out.println(point + " " + answer.size());
		for(int i = 0; i < answer.size(); i++) {
			System.out.print(answer.get(i) + " ");
		}
	}
	
	public static int dijkstra(int start) {
		boolean[] visited = new boolean[N + 1];
		int[] d = new int[N + 1];
		
		Arrays.fill(d, 100);
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		q.add(new Node(start, 0));
		d[start] = 0;
		visited[start] = true;
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int curNode = cur.end;
			int curWeight = cur.weight;
			
			for(int i = 0; i < list[curNode].size(); i++) {
				Node next = list[curNode].get(i);
				int nextNode = next.end;
				int nextWeight = next.weight;
				
				if(!visited[nextNode] && curWeight + nextWeight < d[nextNode]) {
					visited[nextNode] = true;
					d[nextNode] = curWeight + nextWeight;
					q.add(new Node(nextNode, d[nextNode]));
				}
			}
		}
		
		int max = 0;
		
		for(int i = 1; i <= N; i++) {
			if(d[i] == 100) continue;
			max = Math.max(max, d[i]);
		}
		
		return max;
	}

}
