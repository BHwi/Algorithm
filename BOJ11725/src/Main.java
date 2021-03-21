import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());
		
		Node[] node = new Node[N + 1];
		boolean[] visited = new boolean[N + 1];
		int[] parent = new int[N + 1];
		
		for(int i = 1; i <= N; i++) {
			node[i] = new Node(i);
		}
		
		for(int i = 1; i < N; i++) {
			String[] input = br.readLine().split(" ");
			int num1 = Integer.parseInt(input[0]), num2 = Integer.parseInt(input[1]);
			
			node[num1].n.add(node[num2]);
			node[num2].n.add(node[num1]);
		}
		
		ArrayDeque<Node> q = new ArrayDeque<Node>();

		q.add(node[1]);
		
		while(!q.isEmpty()) {
			Node tmp = q.poll();
			
			visited[tmp.value] = true;
			
			for(int i = 0; i < tmp.n.size(); i++) {
				if(!visited[tmp.n.get(i).value]) q.add(tmp.n.get(i));
				else parent[tmp.value] = tmp.n.get(i).value;
			}
			
		}
		
		for(int i = 2; i <= N; i++) {
			System.out.println(parent[i]);
		}
	}

	public static class Node {
		ArrayList<Node> n = new ArrayList<>();
		int value;
		
		Node (int value) {
			this.value = value;
		}
		
	}

}
