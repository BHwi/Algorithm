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
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[100002];
		int idx = 0, n = 0;

		while (st.hasMoreTokens()) {
			int tmp = stoi(st.nextToken());
			if (tmp == 0)
				break;

			arr[idx++] = tmp;
		}

		n = idx;
		idx = 0;

		int[][][] dp = new int[100002][5][5];

		while (arr[idx] != 0) {
			int target = arr[idx];

			if (idx == 0) {
				dp[idx][target][0] = need(0, target);
				dp[idx][0][target] = need(0, target);
			} else {
				for (int i = 0; i < 5; i++) {
					for (int j = 0; j < 5; j++) {
						if (dp[idx - 1][i][j] > 0) {
							if(dp[idx][target][j] != 0)
								dp[idx][target][j] = Math.min(dp[idx - 1][i][j] + need(i, target), dp[idx][target][j]);
							else 
								dp[idx][target][j] = dp[idx - 1][i][j] + need(i, target);
							if(dp[idx][i][target] != 0)
								dp[idx][i][target] = Math.min(dp[idx - 1][i][j] + need(j, target), dp[idx][i][target]); 
							else 
								dp[idx][i][target] = dp[idx - 1][i][j] + need(j, target);
						}
					}
				}
			}
			idx++;
		}

		int answer = Integer.MAX_VALUE;

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				if (dp[n - 1][i][j] != 0) {
					if (i == arr[n - 1] || j == arr[n - 1]) {
						answer = Math.min(answer, dp[n - 1][i][j]);
					}
				}
			}
		}
		System.out.println(answer);
	}

	public static int need(int s, int e) {
		if (s == e)
			return 1;
		if (s == 0)
			return 2;

		if (s % 2 == 1) {
			if (e == 2 || e == 4)
				return 3;
			else
				return 4;
		} else {
			if (e == 1 || e == 3)
				return 3;
			else
				return 4;
		}
	}

}
