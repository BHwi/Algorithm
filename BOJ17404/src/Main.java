import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static final int INF = 1_000 * 1_000 + 1;
	public static int N, min = INF, arr[][], dp[][][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());

		arr = new int[N][3];
		dp = new int[N][3][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				Arrays.fill(dp[i][j], INF);
			}
		}

		// arr : 순서, 현재 색
		// dp : 순서, 첫 집, 현재 색

		dp[0][0][0] = arr[0][0];
		dp[0][1][1] = arr[0][1];
		dp[0][2][2] = arr[0][2];

		for (int T = 1; T < N - 1; T++) {
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					for (int k = 0; k < 3; k++) {
						if(j != k) {
							dp[T][i][j] = Math.min(dp[T][i][j], dp[T - 1][i][k] + arr[T][j]);
						}
					}
				}
			}
		}
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				for(int k = 0; k < 3; k++) {
					if(i != j && j != k)
						dp[N - 1][i][j] = Math.min(dp[N - 1][i][j], dp[N - 2][i][k] + arr[N - 1][j]);
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				min = Math.min(dp[N - 1][i][j], min);
			}
		}

		System.out.println(min);

	}

}
