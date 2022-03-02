import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int stoi(String s) {
		return Integer.parseInt(s);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int test_case = stoi(br.readLine());

		for (int T = 0; T < test_case; T++) {
			st = new StringTokenizer(br.readLine());

			int N = stoi(st.nextToken());
			int K = stoi(st.nextToken());
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = i;
			}

			Tree tree = new Tree(N, arr);

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				int Q = stoi(st.nextToken());
				int A = stoi(st.nextToken());
				int B = stoi(st.nextToken());

				if (Q == 0) {
					int tmp = tree.arr[A];
					
					tree.arr[A] = tree.arr[B];
					tree.arr[B] = tmp;
					
					tree.max_update(0, N - 1, 1, A, tree.arr[A]);
					tree.max_update(0, N - 1, 1, B, tree.arr[B]);

					tree.min_update(0, N - 1, 1, A, tree.arr[A]);
					tree.min_update(0, N - 1, 1, B, tree.arr[B]);
				} else {
					if (tree.get_max(0, N - 1, 1, A, B) == B && 
						tree.get_min(0, N - 1, 1, A, B) == A) {
						System.out.println("YES");
					}
					else {
						System.out.println("NO");
					}
				}
			}
		}

	}

	public static class Tree {
		int arr[];
		int min_tree[];
		int max_tree[];

		public Tree(int n, int[] arr) {
			this.arr = new int[n];
			min_tree = new int[n * 4];
			max_tree = new int[n * 4];

			for (int i = 0; i < arr.length; i++) {
				this.arr[i] = arr[i];
			}
			min_init(0, n - 1, 1);
			max_init(0, n - 1, 1);
		}

		public int min_init(int start, int end, int node) {
			if (start == end)
				return min_tree[node] = arr[start];

			int mid = (start + end) / 2;

			return min_tree[node] = Math.min(min_init(start, mid, node * 2), min_init(mid + 1, end, node * 2 + 1));
		}

		public int max_init(int start, int end, int node) {
			if (start == end)
				return max_tree[node] = arr[start];

			int mid = (start + end) / 2;

			return max_tree[node] = Math.max(max_init(start, mid, node * 2), max_init(mid + 1, end, node * 2 + 1));
		}

		public int get_max(int start, int end, int node, int left, int right) {
			if (left > end || right < start) {
				return -1;
			}
			if (left <= start && end <= right) {
				return max_tree[node];
			}

			int mid = (start + end) / 2;
			return Math.max(get_max(start, mid, node * 2, left, right),
					get_max(mid + 1, end, node * 2 + 1, left, right));
		}

		public int get_min(int start, int end, int node, int left, int right) {
			if (left > end || right < start) {
				return 10000000;
			}
			if (left <= start && end <= right) {
				return min_tree[node];
			}

			int mid = (start + end) / 2;
			return Math.min(get_min(start, mid, node * 2, left, right),
					get_min(mid + 1, end, node * 2 + 1, left, right));
		}

		public int min_update(int start, int end, int node, int index, int dif) {
			if (index < start || index > end) {
				return min_tree[node];
			}

			if (start == end) {
				return min_tree[node] = dif;
			}

			int mid = (start + end) / 2;

			return min_tree[node] = Math.min(min_update(start, mid, node * 2, index, dif),
					min_update(mid + 1, end, node * 2 + 1, index, dif));
		}

		public int max_update(int start, int end, int node, int index, int dif) {
			if (index < start || index > end) {
				return max_tree[node];
			}

			if (start == end) {
				return max_tree[node] = dif;
			}

			int mid = (start + end) / 2;

			return max_tree[node] = Math.max(max_update(start, mid, node * 2, index, dif),
					max_update(mid + 1, end, node * 2 + 1, index, dif));
		}
	}

}
