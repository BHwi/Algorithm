import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static class Node implements Comparable<Node> {
		int end;
		int weight;
		
		Node (int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		public int compareTo(Node o) {
			return this.weight - o.weight;
		}
	}
	public static final int INF = 100_000 * 1000;
	public static ArrayList<Node> list[];
	public static boolean[] visited;
	public static int[] d, num;
	public static String[] str;
	public static int N, M, S, E, W;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		list = new ArrayList[N + 1];
		visited = new boolean[N + 1];
		d = new int[N + 1];
		num = new int[N + 1];
		str = new String[N + 1];
		
		Arrays.fill(d, INF);
		
		for(int i = 0; i <= N; i++)
			list[i] = new ArrayList<>();
		
		while(M --> 0) {
			st = new StringTokenizer(br.readLine());
			
			S = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			list[S].add(new Node(E, W));
		}
		
		st = new StringTokenizer(br.readLine());
		
		S = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		q.add(new Node(S, 0));
		d[S] = 0;
		num[S] = 1;
		str[S] = S + " ";
		
		while(!q.isEmpty()) {
			Node cur = q.poll();
			int curNode = cur.end;
			int curWeight = cur.weight;
			
			visited[curNode] = true;
			
			for(int i = 0; i < list[curNode].size(); i++) {
				int nextNode = list[curNode].get(i).end;
				int nextWeight = list[curNode].get(i).weight;
				
				if(!visited[nextNode] && d[nextNode] > curWeight + nextWeight) {
					d[nextNode] = curWeight + nextWeight;
					str[nextNode] = str[curNode] + nextNode + " ";
					num[nextNode] = num[curNode] + 1;
					
					q.add(new Node(nextNode, d[nextNode]));
				}
			}
		}
		
		System.out.println(d[E]);
		System.out.println(num[E]);
		System.out.println(str[E]);
	}

}
