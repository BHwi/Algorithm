import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static int[] inorder, inorder_index, postorder;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		inorder = new int[N + 1];
		inorder_index = new int[N + 1];
		postorder = new int[N + 1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
			inorder_index[inorder[i]] = i;
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 1; i <= N; i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}
		
		solve(1, N, 1, N);
		
		System.out.println(sb.toString());
	}
	
	public static void solve(int i_start, int i_end, int p_start, int p_end) {
		if(i_start > i_end || p_start > p_end) return;
		
		int root = postorder[p_end];
		sb.append(root + " ");
		
		int root_index = inorder_index[root];
		int amount = root_index - i_start;
		
		solve(i_start, root_index - 1, p_start, p_start + amount - 1);
		solve(root_index + 1, i_end, p_start + amount, p_end - 1);
	}

}
