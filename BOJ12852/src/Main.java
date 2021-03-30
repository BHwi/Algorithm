import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Main {
	public static class Node implements Comparable<Node> {
		int N;
		int count;
		String str;
		
		Node (int N, int count, String str) {
			this.N = N;
			this.count = count;
			this.str = str;
		}
		
		public int compareTo(Node o) {
			return this.count - o.count;
		}
	}
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		solve();
	}

	public static void solve() {
		PriorityQueue<Node> q = new PriorityQueue<>();
		
		q.add(new Node(N, 0, N + " "));
		
		while(!q.isEmpty()) {
			Node curNode = q.poll();
			int curN = curNode.N;
			int curCount = curNode.count;
			String curStr = curNode.str;
			
			if(curNode.N == 1) {
				System.out.println(curCount);
				System.out.println(curStr);
				System.exit(0);
			}
			else {
				q.add(new Node(curN - 1, curCount + 1, curStr + (curN - 1) + " "));
				if(curN % 3 == 0) q.add(new Node(curN / 3, curCount + 1, curStr + (curN / 3) + " "));
				if(curN % 2 == 0) q.add(new Node(curN / 2, curCount + 1, curStr + (curN / 2) + " "));
			}
		}
	}
}