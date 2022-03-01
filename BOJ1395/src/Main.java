import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = stoi(st.nextToken());
		int M = stoi(st.nextToken());
		int[] arr = new int[N];
		
		Tree tree = new Tree(N, arr);
		
		int query, a, b;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			query = stoi(st.nextToken());
			
			if(query == 0) {
				a = stoi(st.nextToken());
				b = stoi(st.nextToken());
				tree.update(0, N - 1, 1, a - 1, b - 1);
			}
			else {
				a = stoi(st.nextToken());
				b = stoi(st.nextToken());
				System.out.println(tree.sum(0, N - 1, 1, a - 1, b - 1));
			}
		}
	}
	
	public static class Tree {
		int[] arr, tree;
		boolean[] lazy;
		
		public Tree(int n, int[] arr) {
			this.arr = new int[n];
			tree = new int[n * 4];
			lazy = new boolean[n * 4];
		}
		
		public void propagate(int start, int end, int node) {
			if(lazy[node]) {
				tree[node] = (end - start + 1) - tree[node];
				
				if(start != end) {
					lazy[node * 2] = !lazy[node * 2];
					lazy[node * 2 + 1] = !lazy[node * 2 + 1];
				}
				
				lazy[node] = false;
			}
		}
		
		public long sum(int start, int end, int node, int left, int right) {
			propagate(start, end, node);
			if(left > end || right < start) {
				return 0;
			}
			if(left <= start && end <= right) {
				return tree[node];
			}
			
			int mid = (start + end) / 2;
			return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
		}
		
		public void update(int start, int end, int node, int left, int right) {
			propagate(start, end, node);
			if(right < start || left > end) return;
			
			if(left <= start && end <= right) {
				tree[node] = (end - start + 1) - tree[node];
				
				if(start != end) {
					lazy[node * 2] = !lazy[node * 2];
					lazy[node * 2 + 1] = !lazy[node * 2 + 1];
				}
				
				return;
			}
			
			int mid = (start + end) / 2;
			
			update(start, mid, node * 2, left, right);
			update(mid + 1, end, node * 2 + 1, left, right);
			
			tree[node] = tree[node * 2] + tree[node * 2 + 1];
		}
	}

}
