import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {return Integer.parseInt(s);}
	public static long stol(String s) {return Long.parseLong(s);}
	public static final long INF = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = stoi(st.nextToken());
		int m = stoi(st.nextToken());
		int k = stoi(st.nextToken());
		
		long[] arr = new long[n + 1];
		
		for(int i = 1; i < arr.length; i++) {
			arr[i] = stol(br.readLine());
		}
		
		Tree tree = new Tree(n, arr);
		
		for(int i = 0; i < m + k; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = stoi(st.nextToken());
			int b = stoi(st.nextToken());
			long c = stol(st.nextToken());
			
			if(a == 1) {
				tree.arr[b] = c;
				tree.update(1, n, 1, b, c);
			}
			else {
				System.out.println(tree.mul(1, n, 1, b, (int) c));
			}
		}
	}
	
	public static class Tree {
		long arr[];
		long tree[];
		
		public Tree(int n, long[] arr) {
			this.arr = new long[n + 1];
			tree = new long[n * 4];
			
			for(int i = 0; i < arr.length; i++) {
				this.arr[i] = arr[i];
			}
			init(1, n, 1);
		}
		
		public long init(int start, int end, int node) {
			if(start == end) return tree[node] = arr[start];
			
			int mid = (start + end) / 2;
			
			return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % INF;
		}
		
		public long mul(int start, int end, int node, int left, int right) {
			if(left > end || right < start) {
				return 1;
			}
			if(left <= start && end <= right) {
				return tree[node];
			}
			
			int mid = (start + end) / 2;
			return (mul(start, mid, node * 2, left, right) * mul(mid + 1, end, node * 2 + 1, left, right)) % INF;
		}
		
		public long update(int start, int end, int node, int index, long dif) {
			if(index < start || index > end) {
				return tree[node];
			}
			
			if(start == end) {
				return tree[node] = dif;
			}
			
			int mid = (start + end) / 2;
			
			return tree[node] = (update(start, mid, node * 2, index, dif) * update(mid + 1, end, node * 2 + 1, index, dif)) % INF;
		}
		
		public void print() {
			for(int i = 0; i < tree.length; i++) {
				System.out.println(i + " : " + tree[i]);
			}
		}
	}

}
