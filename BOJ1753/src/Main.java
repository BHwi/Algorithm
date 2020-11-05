import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	public static int V, E, S;
	public static List<Node>[] list;
	public static int[] distance;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		V = sc.nextInt();
		E = sc.nextInt();
		S = sc.nextInt();
		
		list = new ArrayList[V + 1];
		distance = new int[V + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		
		for(int i = 1; i < V + 1; i++)
			list[i] = new ArrayList<>();
		
		for(int i = 0; i < E; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			int w = sc.nextInt();
			
			list[s].add(new Node(e, w));
		}
		
		dijkstra(S);
		
	}
	
	public static class Node implements Comparable<Node> {
		int end, weight;
		
		public Node(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}
		
		@Override
		public int compareTo(Node o) {
			return weight - o.weight;
		}
	}
	
	public static void dijkstra(int start) {
		PriorityQueue<Node> queue = new PriorityQueue<>();
		boolean[] check = new boolean[V + 1];
		queue.add(new Node(start, 0));
		distance[start] = 0;
		
		while(!queue.isEmpty()) {
			Node currentNode = queue.poll();
			
			int current = currentNode.end;
			
			if(check[current]) continue;
			check[current] = true;
			
			for(Node node : list[current]) {
				if(distance[node.end] > distance[current] + node.weight) {
					distance[node.end] = distance[current] + node.weight;
					queue.add(new Node(node.end, distance[node.end]));
				}
			}
		}
		
		for(int i = 1; i <= V; i++) 
			System.out.println(distance[i] == Integer.MAX_VALUE ? "INF" : distance[i]);
	}

}
