import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static final int INF = 100000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N + 1][N + 1];
		int[][] ans = new int[N + 1][N + 1];
		
		for(int i = 0; i <= N; i++) {
			Arrays.fill(arr[i], INF);
			Arrays.fill(ans[i], INF);
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int T = Integer.parseInt(st.nextToken());
			
			arr[S][E] = Math.min(arr[S][E], T);
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(i == j) arr[i][j] = 0;
				ans[i][j] = arr[i][j];
			}
		}
		
		for(int k = 1; k <= N; k++) {
			for(int i = 1; i <= N; i++) {
				for(int j = 1; j <= N; j++) {
					if(ans[i][k] + ans[k][j] < ans[i][j]) {
						ans[i][j] = ans[i][k] + ans[k][j];
					}
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				System.out.print((ans[i][j] == INF ? 0 : ans[i][j])+ " ");
			}
			System.out.println();
		}

	}

}
