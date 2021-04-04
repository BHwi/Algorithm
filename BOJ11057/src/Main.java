import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static final int INF = 10_007;
	public static int N, ans = 0, dp[] = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		// dp[i] = i로 시작하는 경우의 수
		for(int i = 2; i <= N; i++) {
			int[] tmp_arr = new int[10];
			for(int j = 0; j < 10; j++) {
				int tmp = 0;
				
				for(int k = j; k < 10; k++) {
					tmp = (tmp + dp[k]) % INF;
				}
				
				tmp_arr[j] = tmp;
			}
			dp = tmp_arr;
		}
		
		for(int i = 0; i < 10; i++) {
			ans = (ans + dp[i]) % INF;
		}
		
		System.out.println(ans);
	}

}
